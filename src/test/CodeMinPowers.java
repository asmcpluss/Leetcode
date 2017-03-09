package test;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeMinPowers {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> positivePowers = new ArrayList<Integer>();
		positivePowers = computePowers(N);
		int size = positivePowers.size();
		int minNumofPowers = size;
		for(int i=0;i<positivePowers.size();i++){
			int power = positivePowers.get(i);
			int num = power-size+2*i+3;
			if(num<minNumofPowers){
				minNumofPowers = num;
			}
		}
		System.out.println(minNumofPowers);
	}
	
	public static ArrayList<Integer> computePowers(int n){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i=1;
		
		while(n!=0){
			int count = 0;
			while(i*2<=n){
				i*=2;
				count++;
			}
			result.add(count);
			n -= i;
			i = 1;
		}
		return result;
	}

}
