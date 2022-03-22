package Shopping;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 * @version Spring 2021
 * @author ITCS 2214
 */
public class ShoppingListArrayTest {
    private ShoppingListArray instance;
    private Grocery entry;

    @Before
    public void setUp() {
        instance = new ShoppingListArray();

        instance.add(new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1));
        instance.add(new Grocery("Green Tea", "Tea", 6, 1.99f, 2));
        instance.add(new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1));
        instance.add(new Grocery("Admiral Ackbar Cereal", "Cereal", 7, 4.99f, 1));
        instance.add(new Grocery("Tide Pods", "Laundry", 9, 1.99f, 4));
        instance.add(new Grocery("Spam", "Can Meat", 1, 2.99f, 3));
        instance.add(new Grocery("Honey Wheat", "Pancake Mix", 7, 1.99f, 1));
        instance.add(new Grocery("Clorox", "Bleach", 9, 6.99f, 1));
        instance.add(new Grocery("Velveeta", "Cheese", 13, 3.99f, 2));
        instance.add(new Grocery("I Can't Believe It's Not", "Butter", 13, 2.99f, 2));
        instance.add(new Grocery("Uncle Bens", "Rice", 2, 1.99f, 1));

        entry = new Grocery("Whole Milk", "Dairy", 1, 3.99f, 2);
    }

    @Test
    public void testAdd() {
        // Verify expected starting state
        Assert.assertEquals(11, instance.size());
        Assert.assertFalse(instance.contains(entry));

        // Add test item
        instance.add(entry);

        // Test that size increased correctly
        Assert.assertEquals(12, instance.size());

        // Test that the item has been added correctly
        Assert.assertTrue(instance.contains(entry));

        // Prepare to add duplicate entry to test combine quantity
        int expectedQuantity = entry.getQuantity() + 2;
        Grocery entry2 = new Grocery(entry.getName(), entry.getCategory());
        entry2.setQuantity(2);

        // Verify that combine quantity has functioned properly
        instance.add(entry2);
        Assert.assertEquals(instance.size(), 12);
        try {
            Assert.assertEquals(expectedQuantity, instance.find(instance.indexOf(entry2)).getQuantity());
        } catch (Exception e) {
            Assert.fail("Unexpected exception");
        }
    }

    @Test
    public void testRemove() {
        // Verify initial state
        Assert.assertFalse(instance.remove(entry));

        // Add test item
        instance.add(entry);
        Assert.assertEquals(12, instance.size());
        Assert.assertTrue(instance.contains(entry));

        // Remove item and make sure true is returned upon success
        Assert.assertTrue(instance.remove(entry));

        // Test that the size was decreased and the item removed
        Assert.assertEquals(11, instance.size());
        Assert.assertFalse(instance.contains(entry));

        try {
            // Prepare to test for holes
            Grocery expectedGrocery = instance.find(3);
            instance.remove(instance.find(2));

            // Test that holes are properly filled
            Assert.assertEquals(10, instance.size());
            Assert.assertEquals(expectedGrocery, instance.find(2));
        } catch (Exception e) {
            Assert.fail("Unexpected exception");
        }
    }

    @Test
    public void testFind() {
        // Test IOOB errors
        try {
            instance.find(-1);
            Assert.fail("find does not fail with negative index");
        } catch (IndexOutOfBoundsException e) {
        } catch (Exception e) {
            Assert.fail("Unexpected exception testing negative index");
        }
        try {
            instance.find(20);
            Assert.fail("find does not fail with large index");
        } catch (IndexOutOfBoundsException e) {
        } catch (Exception e) {
            Assert.fail("Unexpected exception testing large index");
        }

        // Test normal find behavior
        try {
            Grocery first = instance.find(0);
            Assert.assertEquals(first, new Grocery("Mayo", "Dressing / Mayo"));
            Assert.assertEquals(11, instance.size());
        } catch (Exception e) {
            Assert.fail("Unexpected exception testing normal index");
        }

        // Prepare for ECE test
        try {
            for (int i = instance.size() - 1; i >= 0; i--) {
                instance.remove(instance.find(i));
            }
            Assert.assertTrue(instance.isEmpty());
        } catch (Exception e) {
            Assert.fail("Unexpected exception clearing list");
        }

        // Test ECE errors
        try {
            instance.find(0);
            Assert.fail("find does not fail with empty collection");
        } catch (EmptyCollectionException e) {
        } catch (Exception e) {
            Assert.fail("Unexpected exception testing empty collection");
        }
    }

    @Test
    public void testIndexOf() {
        // Test indexOf non-existant item
        try {
            instance.indexOf(entry);
            Assert.fail("No exception for indexOf misssing item");
        } catch (ElementNotFoundException e) {

        } catch (Exception e) {
            Assert.fail("Unexpected exception testing misssing item");
        }

        // Test indexOf existing item
        try {
            Assert.assertEquals(0, instance.indexOf(new Grocery("Mayo", "Dressing / Mayo")));
            Assert.assertEquals(1, instance.indexOf(new Grocery("Green Tea", "Tea")));
        } catch (ElementNotFoundException e) {
            Assert.fail("Unexpected exception testing existing item");
        }
    }

    @Test
    public void testContains() {
        // Test for non-existant item
        Assert.assertFalse(instance.contains(entry));

        // Test for existing item
        Assert.assertTrue(instance.contains(new Grocery("Mayo", "Dressing / Mayo")));
    }

    @Test
    public void testSize() {
        // Check size of shopping list
        Assert.assertEquals(11, instance.size());

        // All other cases have been tested in other methods
    }

    @Test
    public void testIsEmpty() {
        // Test not empty
        Assert.assertFalse(instance.isEmpty());

        // Test is empty
        try {
            for (int i = instance.size() - 1; i >= 0; i--) {
                instance.remove(instance.find(i));
            }
            Assert.assertTrue(instance.isEmpty());
        } catch (Exception e) {
            Assert.fail("Unexpected exception clearing list");
        }
    }

    @Test
    public void testToString() {
        // Make sure everything matches
        String expected = "NAME                     CATEGORY          AISLE     QUANTITY  PRICE     \n"
                + "-------------------------------------------------------------------------\n"
                + "Mayo                     Dressing / Mayo   1         1         2.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Green Tea                Tea               6         2         1.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Lucky Charms             Cereal            7         1         3.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Admiral Ackbar Cereal    Cereal            7         1         4.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Tide Pods                Laundry           9         4         1.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Spam                     Can Meat          1         3         2.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Honey Wheat              Pancake Mix       7         1         1.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Clorox                   Bleach            9         1         6.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Velveeta                 Cheese            13        2         3.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "I Can't Believe It's Not Butter            13        2         2.99      \n"
                + "-------------------------------------------------------------------------\n"
                + "Uncle Bens               Rice              2         1         1.99      \n"
                + "-------------------------------------------------------------------------\n";
        Assert.assertEquals(expected, instance.toString());

    }
}
