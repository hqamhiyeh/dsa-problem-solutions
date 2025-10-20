// 2. Add Two Numbers

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
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        var temp = new ListNode();
        var node = temp;
        var node1 = l1;
        var node2 = l2;
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0)
        {
            int sum = (node1?.val ?? 0) + (node2?.val ?? 0) + carry;
            carry = sum / 10;

            node.next = new ListNode(sum % 10);
            node = node.next;
            
            if(node1 != null)
                node1 = node1.next;
            if(node2 != null)
                node2 = node2.next;
        }
        return temp.next;
    }
}
