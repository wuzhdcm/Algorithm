package com.hnkjxy.Algorithm;


/**
 * @author wuzihao
 * @date 2023/2/20 - 22:52
 */
public class MergeSort {
    public static void main(String[] args) {
        int []arr={2,4,1,5,7,2};
        MergeSort test =new MergeSort();
        String result=test.flag1(arr);
        System.out.println(result);
    }

    public static String flag1(int []arr){
        int [] arr1=new int[arr.length];
        int [] arr2=new int[arr.length];
        for (int i=0;i< arr1.length;i++){
            arr1=MergeSort(arr);
        }
        for (int i=0;i< arr2.length;i++){
            arr2=MergeSort(arr);
        }
        for (int i=0;i< arr.length;i++){
            if (arr1[i]==arr[i]){
                String flag="true";
                return flag;
            }else {
                String flag="false";
                return flag;
            }
        }
        return "NO";




    }


    public static int[] MergeSort(int []arr){
        if (arr==null&&arr.length<2) {
            return arr;
        }
        process(arr,0, arr.length-1);
        return arr;
    }


    public static void process(int []arr, int L, int R){
        if(L==R){
            return;
        }
        int mid=L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);

    }


    public static void merge(int []arr,int L,int M,int R){
        int []help=new int [R-L+1];
        int index=0;
        int p=L;
        int mid=M+1;
        while (p<=M&&mid<=R){
            help[index++]=arr[p]<=arr[mid]? arr[p++]:arr[mid++];
        }
        while (p<=M){
            help[index++]=arr[p++];
        }
        while (mid<=R){
            help[index++]=arr[mid++];
        }

        for (int i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
    }
}
