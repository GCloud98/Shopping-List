package Shopping;

/**
 * @version Spring 2021
 * @author ITCS 2214
 */
public interface ShoppingListADT {
    /**
     * Method to add a new entry to the shopping list. If a matching item already
     * exists, the quantities are combined
     * 
     * @param entry the new item to add
     */
    public void add(Grocery entry);

    /**
     * Method to remove a specific entry from the shopping list
     * 
     * @param entry the item to remove
     * @return true if the opperation was completed successfully
     */
    public boolean remove(Grocery entry);

    /**
     * Method to find a specific item in the shopping list
     * 
     * @param index the index of the item in the shopping list
     * @return the entry at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @throws EmptyCollectionException  if the shopping list is empty
     */
    public Grocery find(int index) throws IndexOutOfBoundsException, EmptyCollectionException;

    /**
     * Method to find the index of a Grocery item that is equivalent to the one
     * provided
     * 
     * @param entry the item to find
     * @return the index of the specified item in the shopping list
     * @throws ElementNotFoundException if the specified item is not in the shopping
     *                                  list
     */
    public int indexOf(Grocery entry) throws ElementNotFoundException;

    /**
     * Method to determine the existence of a specific item in the shopping list
     * 
     * @param entry the item to find
     * @return true if the specified item exists in the shopping list, otherwise
     *         false
     */
    public boolean contains(Grocery entry);

    /**
     * Method to get the size of the shopping list
     * 
     * @return the size of the shopping list
     */
    public int size();

    /**
     * Method to tell if the shopping list is empty
     * 
     * @return true if the shopping list is empty, otherwise false
     */
    public boolean isEmpty();

    /**
     * Method to return a string representation of the shopping list
     * 
     * @return the string representation of the shopping list
     */
    @Override
    public String toString();
}
