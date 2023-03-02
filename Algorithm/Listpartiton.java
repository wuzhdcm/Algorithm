package com.hnkjxy.Algorithm;


import java.util.Scanner;

/**
 * @author wuzihao
 * @date 2023/2/27 - 13:10
 */
public class Listpartiton {

    static Node head=null;
    static Node temp=null;


    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value=data;
        }
    }

    public static Node Listpartiton01(Node node , int pivot){
        Node sH=null;//small head
        Node sT=null;//small tail
        Node eH=null;//equal head
        Node eT=null;//equal tail
        Node mH=null;//big head
        Node mT=null;//big tail
        Node next=null;//sava head.next


        while (head != null){
            next=head.next;
            head.next=null;
            if(head.value < pivot){
                if (sH==null){//小于区域没有元素时，将小于区域的头尾指针都指向该节点
                    sH=head;
                    sT=head;
                }else {//有元素时
                    sT.next=head;//老元素的尾巴指向新节点
                    sT=head;//将新节点变成新的尾巴
                }
            }else if(head.value==pivot){
                if  (eH==null){
                    eH=head;
                    eT=head;
                }else  {
                    eT.next=head;
                    eT=head;
                }
            }else {
                if  (mH==null){
                    mH=head;
                    mT=head;
                }else  {
                    mT.next=head;
                    mT=head;
                }

            }

            head=next;


        }
        /*if (sT!=null){//如果有小于区域
            sT.next=eH;
            eT=eT==null?sT:eT;
        }

        if (eT!=null){
            eT.next=mH;
        }*/
        if (sT==null){
            eT.next=mH;
        }else if (eT==null) {
            sT.next = mH;
        }else if (mT==null){
            sT.next=eH;
        }else {
            sT.next=eH;
            eT.next=mH;
        }
        return sH!=null?sH:(eH!=null?eH:mH);
    }

    public static void main(String[] args) {
        int arr[]={2,3,1,5,4,7,1,2,5};
        Listpartiton it=new Listpartiton();
        for (int i=0;i<arr.length;i++){
            it.addNode(arr[i]);
        }
        temp=head;
        head=Listpartiton01(temp,2);
        printLinkedList(head);

    }

    public void addNode(int num){
        Node N=new Node(num);
        if (head==null){
            head=N;
            return;
        }
        temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=N;
    }

    public static void  printLinkedList(Node node){
        System.out.println("Linked List:");
        while (node!=null){
            System.out.println(node.value+" ");
            node=node.next;
        }
    }
}
