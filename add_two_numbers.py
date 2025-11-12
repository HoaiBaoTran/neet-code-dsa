from typing import Optional
from list_node import ListNode
from list_node_utils import ListNodeUtils


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_node = ListNode(0)
        carry = 0
        cur = dummy_node
        while l1 or l2 or carry:
            num1 = l1.val if l1 else 0
            num2 = l2.val if l2 else 0
            val = num1 + num2 + carry
            carry = val // 10
            digit = val % 10
            
            cur.next = ListNode(digit)
            cur = cur.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            
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