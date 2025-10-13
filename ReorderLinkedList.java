class Solution {
    public static void main(String[] args) {
        ListNode list = Utility.createSampleListNode(0, 10);
        reorderList(list);
        Utility.printListNode(list);
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        ListNode l2 = slow.next;
        ListNode prev = slow.next = null;

        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = temp;
        }
        l2 = prev;

        while (l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }

    }
}