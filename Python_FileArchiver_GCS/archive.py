# -*- coding: utf-8 -*-
import os
import time
import shutil
import subprocess
import sys
import inspect
import re
import logging
from google.cloud import storage
from google.oauth2 import service_account
from logging.handlers import RotatingFileHandler

logDir = "C:\\Program Files (x86)\\Epp_Archiver"
# add a service-log.log file to the logging directory.
logPath = logDir + "\\service-log.log"
# Set the name of the object we are logging for
_logger = logging.getLogger("File_Archiver")
_logger.setLevel(logging.DEBUG)
handler = RotatingFileHandler(logPath, maxBytes=20971520, backupCount=10)
# Format the log message to display the time, object name, the logging level, and the message.
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
handler.setFormatter(formatter)
_logger.addHandler(handler)

def main():
    # Log the event has started.
    _logger.info("Starting Scheduled Event")
    # This is where we will being looking to get all the files and folders older than X days
    source_dir = "\\\\your\\directory"
    destination_dir = "\\\\the\\destination\\directory"
    # This is where we will drop the files for a bit before we zip them up.
    temp_dir = "\\\\your\\temp\\directory"
    # time.time is getting the current date time - X, X being the number of days old * 86400 to get the seconds.
    # we are collecting files that are more than 90 days old.
    days_old = time.time()-90*86400
    # Folders to ignore.
    done_folders = ['any folder name you wish to ignore']
    # This is in MB
    size_limit = 1000

    try:
        # Create the temp directory if it doesn't exist.
        if not os.path.isdir(temp_dir):
            _logger.info("Creating: " + temp_dir)
            os.makedirs(temp_dir)

        # Loop through each file or folder in the source directory
        for item in os.listdir(source_dir):
            source_path = os.path.join(source_dir, item)
            temp_path = os.path.join(temp_dir, item)
            # Check if the directory has been modified in the past number of days.
            if os.stat(source_path).st_mtime < days_old:
                # Checking to see that our temp directory doesn't already have the folder
                # we are going to move and isn't zipped up or rar compressed.
                # Also, checking to make sure that we aren't moving a temp file.
                if not os.path.exists(temp_path+".rar") and not os.path.exists(temp_path+".zip") and not os.path.exists(temp_path) and '._' not in item and item not in done_folders:
                    _logger.info("Moving "+source_path+" to "+temp_path)
                    shutil.move(source_path, temp_path)
        for item in os.listdir(temp_dir):
            source_path = os.path.join(temp_dir, item)
            output_path = os.path.join(destination_dir, item)
            # Make sure the output path doesn't already exist. If it does, ignore the file.
            if not os.path.exists(output_path+".rar") and not os.path.exists(output_path+".zip") and not os.path.exists(output_path+"01.zip")\
                    and not os.path.exists(output_path+"01.rar"):
                # Get the size of the directory, if it is larger than 1 Gigabyte, ignore it, we don't want to split
                # files that large into multiple parts because it would create too many parts.
                if get_size(source_path) < size_limit:
                    # subprocess call to split files larger than 50M into multiple parts and move them to a new directory.
                    _logger.info("Compressing: " + source_path)
                    subprocess.call(['C:\Program Files\WinRAR\WinRAR.exe', 'a', '-r', '-s', '-v50M', output_path+'.rar', source_path], shell=True)
                    # Delete the files and folders from the source directory after they have been compressed.
                    # first we check if the item is a directory
                    if os.path.isdir(source_path):
                        # If so, delete the directory.
                        shutil.rmtree(source_path)
                    else:
                        # if it is a file, delete the file.
                        os.remove(source_path)
                    _logger.info("Compression for " + source_path + " Completed Successfully")
                else:
                    _logger.info("Unable to Compress " + source_path + "--File too Large")
            else:
                _logger.info("Ignoring " + source_path + "--File already exists in destination")

        # Loop through files to be Uploaded, and send the files off to GCS.
        for file in os.listdir(destination_dir):
            _logger.info("Uploading: " + file + " to GCS")
            upload_blob(file, destination_dir)
            _logger.info(file + " has been uploaded successfully")
            # delete the file we have sent to GCS.
            os.remove(os.path.join(destination_dir, file))
        _logger.info("Stopping Scheduled Event")
    except Exception as e:
        _logger.info(e)

# used to get the size of each directory in the source folder. Checks to see if
# the item is a directory or a file, then for each directory, continues to check
# if the contents are filed or dirs. For each file in each directory, it adds the
# file size and returns the total size of the start path.
def get_size(start_path):
    # get the size of the file if it is a file
    if os.path.isfile(start_path):
        total_size = os.path.getsize(start_path)/1000000
    else:
        total_size = os.path.getsize(start_path)
        # Loop through the items in the directory
        for item in os.listdir(start_path):
            # Ignoring items that start with ._
            if not item.startswith('._'):
                # create a item path for the item we are currently on.
                itempath = os.path.join(start_path, item)
                # if the item is a file
                if os.path.isfile(itempath):
                    # add to total size
                    total_size += os.path.getsize(itempath)/1000000
                # if the item is a directory call the get_size method to get to the files in the directory.
                elif os.path.isdir(itempath):
                    total_size += get_size(itempath)
    return total_size

# This method uses a GCS service account to generate a blob and upload the
# blob to a designated GCS bucket. Service account auth info is read from
# a json file.
def upload_blob(source_file, directory):

    file_directory = directory + "\\" + source_file
    # get credentials from the service account json
    credentials = service_account.Credentials.from_service_account_file('C:\\path_to\\service_account\\json_file')
    # Get the storage client
    storage_client = storage.Client(project='your_project', credentials=credentials)
    # Specify the bucket in which we will upload our blob
    bucket = storage_client.get_bucket('your_specified_bucket')
    # define our blob object
    blob = bucket.blob(source_file)
    # post the file to the bucket.
    blob.upload_from_filename(file_directory)


if __name__ == '__main__':
    main()
