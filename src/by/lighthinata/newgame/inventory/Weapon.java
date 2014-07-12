package by.lighthinata.newgame.inventory;

/**
 * Created by VeriTi on 12.07.2014.
 */
public class Weapon extends EquippableItem {
    private int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Weapon(int damage) {
        super(ItemSlot.RIGHT_HAND);
        this.damage = damage;
    }

    @Override
    protected boolean isValidSlot(ItemSlot slot) {
        return slot == ItemSlot.RIGHT_HAND;
    }
}
