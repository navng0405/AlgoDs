package Mart;

import java.util.HashMap;
import java.util.Map;

//Implement Doubly Linked List
//Map - >integer , Node
public class LRUCache {

    int capacity;
    int size;
    Map<Integer,DoublyListNode> cache ;
    DoublyListNode head;
    DoublyListNode tail;



    LRUCache(int capacity){
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new DoublyListNode();
        tail = new DoublyListNode();
        head.next = tail;
        tail.prev = head;
    }
    class DoublyListNode{
        int key;
        int value;
        DoublyListNode prev;
        DoublyListNode next;
    }

    private void addNode(DoublyListNode node){
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void removeNode(DoublyListNode node){
        DoublyListNode prev = node.prev;
        DoublyListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoublyListNode node){
        removeNode(node);
        addNode(node);
    }

    private DoublyListNode popTail(){
        DoublyListNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void put(int key, int value) {
        DoublyListNode node = cache.get(key);
        if(node == null){
            DoublyListNode newNode = new DoublyListNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key,newNode);

            ++size;
            if(size>capacity){
                DoublyListNode removeNode = popTail();
                cache.remove(removeNode.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private int get(int key) {
        DoublyListNode node = cache.get(key);
        if(node == null){
            return -1;
        }
            moveToHead(node);
            return node.value;

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(4,4);
        System.out.println(lruCache.get(3));
    }




}
