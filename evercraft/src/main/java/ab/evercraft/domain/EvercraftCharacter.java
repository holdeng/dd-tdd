package ab.evercraft.domain;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import ab.evercraft.exception.InvalidAlignmentException;

@Data
public class EvercraftCharacter {
    
    private String name;
    private String alignment;
    private int armorClass = EvercraftCharacterDefaults.ARMOR_CLASS;
    private int hitPoints = EvercraftCharacterDefaults.HIT_POINTS;
    
    public void setAlignment(String alignment) {
        if (!StringUtils.equals(alignment, "Good") && !StringUtils.equals(alignment, "Neutral") && !StringUtils.equals(alignment, "Evil")) {
            throw new InvalidAlignmentException();
        }
        
        this.alignment = alignment;
    }
    
}
