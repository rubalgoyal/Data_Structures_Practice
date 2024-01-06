import java.util.HashSet;
import java.util.LinkedList;

public class HashMapCode<K, V> {
    private class Node {
        K key;
        V value;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Node> arrayLinkedList[]; // stores key value pair
    private int bucketSize; // size of array
    private int nodeSize; // no of elements in HashMap
    private double thresholdValue; // value beyond which rehashing is required

    public HashMapCode() {
        this.bucketSize = 2;
        this.arrayLinkedList = new LinkedList[this.bucketSize];
        this.nodeSize = 0;
        this.thresholdValue = 2.0;
        // intialize LinkedList at each index of arrayLinkedList
        for(int i =0; i < this.bucketSize; i++){
            arrayLinkedList[i] = new LinkedList<Node>();
        }
    }
    public void put(K key, V value){
        int bucketIndex = getBucketIndex(key);
        int nodeIndex = getnodeIndex(key, bucketIndex);
        if(nodeIndex == -1){
            this.arrayLinkedList[bucketIndex].add(new Node(key,value));
            this.nodeSize++;
        }
        else {
            this.arrayLinkedList[bucketIndex].get(nodeIndex).value = value;
        }

        if((double)this.nodeSize/this.bucketSize > this.thresholdValue){
           rehash();
        }
    }
    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        int nodeIndex = getnodeIndex(key, bucketIndex);
        if(nodeIndex == -1)
            return null;
        else
            return this.arrayLinkedList[bucketIndex].get(nodeIndex).value;
    }
    public int size(){
        return this.nodeSize;
    }

    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        int nodeIndex = getnodeIndex(key,bucketIndex);
        if(nodeIndex == -1)
            return null;
        else{
           V nodeValue = this.arrayLinkedList[bucketIndex].get(nodeIndex).value;
            this.arrayLinkedList[bucketIndex].remove(nodeIndex);
            this.nodeSize--;
            return nodeValue;
        }
    }

    public boolean contains(K key){
        int bucketIndex = getBucketIndex(key);
        int nodeIndex = getnodeIndex(key, bucketIndex);
        if(nodeIndex != -1)
            return true;
        else
            return false;
    }

    public HashSet<K> keySet(){
        HashSet<K> hashSet = new HashSet<>();
        for(int i =0; i < this.bucketSize; i++){
            for(int j =0; j <this.arrayLinkedList[i].size(); j++){
                hashSet.add(this.arrayLinkedList[i].get(j).key);
            }
        }
        return hashSet;
    }

    private int getBucketIndex(K key){
        int hashCode = Math.abs(key.hashCode());
        return hashCode % this.bucketSize;
    }

    private int getnodeIndex(K key, int bucketIndex){
        LinkedList<Node> temp = this.arrayLinkedList[bucketIndex];
        for(int i =0; i < temp.size(); i++){
            if( temp.get(i).key == key)
                return i;
        }
        return -1;
    }

    private void rehash(){
        LinkedList<Node> temp[]  = this.arrayLinkedList.clone();
        this.arrayLinkedList = new LinkedList[this.bucketSize * 2];
        int oldBucketSize = this.bucketSize;
        this.bucketSize = this.bucketSize * 2;
        this.nodeSize = 0;

        for(int i =0; i < this.bucketSize; i++){
            arrayLinkedList[i] = new LinkedList<Node>();
        }

        for(int i = 0; i < oldBucketSize; i++ ){
            for(int j =0; j < temp[i].size(); j++){
                put(temp[i].get(j).key,temp[i].get(j).value);
            }
        }

    }
}
