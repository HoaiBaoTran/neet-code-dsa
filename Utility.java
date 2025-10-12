public class Utility {
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode createSampleListNode() {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i <= 5; i++) {
            ListNode element = new ListNode(i);
            curr.next = element;
            curr = curr.next;
        }
        return head;
    }
}
