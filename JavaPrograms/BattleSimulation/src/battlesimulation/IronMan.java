/*
 * Romeo Medoro.
 * Intro to Java
 * 12/08/2017
 * The Iron man class is a child class or the Armor class. It adds the heal
 * method used by the IronMan armor. 
 */
package battlesimulation;

public class IronMan extends Armor {
   
    // ironman constructor calls the armor constructor. 
    IronMan(String name){
        super(name);
    }
    
    // Add to the armor's health
    public void healArmor(){
        int currentHealth = this.getHealth();
        
        // If the armor's current health is less than 20
        if (currentHealth < 20){
            // If the armor's current health + 5 is greater than 20 
            // set the health at 20. 
            if((currentHealth + 5) > 20){
                 this.setHealth(20);
            }
            // otherwise add 5 points to the health. 
            else 
                this.setHealth(currentHealth + 5);
        }
    }
    
    // overloads the attack method, add an integer as a parameter. 
    public void attack(Armor armor, int input){
        int success = (int)(Math.random() * 20 + 1);
        int damageAmount = 0;
        String attackType = null;
        // check the value of the user input
        // assign the attack type and call the attack result function
        switch(input){
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
            case 4:
                // if the user selects heal, call the heal armor method.
                attackType = "Healing";
                this.healArmor();
                break;
            default:
                break;
        }
        
        // subtract the damage amount from the armor, print the attack
        // result to the user.
        if (!(attackType.equals("Healing"))){
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
        else   
            System.out.println("Healing...Health increased to: " + armor.getHealth());
    }
}
