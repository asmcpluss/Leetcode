package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AliTest  {

	
	public static void main(String[] args) {
//		int m,n,t;
//		int s1,s2,e;
//		Scanner scan = new Scanner(System.in);
//		m = scan.nextInt();
//		n = scan.nextInt();
//		t = scan.nextInt();
//		s1=scan.nextInt();
//		s2 = scan.nextInt();
//		e = scan.nextInt();
		int arr[] = {4,1,2,3,5};
		System.out.println(xNotInArr(arr));
	}
	/**
	 * arr[n]的数字在[0,n]范围内，且各不相同，问[0,n]哪个数字没有出现在arr中
	 * @param arr
	 * @return
	 */
	public static int xNotInArr(int[] arr){
		int result=arr.length;
		for(int i=0;i<arr.length;i++){
			result ^= arr[i];
			result ^= i;
		}
		return result;
	}
	/**
	 * Given a string, sort it in decreasing order based on the frequency of characters.
	 * e.g tree-->eetr/eert
	 * @param s
	 * @return
	 */
	public static String frequencySort(String s) {
		if(s.length()<=2){
            return s;
        }
        int count[] = new int[128];
        int max = 0;
        for(char ch:s.toCharArray()){
        	count[ch] += 1;
        	max = Math.max(max, count[ch]);
        }
        String tmp[] = new String[max+1];
        for(int i=0;i<128;i++){
        	if(count[i]!=0){
        		if(tmp[count[i]]==null){
        			tmp[count[i]] = ""+(char)i;
        		}
        		else{
        			tmp[count[i]] += (char)i;
        		}
        	}
        }
        //使用StringBuilder目的是为了防止在字符串(String)更新的过程中一直分配新的内存(超时)
        StringBuilder result = new StringBuilder();
        for(int i=max;i>=0;i--){
        	String str = tmp[i];
        	if(str==null) continue;
        	for(int j=0;j<str.length();j++){
        		for(int k=0;k<i;k++){
        			result.append(str.charAt(j));
        		}
        	}
        }
        return result.toString();
    }
	
	/**give a list of time points,find the mininum difference minutes
	 * 00:00-23:59
	 * @param timePoints
	 * @return
	 */
	 public static int findMinDifference(List<String> timePoints) {
	        int[] timeArr = new int[1440];
	        int left=1439,right=0;
	        if(timePoints.size()>1440){
	            return 0;
	        }
	        for(String t:timePoints){
	            String[] splits = t.split(":");
	            int hour = (splits[0].charAt(0)-'0')*10+splits[0].charAt(1)-'0';
	            int minute = (splits[1].charAt(0)-'0')*10+splits[1].charAt(1)-'0';
	            int minutes = hour*60+minute;
	            if(timeArr[minutes]==0){
	                timeArr[minutes] = 1;
	            }
	            else if(timeArr[minutes]==1) return 0;
	            if(minutes<left){
	                left = minutes;
	            }
	            if(minutes>right){
	                right = minutes;
	                
	            }
	        }
	        int min = 1440-right+left;
	        int last = -1;
	        //test
	        System.out.println(timeArr[1404]);
	        for(int i=0;i<1440;i++){
	            if(timeArr[i]==1){
	                if(last==-1){
	                    last = i;
	                    continue;
	                }
	                if((i-last)<min){
	                    min = Math.abs(i-last);  
	                }
	                last = i;
	            }
	        }
	        return min;
	    }
	 
	 /**
	  * leetcode contest2 test2
	  * @param picture
	  * @return
	  */
	 public int findLonelyPixel(char[][] picture) {
	        int row = picture.length,col = picture[0].length;
	        int[] rowSign = new int[row];
	        int[] colSign = new int[col];
	        HashMap<Integer,ArrayList<Integer>> blackp = new HashMap<Integer,ArrayList<Integer>>();
	        for(int i=0;i<row;i++){
	            rowSign[i] = 0;
	        }
	        for(int i=0;i<col;i++){
	            colSign[i] = 0;
	        }
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                if('B'==picture[i][j]){
	                    rowSign[i] += 1;
	                    colSign[j] += 1;
	                    if(blackp.containsKey(i)){
	                        ArrayList<Integer> list = blackp.get(i);
	                        list.add(j);
	                    }
	                    else{
	                        ArrayList<Integer> list = new ArrayList<Integer>();
	                        list.add(j);
	                        blackp.put(i,list);
	                    }
	                }
	            }
	        }
	        int count = 0;
	        Iterator it = blackp.entrySet().iterator();
	        while(it.hasNext()){
	        	Map.Entry<Integer,ArrayList<Integer>> entry = (Map.Entry<Integer,ArrayList<Integer>>)it.next();
	        	int key = entry.getKey();
	        	ArrayList<Integer> val = entry.getValue();
	        	if(rowSign[key]>1){
	        		continue;
	        	}
	        	else{
	        		for(int each : val){
	        			if(colSign[each]==1){
	        				count += 1;
	        			}
	        		}
	        	}
	        }
	        return count;
	    }
	 
	 /**
	  * not finished yet
	  * @param ring
	  * @param key
	  * @return
	  */
	 public int findRotateSteps(String ring, String key) {
		  int length = ring.length();
		  int count = key.length();
	      HashMap<Character,ArrayList<Integer>> pos = new HashMap<Character,ArrayList<Integer>>();
	      for(int i=0;i<length;i++){
	    	  char ch =ring.charAt(i);
	    	  if(pos.containsKey(ch)){
	    		  ArrayList<Integer> val = pos.get(ch);
	    		  val.add(i);
	    	  }
	    	  else{
	    		  ArrayList<Integer> val = new ArrayList<Integer>();
	    		  val.add(i);
	    		  pos.put(ch, val);
	    	  }
	      }
	      for(int i=1,lastPos=0;i<key.length();i++){
	    	  char keyC = key.charAt(i);
	    	  if(keyC==ring.charAt(lastPos)){
	    		  continue;
	    	  }
	    	  ArrayList<Integer> vals = pos.get(keyC);
	    	  int clockWise =0;
	    	  int antiC = 0;
	    	  int left=0,right=0;
	    	  if(vals.size()>=1){
	    		  if(lastPos<vals.get(0)){
	    			  clockWise = vals.get(0)-lastPos;
	    	    	  antiC = length-vals.get(vals.size()-1)+lastPos;
	    	    	  left  = vals.get(vals.size()-1); //anticlockwise
	    	    	  right = vals.get(0);//clockwise
	    		  }
	    		  else if(lastPos>vals.get(vals.size())){
	    			  clockWise = length-lastPos+vals.get(0);
	    			  antiC = lastPos-vals.get(vals.size()-1);
	    	    	  left  = vals.get(vals.size()-1); //anticlockwise
	    	    	  right = vals.get(0);//clockwise
	    		  }
	    		  else{
	    			  int p=0;
	    			  for(int index : vals){
	    				  if(vals.get(index)>lastPos){
	    					  p = index;
	    					  break;
	    				  }
	    			  }
	    			  clockWise = vals.get(p)-lastPos;
	    			  antiC = lastPos-vals.get(p-1);
	    			  left  = vals.get(p-1); //anticlockwise
	    	    	  right = vals.get(p);//clockwise
	    		  }
	    		  count += (clockWise>antiC?antiC:clockWise);
	    		  lastPos = (clockWise>antiC?left:right);
	    	  }
	      }
	      return count;
	 }
}
