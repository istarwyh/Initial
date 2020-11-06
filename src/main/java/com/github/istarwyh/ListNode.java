package com.github.istarwyh;

/**
 * @Description: ListNode
 * @author: YiHui
 * @Date: 2020-11-02 16:51
 * @version: 1.0.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "{ val:"+ val + "  next:"+ next + "}";
    }

    public static ListNode createListNodeByArray(int[] arr){
        if( arr.length == 0 ) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for( int i=1;i<arr.length;i++ ){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

}
