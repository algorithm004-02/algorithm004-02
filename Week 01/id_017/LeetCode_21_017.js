/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    //递归
    //时间复杂度 O(n+m)  空间复杂度 O(n+m)
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    
    //取小的那个节点  并指向next指针
    if(l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next,l2);
        return l1;
    }else{
        l2.next = mergeTwoLists(l2.next,l1);
        return l2;
    }
    
    //迭代
    //时间复杂度O(n+m)  空间复杂度O(1)  只用了几个指针
    
    
};