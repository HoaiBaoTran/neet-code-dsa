import collections
from typing import Optional

from node import Node


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        # 2 pass
        # curr = head
        # map = {None: None}
        
        # while curr:
        #     new_list_node = Node(curr.val)
        #     map[curr] = new_list_node
        #     curr = curr.next
            
        # curr = head
        # while curr:
        #     copy = map[curr]
        #     copy.next = map[curr.next]
        #     copy.random = map[curr.random]
        #     curr = curr.next
            
        # return map[head]
            
        # 1 pass
        map = collections.defaultdict(lambda: Node(0))
        map[None] = None
        
        cur = head
        while cur:
            map[cur].val = cur.val
            map[cur].next = map[cur.next]
            map[cur].random = map[cur.random]
            cur = cur.next
            
        return map[head]
    
