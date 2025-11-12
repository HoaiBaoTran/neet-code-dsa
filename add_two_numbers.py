from typing import Optional
from list_node import ListNode
from list_node_utils import ListNodeUtils


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_node = ListNode(0)
        rem = 0
        cur = dummy_node
        while l1 and l2:
            sum = l1.val + l2.val + rem
            result = sum % 10
            rem = sum // 10
            new_node = ListNode(result)
            cur.next = new_node
            cur = cur.next
            l1 = l1.next
            l2 = l2.next
        
        while l1:
            sum = l1.val + rem
            new_node = ListNode(sum % 10)
            rem = sum // 10
            cur.next = new_node
            cur = cur.next
            l1 = l1.next
            
        while l2:
            sum = l2.val + rem
            new_node = ListNode(sum % 10)
            rem = sum // 10
            cur.next = new_node
            cur = cur.next
            l2 = l2.next
        
        while rem > 0:
            new_node = ListNode(rem)
            cur.next = new_node
            cur = cur.next
            rem = 0
        
        return dummy_node.next
            
l1 = ListNodeUtils.create_linked_list([1, 2, 3])
l2 = ListNodeUtils.create_linked_list([4, 5, 6])
solution = Solution()
l3 = solution.addTwoNumbers(l1, l2)
l3.print()

l4 = ListNodeUtils.create_linked_list([9])
l5 = ListNodeUtils.create_linked_list([9])
l6 = solution.addTwoNumbers(l4, l5)
l6.print()