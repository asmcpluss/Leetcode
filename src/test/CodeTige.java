package test;

import java.util.Scanner;

public class CodeTige {
	public static void main(String args[]){
		int digits[] = new int[4];
		int lessThan3 = 0;
		int lessThan6 = 0;
		boolean contain2 = false;
		boolean contain3 = false;
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<4;i++){
			int num = scan.nextInt();
			digits[i] = num;
			if(num<6){
				lessThan6++;
				if(num==3){
					contain3 = true;
				}
				else if(num<3){
					lessThan3++;
				}
				if(num==2){
					contain2 = true;
				}
			}
		}
		if(lessThan6<2||lessThan3<1||(!contain3&&lessThan3<2)){
			System.out.println("NOT POSSIBLE");
		}
		else{
			int maxTimeMin = 0;
			int mh1=0,mh2=0,mm1=0,mm2=0;
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					if(j==i){
						continue;
					}
					for(int k=0;k<4;k++){
						for(int l=0;l<4;l++){
							if(k==l||k==i||k==j||l==i||l==j){
								continue;
							}
							int h1,h2,m1,m2;
							h1 = digits[i];
							h2 = digits[j];
							m1 = digits[k];
							m2 = digits[l];
							if(IsTime(h1,h2,m1,m2)){
								if((h1*10+h2)*60+m1*10+m2>maxTimeMin){
									maxTimeMin = (h1*10+h2)*60+m1*10+m2;
									mh1 = h1;
									mh2 = h2;
									mm1 = m1;
									mm2 = m2;
								}
							}
						}
					}
					
				}
			}
			System.out.println(mh1+""+mh2+":"+mm1+""+mm2);
		}
	}
	
	public static boolean IsTime(int h1,int h2,int m1,int m2){
		if((h1*10+h2) <= 23&&(m1*10+m2) <=59){
			return true;
		}
		return false;
	}

}
