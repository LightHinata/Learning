package by.lighthinata.newgame.inventory;

import java.util.Arrays;

import static by.lighthinata.newgame.inventory.ItemSlot.*;

/**
 * Created by VeriTi on 12.07.2014.
 */
public class Clothing extends EquippableItem {
    protected Clothing(ItemSlot slot) {
        super(slot);
    }

    @Override
    protected boolean isValidSlot(ItemSlot slot) {
        return Arrays.asList(EYES, EARS, NECK, TALISMAN).contains(slot);
    }
}
