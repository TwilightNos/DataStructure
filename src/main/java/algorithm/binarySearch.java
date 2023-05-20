package algorithm;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,9};
        System.out.println(binarySearchBasic(arr,6));
        System.out.println(binarySearchModify1(arr,6));
        System.out.println(binarySearchModify2(arr,6));


        Arrays.binarySearch(arr,6);
    }


    public static int binarySearchBasic(int[] a,int target){

        int i = 0;
        int j = a.length-1;
        while(i <= j){
            int m = (i+j)>>>1;
            if(a[m] == target){
                return m;
            }else if(a[m] > target){
                j = m-1;
            }else {
                i = m+1;
            }
        }
        return -1;
    }


    public static int binarySearchModify1(int[] a, int target){
        int i = 0, j = a.length;
        while(i < j){
            int m = (i+j)>>>1;
            if(target < a[m]){
                j = m;
            }else if(a[m] < target){
                i = m+1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchModify2(int[] a, int target){
        int i = 0,j = a.length; // 左闭右开区间
        while(j-i>1){ // 当区间中的元素个数大于1时继续缩小区间大小
            int m = (i+j)>>>1;
            if(target < a[m]){ // 只有if和else，没有else-if，保证每次循环语句中只判断一次
                j = m;
            }else{
                i = m;
            }
        }
        // 在循环外侧判断最后剩余的值是否与目标值相等
        if(a[i] == target){
            return i;
        }else{
            return -1;
        }
    }

}
