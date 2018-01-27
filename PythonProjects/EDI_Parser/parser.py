"""EDI 850 Parser. Follows X12 standards to parse EDI 850 and convert to XML
  Romeo Medoro
  Hatteras Printing, Inc. """

import xml.etree.ElementTree as ET
from xml.etree.ElementTree import tostring
from xml.dom import minidom

def main():
    file = "test2.txt"
    segmentID = ""
    header_dict = {}
    po_dict = {}
    footer_dict = {}
    root = "XML"
    #open the file and start reading
    with open(file) as f:
        for line in readLines(f, "~"):
            elements = readElements(line)
            # Read the first index of each line to determine what the identifier is.  We then create 3 dictionaries
            # of lists based on the purpose of the data. The Idestifier will be used as the key for each list.
            if (elements[0] == 'ISA'):
                header_dict['ISA'] = formatList(elements)
            if (elements[0].strip('\n') == 'GS'):
                header_dict['GS'] = formatList(elements)
            if (elements[0].strip('\n') == 'ST'):
               header_dict['ST'] = formatList(elements)
            if (elements[0].strip('\n') == 'BEG'):
                po_dict['BEG'] = formatList(elements)
            if (elements[0].strip('\n') == 'REF'):
                po_dict['REF'] = formatList(elements)
            if (elements[0].strip('\n') == 'PER'):
                po_dict['PER'] = formatList(elements)
            if (elements[0].strip('\n') == 'FOB'):
                po_dict['FOB'] = formatList(elements)
            if (elements[0].strip('\n') == 'CSH'):
                po_dict['CHS'] = formatList(elements)
            if (elements[0].strip('\n') == 'SAC'):
                po_dict['SAC'] = formatList(elements)
            if (elements[0].strip('\n') == 'ITD'):
                po_dict['ITD'] = formatList(elements)
            if (elements[0].strip('\n') == 'DTM'):
                po_dict['DTM'] = formatList(elements)
            if (elements[0].strip('\n') == 'N9'):
                po_dict['N9'] = formatList(elements)
            if (elements[0].strip('\n') == 'MTX'):
                po_dict['MTX'] = formatList(elements)
            if (elements[0].strip('\n') == 'N1'):
                po_dict['N1'] = formatList(elements)
            if (elements[0].strip('\n') == 'N3'):
                po_dict['N3'] = formatList(elements)
            if (elements[0].strip('\n') == 'N4'):
                po_dict['N4'] = formatList(elements)
            if (elements[0].strip('\n') == 'PO1'):
                po_dict['PO1'] = formatList(elements)
            if (elements[0].strip('\n') == 'CPT'):
                po_dict['CPT'] = formatList(elements)
            if (elements[0].strip('\n') == 'PID'):
                po_dict['PID'] = formatList(elements)
            if (elements[0].strip('\n') == 'SLN'):
                po_dict['SLN'] = formatList(elements)
            if (elements[0].strip('\n') == 'CTT'):
                po_dict['CTT'] = formatList(elements)
            if (elements[0].strip('\n') == 'SE'):
                footer_dict['SE'] = formatList(elements)
            if (elements[0].strip('\n') == 'GE'):
                footer_dict['GE'] = formatList(elements)
            if (elements[0].strip('\n') == 'IEA'):
                footer_dict['IEA'] = formatList(elements)
    # Close the file.
    f.close()

    output = buildxml(root,header_dict,po_dict,footer_dict)
    print(output)

# This method takes each element in the list and strips newline characters, then returns a dict.
def formatList(el):
    dict = []
    for i in range(1, len(el)):
        dict += el[i].strip('\n').split(',')
    return dict

# This method is a buffer. It chunks the file and reads each line of the file independently
def readLines(f, newline):
    buffer = ""
    while True:
        while newline in buffer:
            pos = buffer.index(newline)
            yield buffer[:pos]
            buffer = buffer[pos + len(newline):]
        chunk = f.read(4096)
        if not chunk:
            yield buffer
            break
        buffer += chunk

# this method splits the line into elements based on the delimiter, in our case the *
def readElements(s):
    el = ""
    el = s.split('*')
    return el

# this method takes in the root and our three dictionaries and builds the elements that make up our xml output.
# It returns the root and all of its contents.
def buildxml(r, d1, d2, d3):
    root = ET.Element(r)
    if isinstance(d1, dict):
        wrapper = ET.SubElement(root, "header")
        for key, val in d1.items():
            if key == "ISA":
                tag = ET.SubElement(wrapper, "interchange_control_header")
                try:
                    ET.SubElement(tag, "auth_qualifier").text = val[0]
                    ET.SubElement(tag, "auth_info").text = val[1]
                    ET.SubElement(tag, "security_qualifier").text = val[2]
                    ET.SubElement(tag, "security_info").text = val[3]
                    ET.SubElement(tag, "interchangeID").text = val[4]
                    ET.SubElement(tag, "interchange_senderID").text = val[5]
                    ET.SubElement(tag, "ID_qualifier").text = val[6]
                    ET.SubElement(tag, "receiverID").text = val[7]
                    ET.SubElement(tag, "interchange_date_time").text = val[8]
                    ET.SubElement(tag, "repetition_separator").text = val[9]
                    ET.SubElement(tag, "version_number").text = val[10]
                    ET.SubElement(tag, "control_number").text = val[11]
                    ET.SubElement(tag, "ack_request").text = val[12]
                    if val[13] == 'T':
                        ET.SubElement(tag, "usage_indicator").text = 'TEST DATA'
                    elif val[13] == "P":
                        ET.SubElement(tag, "usage_indicator").text = 'PRODUCTION DATA'
                    ET.SubElement(tag, "element_separator").text = val[14]
                except IndexError:
                    continue
            if key == "GS":
                tag = ET.SubElement(wrapper, "group_header")
                try:
                    ET.SubElement(tag, "functional_id_code").text = val[0]
                    ET.SubElement(tag, "app_sender_code").text = val[1]
                    ET.SubElement(tag, "app_receiver_code").text = val[2]
                    ET.SubElement(tag, "date").text = val[3]
                    ET.SubElement(tag, "time").text = val[4]
                    ET.SubElement(tag, "group_control_num").text = val[5]
                    ET.SubElement(tag, "agency_code").text = val[6]
                    ET.SubElement(tag, "ver_release_industryID").text = val[7]
                except IndexError:
                    continue
            if key == "ST":
                tag = ET.SubElement(wrapper, "transaction_header")
                try:
                    ET.SubElement(tag, "transaction_ID").text = val[0]
                    ET.SubElement(tag, "trans_control_number").text = val[1]
                except IndexError:
                    continue
    if isinstance(d2, dict):
        wrapper = ET.SubElement(root, "po_data")
        for key, val in d2.items():
            if key == 'BEG':
                tag = ET.SubElement(wrapper, "beg_PO_segment")
                try:
                    ET.SubElement(tag, "purpose_code").text = val[0]
                    ET.SubElement(tag, "po_type_code").text = val[1]
                    ET.SubElement(tag, "PurchaseOrderNumber").text = val[2]
                    ET.SubElement(tag, "PO_date").text = val[3]
                except IndexError:
                    continue
            if key == 'REF':
                tag = ET.SubElement(wrapper, "referenceID")
                try:
                    if val[0] == 'DP':
                        ET.SubElement(tag, "ref_ID_qualifier").text = 'Department Number'
                    elif val[0] == 'IT':
                        ET.SubElement(tag, "ref_ID_qualifier").text = 'Customer Number'
                    elif val[0] == 'PD':
                        ET.SubElement(tag, "ref_ID_qualifier").text = 'Promotion Number'
                    ET.SubElement(tag, "ref_ID").text = val[1]
                except IndexError:
                    continue
            if key == 'PER':
                tag = ET.SubElement(wrapper, "admin_comm_contact")
                try:
                    ET.SubElement(tag, "contact_function_code").text = val[0]
                    ET.SubElement(tag, "contact_name").text = val[1]
                    ET.SubElement(tag, "number_qualifier").text = val[2]
                    ET.SubElement(tag, "comm_number").text = val[3]
                except IndexError:
                    continue
            if key == 'FOB':
                tag = ET.SubElement(wrapper, "freight_on_board")
                try:
                    if val[0] == "CC":
                        ET.SubElement(tag, "payment_method").text = 'Collect, Paid by Dunhams'
                    elif val[0] == 'CF':
                        ET.SubElement(tag, "payment_method").text = 'Collect, credit freight to Dunhams'
                    else:
                        ET.SubElement(tag, "payment_method").text = 'Prepaid by seller'
                except IndexError:
                    continue
            if key == 'CSH':
                tag = ET.SubElement(wrapper, "sales_requirement")
                try:
                    if val[0] == 'C':
                        ET.SubElement(tag, "sales_requirement_code").text = 'Consignment'
                    else:
                        ET.SubElement(tag, "sales_requirement_code").text = 'No Back Order'
                except IndexError:
                    continue
            if key == 'SAC':
                tag = ET.SubElement(wrapper, "servicePromotionAllowanceCharge")
                try:
                    ET.SubElement(tag, "allowance_or_charge").text = val[0]
                    if val[1] == 'B720':
                        ET.SubElement(tag, "SAC_CODE").text = 'Cooperative ad allowance %'
                    elif val[1] == 'C000':
                        ET.SubElement(tag, "SAC_CODE").text = 'Defective allowance'
                    elif val[1] == 'D170':
                        ET.SubElement(tag, "SAC_CODE").text = 'Free Goods'
                    else:
                        ET.SubElement(tag, "SAC_CODE").text = 'New Store Discount'
                    ET.SubElement(tag, "AllowancePercentQualifier").text = val[5]
                    ET.SubElement(tag, "percent").text = val[6]
                except IndexError:
                    continue
            if key == 'ITD':
                tag = ET.SubElement(wrapper, "terms_deferredTerms_of_sale")
                try:
                    if val[1] == '3':
                        ET.SubElement(tag, "term_date_type").text = 'Invoice Date'
                    elif val[1] == '4':
                        ET.SubElement(tag, "term_date_type").text = 'Specified Date'
                    else:
                        ET.SubElement(tag, "term_date_type").text = 'Receipt Date'
                    ET.SubElement(tag, "discount_percent").text = val[2]
                    ET.SubElement(tag, "discount_due_date").text = val[3]
                    ET.SubElement(tag, "days_valid").text = val[4]
                    ET.SubElement(tag, "net_due_date").text = val[5]
                    ET.SubElement(tag, "days_until_invoice_due").text = val[6]
                    if val[13] == 'L':
                        ET.SubElement(tag, "payment_method").text = 'Letter of Credit'
                    else:
                        ET.SubElement(tag, "discount_percent").text = 'Wire Transfer'
                except IndexError:
                    continue
            if key == 'DTM':
                tag = ET.SubElement(wrapper, "date_time_ref")
                try:
                    if val[0] == '001':
                        ET.SubElement(tag, "discount_percent").text = 'Cancel Date'
                    elif val[0] == '002':
                        ET.SubElement(tag, "discount_percent").text = 'Anticipated Deliver'
                    elif val[0] == '010':
                        ET.SubElement(tag, "discount_percent").text = 'Requested Ship Date'
                    elif val[0] == '037':
                        ET.SubElement(tag, "discount_percent").text = 'Ship Not Before'
                    else:
                        ET.SubElement(tag, "discount_percent").text = 'Ship No Later'
                    ET.SubElement(tag, "date").text = val[1]
                except IndexError:
                    continue
            if key == 'N9':
                tag = ET.SubElement(wrapper, "reference_ID")
                try:
                    ET.SubElement(tag, "reference_code").text = val[0]
                    ET.SubElement(tag, "ref_ID").text = val[1]
                except IndexError:
                    continue
            if key == 'MTX':
                tag = ET.SubElement(wrapper, "text")
                try:
                    ET.SubElement(tag, "message").text = val[1]
                    ET.SubElement(tag, "message").text = val[2]
                except IndexError:
                    continue
            if key == 'N1':
                tag = ET.SubElement(wrapper, "name")
                try:
                    if val[0] == 'BT':
                        ET.SubElement(tag, "discount_percent").text = 'Bill to'
                    elif val[0] == 'BY':
                        ET.SubElement(tag, "discount_percent").text = 'Buying Party'
                    else:
                        ET.SubElement(tag, "discount_percent").text = 'Ship To'
                    ET.SubElement(tag, "Name").text = val[1]
                    if val[2] == '91':
                        ET.SubElement(tag, "message").text = 'Assigned by Seller'
                    else:
                        ET.SubElement(tag, "message").text = "Dunham's Store Num"
                    ET.SubElement(tag, "ID_code").text = val[3]
                except IndexError:
                    continue
            if key == 'N3':
                tag = ET.SubElement(wrapper, "address_info")
                try:
                    ET.SubElement(tag, "Address1").text = val[0]
                    ET.SubElement(tag, "Address2").text = val[1]
                except IndexError:
                    continue
            if key == 'N4':
                tag = ET.SubElement(wrapper, "geographic_location")
                try:
                    ET.SubElement(tag, "City").text = val[0]
                    ET.SubElement(tag, "State").text = val[1]
                    ET.SubElement(tag, "Zip").text = val[2]
                    ET.SubElement(tag, "country").text = val[3]
                except IndexError:
                    continue
            if key == 'PO':
                tag = ET.SubElement(wrapper, "business_item_detail")
                try:
                    ET.SubElement(tag, "quantity_ordered").text = val[1]
                    if val[2] == 'CA':
                        ET.SubElement(tag, "UOM").text = 'Case'
                    else:
                        ET.SubElement(tag, "UOM").text = 'Each'
                    ET.SubElement(tag, "unit_price").text = val[3]
                    ET.SubElement(tag, "identifier_type").text = val[5]
                    ET.SubElement(tag, "short_SKU").text = val[6]
                    if val[7] == 'UP':
                        ET.SubElement(tag, "ID_qualifier").text = 'UPC'
                    else:
                        ET.SubElement(tag, "ID_qualifier").text = 'International Article'
                    ET.SubElement(tag, "UPC_code").text = val[8]
                    ET.SubElement(tag, "vendor_item_num").text = val[10]
                    ET.SubElement(tag, "long_SKU").text = val[12]
                    ET.SubElement(tag, "size_code").text = val[14]
                    ET.SubElement(tag, "color_code").text = val[16]
                except IndexError:
                    continue
            if key == 'CTP':
                tag = ET.SubElement(wrapper, "pricing_info")
                try:
                    if val[1] == 'MSR':
                        ET.SubElement(tag, "short_SKU").text = 'Mnfcr Suggested Retail'
                    else:
                        ET.SubElement(tag, "short_SKU").text = 'Retail'
                    ET.SubElement(tag, "unit_price").text = val[2]
                except IndexError:
                    continue
            if key == 'PID':
                tag = ET.SubElement(wrapper, "product_item_desc")
                try:
                    ET.SubElement(tag, "dec_type").text = val[0]
                    ET.SubElement(tag, "characteristics_code").text = val[1]
                    ET.SubElement(tag, "description").text = val[4]
                except IndexError:
                    continue
            if key == 'SLN':
                tag = ET.SubElement(wrapper, "subline_item_detail")
                try:
                    ET.SubElement(tag, "assignedID").text = val[0]
                    ET.SubElement(tag, "relationship_code").text = val[2]
                    ET.SubElement(tag, "quantity").text = val[3]
                    ET.SubElement(tag, "UOM").text = val[4]
                    ET.SubElement(tag, "unit_price").text = val[5]
                    ET.SubElement(tag, "basis").text = val[6]
                    if val[8] == 'UP':
                        ET.SubElement(tag, "subline_qualifier").text = 'UPC'
                    else:
                        ET.SubElement(tag, "short_SKU").text = 'International Article'
                    ET.SubElement(tag, "subline_UPC").text = val[9]
                    ET.SubElement(tag, "buyer_item_num").text = val[11]
                    ET.SubElement(tag, "vendor_item_num").text = val[13]
                    ET.SubElement(tag, "buyer_style_num").text = val[15]
                    ET.SubElement(tag, "buyer_size_code").text = val[17]
                    ET.SubElement(tag, "buyer_color_code").text = val[19]
                except IndexError:
                    continue
            if key == 'CTT':
                tag = ET.SubElement(wrapper, "transaction_totals")
                try:
                    ET.SubElement(tag, "total_line_items").text = val[0]
                except IndexError:
                    continue
    if isinstance(d3, dict):
        wrapper = ET.SubElement(root, "footer")
        for key, val in d3.items():
            if key == 'SE':
                tag = ET.SubElement(wrapper, "transaction_set_trailer")
                try:
                    ET.SubElement(tag, "total_segments").text = val[0]
                    ET.SubElement(tag, "transaction_contorl_num").text = val[1]
                except IndexError:
                    continue
            if key == 'GE':
                tag = ET.SubElement(wrapper, "functional_group_header")
                try:
                    ET.SubElement(tag, "total_transaction_sets").text = val[0]
                    ET.SubElement(tag, "group_control_num").text = val[1]
                except IndexError:
                    continue
            if key == 'IEA':
                tag = ET.SubElement(wrapper, "interchange_control_trailer")
                try:
                    ET.SubElement(tag, "total_functional_groups").text = val[0]
                    ET.SubElement(tag, "interchange_control_num").text = val[1]
                except IndexError:
                    continue
    rough_string = ET.tostring(root, 'utf-8')
    reparse = minidom.parseString(rough_string)
    return reparse.toprettyxml(indent = '\t')



if __name__ == '__main__':
    main()