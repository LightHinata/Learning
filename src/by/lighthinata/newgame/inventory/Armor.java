package by.lighthinata.newgame.inventory;

import java.util.Arrays;

import static by.lighthinata.newgame.inventory.ItemSlot.*;

/**
 * Created by VeriTi on 12.07.2014.
 */
public class Armor extends EquippableItem {
    private int reductionOfDamage;

    public Armor(ItemSlot slot, int reductionOfDamage) {
        super(slot);
        this.reductionOfDamage = reductionOfDamage;
    }

    public int getReductionOfDamage() {
        return reductionOfDamage;
    }

    public void setReductionOfDamage(int reductionOfDamage) {
        this.reductionOfDamage = reductionOfDamage;
    }

    @Override
    protected boolean isValidSlot(ItemSlot slot) {
        return Arrays.asList(HEAD, BODY, HANDS, LEGS, FEET).contains(slot);
    }
}
