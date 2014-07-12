package by.lighthinata.newgame.inventory;

/**
 * Created by VeriTi on 12.07.2014.
 */
public class Shield extends Armor{
    private double blockChance;

    public Shield(ItemSlot slot, int reductionOfDamage, double blockChance) {
        super(ItemSlot.LEFT_HAND, reductionOfDamage);
        this.blockChance = blockChance;
    }

    @Override
    protected boolean isValidSlot(ItemSlot slot) {
        return slot == ItemSlot.LEFT_HAND;
    }
}
