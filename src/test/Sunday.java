package test;

public class Sunday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "codemonkeyadf";
		String mode = "key";
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
				if(j==0){//mode����ƥ���ַ�
					ch = str.charAt(i+m);
				}
				else{//mode����ƥ����ַ�
					j = 0;
					continue;
				}
				//str��ǰ�ַ�û����mode�г��֣�����mode���ĳ��ȣ�������һλ
				if(mode.indexOf(ch)==-1){
					i += m+1;
					j = 0;
					continue;
				}
				else{//Ѱ��str��ǰ�ַ���mode�������ֵ�λ��
					int index = mode.lastIndexOf(ch);
					j = 0;
					i += 1;
				}
			}
			else{//˳��ƥ��
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
