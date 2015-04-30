package ab.evercraft.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ab.evercraft.domain.Attack;
import ab.evercraft.domain.EvercraftCharacter;

public class AttackTest {
    
    private static final int STRONGEST_ATTACK_ROLL_VALUE = 20;
    private static final int STRONG_ATTACK_ROLL_VALUE = 15;
    private static final int WEAKEST_ATTACK_ROLL_VALUE = 1;
    private Attack attack;
    private EvercraftCharacter attacker;
    private EvercraftCharacter defender;
    
    @Before
    public void setUp() throws Exception {
        attacker = new EvercraftCharacter();
        defender = new EvercraftCharacter();
        attack = new Attack(attacker, defender);
    }
    
    @Test
    public void oneCharacterHitsAnotherCharacterWhenRollIsGreaterThanDefenderAC() {
        assertTrue(attack.attack(STRONGEST_ATTACK_ROLL_VALUE));
    }
    
    @Test
    public void oneCharacterMissesAnotherCharacterWhenRollIsLessThanDefenderAC() {
        assertFalse(attack.attack(WEAKEST_ATTACK_ROLL_VALUE));
    }
    
    @Test
    public void successfulAttackDamagesDefenderByOneHitPoint() {
        int defenderHitPointsBeforeAttack = defender.getHitPoints();
        attack.attack(STRONG_ATTACK_ROLL_VALUE);
        int defenderHitPointsAfterAttack = defender.getHitPoints();
        
        assertEquals(defenderHitPointsBeforeAttack - 1, defenderHitPointsAfterAttack);
    }
    
    @Test
    public void strongestAttackDamagesDefenderByTwoHitPoints() {
        int defenderHitPointsBeforeAttack = defender.getHitPoints();
        attack.attack(STRONGEST_ATTACK_ROLL_VALUE);
        int defenderHitPointsAfterAttack = defender.getHitPoints();
        
        assertEquals(defenderHitPointsBeforeAttack - 2, defenderHitPointsAfterAttack);
    }
}
