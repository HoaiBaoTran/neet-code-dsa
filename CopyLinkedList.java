import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node curr = head;

        Map<Node, Node> map = new HashMap<>();

        while (curr != null) {
            Node tmp = new Node(curr.val);
            if (dummy.next == null) {
                dummy.next = tmp;
            }
            map.put(curr, tmp);
            curr = curr.next;
            tmp.next = curr;
            tmp = tmp.next;
        }

        curr = head;
        Node copy = dummy.next;
        while (curr != null) {
            copy.random = map.get(curr.random);
            copy = copy.random;
            curr = curr.random;
        }

        return dummy.next;
    }
}