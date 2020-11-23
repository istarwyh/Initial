package com.github.istarwyh.cache;

import java.util.HashMap;

/**
 * @Description: LruCache
 * @Author: YiHui
 * @Date: 2020-11-23 21:10
 * @Version: ing
 */
public class LruCache {
    public Node head;
    public Node end;
    private final HashMap<String, Node> cache;
    private final Integer capacity;
    public LruCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    /**
     * 向哈希表中放入构造后的数据并调用维护状态的方法
     * @param key 消息标识
     * @param value 消息内容
     */
    public void put(String key,String value ){
        Node node = cache.get(key);
        if( node == null ){
            node = new Node(key, value);
            if( cache.size() >= capacity){
                remove(head.key);
            }
            addNode2End(node);
            cache.put( key , node);
        }else if( node.value.equals(value) ){
            moveNode2End(node);
        }else{
            node.value = value;
            moveNode2End(node);
            cache.put( key , node);
        }
    }

    public String get( String key) {
        Node node = cache.get(key);
        if( node == null ){
//            throw new NotFoundException("key没有对应的元素");
            return "-1";
        }else{

            moveNode2End(node);
            return node.value;
        }
    }

    public void remove( String key){
        Node node = cache.get(key);
        removeNode(node);
        cache.remove(key);
    }

    private void addNode2End(Node node) {
//        cache.size() == 0
        if( head == null){
            head = end = node;
        }else {
            if( end != null ){
                end.next = node;
                node.pre = end;
                node.next = null;
            }
            end = node;
        }
    }

    private void moveNode2End(Node node) {
        if( end != node ){
            removeNode(node);
            addNode2End(node);
        }
    }

    private void removeNode(Node node) {
        if( head == node){
            Node tmpNode = head;
            head = head.next;
            if( head != null){
                head.pre = null;
            }
            tmpNode.next = null;
        }else if( end == node){
            Node tmpNode = end;
            end = end.pre;
            if( end != null ){
                end.next = null;
            }
            tmpNode.pre = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
        }
    }


    static class Node{
        private Node pre;
        private Node next;
        public final String key;
        public String value;
        public Node(String key, String value){
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
