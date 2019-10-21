
struct ListNode* reverseList(struct ListNode* head){
    if(head== NULL){
        return head;
    }
    struct ListNode * pre = NULL;
    struct ListNode * nextNode = NULL;
     while(head != NULL){
        nextNode = head -> next;
        head -> next = pre;
        pre = head;
        head = nextNode;
     }
    return pre;
}