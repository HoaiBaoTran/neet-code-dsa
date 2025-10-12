class Solution {
    public static void main(String[] args) {
        ListNode cycListNode = Utility.createCycleListNode();
        ListNode norListNode = Utility.createSampleListNode();

        System.out.println(hasCycle(norListNode));
        System.out.println(hasCycle(cycListNode));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}