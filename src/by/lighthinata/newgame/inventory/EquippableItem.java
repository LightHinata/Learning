package by.lighthinata.newgame.inventory;

/**
 * Created by VeriTi on 12.07.2014.
 */
public abstract class EquippableItem extends Item {
    private final ItemSlot slot;

    protected EquippableItem(ItemSlot slot) {
        if (isValidSlot(slot)){
            this.slot = slot;
        }
        else {
            throw new IllegalArgumentException(String.format("Slot %s isn't valid for class %s",
                                               slot, this.getClass().getSimpleName()));
        }
    }
    protected abstract boolean isValidSlot(ItemSlot slot);

    public ItemSlot getSlot() {
        return slot;
    }
}
