package com.himanshu.google;

public class ReverseKGroupNodes {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		
		ListNode node6 = new ListNode(6);
		node5.next = node6;
		/*ListNode node7 = new ListNode(7);
		node6.next = node7;*/
		
		ListNode ans = reverseKGroup(node1, 6);

	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0 || k == 1)
            return head;
        
        ListNode curr = head;
        ListNode start = curr, prev = null;
        ListNode oldPrev = null;
        ListNode res = null;
        
        while(curr != null){
             int i = 0;
            boolean flag = false;
            boolean setPrev = false;
            start = curr;
            prev = oldPrev;
            while(true){
                i+=2;
                
                int count = k - i;
                ListNode end = start;
                while(count > 0 && end != null){
                    end = end.next;
                    count--;
                }
                if(end == null)
                {
                	curr = null;
                	break;
                }
                
                if(count < 0 || count > 0){
                	if(curr != null && curr.next == null)
                	    curr = null;
                    break;
                }
                
                ListNode temp1 = end.next;
                if(temp1 == null){
                    curr = null;
                    break;
                }
                if(!flag) {
                	curr = temp1.next;
                	flag = true;
                }
                
                if(start != end){
                    ListNode temp2 = temp1.next;
                    temp1.next = start.next;
                    start.next = temp2;
                    if(prev == null)
                        prev = temp1;
                    else
                    {
                    	prev.next = temp1;
                    	prev = prev.next;
                    }

                    end.next = start;

                    if(!setPrev) {
                    	oldPrev = start;
                    	setPrev = true;
                    }
                    
                    start = temp1.next;
                    if(res == null)
                    	res = temp1;

                }else{
                	ListNode temp = end.next;
                    start.next = end.next.next;
                    if(prev == null)
                        prev = temp;
                    else {
                    	prev.next = temp;
                    	prev = prev.next;
                    }
      
                    temp.next = start;
                    
                    if(!setPrev) {
                    	oldPrev = start;
                    	setPrev = true;
                    }
                    if(res == null)
                    	res = temp;
                    break;
                }
            }   
        }  
        if(res == null)
        	return head;
        return res;
    }

}
