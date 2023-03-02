package com.hnkjxy.Algorithm;


import java.util.Scanner;

/**
 * @author wuzihao
 * @date 2023/2/25 - 21:27
 */
public class IsPalindromeList {

    static Node head=null;
    static Node temp=null;
    static Node temp1=null;

    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value=data;
        }
    }

    public static boolean isPalindrome(Node head){
        if (head==null||head.next==null){
            return true;
        }
        Node n1=head;
        Node n2=head;
        while (n2.next!=null&&n2.next.next!=null){
            n1=n1.next;//n1->mid
            n2=n2.next;//n2->end
        }
        n2=n1.next;//head of right
        n1.next=null;//mid.next=null
        Node n3=null;//next
        n1= reverseList(n2,n1,n3);
        /*while (n2!=null){
            n3=n2.next;
            n2.next=n1;
            n1=n2;
            n2=n3;
        }*/

        n3=n1;//n3->最右边的node
        n2=head;//n2->最左边的node
        boolean res=true;
        while (n1!=null&&n2!=null){
            if (n1.value!=n2.value){
                res=false;
                break;
            }
            n1=n1.next;
            n2=n2.next;
        }
        n1=n3.next;//head of cover
        n3.next=null;
        reverseList(n1,n3,n2);
        /*while (n1!=null){
            n2=n1.next;
            n1.next=n3;
            n1=n2;
            n3=n1;
        }
*/
        return res;


    }


    public static Node reverseList(Node head ,Node pre,Node next){
        if (head==null){
            return null;
        }

        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }

        return pre ;


    }

    public static void main(String[] args) {
        int arr[]=new int[5];
        for (int i=0;i<arr.length;i++){
            Scanner sca=new Scanner(System.in);
            arr[i]=sca.nextInt();
            IsPalindromeList it=new IsPalindromeList();
            it.addNode(arr[i]);
        }
        temp=head;//判断是否为回文数
        boolean flag=isPalindrome(temp);
        System.out.println(flag);
        temp1=head;//打印
        for (int i=0;i<arr.length;i++){
            System.out.println(temp1.value+" ");
            temp1=temp1.next;
        }

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
}

