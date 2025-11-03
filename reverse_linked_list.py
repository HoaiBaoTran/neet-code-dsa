from typing import Optional
from list_node import ListNode
from list_node_utils import ListNodeUtils


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None, head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
    
list_node = ListNodeUtils.create_linked_list([0, 1, 2, 3]);
list_node.print()
solution = Solution()
reverse = solution.reverseList(list_node)
reverse.print()
            