package test;

public class MergeSort {

	public static void main(String[] args) {
		
	}

	public static int[] sort(int[] arr){
		int length = arr.length;
		int[] result = new int[length];
		return result;
	}
	public static int[]  merge(int[] arr1,int[] arr2){
		int length1 = arr1.length;
		int length2 = arr2.length;
		int[] mergeArr = new int[length1+length2];
		int i=0,p1=0,p2=0;
		for(;p1<length1&&p2<length2;i++){
			if(arr1[p1]<arr2[p2]){
				mergeArr[i] = arr1[p1];
				p1 += 1;
			}
			else{
				mergeArr[i] = arr2[p2];
				p2 += 1;
			}
		}
		if(i<length1+length2-1){
			if(p1==length1){
				for(int j=p2;j<length2;j++,i++){
					mergeArr[i] = arr2[j];
				}
			}
			else{
				for(int j=p1;j<length1;j++,i++){
					mergeArr[i] = arr1[j];
				}
			}
		}
		return mergeArr;
	}
}
