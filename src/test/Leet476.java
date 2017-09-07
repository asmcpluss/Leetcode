package test;

public class Leet476 {

	public static void main(String[] args) {
		int num = 5;
		String binary = Integer.toBinaryString(num);
        int result = 0;
        int length = binary.length();
        for(int i=0;i<length;i++){
        	int tmp = binary.charAt(i)-'0';
            result = result*2 +1-tmp;
        }
        System.out.println(result);;
	}

}
