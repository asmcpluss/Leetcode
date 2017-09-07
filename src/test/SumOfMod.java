package test;

import java.util.Scanner;

/**
 * compute m%1+m%2+m%3+...+m%n;
 * @author Li Lingqi
 *
 */
public class SumOfMod {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int sum = 0;
		for(int i=1;i<=n;){
			int div = m/i;//公差
			int mod1 = m%i;
			int lastI = m/div;//当前公差的最后一项
			if(mod1==0){
				i+=1;
				continue;
			}
			int num = lastI - i + 1;
			if(lastI>n){
				num = n-i+1;
			}
			sum += num * mod1 - (num-1)*num*div/2;
			i = lastI + 1;
		}
		System.out.println(sum);
	}

}
