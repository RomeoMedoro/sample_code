/*
 * Romeo Medoro.
 * Intro to Java
 * 12/08/2017
 * Simulates a battle between Iron Man and Iron Monger. 
 */
package battlesimulation;
import java.util.*;

public class BattleSimulation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // create the armor and iron man objects
        Armor ironMonger = new Armor("Obadiah Stane");
        IronMan ironMan = new IronMan("Tony Stark");
        
        // Local variables
        int selection = 0,
                ironManHealth,
                ironMongerHealth;
        boolean isActive = true;
        
        // Loop through the battle until a player has no more life left. 
        do{
            // Prompt the user.
            printScore(ironMonger, ironMan);
            System.out.println("Iron Man attacks: ");
            System.out.println("Here are your attacks: ");
            System.out.println("\t(1) Repulsor Ray");
            System.out.println("\t(2) Unibeam");
            System.out.println("\t(3) Strike");
            System.out.println("\t(4) Heal");
            // Validate the user input
            boolean valid = false;
            while(valid == false){
                System.out.print("Enter your attack: ");
                // get the user input
                selection = input.nextInt();
                if (selection < 1 || selection > 4){
                    System.out.println("Invalid selection! ");
                    valid = false;
                }
                // is the user input it to heal, but his health is already
                // full, display an error. 
                else if (selection == 4){
                    if (ironMan.getHealth() == 20){
                        System.out.println("Health is already full! ");
                        valid = false;
                    }
                    // Otherwise perform the attack. 
                    else{
                        ironMan.attack(ironMonger, selection);
                        valid = true;
                    }
                }
                else{
                    valid = true;
                    ironMan.attack(ironMonger, selection);
                }
            }
             // Obadiah attacks
            System.out.print("Obadiah Stane Attacks: ");
            ironMonger.attack(ironMan);
            // Check Iron Monger's health to see if IronMan wins
            if(ironMonger.getHealth() <= 0 ){
                System.out.println(ironMan.getName() + " wins!!");
                isActive = true;
            }
            // Check Iron Man's health to see if Iron Monger wins
            else if(ironMan.getHealth() <= 0){
                System.out.println(ironMonger.getName() + " wins!");
                isActive = true;
            }
            else{
                System.out.print("\n");
                isActive = false;
            }
            
        }while(isActive == false); 
    }
    /* The printScore method prints out the payer names, and the health for each
    player. 
    */
    public static void printScore(Armor armor, IronMan iron){
        System.out.println(armor.getName() + ": " + armor.getHealth() + "   " +
                iron.getName() + ": " + iron.getHealth());
        System.out.println("=================================================");
    }
    
}
