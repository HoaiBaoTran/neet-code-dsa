class Solution {
    public static void main(String[] args) {
        ListNode l1 = Utility.createSampleListNode(1, 5);
        ListNode l2 = Utility.createSampleListNode(6, 9);
        Utility.printListNode(addTwoNumbers(l1, l2));

        ListNode l3 = Utility.createDuplicateValueListNode(9, 7);
        ListNode l4 = Utility.createDuplicateValueListNode(9, 4);
        Utility.printListNode(addTwoNumbers(l3, l4));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = v1 + v2 + carry;
            
            carry = val / 10;
            val = val % 10;

            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return dummy.next;
    }
}