package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AliTest  {

	public static void main(String[] args) {
		
	}

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
