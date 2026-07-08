/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode revHead = reverse(slow);
        prev.next=revHead;
        ListNode first=head;
        ListNode second=revHead;
        int maxSum=Integer.MIN_VALUE;
        while(second!=null){
            int sum = first.val+second.val;
            maxSum=Math.max(sum,maxSum);
            first=first.next;
            second=second.next;
        }
        return maxSum;
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
}