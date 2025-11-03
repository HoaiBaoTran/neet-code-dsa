from typing import List, Optional
from list_node import ListNode

class ListNodeUtils:
    @staticmethod
    def create_linked_list(values: List[int]) -> Optional[ListNode]:
        """Create a linked list from a list of values.
        
        Args:
            values: List of integers to create nodes from
            
        Returns:
            Head of the created linked list, or None if values is empty
        """
        if not values:
            return None
            
        head = ListNode(values[0])
        current = head
        
        for val in values[1:]:
            current.next = ListNode(val)
            current = current.next
            
        return head
    
    @staticmethod
    def create_cycle_list(values: List[int], pos: int) -> Optional[ListNode]:
        """Create a linked list with a cycle at specified position.
        
        Args:
            values: List of integers to create nodes from
            pos: Position to create cycle (-1 means no cycle)
            
        Returns:
            Head of the created linked list
        """
        if not values:
            return None
            
        # Create normal linked list first
        head = ListNodeUtils.create_linked_list(values)
        
        if pos < 0:
            return head
            
        # Find the node at cycle position
        cycle_node = head
        for _ in range(pos):
            if not cycle_node:
                return head
            cycle_node = cycle_node.next
            
        # Find last node
        last = head
        while last.next:
            last = last.next
            
        # Create cycle
        last.next = cycle_node
        
        return head
    
    @staticmethod
    def to_list(head: Optional[ListNode]) -> List[int]:
        """Convert a linked list to a Python list.
        
        Args:
            head: Head of the linked list
            
        Returns:
            List containing all values in the linked list
        """
        result = []
        current = head
        
        while current:
            result.append(current.val)
            current = current.next
            
        return result

# Example usage
if __name__ == "__main__":
    # Create a simple linked list: 1 -> 2 -> 3 -> 4 -> 5
    values = [1, 2, 3, 4, 5]
    head = ListNodeUtils.create_linked_list(values)
    print("Regular linked list:")
    head.print()
    
    # Create a linked list with cycle: 1 -> 2 -> 3 -> 4 -> 5 -> (back to 2)
    cycle_head = ListNodeUtils.create_cycle_list(values, 1)  # Cycle at position 1 (points to 2)
    print("\nList values before cycle:")
    print(ListNodeUtils.to_list(cycle_head))  # Will only print values before potential cycle
    print("(Note: This list has a cycle at position 1)")
