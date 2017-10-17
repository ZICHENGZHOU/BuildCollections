package hash;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BSTSetTest {

    public static boolean USE_HASH = false;

    @Test
    public void testAdd() {
        Set<String> set = (Set<String>) (USE_HASH ? new HashSet<String>() : new BSTSet<String>());
        set.add("apple");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("apple"));
        set.add("orange");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("apple, orange") || set.toString().equals("orange, apple"));
        set.add("orange");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("apple, orange") || set.toString().equals("orange, apple"));
        set.add("banana");
        assertTrue(set.size() == 3);
    }

    @Test
    public void testRemove() {
        Set<String> set = (Set<String>) (USE_HASH ? new HashSet<String>() : new BSTSet<String>());
        set.add("apple");
        set.add("orange");
        set.add("banana");
        assertTrue(set.size() == 3);
        set.remove("banana");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("apple, orange") || set.toString().equals("orange, apple"));
        set.remove("orange");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("apple"));
        set.remove("orange");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("apple"));
    }

    @Test
    public void testContains() {
        Set<String> set = (Set<String>) (USE_HASH ? new HashSet<String>() : new BSTSet<String>());
        set.add("apple");
        set.add("orange");
        set.add("banana");
        assertTrue(set.size() == 3);
        assertTrue(set.contains("apple") && set.contains("orange") && set.contains("banana"));
        assertFalse(set.contains("pineapple"));
    }
}
