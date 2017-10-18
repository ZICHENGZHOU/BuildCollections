package hash;

import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    private final int DEFAULT_SIZE = 2;
    LinkedList<KPairs<K, V>>[] table;
    int number = 0;

    public HashMap(){
        table = (LinkedList<KPairs<K, V>>[])new LinkedList[DEFAULT_SIZE];
    }

    class KPairs<K, V> {
        K key;
        V value;
        KPairs(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    int hash(K key) {
        return (Math.abs(key.hashCode()) % table.length);
    }

    private KPairs<K, V> find(LinkedList<KPairs<K, V>> list, K key) {
        for (KPairs<K, V> kPair : list) {
            if (kPair.key.equals(key))
                return kPair;
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int temp = hash(key);
        if (table[temp] == null)
            table[temp] = new LinkedList<KPairs<K, V>>();
        KPairs<K, V> kp = this.find(table[temp], key);
        if (kp != null) {
            kp.value = value;
        }
        else {
            table[temp].add(new KPairs<>(key, value));
            number++ ;
        }
    }

    @Override
    public void remove(K key) {
        int temp = hash(key);
        if (table[temp] == null)
            return;
        KPairs<K, V> kp = this.find(table[temp], key);
        if (kp == null)
            return;
        else {
            table[temp].remove(kp);
            number--;
        }
    }

    @Override
    public V get(K key) {
        int temp = hash(key);
        if (table[temp] == null)
            return null;
        KPairs<K, V> kp = this.find(table[temp], key);
        if (kp == null)
            return  null;
        else
            return kp.value;
    }

    @Override
    public int size() {
        return number;
    }

    @Override
    public String toString() {
        String rtn = "";

        for (int bkt = 0; bkt < table.length; bkt++) {
            if (table[bkt] != null) {
                LinkedList<KPairs<K,V>> ll = table[bkt];
                for (KPairs<K,V> kv : ll) {
                    if (!rtn.equals(""))
                        rtn += ", ";
                    rtn += kv.toString();
                }
            }
        }

        return rtn;
    }
}
