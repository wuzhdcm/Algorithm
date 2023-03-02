package com.hnkjxy.Algorithm;

/**
 * @author wuzihao
 * @date 2023/2/28 - 22:02
 */
public class FindFirstIntersectNode {
    static Node head=null;
    static Node temp=null;

    public static class Node{
        public int value;
        public Node next;


        public Node(int data){
            this.value=data;
        }
    }

    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 ==null||head2==null){
            return null;
        }
        Node loop1=getLoopNode(head1);
        Node loop2=getLoopNode(head2);
        if (loop1==null&&loop2==null){
            return noLoop(head1,head2);
        }
        if (loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }


    //判断链表有没有环
    public static Node getLoopNode(Node head){
        if (head==null||head.next==null||head.next.next==null) {
            return null;
        }
        Node n1=head.next;//slow
        Node n2=head.next.next;//fast

        while (n1!=n2){
            if (n2.next==null){
                return null ;
            }
            n2=n2.next.next;
            n1=n1.next;
        }
        n2=head;//n2->head
        while (n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }

    //如果两个来链表都无环，返回第一个相交节点，如果不相交返回null
    public static Node noLoop(Node head1,Node head2){
        if (head1==null||head2==null){
            return null;
        }
        Node cur1=head1;
        Node cur2=head2;
        int n=0;
        while (cur1.next!=null){
            n++;
            cur1=cur1.next;
        }
        while (cur2.next!=null){
            n--;
            cur2=cur2.next;
        }

        if (cur1!=cur2){//两个链表平行
            return null;
        }

        cur1 =n >0? head1:head2;//谁长谁的头就是cur1

        cur2=cur1==head1? head2:head1;//谁短是谁的头为cur2

        n=Math.abs(n);

        while (n!=0){//长链表走n步后就是两个链表相交的地方
            n--;
            cur1=cur1.next;
        }
        while (cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }

        return cur1;



    }

    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        if (loop1 == loop2) {
            while (cur1.next != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2) {
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;//谁长谁的头就是cur1

            cur2 = cur1 == head1 ? head2 : head1;//谁短是谁的头为cur2

            n = Math.abs(n);

            while (n != 0) {//长链表走n步后就是两个链表相交的地方
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return cur1;
        }else {
            cur1 =loop1.next;
            while (cur1!=loop1){
                if (cur1==loop2){
                    return loop1;
                }
                cur1=cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
