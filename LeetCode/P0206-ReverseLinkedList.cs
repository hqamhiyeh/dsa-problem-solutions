// 206. Reverse Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode
 * {
 *     public int val;
 *     public ListNode next;
 * 
 *     public ListNode(int val=0, ListNode next=null)
 *     {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution
{
    public ListNode ReverseList(ListNode head)
    {
        var current = head;
        ListNode previous = null;
        while (current != null)
        {
            var temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
