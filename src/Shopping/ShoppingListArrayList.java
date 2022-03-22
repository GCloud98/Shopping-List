package Shopping;

import java.util.*;

/**
 * This is the file where you will do most of your work. You are responsible for
 * implementing remove(), find(), and contains(). Feel free to use the Array
 * based implementation as a base to figure out what you need to do
 * 
 * @version Spring 2021
 * @author ITCS 2214
 */
public class ShoppingListArrayList implements ShoppingListADT {

    private ArrayList<Grocery> shoppingList;

    /**
     * Default constructor for creating an empty shopping list
     */
    public ShoppingListArrayList() {
        this.shoppingList = new ArrayList<>();
    }

    /**
     * Method to add a new entry to the shopping list. If a matching item already
     * exists, the quantities are combined
     * 
     * @param entry the new item to add
     */
    @Override
    public void add(Grocery entry) {
        if (entry == null) {
            return;
        }

        // Check if this item already exists
        if (this.contains(entry)) {
            // Merge the quantity of new entry into existing entry
            this.combineQuantity(entry);
            return;
        }

        this.shoppingList.add(entry);
    }

    /**
     * Method to remove a specific entry from the shopping list
     * 
     * @param entry the item to remove
     * @return true if the operation was completed successfully
     */
    @Override
    public boolean remove(Grocery entry) {

        // the boolean found describes whether or not we find the
        // entry to remove
        boolean found = false;
     // TODO Search the parameter variable ent in the shoppingList;
        for(int i = 0; i < shoppingList.size(); i++) {
            
            if(shoppingList.contains(entry)) {
                shoppingList.remove(entry);
                found = true;
            }
        }

        // Return false if not found
        return found;
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
        // TODO throw EmptyCollectionException if shopping list is empty
        if(shoppingList.isEmpty()) {
            throw new EmptyCollectionException("Empty Collection");
        }
        // TODO check whether or not the given index is legal
        if(index > shoppingList.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        // for example, the given index is less than 0 or falls outside of the size.
        // If it is not legal, throw an IndexOutOfBoundsException

        // return the corresponding entry in the shoppingList
       return shoppingList.get(index);
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
        if (entry != null) {
            for (int i = 0; i < shoppingList.size(); i++) {
                if (shoppingList.get(i).compareTo(entry) == 0) {
                    return i;
                }
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
        boolean hasItem = false;

        if (entry != null) {
        // TODO go through the shoppingList and try to find the given item, named entry, in the list. 
             for(int i = 0; i < shoppingList.size(); i++) {
                if(shoppingList.contains(entry)) {
                hasItem = true;
                }
            }
        //If found, return true. Either using methods from Java build-in ArrayList method 
        //or writing your own loop is fine.
        }
        return hasItem;
    }

    /**
     * Method to get the size of the shopping list
     * 
     * @return the size of the shopping list
     */
    @Override
    public int size() {
        return shoppingList.size();
    }

    /**
     * Method to tell if the shopping list is empty
     * 
     * @return true if the shopping list is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return shoppingList.isEmpty();
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
        for (int i = 0; i < shoppingList.size(); i++) {
            s.append(String.format("%-25s", this.shoppingList.get(i).getName()));
            s.append(String.format("%-18s", this.shoppingList.get(i).getCategory()));
            s.append(String.format("%-10s", this.shoppingList.get(i).getAisle()));
            s.append(String.format("%-10s", this.shoppingList.get(i).getQuantity()));
            s.append(String.format("%-10s", this.shoppingList.get(i).getPrice()));
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
            this.shoppingList.get(index).setQuantity(this.shoppingList.get(index).getQuantity() + entry.getQuantity());
        } catch (ElementNotFoundException e) {
            System.out.println("combineQuantity - ECE");
        }

    }

}
