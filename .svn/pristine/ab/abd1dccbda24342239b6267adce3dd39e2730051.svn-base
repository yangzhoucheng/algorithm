package at.mySource;

public class Remove {
    public ListNode removeElement(ListNode list,int val){
        if(list == null)
            return null;

        list.next = removeElement(list.next,val);
        return list.val == val?list.next:list;
    }

}
