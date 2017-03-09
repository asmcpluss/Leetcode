package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Code1082 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		ArrayList<String> result = new ArrayList<String>();
		while(in.hasNextLine()){
			String source = in.nextLine();
			String sourceLower = source.toLowerCase();
			String str = "";
			int index = -9;
			int lastIndex = 0;
			while(index!=-1){
				index = sourceLower.indexOf("marshtomp", index+9);
				if(index==-1){
					break;
				}
				str += source.substring(lastIndex, index) + "fjxmlhx";
				lastIndex = index + 9;
			}
			str += source.substring(lastIndex,source.length());
			result.add(str);
		}
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}

}
