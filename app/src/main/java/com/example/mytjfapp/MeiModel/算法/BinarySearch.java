package com.example.mytjfapp.MeiModel.算法;

/**
 * Created by Administrator on 2019-02-21 0021.
 */
 /*
 * 循环实现二分查找算法arr 已排好序的数组x 需要查找的数-1 无法查到数据
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle - 1;

            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("循环查找：" + (binarySearch(arr, 87) + 1));
    }
}
