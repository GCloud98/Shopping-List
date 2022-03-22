package Shopping;

/**
 * @version Spring 2021
 * @author ITCS 2214
 */
public class Grocery implements Comparable<Grocery> {
    private String name;
    private String category;
    private int aisle;
    private float price;
    private int quantity;

    /**
     * Basic constructor of Grocery object. Objects that match name and category are
     * considered equivalent.
     * 
     * @param name     the name of the grocery item
     * @param category the category of the grocery item
     */
    public Grocery(String name, String category) {
        this.name = name;
        this.category = category;
        this.aisle = -1;
        this.price = 0.0f;
        this.quantity = 0;
    }

    /**
     * Full constructor of Entry object.
     *
     * @param name     the name of the grocery item
     * @param category the category of the grocery item
     * @param aisle    the aisle where the grocery item is located
     * @param price    the price of the grocery item
     * @param quantity the quantity of the item to purchase
     */
    public Grocery(String name, String category, int aisle, float price, int quantity) {
        this.name = name;
        this.category = category;
        this.aisle = aisle;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Copy constructor
     * 
     * Should this be used in the tests or does the equals overide fix this?
     * 
     * @param another An existing grocery object to copy
     */
    public Grocery(Grocery another) {
        if (another != null) {
            this.name = another.getName();
            this.category = another.getCategory();
            this.aisle = another.getAisle();
            this.price = another.getPrice();
            this.quantity = another.getQuantity();
        }
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category of the item.
     *
     * @return the category of the item
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the item.
     *
     * @param category the category of the item
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the aisle of the item.
     *
     * @return the aisle of the item
     */
    public int getAisle() {
        return aisle;
    }

    /**
     * Sets the aisle of the item.
     *
     * @param aisle the aisle of the item
     */
    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the price of the item
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item.
     *
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of this item
     * 
     * @return a string representation of this item
     */
    @Override
    public String toString() {
        return "Grocery{" + "name=" + name + ", category=" + category + ", aisle=" + aisle + ", price=" + price
                + ", quantity=" + quantity + "}";
    }

    /**
     * Implementation of compareTo for Grocery objects
     * 
     * @param t the Grocery object to compare
     * @return negative if the calling object goes before the referenced, positive
     *         if the calling object goes after the referenced, zero if the two
     *         objects are equivalent
     */
    @Override
    public int compareTo(Grocery t) {
        if (this.getName().toUpperCase().compareTo(t.getName().toUpperCase()) == 0) {
            return this.getCategory().compareToIgnoreCase(t.getCategory().toUpperCase());
        }
        return this.getName().compareToIgnoreCase(t.getName().toUpperCase());
    }

    /**
     * Implementation of equals for Grocery objects
     * 
     * @param t the Grocery object to compare
     * @return true if the two objects are equivalent, otherwise false
     */
    @Override
    public boolean equals(Object t) {
        Grocery temp = (Grocery) t;
        return this.compareTo(temp) == 0;
    }

}