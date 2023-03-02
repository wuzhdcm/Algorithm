package com.hnkjxy.Algorithm;

import org.junit.Test;

/**
 * @author wuzihao
 * @date 2023/2/22 - 16:42
 */
public class Minsum {
    //最小和问题

    @Test
    public void minsum(){
        int []arr={1,3,4,2,5};
        Minsum minsum=new Minsum();
        int num= minsum.smallsum(arr);
        System.out.println(num);
    }

    public int smallsum(int []arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1 );
    }

    public  int  process(int []num,int L,int R){
        if (L==R){
            return 0;
        }
        int mid=L+((R-L)>>1);
        return  process(num,L,mid)+
                process(num,mid+1,R)+
                marge(num,mid,L,R);



    }

    public int marge(int []arr ,int m,int L,int R){
        int []help=new int [R-L+1];
        int index=0;
        int p1=L;
        int p2=m+1;
        int minsum=0;
        while (p1<=m&&p2<=R){
            minsum+=arr[p1]<arr[p2]?(R-p2+1)*arr[p1]:0;
            help[index++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];

        }
        while (p1<=m){
            help[index++]=arr[p1++];
        }
        while (p2<=R){
            help[index++]=arr[p2++];
        }
        for (int i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
        return minsum;


    }
}
