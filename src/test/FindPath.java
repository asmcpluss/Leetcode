package test;
import java.util.*;
public class FindPath {
    static HashMap<Character,ArrayList<Integer>> map ;
    static char[] str1;
    static int rows1;
    static int cols1;
    
    /**
     * judge whether there exists a way in matrix to traverse str,each move must be top down left or right;
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(str.length>rows*cols){
            return false;
        }
        map = new HashMap<Character,ArrayList<Integer>>();
        for(int i=0;i<rows*cols;i++){
            char ch = matrix[i];
            if(map.containsKey(ch)){
                ArrayList<Integer> list = map.get(ch);
                list.add(i);
                map.put(ch,list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(ch,list);
            }
        }
        str1 = str;
        rows1 = rows;
        cols1 = cols;
        boolean[] signs = new boolean[rows*cols];
        boolean found = hasPath(signs,0,0);
        return found;
    }

    /**
     * 
     * @param signs Store the status whether the position has been passed
     * @param curr
     * @param lastP
     * @return
     */
    public static boolean hasPath(boolean[] signs,int curr,int lastP){
        if(curr>=str1.length){
            return true;
        }
        char ch = str1[curr];
        if(!map.containsKey(ch)){
        	return false;
        }
        ArrayList<Integer> list = map.get(str1[curr]);
        //search all the possible roads
        for(Integer pos: list){
            if(!signs[pos]){
                if(curr==0||(Math.abs(lastP-pos)==1&&lastP/cols1==pos/cols1)||(Math.abs(lastP-pos)==cols1)){
                    signs[pos] = true;
                    if(hasPath(signs,curr+1,pos)){
                        return true;
                    }
                    else{
                        signs[pos] = false;
                    }
                }
            }
        }
        return false;
    }
    
    public static void main(String args[]){
    	char[] matrix = {'A'};
    	char[] str = {'B'};
    	int rows = 1;
    	int cols = 1;
    	System.out.println(hasPath(matrix,rows,cols,str));
    }

}