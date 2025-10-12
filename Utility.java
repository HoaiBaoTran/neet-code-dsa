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

    public static ListNode createCycleListNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        return node1;
    }
}
