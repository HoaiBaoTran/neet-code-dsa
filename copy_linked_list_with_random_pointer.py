from typing import Optional

from node import Node


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        curr = head
        map = {}
        while curr:
            new_list_node = Node(curr.val)
            
            if curr.next not in map:
                next_node = Node(curr.next.val)
                map[curr.next] = next_node
                
            if curr.next not in map:
                random_node = Node(curr.random.val)
                map[curr.random] = random_node  
                
            map[curr] = new_list_node
            curr = curr.next
        return map[head]
