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
	 * [begin,end] 's elements
	 * @param begin
	 * @param end
	 */
	public  void quick_sort(int begin,int end){
		if(begin>=end){
			return ;
		}
		int key = arr[begin];
		int i = begin+1,j=end;
		while(i<j){
			if(arr[i]<=key){
				i += 1;
			}
			if(arr[j]>key){
				j -= 1;
			}
			if(arr[i]>key&&arr[j]<=key){
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i += 1;
				j -= 1;
			}
		}
		int pos = begin;
		if(i==j){
			if(arr[i]>key){
				arr[begin] = arr[i-1];
				arr[i-1] = key;
				pos = i-1;
			}
			else{
				arr[begin] = arr[i];
				arr[i] = key;
				pos = i;
			}
		}
		else{
			arr[begin] = arr[j];
			arr[j] = key;
			pos = j;
		}
		quick_sort(begin,pos-1);
		quick_sort(pos+1,end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array  = {3,8,5,3,2,6,1,4,7,6,0,1,3};
		QuickSort obj = new QuickSort(array);
		obj.quick_sort(0,array.length-1);
		int result[] = obj.getArr();
		for(int i=0;i<array.length;i++){
			System.out.print(result[i]+" ");
		}
	}
}
