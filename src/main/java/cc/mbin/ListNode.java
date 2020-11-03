package cc.mbin;

/**
 * @Description:ListNode
 * @author:wangyihui
 * @Date:2020-11-02 16:51
 * @version:1.0.0
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
