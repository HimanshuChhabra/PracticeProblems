package com.himanshu.bloomberg;

import java.util.*;

public class FlattenDoublyChildList {
	
	

	public static void main(String[] args) {
		// Problem 430

	}
	/*public Node flatten(Node head) {
        Node temp = head;
        while(temp != null){
            
            if(temp.child != null){
            Node oldNext = temp.next;
            Node newNext = flatten(temp.child);
            temp.child = null;
            temp.next = newNext;
            newNext.prev = temp;
                
            if(oldNext != null){
                while(newNext.next != null)
                    newNext = newNext.next;
                newNext.next = oldNext;
                oldNext.prev = newNext;
            }
            
            temp = oldNext;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }*/
}

