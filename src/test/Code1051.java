package test;

import java.util.Scanner;

public class Code1051 {
	public static void main(String args[]){
		int T;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		int result[] = new int[T];
		for(int i=0;i<T;i++){
			int N = in.nextInt();
			int M = in.nextInt();
			int location[] = new int[N];
			for(int j=0;j<N;j++){
				location[j] = in.nextInt();
			}
			result[i] = computeMaxCon(N,M,location);
		}
		for(int k=0;k<T;k++){
			System.out.println(result[k]);
		}
	}

	public static int computeMaxCon(int n,int m,int locate[]){
		int result = 0;
		int interval[] = new int[n+1];
		for(int i=0;i<n+1;i++){
			if(i==0){
				interval[i] = locate[i]-1;
			}
			else if(i==n){
				interval[i] = 100 - locate[i-1];
			}
			else{
				interval[i] = locate[i] - locate[i-1] -1;
			}
		}
		if(m>=n){
			result = 100;
		}
		else{
			for(int j=0;j<n-m;j++){
				int temp = 0;
				for(int k=0;k<=m;k++){
					temp += interval[j+k];
				}
				result = Math.max(result, temp+m);
			}
		}
		return result;
	}
}
