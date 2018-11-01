package com.mmp.test;

import java.util.Arrays;



public class ArithmeticTest {
	public static void main(String[] args) {
		
		int[] arr ={1,5,8,7,9,6,3,4,2};
		//new ArithmeticTest().sort(arr);
		//int[] mergeSort = mergeSort(arr);
		//System.out.println("归并排序最终结果："+Arrays.toString(mergeSort));
		quickSort(arr);
	}
	
	/**
	 * 快速排序
	 */
	public static void quickSort(int[] a) {
		if(a.length>0) {
			quickSort(a, 0 , a.length-1);
		}
	}
	private static void quickSort(int[] a, int low, int high) {
		//1,找到递归算法的出口
		if( low > high) {
			return;
		}
		//2, 存
		int i = low;
		int j = high;
		//3,key
		int key = a[ low ];
		//4，完成一趟排序
		while( i< j) {
			//4.1 ，从右往左找到第一个小于key的数
			while(i<j && a[j] > key){
				j--;
			}
			// 4.2 从左往右找到第一个大于key的数
			while( i<j && a[i] <= key) {
				i++;
			}
			//4.3 交换
			if(i<j) {
				int p = a[i];
				a[i] = a[j];
				a[j] = p;
			}
		}
		// 4.4，调整key的位置
		int p = a[i];
		a[i] = a[low];
		a[low] = p;
		System.out.println(Arrays.toString(a));
		//5, 对key左边的数快排
		quickSort(a, low, i-1 );
		//6, 对key右边的数快排
		quickSort(a, i+1, high);
	}
	/* 快速排序结束*/
	
	
	private static int[] mergeSort(int[] arr) {
	        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	        
	    }

    private static int[] mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, temp, left, center); // 左边
            mergeSort(arr, temp, center + 1, right); // 右边
            merge(arr, temp, left, center + 1, right); // 合并两个有序
        }
    	return arr;
        
    }

    /**
     * 将两个有序表归并成一个有序表
     *
     * @param arr
     * @param temp     临时数组
     * @param leftPos  左边开始下标
     * @param rightPos 右边开始下标
     * @param rightEnd 右边结束下标
     */
    private static int[] merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1; // 左边结束下标
        int tempPos = leftPos; // 从左边开始算
        int numEle = rightEnd - leftPos + 1; // 元素个数
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos])
                temp[tempPos++] = arr[leftPos++];
            else
                temp[tempPos++] = arr[rightPos++];
        }
        while (leftPos <= leftEnd) {  // 左边如果有剩余
            temp[tempPos++] = arr[leftPos++];
        }
        while (rightPos <= rightEnd) { // 右边如果有剩余
            temp[tempPos++] = arr[rightPos++];
        }
        // 将temp复制到arr
        for (int i = 0; i < numEle; i++) {
            arr[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    
	//希尔排序
	public void sort(int[] arr) {
        int i, j, r, tmp;
        // 划组排序
        for(r = arr.length / 2; r >= 1; r = r / 2) {
            for(i = r; i < arr.length; i++) {
                tmp = arr[i];
                j = i - r;
                // 一轮排序
                while(j >= 0 && tmp < arr[j]) {
                    arr[j+r] = arr[j];
                    j -= r;
                }
                arr[j+r] = tmp;
            }
            System.out.println(i + ":" + Arrays.toString(arr));
        }
    }

}
