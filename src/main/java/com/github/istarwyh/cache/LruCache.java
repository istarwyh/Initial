package com.github.istarwyh.cache;

import java.util.HashMap;

/**
 * @Description: LruCache
 * @Author: YiHui
 * @Date: 2020-11-23 21:10
 * @Version: ing
 */
public class LruCache<T> {
    public Node<T> head;
    public Node<T> end;
    private final HashMap<String, Node<T>> cache;
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
    public void put(String key,T value ){
//        放之前先看缓存中有没有
        Node<T> node = cache.get(key);
        if( node == null ){
            node = new Node<T>(key, value);
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

    public T get( String key) {
        Node<T> node = cache.get(key);
        if( node == null ){
//            throw new NotFoundException("key没有对应的元素");
            return null;
        }else{
            moveNode2End(node);
            return node.value;
        }
    }

    public void remove( String key ){
        Node<T> node = cache.get(key);
        removeNode(node);
        cache.remove(key);
    }

    /**
     * 只要是添加结点,它就是最近访问的应该在最安全的位置-尾部
     */
    private void addNode2End(Node<T> node) {
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

    /**
     * 访问的同时,这个结点就要移到安全的位置-尾部
     */
    private void moveNode2End(Node<T> node) {
        if( end != node ){
            removeNode(node);
            addNode2End(node);
        }
    }

    private void removeNode(Node<T> node) {
        if( head == node){
            Node<T> tmpNode = head;
            head = head.next;
            if( head != null){
                head.pre = null;
            }
            tmpNode.next = null;
        }else if( end == node){
            Node<T> tmpNode = end;
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


    static class Node<T>{
        private Node<T> pre;
        private Node<T> next;
        public final String key;
        public T value;
        public Node(String key, T value){
            this.key = key;
            this.value = value;
        }

    }
}
