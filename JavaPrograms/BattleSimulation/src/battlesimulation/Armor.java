/*
 * Romeo Medoro.
 * Intro to Java
 * 12/08/2017
 * The armor class defines the main object used in the battle simulation
 * program.
 */
package battlesimulation;
import java.util.*;

public class Armor {
    public String name;
    public int health;
    
    /* default constructor */
    Armor(){
        this.health = 20;
    }
    
    /* Armor Constructor */
    Armor(String name){
        this.name = name;
        this.health = 20;
    }
    
    // Return the name
    public String getName(){
        return this.name;
    }
    
    // Set the health
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    
    // Return the health
    public int getHealth(){
        return this.health;
    }
    
    // returns the result of the attack
    public int attackResult(String type, int num){
        int result = 0;
        // check the attack type, if it meets the criteria for hit or miss, 
        // randomly generate a number whithin the criteria of max damage allowed
        // by the strike. 
        switch(type){
            case "Repulsor Ray":
                System.out.println("Firing Repulsor Ray");
                if (num >= 8){
                    result = (int)(Math.random() * 8 + 1);
                    break;
                }
                else{
                    break;
                }
            case "Unibeam":
                System.out.println("Firing Unibeam");
                if (num >= 12){
                    result = (int)(Math.random()* 10 + 1);
                    break;
                }
                else{
                    break;
                }
                case "Strike":
                    System.out.println("Strike");
                    if (num >= 5){
                        result = (int)(Math.random() * 4 + 1);
                        break;
                    }
                    else{
                        break;
                    }
        }
        return result;
    }
    
    // the attack method 
    public void attack(Armor armor){
        int rand = (int)(Math.random() * 2 + 1);
        int success = (int)(Math.random() * 20 + 1);
        int damageAmount = 0;
        String attackType;
        // chek the value of the random number.
        // assign the attack type and call the attack result function
        switch(rand){
            case 1:
                attackType = "Repulsor Ray";
                damageAmount = attackResult(attackType, success);
                break;
            case 2:
                attackType = "Unibeam";
                damageAmount = attackResult(attackType, success);
                break;
            case 3:
                attackType = "Strike";
                damageAmount = attackResult(attackType, success);
                break;
            default:
                break;
        }
        
        // subtract the damage amount from the armor, print the attack
        // result to the user.
        if (damageAmount > 0){
            int temp = armor.getHealth();
            temp -= damageAmount;
            armor.setHealth(temp);
            
            System.out.println("Attack does " + damageAmount + " damage");
        }
        else{
            System.out.println("Attack Misses!");
        }
    }
}

