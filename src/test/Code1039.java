package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Code1039 {
	 public static void main(String args[]) {
	        Scanner scan = new Scanner(System.in);
	        int T;
			String element = "";
	        T = scan.nextInt();
	        ArrayList<String> input = new ArrayList<String>(T);
	        int result[] = new int[T];
	        for(int i=0;i<T;i+=1){
	            element = scan.next();
	            input.add(element);
	        }
	        for(int j=0;j<T;j+=1){
	        	result[j] = input.get(j).length()+1-computeMaxReMove(input.get(j),input.get(j).length());
	        }
	        for(int j=0;j<T;j+=1){
	        	System.out.println(result[j]);
	        }
	    }
	 
	 public static int insertCh(String para,int length,char ch){
		 int resA = length;
		 boolean found = true;
	    	for(int i=-1;i<length;i+=1){
	    		if(i==-1){
	    			resA = Math.min(resA, deleteRecursion((ch+para).toCharArray(),length+1));
	    		}
	    		else if(i==length-1){
	    			resA = Math.min(resA, deleteRecursion((para+ch).toCharArray(),length+1));
	    		}
	    		else{
	    			resA = Math.min(resA, deleteRecursion((para.substring(0, i+1)+ch+para.substring(i+1, length)).toCharArray(),length+1));
	    		}
	    	}

	    	return resA;
	 }
	    
	    public static int computeMaxReMove(String para,int length){
	    	char cha = 'A',chb = 'B',chc = 'C';
	    	int rA = length+1,rB = length+1,rC = length+1;
	    	if(para.indexOf(cha)!=-1){
	    		rA = insertCh(para,length,cha);
	    	}
	    	if(para.indexOf(chb)!=-1){
	    		rB = insertCh(para,length,chb);
	    	}
	    	if(para.indexOf(chc)!=-1){
	    		rC = insertCh(para,length,chc);
	    	}
//	    	System.out.println(rA+" "+rB+" "+rC);
	    	return Math.min(Math.min(rA, rB), rC);
	    }
	    
	    public static int deleteRecursion(char[] para,int length){
	    	String nextState = "";
	    	boolean found = true;
	    	if(length>1){
	    		for(int i=0;i<length;i+=1){
		    		if(i==0){
		    			if(para[i]!=para[i+1]){
		    				nextState += para[i];
		    			}
		    		}
		    		else if(i==length-1){
		    			if(para[i]!=para[i-1]){
		    				nextState += para[i];
		    			}
		    		}
		    		else if(para[i]!=para[i-1]&&para[i]!=para[i+1]){
		    			nextState += para[i];
		    		}
		    		else {
		    			found = false;
		    		}
		    	}
	    	}
	    	if(length<=1){
	    		return length;
	    	}
	    	if(found){
	    		return nextState.length();
	    	}
	    	else{
	    		 return deleteRecursion(nextState.toCharArray(),nextState.length());
	    	}
	    }
}
