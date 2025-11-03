class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
    def print(self):
        current = self
        result = []
        while current:
            result.append(str(current.val))
            current = current.next
        print(" -> ".join(result))
        
            