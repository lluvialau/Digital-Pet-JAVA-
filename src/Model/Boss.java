
package Model;

/**
 * the class represent the boss
 * @author Yu Liu
 */
public class Boss extends Pet {

    /**
     * the levels of three bosses
     * @param level
     */
    public Boss(int level) {
        super("boss");
        if(level==1){
            this.setStrength(1);
            this.setStamina(100);
            this.setMoney(50);
        }else if (level==2){
            this.setStrength(2);
            this.setStamina(500);
            this.setMoney(100);
        }else if (level==3){
            this.setStrength(3);
            this.setStamina(1000);
            this.setMoney(500);
        }
    }
    
}
