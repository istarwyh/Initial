package com.github.istarwyh.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: LruCacheByLHM保证了最久未使用的元素会被淘汰,从而在有限的内存空间里实现LRU缓存;但是LHM中的情况对调用者是完全的黑盒,head,tail是无法得到的
 * @Author: YiHui
 * @Date: 2020-11-23 22:00
 */
public class LruCacheByLHM<K,V> {
    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;
    public LinkedHashMap<K,V> lhm;
    public LruCacheByLHM(int cacheSize){
        this.MAX_CACHE_SIZE = cacheSize;
        int capacity = (int)Math.ceil( MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY)+1;
        this.lhm = new LinkedHashMap<K,V>(capacity,DEFAULT_LOAD_FACTORY,true){
            private static final long serialVersionID = 12343542L;
            @Override
            protected boolean removeEldestEntry( Map.Entry<K,V> eldest){    return size()>MAX_CACHE_SIZE;}
        };
    }
    public synchronized void put(K key,V value){lhm.put(key,value);}
    public synchronized void remove(K key){ lhm.remove(key);}
    public synchronized void get(K key){ lhm.get(key);}
    public synchronized Set<Map.Entry<K,V>> getAll(K key){ return lhm.entrySet();}
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for( Map.Entry<K,V> entry : lhm.entrySet()){
            sb.append( String.format("%s: %s",entry.getKey(),entry.getValue()));
        }
        return sb.toString();
    }
}
