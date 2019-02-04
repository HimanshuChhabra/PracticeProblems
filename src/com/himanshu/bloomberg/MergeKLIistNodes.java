package com.himanshu.bloomberg;

import java.util.*;

public class MergeKLIistNodes {

	public static void main(String[] args) {
	
		ListNode l1 = new ListNode(-2);
		ListNode l2 = new ListNode(-1);
		ListNode l3 = new ListNode(-1);
		ListNode l4 = new ListNode(-1);
		l1.next = l2; l2.next = l3 ; l3.next = l4;
		ListNode lists[] = {l1,};
		mergeKLists(lists);

	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode i, ListNode j) {
				return i.val - j.val;
			}
        	
		});
            
      for(ListNode node : lists){
          
          ListNode listNode = node;
          
          while(listNode != null){
              queue.add(listNode);
              listNode = listNode.next;
          }
      }
        ListNode head = null ,next = null;
        while(!queue.isEmpty()){
            
            if(head == null)
            {
                head = queue.poll();
                next = head;
            }else{
                next.next = queue.poll();
                next = next.next;
            }
        }
        
      //  next.next = null;
        
        return head;
    }

}

class ListNode {
	  int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
 }



