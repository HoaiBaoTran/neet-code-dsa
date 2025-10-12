class Solution {
    public static void main(String[] args) {
        System.out.println("Revert List Node Iterative");
        ListNode head = Utility.createSampleListNode();
        Utility.printListNode(revertListNode(head));

        System.out.println("Revert List Node Recursion");
        ListNode head2 = Utility.createSampleListNode();
        Utility.printListNode(revertListNodeRecursion(head2));
    }

    public static ListNode revertListNode(ListNode head) {
        // iterative
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

    public static ListNode revertListNodeRecursion(ListNode head) {
        return revertListNodeRecursionHelper(head, null);
    }

    public static ListNode revertListNodeRecursionHelper(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        return revertListNodeRecursionHelper(curr, prev);
    }
}