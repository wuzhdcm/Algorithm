package com.hnkjxy.Algorithm;

import static com.hnkjxy.Algorithm.HeapSort.printArray;

/**
 * @author wuzihao
 * @date 2023/2/23 - 22:53
 */
public class RadixSort {

    //基数排序

    public static int[] radixSort(int []arr){
        if (arr==null||arr.length<2){
            return arr;
        }
        return radixsort(arr,0,arr.length-1,maxbits(arr));
    }

    public static int maxbits(int []arr){
        int max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int res=0;
        while (max!=0){
            res++;
            max/=10;
        }
        return res;
    }



    public  static int[] radixsort(int []arr  ,int L,int R,int digit){
        final int radix=10;//count的长度
        int i=0,j=0;

        //有多少个数准备多少个辅助空间
        int []bucket=new int [R-L+1];
        for (int d=1;d<=digit;d++){//有多少位就进多少次
            /**
             * 10个空间
             * count[0]当前位（d位）是0的数字有多少个
             * count[1]当前位（d位）是（0，1）的数字有多少个
             * count[2]当前位 （d位）是（0，1，2）的数字有多少个
             * count[i]当前位（d位）是（0~i）的数字有多少个
             */
            int []count=new int [radix];//count [0~9]

            for (i=L;i<=R;i++){//记录数组下标位d的词频
                j=getDigit(arr[i],d);
                count[j]++;
            }
            for (i=1;i<radix;i++){//将count处理成注释的说法(前缀和)
                count[i]=count[i-1]+count[i];
            }
            for (i=R;i>=L;i--){//将原数组的数赋值到辅助数组
                j=getDigit(arr[i],d);
                bucket[count[j]-1]=arr[i];
                count[j]--;
            }

            for (i=L,j=0;i<=R;i++,j++){
                arr[i]=bucket[j];
            }
        }
        return arr;
    }

    public static int getDigit(int x,int d){
        return ((x/((int)Math.pow(10,d-1)))%10);
    }

    public static int[] generateRandomArray(int maxsize,int maxvalue){
        int num[]=new int[(int)((maxsize+1)*Math.random())];
        for (int i=0;i<num.length;i++){
            num[i]=(int)(Math.random()*maxvalue);
        }

        return num;
    }

    public static void main(String[] args) {
        int maxvalue=100;
        int maxsize=100;
        int []a=generateRandomArray(maxsize,maxvalue);
        printArray(a);
        radixSort(a);
        printArray(a);

    }
}
