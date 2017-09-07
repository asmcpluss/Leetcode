package test;

import java.util.ArrayList;

public class KMP {

	public static void main(String[] args) {
		String str = "babsdfaadsdddljl";
		String pattern="dlj";
		ArrayList<Integer> result = matchString(str,pattern);
		if(result.size()==0){
			System.out.println(-1);
		}
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+" ");
		}
	}
	public static ArrayList<Integer> matchString(String str,String subStr){
		ArrayList<Integer> appearPos = new ArrayList<Integer>();
		int next[] = computeNext(subStr);
		int n = str.length();
		int m = subStr.length();
		int pOfSub = 0;
		for(int i=0;i<n;i++){
			while(pOfSub>0 && subStr.charAt(pOfSub)!=str.charAt(i)){ //core process
				pOfSub = next[pOfSub-1];
			}
			if(str.charAt(i)==subStr.charAt(pOfSub)){
				pOfSub += 1;
			}
			if(pOfSub==m){ //find a successful match and start a new match
				appearPos.add(i-m+1);
				pOfSub = next[pOfSub-1];
			}
		}
		return appearPos;
	}

	/** for "abcab",next[5] = {0,0,0,1,2}
	 * compute next[]
	 * @param para
	 * @return
	 */
	public static int[] computeNext(String para){
		int length = para.length();
		int next[] = new int[length];
		next[0] = 0;
		String subStr = para;
		int match_position = 0;
		for(int i=1;i<length;i++){
			while(match_position>0 && para.charAt(match_position)!=para.charAt(i)){ //core process
				match_position = next[match_position-1];
			}
			if(para.charAt(match_position)==para.charAt(i)){
				match_position += 1;
			}
			next[i] = match_position;
		}
		return next;
	}
}
