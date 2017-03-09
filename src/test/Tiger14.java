package test;

import java.util.Scanner;

public class Tiger14 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		boolean isPrime[] = new boolean[t+1];
		int primeList[] = new int[t+1];
		for(int i=0;i<=t;i++){
			isPrime[i] = true;
		}
		int count=0;
		for(int j=1;j<=t;j++){
			if(isPrime[j]){
				if(Miller_Rabin(j)){
					count++;
					primeList[count] = j;
					for(int k=1;k<=count;k++){
						if(j*primeList[k]>t){
							break;
						}
						isPrime[j*primeList[k]] = false;
						if(j%primeList[k]==0){
							break;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	//test whether a num is prime 
	public static boolean Miller_Rabin(long n)
	{
		
	    if(n <= 2) return n == 2;
	    if(n%2 == 0) return false;
	    long t = n - 1;
	    while(t%2 == 0) t >>= 1;
	    int N = 15;
		java.util.Random rand = new java.util.Random(N);
	    for(int i = 0;i < 15;i++){
	        long p = ((long)rand.nextDouble()*1000000000)%(n-2)+2;
	        if(n%p == 0) return false;
	        long tmp = t;
	        long x = pow(p,t,n); // p[i]^t % n;
	        while(tmp < n){
	            long y = mult(x,x,n);
	            if(y == 1 && x != 1 && x != n-1) return false;
	            x = y;
	            tmp <<= 1;
	        }
	        if(x != 1) return false; // Fermat¼ì²â
	    }
	    return true;
	}

	private static long mult(long x, long y, long mod) {
		long ans = 0;x %= mod;
	    while(y!=0){
	        if((y&1)!=0) {
	        	ans += x;
	        	y--;
	        }
	        if(ans >= mod) ans -= mod;
	        y >>= 1;
	        x <<= 1;
	        if(x >= mod) x -= mod;
	    }
	    return ans;
	}

	private static long pow(long a, long n, long mod) {
		a %= mod;
	    long ans = 1;
	    long one = 1;
	    while(n!=0){
	        if((n&1)!=0) ans = mult(ans,a,mod);
	        a = mult(a,a,mod);
	        n >>= 1;
	    }
	    return ans;
	}
}
