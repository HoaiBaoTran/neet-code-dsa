class Solution {
    public static void main(String[] args) {
        ListNode head = Utility.createSampleListNode();
        Utility.printListNode(revertListNode(head));
    }

    public static ListNode revertListNode(ListNode head) {
        /* iterative */
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}