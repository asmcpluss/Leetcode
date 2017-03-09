package test;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {

	private  int[] arr;
	
	public QuickSort(int[] arr){
		this.arr = arr;
	}
	
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	/**
	 * from minimum to maximum
	 * @param arr
	 * @return
	 */
	public  void quick_sort(){
		quick_sort(0,arr.length-1);
	}
	
	/**
	 * [begin,end] 's elements
	 * @param begin
	 * @param end
	 */
	public  void quick_sort(int begin,int end){
		if(begin>=end){
			return ;
		}
		int pos = begin;
		for(int i = begin+1;i<=end;i++){
			if(arr[pos]>arr[i]){
				int tmp = arr[i];
				arr[i] = arr[pos];
				arr[pos] = tmp;
			}
		}
		quick_sort(begin,pos-1);
		quick_sort(pos+1,end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int[] array  = new int[length];
		for(int i=0;i<length;i++){
			array[i] = in.nextInt();
		}
		QuickSort obj = new QuickSort(array);
		obj.quick_sort();
		int result[] = obj.getArr();
		for(int i=0;i<length;i++){
			System.out.print(result[i]+" ");
		}
	}
}
