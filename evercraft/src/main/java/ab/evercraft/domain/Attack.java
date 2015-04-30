package ab.evercraft.domain;

import lombok.Data;

@Data
public class Attack {
    // private static final int lowValue = 1;
    // private static final int highValue = 20;
    
    private static final int STRONGEST_ROLL_VALUE = 20;
    private EvercraftCharacter attacker;
    private EvercraftCharacter defender;
    
    public Attack() {
    }
    
    public Attack(EvercraftCharacter attacker, EvercraftCharacter defender) {
        this.attacker = attacker;
        this.defender = defender;
    }
    
    public boolean attack(int rollValue) {
        if (rollValue == STRONGEST_ROLL_VALUE) {
            defender.setHitPoints(defender.getHitPoints() - 2);
            return true;
        }
        
        if (rollValue >= defender.getArmorClass()) {
            defender.setHitPoints(defender.getHitPoints() - 1);
            return true;
        }
        
        return false;
    }
    
    // public void performAttack() {
    // int rollValue = rollTheDie();
    //
    // }
    //
    // private int rollTheDie() {
    // Random random = new Random();
    // return random.nextInt(highValue - lowValue) + lowValue;
    // }
    
}
