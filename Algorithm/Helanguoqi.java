package com.hnkjxy.Algorithm;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author wuzihao
 * @date 2023/2/22 - 22:46
 */
public class Helanguoqi {
    @Test
    public void test01(){
        int []nums={2,5,1,6,2,7,8,2};
        int target=4;
        Helanguoqi test=new Helanguoqi();
        System.out.println(Arrays.toString(test.sort(nums,target)));
    }


    public int[] sort(int []arr , int target){
        int l=0, r= arr.length-1;
        while (l<=r){
            if (arr[l]<=target){
                l++;

            }else {
                int tmep=arr[l];
                arr[l]=arr[r];
                arr[r]=tmep;
                r--;

            }
        }
        return arr;
    }
}
