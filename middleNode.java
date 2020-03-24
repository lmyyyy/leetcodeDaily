public class middleNode {
    //3.23链表的中间节点
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode middleNode(ListNode head){
        //遍历两遍，得到长度后再遍历至length／2的位置返回
        ListNode dummy = head;
        int length = 0;
        while(dummy != null){
            length ++;
            dummy = dummy.next;
        }
        for(int i = 0;i < length;i ++){
            if(i == length/2){
                break;
            }
            head = head.next;
        }
        return head;
    }
    public static ListNode middleNodeTwoPionter(ListNode head){
        //链表问题中设计到了位置都应该考虑通过构造双指针的移动规则来解决
        //快指针一次前进两个结点，速度是慢指针的两倍
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
