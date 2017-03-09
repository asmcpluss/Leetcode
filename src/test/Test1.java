package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test1{
    public static void main(String args[]) throws FileNotFoundException{
        Scanner scan = new Scanner(new File("src/test/input"));
        int N,element = 0;
        N = scan.nextInt();
        ArrayList<Short> signal = new ArrayList<Short>(N);
        for(int i=0;i<N;i+=1){
            element = scan.nextInt();
            if(element%2==0){
            	signal.add((short)0);
            }
            else{
            	signal.add((short)1);
            }
        }
        int result = removeSumOdd(signal,N);
        System.out.println(result);
    }
    
    public static int removeSumOdd(ArrayList<Short> para,int length){
    	ArrayList<Short> temp = new ArrayList<Short>();
    	boolean found = false;
    	for(int i=0;i<length-1;i+=1){
    		if((para.get(i)+para.get(i+1))%2!=0){
    			i+=1;
    			found = true;
    		}
    		else{
    			temp.add(para.get(i));
    			if(i==length-2){
    				temp.add(para.get(i+1));
    			}
    		}
    	}
    	if(found){
    		return removeSumOdd(temp,temp.size());
    	}
    	else{
    		return para.size();
    	}
    }
}
