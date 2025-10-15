import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        /*
         * 2 passes
         * Map<Node, Node> map = new HashMap<>();
         * 
         * Node curr = head;
         * while (curr != null) {
         * map.put(curr, new Node(curr.val));
         * curr = curr.next;
         * }
         * 
         * curr = head;
         * while (curr != null) {
         * Node tmp = map.get(curr);
         * tmp.next = map.get(curr.next);
         * tmp.random = map.get(curr.random);
         * curr = curr.next;
         * }
         * 
         * return map.get(head);
         */

        // 1 pass
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, new Node(0));
            }
            map.get(cur).val = cur.val;

            if (!map.containsKey(cur.next)) {
                map.put(cur.next, new Node(0));
            }
            map.get(cur).next = map.get(cur.next);

            if (!map.containsKey(cur.random)) {
                map.put(cur.random, new Node(0));
            }
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}