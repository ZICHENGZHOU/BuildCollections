package hash;

import static org.junit.Assert.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class HashMapTest {
    public static boolean USE_HASH = true;

    @Test
    public void testPut() {
        Map<String, Double> map = (Map<String, Double>) (USE_HASH ? new HashMap<String, Double>() : new BSTMap<String, Double>());
        map.put("apple", 3.5);
        assertTrue(map.size() == 1);
        System.out.println("hmmm we got: "+map.toString());
        assertTrue(map.toString().equals("(apple, 3.5)"));
        map.put("orange", 4.0);
        System.out.println("Size: "+map.size()+" "+map.toString());
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(apple, 3.5), (orange, 4.0)") || map.toString().equals("(orange, 4.0), (apple, 3.5)"));
        map.put("orange", 3.50);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(apple, 3.5), (orange, 3.5)") || map.toString().equals("(orange, 3.5), (apple, 3.5)"));
        map.put("banana", 2.50);
        assertTrue(map.size() == 3);
    }

    @Test
    public void testRemove() {
        Map<String, Double> map = (Map<String, Double>) (USE_HASH ? new HashMap<String, Double>() : new BSTMap<String, Double>());
        map.put("apple",3.50);
        map.put("orange",4.00);
        map.put("banana",2.50);
        assertTrue(map.size() == 3);
        map.remove("banana");
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(apple, 3.5), (orange, 4.0)") || map.toString().equals("(orange, 4.0), (apple, 3.5)"));
        map.remove("orange");
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(apple, 3.5)"));
        map.remove("orange");
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(apple, 3.5)"));
    }

    @Test
    public void testGet() {
        Map<String, Double> map = (Map<String, Double>) (USE_HASH ? new HashMap<String, Double>() : new BSTMap<String, Double>());
        map.put("apple",3.50);
        map.put("orange",4.00);
        map.put("banana",2.00);
        assertTrue(map.size() == 3);
        assertTrue(map.get("apple") == 3.5 && map.get("orange") == 4 && map.get("banana") == 2.00);
        assertTrue(map.get("pineapple") == null);
    }

}