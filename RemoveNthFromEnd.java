class Solution {
    public static void main(String[] args) {
        ListNode head = Utility.createSampleListNode(1, 4);
        head = removeNthFromEnd(head, 2);
        Utility.printListNode(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode left = dummyNode;
        ListNode right = head;

        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummyNode.next;
    }
}