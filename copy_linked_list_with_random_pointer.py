from typing import Optional

from node import Node


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        curr = head
        map = {None: None}
        
        while curr:
            new_list_node = Node(curr.val)
            map[curr] = new_list_node
            curr = curr.next
            
        curr = head
        while curr:
            copy = map[curr]
            copy.next = map[curr.next]
            copy.random = map[curr.random]
            curr = curr.next
            
        return map[head]
            
            
            # new_list_node = Node(curr.val)
            # map[curr] = new_list_node
            
            # if curr.next and curr.next not in map:
            #     next_node = Node(curr.next.val)
            #     map[curr.next] = next_node
            # new_list_node.next = map[curr.next]
            
            # if curr.random and curr.random not in map:
            #     random_node = Node(curr.random.val)
            #     map[curr.random] = random_node
            # new_list_node.random = map[curr.random]
                
            # curr = curr.next
            
        # return map[head]
    
