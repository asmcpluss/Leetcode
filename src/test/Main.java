package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
/**
 * 二分法查找id位置
 * @param itemList
 * @param itemPriceList
 * @param itemId
 * @param itemPrice
 * @return
 */
    static int position(String itemList, String itemPriceList, String itemId, double itemPrice) {
    	int id_pos = -1;
        String priceList[] = itemPriceList.split(",");
        String list[] = itemList.split(",");
        if(priceList.length!=list.length){
        	return -1;
        }
        long left = 0,right = priceList.length-1,mid = (left+right)/2;
        while(left<right-1){
        	double pri = Double.parseDouble(priceList[(int)mid]);
        	if(pri>itemPrice){
        		left = mid;
        	}
        	else if(pri<itemPrice){
        		right = mid;
        	}
        	else{
        		left = mid;
        		break;
        	}
        }
        if(left==right-1){
        	return -1;
        }
        int index=(int)left,index2=(int)left+1;
        while(Double.parseDouble(priceList[index])==itemPrice||Double.parseDouble(priceList[index2])==itemPrice){
        	if(list[index].equals(itemId)){
        		id_pos = index;
        	}
        	if(list[index2].equals(itemId)){
        		id_pos = index2;
        	}
        	else{
        		index -=1;
        		index2 +=1;
        	}
        }
        return id_pos;
    }


    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
        int res;
            
        String _itemList;
        try {
            _itemList = in.nextLine();
        } catch (Exception e) {
            _itemList = null;
        }
        
        String _itemPriceList;
        try {
            _itemPriceList = in.nextLine();
        } catch (Exception e) {
            _itemPriceList = null;
        }
        
        String _itemId;
        try {
            _itemId = in.nextLine();
        } catch (Exception e) {
            _itemId = null;
        }

        double _itemPrice;
        _itemPrice = Double.parseDouble(in.nextLine().trim());
  
        res = position(_itemList, _itemPriceList, _itemId, _itemPrice);
        System.out.println(String.valueOf(res));    

    }
}