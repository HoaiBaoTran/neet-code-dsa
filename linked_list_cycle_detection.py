from typing import Optional
from list_node import ListNode
from list_node_utils import ListNodeUtils


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
            if (slow == fast):
                return True
        
        return False
    
cycle_linked_list = ListNodeUtils.create_cycle_list([1, 2, 3, 4], 1)
solution = Solution()
print(solution.hasCycle(cycle_linked_list))
        