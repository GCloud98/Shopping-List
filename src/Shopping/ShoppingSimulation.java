package Shopping;

/**
 * @version Spring 2021
 * @author ITCS 2214
 */
public class ShoppingSimulation {
    public static void main(String[] args) {
        ShoppingListADT sl;

        // Pick the implementation of shopping list to use
        //sl = new ShoppingListArray();
         sl = new ShoppingListArrayList();

        // Initial fill of shopping list
        sl.add(new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1));
        sl.add(new Grocery("Green Tea", "Tea", 6, 1.99f, 2));
        sl.add(new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1));
        sl.add(new Grocery("Admiral Ackbar Cereal", "Cereal", 7, 4.99f, 1));
        sl.add(new Grocery("Tide Pods", "Laundry", 9, 1.99f, 4));
        sl.add(new Grocery("Spam", "Can Meat", 1, 2.99f, 3));
        sl.add(new Grocery("Spam", "Can Meat", 1, 2.99f, 3));
        sl.add(new Grocery("Honey Wheat", "Pancake Mix", 7, 1.99f, 1));
        sl.add(new Grocery("Clorox", "Bleach", 9, 6.99f, 1));
        sl.add(new Grocery("Velveeta", "Cheese", 13, 3.99f, 2));
        sl.add(new Grocery("I Can't Believe It's Not", "Butter", 13, 2.99f, 2));
        sl.add(new Grocery("Uncle Bens", "Rice", 2, 1.99f, 1));

        sl.add(new Grocery("Pistachio Ice Cream", "Dairy", 10, 2.99f, 1));
        System.out.println("Does list contain Pistachio Ice Cream? "
                + sl.contains(new Grocery("Pistachio Ice Cream", "Dairy", 10, 2.99f, 1)));
        System.out.println("Does list contain Dill Pickles? "
                + sl.contains(new Grocery("Dill Pickles", "Condiments", 4, 2.99f, 1)));
        System.out.println("Let's add 3 jars of pickles.");
        sl.add(new Grocery("Dill Pickles", "Condiments", 4, 2.99f, 3));
        System.out.println("Let's remove the ice cream.");
        sl.remove(new Grocery("Pistachio Ice Cream", "Dairy", 10, 2.99f, 1));
        System.out.println("Does list contain Pistachio Ice Cream? "
                + sl.contains(new Grocery("Pistachio Ice Cream", "Dairy", 10, 2.99f, 1)));
        System.out.println("Here is the whole shopping list: \n" + sl + "\n");
    }
}
