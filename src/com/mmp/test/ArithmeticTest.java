package com.mmp.test;

import java.util.Arrays;



public class ArithmeticTest {
	public static void main(String[] args) {
		
		int[] arr ={1,5,8,7,9,6,3,4,2};
		//new ArithmeticTest().sort(arr);
		//int[] mergeSort = mergeSort(arr);
		//System.out.println("褰掑苟鎺掑簭鏈�缁堢粨鏋滐細"+Arrays.toString(mergeSort));
		quickSort(arr);
	}
	
	/**
	 * 蹇�熸帓搴�
	 */
	public static void quickSort(int[] a) {
		if(a.length>0) {
			quickSort(a, 0 , a.length-1);
		}
	}
	private static void quickSort(int[] a, int low, int high) {
		//1,鎵惧埌閫掑綊绠楁硶鐨勫嚭鍙�
		if( low > high) {
			return;
		}
		//2, 瀛�
		int i = low;
		int j = high;
		//3,key
		int key = a[ low ];
		//4锛屽畬鎴愪竴瓒熸帓搴�
		while( i< j) {
			//4.1 锛屼粠鍙冲線宸︽壘鍒扮涓�涓皬浜巏ey鐨勬暟
			while(i<j && a[j] > key){
				j--;
			}
			// 4.2 浠庡乏寰�鍙虫壘鍒扮涓�涓ぇ浜巏ey鐨勬暟
			while( i<j && a[i] <= key) {
				i++;
			}
			//4.3 浜ゆ崲
			if(i<j) {
				int p = a[i];
				a[i] = a[j];
				a[j] = p;
			}
		}
		// 4.4锛岃皟鏁磌ey鐨勪綅缃�
		int p = a[i];
		a[i] = a[low];
		a[low] = p;
		System.out.println(Arrays.toString(a));
		//5, 瀵筴ey宸﹁竟鐨勬暟蹇帓
		quickSort(a, low, i-1 );
		//6, 瀵筴ey鍙宠竟鐨勬暟蹇帓
		quickSort(a, i+1, high);
	}
	/* 蹇�熸帓搴忕粨鏉�*/
	
	
	private static int[] mergeSort(int[] arr) {
	        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	        
	    }

    private static int[] mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, temp, left, center); // 宸﹁竟
            mergeSort(arr, temp, center + 1, right); // 鍙宠竟
            merge(arr, temp, left, center + 1, right); // 鍚堝苟涓や釜鏈夊簭
        }
    	return arr;
        
    }

    /**
     * 灏嗕袱涓湁搴忚〃褰掑苟鎴愪竴涓湁搴忚〃
     *
     * @param arr
     * @param temp     涓存椂鏁扮粍
     * @param leftPos  宸﹁竟寮�濮嬩笅鏍�
     * @param rightPos 鍙宠竟寮�濮嬩笅鏍�
     * @param rightEnd 鍙宠竟缁撴潫涓嬫爣
     */
    private static int[] merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1; // 宸﹁竟缁撴潫涓嬫爣
        int tempPos = leftPos; // 浠庡乏杈瑰紑濮嬬畻
        int numEle = rightEnd - leftPos + 1; // 鍏冪礌涓暟
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos])
                temp[tempPos++] = arr[leftPos++];
            else
                temp[tempPos++] = arr[rightPos++];
        }
        while (leftPos <= leftEnd) {  // 宸﹁竟濡傛灉鏈夊墿浣�
            temp[tempPos++] = arr[leftPos++];
        }
        while (rightPos <= rightEnd) { // 鍙宠竟濡傛灉鏈夊墿浣�
            temp[tempPos++] = arr[rightPos++];
        }
        // 灏唗emp澶嶅埗鍒癮rr
        for (int i = 0; i < numEle; i++) {
            arr[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    
	//甯屽皵鎺掑簭
	public void sort(int[] arr) {
        int i, j, r, tmp;
        // 鍒掔粍鎺掑簭
        for(r = arr.length / 2; r >= 1; r = r / 2) {
            for(i = r; i < arr.length; i++) {
                tmp = arr[i];
                j = i - r;
                // 涓�杞帓搴�
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
