/*
 * Romeo Medoro.
 * Intro to Java
 * 10/27/2017.
 * Picks four cards from a deck of 52 cards and computes their sum
 */
package pickfourcards;
import java.util.*;

public class PickFourCards {
    
    public static void main(String[] args) {
         // Array declarations
        final String[] suit = {"Spades", "Diamonds", "Hearts", "Clubs"};
        final String[] cards = {"Ace", "King", "Queen", "Jack", "2", "3",
                            "4", "5", "6", "7", "8", "9","10"};
        String[][] cardList = new String[2][4];
        int sum =0,                 // holds the sum of the cards.
               counter = 0;         // Counts the picks that yield 24. 
       
        while (sum != 24){
            // Call the getCards method to generate an array of 4 random 
            //cards. 
            cardList = getCards(suit, cards);
            
            // get the sum of the cards 
            sum = sumCards(cardList);
       
            // loop through the cards to display them to the user.
            for (int j = 0; j < 4; j++){
                // Display the suit.
                System.out.print("Suit: " + cardList[0][j] + " ");
                // Display the face value.
                System.out.print("\t Face: " + cardList[1][j]);
                // Get and display the point value.
                System.out.println("\t Points: " + getPoints(cardList[1][j]));
            }
            System.out.println("--------------------------------------------");
            // Display the sum. 
            System.out.println("Total Points: " + sum + "\n");
            counter++;
        }
        
        // Display the number of picks that yields the sum of 24.
        System.out.println("Number of Picks before reaching 24: " + counter);
    }
    
    /* Picks a random card suit */
    public static int getSuit(){
        int result;
        //get a random suit and card.
        result = (int)(Math.random()*4);
        
        return result;
    }
    
    /* Picks random card value */
    public static int getValue(){
        int result;
        // get random value.
        result = (int)(Math.random()*13);
        
        return result;
    }
    
    /* uses the random index to loop through our arrays and create a 
    new 2d array of cards.
    */
    public static String[][] getCards(String[] array1, String[] array2){
        String[][] result = new String[2][4];
            for (int col = 0; col < 4; col++){
                result[0][col] = array1[getSuit()];
                result[1][col] = array2[getValue()];
            }
        return result;
    }
    
    /* Adds the values of 4 random cards. 
    */
    public static int sumCards(String[][] array){
        int result = 0,
                points = 0;
            // Loop through the array to get values for the cards
            for (int col = 0; col < 4; col++){
                if (array[1][col] == "Ace"){
                    result = 1;
                }
                else if (array[1][col] == "King"){
                    result = 13;
                }
                else if (array[1][col] == "Queen"){
                    result = 12;
                }
                else if (array[1][col] == "Jack"){
                    result = 11;
                }
                else{
                    result = Integer.parseInt(array[1][col]);
                }
                points += result;
            }
        return points;
    }
    
    /* returns the value for each card */
    public static int getPoints(String s){
        int result = 0;
            // Loop through the array to get values for the cards
            for (int col = 0; col < 4; col++){
                if (s == "Ace"){
                    result = 1;
                }
                else if (s == "King"){
                    result = 13;
                }
                else if (s == "Queen"){
                    result = 12;
                }
                else if (s == "Jack"){
                    result = 11;
                }
                else
                    result = Integer.parseInt(s);
            }
        return result;
    }
}
