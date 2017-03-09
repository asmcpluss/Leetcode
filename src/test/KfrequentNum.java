package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KfrequentNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1};
		int k = 2;
		System.out.println(topKFrequent(nums,k));
	}
	
	//time complexity:O(n+n+k)
	public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] frequencyLst = new List[nums.length+1];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        int[] heap = new int[k];
        int[] ele = new int[k];
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>)it.next();
            int key = entry.getKey();
            int val = entry.getValue();
            if(frequencyLst[val]==null){
                frequencyLst[val] = new ArrayList<Integer>();
            }
            frequencyLst[val].add(key);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i=nums.length;i>0&&res.size()<k;i--){
            List<Integer> list = frequencyLst[i];
            if(list!=null){
                if(list.size()<=(k-res.size())){
                    res.addAll(list);
                }
                else{
                    for(int j=0;j<(k-res.size());j++){
                        res.add(list.get(j));
                    }
                }
            }
        }
        return res;
    }

}
