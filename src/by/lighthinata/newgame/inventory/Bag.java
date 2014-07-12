package by.lighthinata.newgame.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by VeriTi on 12.07.2014.
 */
public class Bag {
    private static final int SIZE = 60;
    private List<Item> bag = new ArrayList<>(SIZE);
    public boolean put(Item item){
        if (bag.size() - Collections.frequency(bag, null) < SIZE) {
            bag.add(item);
            return true;
        }
        else {
            return false;
        }
    }

}
