package ab.evercraft.test.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ab.evercraft.domain.EvercraftCharacter;
import ab.evercraft.domain.EvercraftCharacterDefaults;
import ab.evercraft.exception.InvalidAlignmentException;

public class EvercraftCharacterTest {
    
    private EvercraftCharacter myCharacter = null;
    private static final String CHARACTER_NAME = "Scott";
    private static final String VALID_ALIGNMENT = "Good";
    private static final String INVALID_ALIGNMENT = "Bad Ass";
    
    @Before
    public void setUp() throws Exception {
        myCharacter = new EvercraftCharacter();
    }
    
    @Test
    public void canCreateEvercraftCharacter() {
        assertNotNull(myCharacter);
    }
    
    @Test
    public void canSetCharacterName() {
        myCharacter.setName(CHARACTER_NAME);
        assertEquals(CHARACTER_NAME, myCharacter.getName());
    }
    
    @Test
    public void canSetValidAlignment() {
        myCharacter.setAlignment(VALID_ALIGNMENT);
        assertEquals(VALID_ALIGNMENT, myCharacter.getAlignment());
    }
    
    @Test(expected = InvalidAlignmentException.class)
    public void setingInvalidAlignmentThrowsException() {
        myCharacter.setAlignment(INVALID_ALIGNMENT);
    }
    
    @Test
    public void newCharacterHasCorrectArmorClassDefault() {
        assertEquals(EvercraftCharacterDefaults.ARMOR_CLASS, myCharacter.getArmorClass());
    }
    
    @Test
    public void newCharacterHasCorrectHitPointsDefault() {
        assertEquals(EvercraftCharacterDefaults.HIT_POINTS, myCharacter.getHitPoints());
    }
    
}
