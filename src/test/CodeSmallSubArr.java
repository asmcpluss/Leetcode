package test;

import java.util.Scanner;

public class CodeSmallSubArr {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int[] arr = new int[length];
		int begin=-1,end=-1;
		int smstSub = 0;
		for(int i=0;i<length;i++){
			arr[i] = scan.nextInt();
		}
		for(int j=0;j<length-1;j++){
			if(arr[j]>arr[j+1]){
				begin = j;
				break;
			}
		}
		for(int k=length-1;k>0;k--){
			if(arr[k]<arr[k-1]){
				end = k;
				break;
			}
		}
		if(begin==-1){
			smstSub = 0;
		}
		else{
			int start = begin,finish = end;
			for(int i = start;i<=finish;i++){
				if(arr[i]<arr[begin-1]){
					int left=0,right = begin-1;
					while(right-left>1){
						if(arr[(left+right)/2]<arr[i]){
							left = (left+right)/2;
						}
						else if(arr[(left+right)/2]>arr[i]){
							right = (left+right)/2;
						}
						else{
							left = right = (left+right)/2;
						}
					}
					begin = right;
				}
				if(arr[i]>arr[end+1]){
					int left=end+1,right = length-1;
					while(right-left>1){
						if(arr[(left+right)/2]<arr[i]){
							left = (left+right)/2;
						}
						else if(arr[(left+right)/2]>arr[i]){
							right = (left+right)/2;
						}
						else{
							left = right = (left+right)/2;
						}
					}
					end = left;
				}
			}
		}
		smstSub = end-begin+1;
		System.out.println(smstSub);
	}

}
