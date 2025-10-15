import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node tmp = map.get(curr);
            tmp.next = map.get(curr.next);
            tmp.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}