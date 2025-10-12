class Solution {
    public static void main(String[] args) {
        ListNode list1 = Utility.createSampleListNode();
        ListNode list2 = Utility.createSampleListNode();
        Utility.printListNode(mergeTwoSortedListNode(list1, list2));
    }

    public static ListNode mergeTwoSortedListNode(ListNode list1, ListNode list2) {
        ListNode dummyListNode = new ListNode(-1);
        ListNode curr = dummyListNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        return dummyListNode.next;
    }
}