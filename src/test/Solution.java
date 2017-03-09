package test;

import java.util.Collections;
import java.util.Vector;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Leetcode";
		System.out.println(reverseVowels(str));

	}
	
	static String reverseVowels(String s) {
        Vector<Integer> epos = new Vector<Integer>();
        Vector<Integer> opos = new Vector<Integer>();
        Vector<Integer> sortList = new Vector<Integer>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='e'){
                epos.add(i);
                sortList.add(i);
            }
            if(s.charAt(i)=='o'){
                opos.add(i);
                sortList.add(i);
            }
        }
        Collections.sort(sortList);
        String str="";
        for(int i=0;i<sortList.size()-1;i++){
        	int left = sortList.get(i);
        	int right = sortList.get(i+1);
        	if(epos.contains(left)&&opos.contains(right)){
        		str += s.substring(str.length(), left) + reverse(s.substring(left,right+1));
        	}
        }
        str += s.substring(str.length(),s.length());
        return str;
    }
    static String reverse(String s){
        String result = "";
        if(s.indexOf('y')==-1||s.indexOf(" ")==-1){
            for(int i=s.length()-1;i>=0;i--){
                result += s.charAt(i);
            }
            return result;
        }
        else{
            return s;
        }
    }

}
