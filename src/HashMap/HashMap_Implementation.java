package HashMap;

import java.util.LinkedList;

public class HashMap_Implementation {
    static class MyHashMap<K,V>{
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        // class Node
        private class Node{
            K key;
            V value;
            Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // returns the numbers of entries in the map,,,,
        private LinkedList<Node>[] buckets;

        private void initBuckets(int N) {// N --> capacity/size of buckets array
            buckets = new LinkedList[N]; // buckets ko bolo ek naya array banao linked list ka....
            for(int i = 0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>(); // saare buckets me jaao and usme ek empty linked list rakh do....
            }
        }

        // returns bucket Index....
        private int HashFunc(K key){
            int hc = key.hashCode(); // returns hashedValue....
            return (Math.abs(hc)) % buckets.length;
        }

        // Traverse the ll and looks for a node with key, if found it returns it's index otherwise it returns null....
        private int searchInBucket(LinkedList<Node> ll,K key){
            for(int i = 0; i<ll.size();i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }
        // constructor...
        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }

        public int capacity(){
            return buckets.length;
        }

        public float load(){
            return (n*1.0f)/buckets.length;
        }

        // rehashing function...
        private void rehash(){
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length * 2);
            n = 0;
            for(var bucket : oldBuckets){
                for(var node : bucket){
                    put(node.key, node.value);
                }
            }
        }
        // size
        public int size(){ // returns the numbers of entries in the map,,,,
            return n;
        }

        // put
        public void put(K key, V value){  // insert/update
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if(ei == -1){ // key doesn't exist...
                Node node = new Node(key,value);
                currBucket.add(node);
                n++;
            }
            else{ // update case...
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }

            // rehashing....
            if(n >= buckets.length * DEFAULT_LOAD_FACTOR){
                 rehash();
            }
        }

        // get
        public V get(K key){
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if(ei != -1){ // key exists...
                Node currNode = currBucket.get(ei);
                return currNode.value;
            }
            else{ // key doesn't exist...
                return null;
            }
        }

        // remove
        public V remove(K key){
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if(ei != -1){ // key exists....
                Node currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            }
            else{ // key doesn't exist...
                return null;
            }
        }

    }
    public static void main(String[] args) {
        MyHashMap<String,Integer> mp = new MyHashMap<>();
        mp.put("A",1);
        mp.put("B",2);
        System.out.println("CAPACITY :" + mp.capacity());
        System.out.println("LOAD FACTOR :" + mp.load());
        mp.put("C",3);
        mp.put("D",61);
        mp.put("E",65);
        System.out.println(mp.size());
        mp.put("C",30);
        System.out.println(mp.size());
        System.out.println(mp.get("D"));
        System.out.println(mp.get("E"));
        System.out.println(mp.get("C")); // updated...
        System.out.println(mp.get("college")); // null
        System.out.println(mp.remove("C")); // 30
        System.out.println(mp.remove("C")); // null
        System.out.println(mp.size()); // 4

        System.out.println("CAPACITY :" + mp.capacity());
        System.out.println("LOAD FACTOR :" + mp.load());
    }
}
