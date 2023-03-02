package com.hnkjxy.Algorithm;

import java.security.interfaces.RSAKey;
import java.util.HashMap;

/**
 * @author wuzihao
 * @date 2023/2/27 - 22:19
 */
public class CopyListWithRandom {
    static Node head=null;
    static Node temp=null;

    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int data){
            this.value=data;
        }
    }



    public static Node copyListWithRand1(Node head){
        HashMap <Node,Node> map=new HashMap<>();
        Node cur=head;

        while (cur!=null){
            map.put(cur,new Node(cur.value));//new Node(cur.value)cur的克隆
            cur=cur.next;
        }
        cur=head;

        while (cur!=null){
            //cur老
            //map.get(cur)新

            map.get(cur).next=map.get(cur.next);
            map.get(cur).rand=map.get(cur.rand);
            cur=cur.next;

        }
        return map.get(head);
    }


    public static Node copyListWithPand2(Node head){
        if (head ==null){
            return null;
        }

        Node cur=head;
        Node next=null;

        //copy node link to every node
        //1->2  变成 1->1'->2->2'

        while (cur!=null){
            next=cur.next;
            cur.next=new Node(cur.value);
            cur.next.next=cur.next;
            cur=next;

        }
        cur=head;
        Node curCopy=null;
        //set copy node rand
        //1->1'->2->2'
        while (cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.rand=cur.rand!=null? cur.rand.next: null;
            cur=next;
        }
        Node res=head.next;
        cur=head;

        while (cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.next=next!=null? next.next:null;
            cur=next;
        }
        return res;


    }
}
