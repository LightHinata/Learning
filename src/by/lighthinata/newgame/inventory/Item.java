package by.lighthinata.newgame.inventory;

/**
 * Created by VeriTi on 12.07.2014.
 */
public class Item {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price >= 0) {
            this.price = price;
        }
        else{
            throw new IllegalArgumentException("Are u fucking kidding me?!");
        }
    }
}
