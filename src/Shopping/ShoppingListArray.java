package Shopping;

import java.util.Arrays;

/**
 * @version Spring 2021
 * @author ITCS 2214
 */
public class ShoppingListArray implements ShoppingListADT {

    private static final int DEFAULT_SIZE = 5;
    private Grocery[] shoppingList;
    private int size;

    /**
     * Default constructor to create an empty shopping list
     */
    public ShoppingListArray() {
        shoppingList = new Grocery[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Method to add a new entry to the shopping list. If a matching item already
     * exists, the quantities are combined
     * 
     * @param entry the new item to add
     */
    @Override
    public void add(Grocery entry) {
        // Check if the item is already in shoppingList
        if (this.contains(entry)) {
            // Call combineQuantity to merge items
            this.combineQuantity(entry);
            return;
        }

        // Increase shoppingList size if needed
        if (size == shoppingList.length) {
            this.expandCapacity();
        }

        shoppingList[size++] = entry;
    }

    /**
     * Method to remove a specific entry from the shopping list
     * 
     * @param entry the item to remove
     * @return true if the operation was completed successfully
     */
    @Override
    public boolean remove(Grocery entry) {
        // Find entry in shoppingList
        int index = -1;
        try {
            index = this.indexOf(entry);
        } catch (ElementNotFoundException e) {
            // Return false if the entry is not found
            return false;
        }

        // Shift elements to remove from shoppingList
        for (int i = index; i + 1 < size; i++) {
            this.shoppingList[i] = this.shoppingList[i + 1];
        }

        this.shoppingList[size - 1] = null;

        size--;
        return true;
    }

    /**
     * Method to find a specific item in the shopping list
     * 
     * @param index the index of the item in the shopping list
     * @return the entry at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @throws EmptyCollectionException  if the shopping list is empty
     */
    @Override
    public Grocery find(int index) throws IndexOutOfBoundsException, EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("ECE - find");
        }

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IOOBE - find");
        }

        return shoppingList[index];
    }

    /**
     * Method to find the index of a Grocery item that is equivalent to the one
     * provided
     * 
     * @param entry the item to find
     * @return the index of the specified item in the shopping list
     * @throws ElementNotFoundException if the specified item is not in the shopping
     *                                  list
     */
    @Override
    public int indexOf(Grocery entry) throws ElementNotFoundException {
        for (int i = 0; i < size; i++) {
            if (this.shoppingList[i].equals(entry)) {
                return i;
            }
        }

        throw new ElementNotFoundException("indexOf");
    }

    /**
     * Method to determine the existence of a specific item in the shopping list
     * 
     * @param entry the item to find
     * @return true if the specified item exists in the shopping list, otherwise
     *         false
     */
    @Override
    public boolean contains(Grocery entry) {
        for (int i = 0; i < size; i++) {
            if (this.shoppingList[i] != null && this.shoppingList[i].equals(entry)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to get the size of the shopping list
     * 
     * @return the size of the shopping list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Method to tell if the shopping list is empty
     * 
     * @return true if the shopping list is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Method to return a string representation of the shopping list
     * 
     * @return the string representation of the shopping list
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-25s", "NAME"));
        s.append(String.format("%-18s", "CATEGORY"));
        s.append(String.format("%-10s", "AISLE"));
        s.append(String.format("%-10s", "QUANTITY"));
        s.append(String.format("%-10s", "PRICE"));
        s.append('\n');
        s.append("------------------------------------------------------------" + "-------------");
        s.append('\n');
        for (int i = 0; i < size; i++) {
            s.append(String.format("%-25s", this.shoppingList[i].getName()));
            s.append(String.format("%-18s", this.shoppingList[i].getCategory()));
            s.append(String.format("%-10s", this.shoppingList[i].getAisle()));
            s.append(String.format("%-10s", this.shoppingList[i].getQuantity()));
            s.append(String.format("%-10s", this.shoppingList[i].getPrice()));
            s.append('\n');
            s.append("--------------------------------------------------------" + "-----------------");
            s.append('\n');
        }

        return s.toString();
    }

    /**
     * Method to add the quantity of duplicate entries in the shopping list
     * 
     * @param entry duplicate entry
     */
    private void combineQuantity(Grocery entry) {
        try {
            int index = this.indexOf(entry);
            this.shoppingList[index].setQuantity(this.shoppingList[index].getQuantity() + entry.getQuantity());
        } catch (ElementNotFoundException e) {
            System.out.println("combineQuantity - ECE");
        }

    }

    /**
     * Method to expand the capacity of the collection.
     */
    private void expandCapacity() {
        this.shoppingList = Arrays.copyOf(shoppingList, size * 2);
    }

}
