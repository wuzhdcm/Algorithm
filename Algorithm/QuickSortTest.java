package com.hnkjxy.Algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wuzihao
 * @date 2023/2/22 - 23:45
 */
public class QuickSortTest {

    @Test
    public void test(){
        int []arr={2,1,5,2,3,6,7,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }




    public void quickSort(int []arr,int L,int R){
        if (L<R){
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int p[] = partiton(arr, L, R);

            quickSort(arr, L, p[0] - 1);//<区
            quickSort(arr, p[1] + 1, R);//>区

        }


    }


    public int [] partiton(int arr[],int L,int R){
        int less=L-1;//左边界
        int more=R;//右边界
        while (L<more){//L为当前数的位置 arr[R]->划分值
            if (arr[L]>arr[R]){//当前数大于划分值
                swap(arr,--more,L);
            }else if(arr[L]<arr[R]){//当前数小于划分值
                swap(arr,++less,L++);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }


    public int [] swap(int []arr ,int L,int R){
        int tmep=arr[L];
        arr[L]=arr[R];
        arr[R]=tmep;
        return arr;
    }

}
