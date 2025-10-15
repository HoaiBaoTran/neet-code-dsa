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

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = 0;
            if (val >= 10) {
                carry = 1;
                val -= 10;
            }

            if (dummy.next == null) {
                dummy.next = new ListNode(val);
            } else {
                cur.next = new ListNode(val);
            }
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            carry = 0;
            if (val >= 10) {
                carry = 1;
                val -= 10;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            carry = 0;
            if (val >= 10) {
                carry = 1;
                val -= 10;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}