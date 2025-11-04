from typing import Optional

from list_node import ListNode
from list_node_utils import ListNodeUtils


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        prev, l2 = None, slow.next
        slow.next = None
        
        while l2:
            temp = l2.next
            l2.next = prev
            prev = l2
            l2 = temp
            
        first, second = head, prev
        
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2
            
linked_list = ListNodeUtils.create_linked_list([2, 4, 6, 8])
solution = Solution()
solution.reorderList(linked_list)
linked_list.print()
    