package com.github.istarwyh.factory;

import com.github.istarwyh.ListNode;

/**
 * @Description: ListNodes
 * @Author: YiHui
 * @Date: 2021-01-16 16:21
 * @Version: ing
 */
public class ListNodes {
    /**
     * return a new ListNode when this method is invoked
     * @param val int
     * @return ListNode
     */
    public static ListNode create(int val){
        return new ListNode(val);
    }

    /**
     * return a new ListNode when this method is invoked
     * @param val int
     * @param node ListNode
     * @return ListNode
     */
    public static ListNode create(int val,ListNode node){
        return new ListNode(val);
    }
}
