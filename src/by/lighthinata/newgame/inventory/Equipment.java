package by.lighthinata.newgame.inventory;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by VeriTi on 12.07.2014.
 */
public class Equipment {

    private Map<ItemSlot, EquippableItem> equipment = new EnumMap<ItemSlot, EquippableItem>(ItemSlot.class);

    public EquippableItem equip(EquippableItem item){
        return equipment.put(item.getSlot(), item);
    }
    public EquippableItem unequip(ItemSlot itemSlot){
        return equipment.remove(itemSlot);
    }
}
