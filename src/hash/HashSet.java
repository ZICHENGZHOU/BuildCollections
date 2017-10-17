package hash;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {
    private final int DEFAULT_SIZE = 2;
    LinkedList<T>[] table;
    int number = 0;

    public HashSet() {
        table = (LinkedList<T>[])new LinkedList [DEFAULT_SIZE];
    }

    public HashSet(int size) {
        table = (LinkedList<T>[]) new LinkedList[size];
    }

    private int hash(T element){
        return (Math.abs(element.hashCode()) % table.length);
    }


    @Override
    public void add(T element) {
        int temp = hash(element);
        if (table[temp] == null)
            table[temp] = new LinkedList<T>();
        if (table[temp].contains(element))
            return;
        else {
            table[temp].add(element);
            number++;
        }
    }

    @Override
    public void remove(T element) {
        int temp = hash(element);
        if (table[temp] == null) return;
        if (table[temp].contains(element)) {
            table[temp].remove(element);
            number--;
        }
        else {
            return;
        }
    }

    @Override
    public boolean contains(T element) {
        int temp = hash(element);
        LinkedList list = table[temp];
        if (list == null) return false;
        if (list.contains(element))
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return number;
    }

    @Override
    public String toString() {
        String rtn = "";

        for (int i=0; i<table.length; i++){
            if (table[i] != null){
                for (T element : table[i]){
                    if (! rtn.equals(""))
                        rtn += ", ";
                    rtn += element.toString();
                }
            }
        }
        return rtn;
    }


    @Override
    public HashSet<T> newInstance(){
        return new HashSet<T>(this.table.length);
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("apple");
        System.out.println(set.toString());
    }
}
