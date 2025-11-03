from typing import Optional
from list_node import ListNode
from list_node_utils import ListNodeUtils


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        cur = dummy
        while list1 and list2:
            if list1.val <= list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next
            
        if list1:
            cur.next = list1
        elif list2:
            cur.next = list2
        
        return dummy.next
    
    
list1 = ListNodeUtils.create_linked_list([1, 2, 4])
list1.print()
list2 = ListNodeUtils.create_linked_list([1, 3, 5])
list2.print()
solution = Solution()
merge_list = solution.mergeTwoLists(list1, list2)
merge_list.print()