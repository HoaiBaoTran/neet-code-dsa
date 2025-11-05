from typing import Optional

from node import Node


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        curr = head
        map = {}
        while curr:
            new_list_node = Node(curr.val)
            
            if curr.next in map:
                new_list_node.next = map[curr.next]
                
            if curr.random in map:
                new_list_node.random = map[curr.random]
                
            map[curr] = new_list_node
            curr = curr.next
        return map[head]
