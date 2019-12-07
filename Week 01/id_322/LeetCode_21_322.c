struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
        if(l1==NULL && l2==NULL) return l1;
        if(l1==NULL && l2!=NULL) return l2;
        if(l2==NULL && l1!=NULL) return l1;
        struct ListNode* p1=l1;
        struct ListNode* p2=l2;
        struct ListNode* p=p1;
        if(p1->val<=p2->val)
        {
            p=p1;
            p1=p1->next;
        }
        else
        {
             p=p2;
             p2=p2->next;
        }
        struct ListNode* res=p;
        while(p1&&p2)
        {
            if(p1->val<=p2->val)
            {
                p->next=p1;
                p1=p1->next;
            }
            else
            {
                p->next=p2;
                p2=p2->next;
            }
                
            p=p->next;
        }
        while(p1)
        {
            p->next=p1;
            p1=p1->next;
            p=p->next;
        } 
        while(p2)
        {
            p->next=p2;
            p2=p2->next;
            p=p->next;
        }
           
        return res; 
}