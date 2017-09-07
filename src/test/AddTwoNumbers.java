package test;

import java.util.HashSet;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head1 = new ListNode(5);
		ListNode p1 = new ListNode(5);
		ListNode p2 = new ListNode(4);
		ListNode p3 = new ListNode(6);
		ListNode p4 = new ListNode(3);
		ListNode p5 = new ListNode(2);
		ListNode p6 = new ListNode(2);
		ListNode p7 = new ListNode(0);
		ListNode p8 = new ListNode(6);
		ListNode p9 = new ListNode(1);
		head1.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		p7.next = p8;
		p8.next = p9;
		p9.next = null;
		ListNode head2 = new ListNode(1);
		ListNode q1 = new ListNode(9);
		ListNode q2 = new ListNode(4);
		ListNode q3 = new ListNode(8);
		ListNode q4 = new ListNode(5);
		ListNode q5 = new ListNode(2);
		ListNode q6 = new ListNode(0);
		ListNode q7 = new ListNode(3);
		ListNode q8 = new ListNode(7);
		head2.next = q1;
		q1.next = q2;
		q2.next = q3;
		q3.next = q4;
		q4.next = q5;
		q5.next = q6;
		q6.next = q7;
		q7.next = q8;
		q8.next = null;
		System.out.println(addTwoNumbers(head1,head2));
		
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1,q = l2;
        int asc = 0;
        boolean found = true;
        ListNode head = null;
        ListNode node = null;
        while(p!=null||q!=null){
            int digit = 0;
            if(p!=null){
                digit += p.val;
                p = p.next;
            }
            if(q!=null){
                digit += q.val;
                q = q.next;
            }
            digit += asc;
            ListNode sumL = new ListNode(digit%10);
            asc = digit/10;
            if(found){
                head = sumL;
                node = head;
            }
            else{
                node.next = sumL;
                node = sumL;
            }
            found = false;
        }
        if(asc!=0){
            ListNode last = new ListNode(asc);
            last.next = null;
            node.next = last;
        }
        else{
            node.next = null;
        }
        return head;
    }
}
