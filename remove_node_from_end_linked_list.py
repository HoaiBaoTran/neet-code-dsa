from typing import Optional

from list_node import ListNode
from list_node_utils import ListNodeUtils


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy_node = ListNode(-1)
        dummy_node.next = head
        curr = head
        while n > 0 and curr:
            curr = curr.next
            n -= 1
        
        first, second = dummy_node, curr
        
        while second:
            first = first.next
            second = second.next
            
        first.next = first.next.next
        return dummy_node.next
    
    
linked_list = ListNodeUtils.create_linked_list([1, 2, 3, 4])
solution = Solution()
remove_linked_list = solution.removeNthFromEnd(linked_list, 2)
remove_linked_list.print()