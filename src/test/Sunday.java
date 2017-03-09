package test;

public class Sunday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "codemonkey";
		String mode = "onk";
		System.out.println(sunday(str,mode));

	}
	
	/**
	 * find the initial position that mode appears in str
	 * @param str
	 * @param mode
	 * @return
	 */
	public static int sunday(String str,String mode){
		int pos = -1;
		int i=0,j=0,curr=i;
		int m = mode.length();
		int n = str.length();
		while(i<n&&j<m){
			if(str.charAt(i)!=mode.charAt(j)){
				if(i+m>=n){
					break;
				}
				char ch ;
				if(j==0){//mode串无匹配字符
					ch = str.charAt(i+m);
				}
				else{//mode串有匹配的字符
					j = 0;
					continue;
				}
				//str当前字符没有在mode中出现，跳过mode串的长度，再右移一位
				if(mode.indexOf(ch)==-1){
					i += m+1;
					j = 0;
					continue;
				}
				else{//寻找str当前字符在mode中最后出现的位置
					int index = mode.indexOf(ch);
					while(mode.indexOf(ch,index+1)!=-1&&index<m-1){
						index = mode.indexOf(ch,index+1);
					}
					j = 0;
					i += 1;
				}
			}
			else{//顺序匹配
				i+=1;
				j+=1;
			}
		}
		if(j==m){
			pos = i-m;
		}
		return pos;
	}

}
