/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

/**
Way 1: Recurssion 


func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    
    //Check boundary
    
    if l1 == nil {
        return l2
    }
    
    if l2 == nil {
        return l1
    }
    
    //Recurrsion 
    
    if l1.Val < l2.Val {
        l1.Next = mergeTwoLists(l1.Next, l2)
        
        return l1
    } else {
        l2.Next = mergeTwoLists(l2.Next, l1)
        
        return l2
    }
    
}*/

/* Way 2: Iteration
*/
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    prehead := &ListNode{-1, nil}
    
    pre := prehead
    
    //pre to track the min by iterating l1 and l2
    
    for (l1 != nil && l2 != nil) {
        if l1.Val < l2.Val {
            pre.Next = l1
            l1 = l1.Next
            
        } else {
            pre.Next = l2
            l2 = l2.Next
        }
        
        pre = pre.Next
    }
    
    //Check l1 or l2 null , append it to pre next
    
    if l1 == nil {
        pre.Next = l2
    }
    
    if l2 == nil {
        pre.Next = l1
    }
    
    return prehead.Next
    
    
}