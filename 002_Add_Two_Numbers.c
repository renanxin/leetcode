//struct ListNode {
//    int val;
//    struct ListNode *next;
//
//};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    struct ListNode *L=(struct ListNode*)malloc(sizeof(struct ListNode)),*p=L,*ll;
    int flag=0;
    while(l1&&l2){
        struct ListNode *l = (struct ListNode*)malloc(sizeof(struct ListNode));
        l->next = NULL;
        l->val = l1->val+l2->val+flag;
        flag=0;
        if(l->val>=10){
            flag=1;
            l->val-=10;
        }
        l1=l1->next;l2=l2->next;
        p->next=l;
        p=p->next;
    }
    ll = l1==NULL?l2:l1;
    while(ll){
        struct ListNode *l = (struct ListNode*)malloc(sizeof(struct ListNode));
        l->next = NULL;
        l->val = ll->val+flag;
        flag=0;
        if(l->val>=10){
            flag=1;
            l->val-=10;
        }
        ll=ll->next;
        p->next=l;
        p=p->next;
    }
    if(flag==1){
        struct ListNode *l = (struct ListNode*)malloc(sizeof(struct ListNode));
        l->next = NULL;
        l->val = 1;
        p->next=l;
    }
    return L->next;
}
