package com.hnkjxy.Algorithm;

import java.util.Arrays;


/**
 * @author wuzihao
 * @date 2023/2/23 - 13:48
 */
public class HeapSort {

    public static int [] heapsort(int []arr){
        if (arr.length<2||arr==null){
            return arr;
        }

        for (int i=0;i<arr.length;i++){
            heapinsert(arr,i);
        }
        int heapsize=arr.length;
        swap(arr,0,--heapsize);
        while (heapsize>0){
            heapify(arr,0,heapsize);
            swap(arr,0,--heapsize);
        }

        return arr;
    }




    public static int[]  heapinsert(int [] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr, index,(index-1)/2);
            index=(index-1)/2;
        }
        return arr;
    }




    public static int[]  heapify(int []arr ,int index ,int heapsize){
        int left=index*2+1;//表示左孩子
        while (left<heapsize){//表示index下方还有孩子
            //比较两个孩子中的值，最大为largest
            int largest=0;
            largest=arr[left+1] > arr[left] && left+1 < heapsize ? left+1:left;

            largest=arr[index] > arr[largest]? index: largest;

            if (index==largest){
                break;
            }
            swap(arr,largest,index);
            index=largest;
            left=index*2+1;

        }

        return arr ;

    }

    public static int[] swap(int []arr ,int L,int R){
        int tmep=arr[L];
        arr[L]=arr[R];
        arr[R]=tmep;
        return arr;
    }


    public static int[] generateRandomArray(int maxsize,int maxvalue){
        int num[]=new int[(int)((maxsize+1)*Math.random())];
        for (int i=0;i<num.length;i++){
            num[i]=(int)(Math.random()*maxvalue);
        }

        return num;
    }

    public static int[] copyArray(int arr[]){
        int num[]= Arrays.copyOf(arr,arr.length-1);
        return num;
    }

    public static void printArray(int []arr){
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int maxvalue=100;
        int maxsize=100;
        int []a=generateRandomArray(maxsize,maxvalue);
        printArray(a);
        heapsort(a);
        printArray(a);






    }

}


