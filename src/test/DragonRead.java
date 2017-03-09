package test;

public class DragonRead {

	public static void main(String args[]){
		int[][] matrix={{3,2,2}};
	    int[] result = findDiagonalOrder(matrix);
	    for(int i=0;i<result.length;i++){
	    	System.out.print(result[i]+" ");
	    }
	}
	public static int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length,cols;
        if(rows==0){
        	cols = 0;
        }
        else{
        	cols = matrix[0].length;
        }
        if(rows==1){
        	return matrix[0];
        }
        int[] result = new int[rows*cols];
        int lastr=0,lastc=0,sign=1,count=0;
        while(lastr<rows&&lastc<cols){
            result[count] = matrix[lastr][lastc];
            count+=1;
            if(count==result.length){
            	break;
            }
            if(lastr==0&&lastc<cols-1){
            	if(sign%2!=0){
            		lastc+=1;
            		sign+=1;
            	}
            	else{
            		lastr+=1;
            		lastc-=1;
            	}
                continue;
            }
            else if(lastr==rows-1){
            	lastc +=1;
            	if(sign%2==0){
            		sign+=1;
            	}
            	else{
            		lastr -= 1;
            	}
                continue;
            }
            if(lastc==0){
            	if(sign%2==0){
            		lastr+=1;
            		sign +=1;
            	}
            	else{
            		lastr-=1;
            		lastc+=1;
            	}
                continue;
            }
            else if(lastc==cols-1){
                lastr +=1;
                if(sign%2==0){
                	lastc-=1;
                }
                else{
                	sign+=1;
                }
                continue;
            }
            lastr = sign%2==0?(lastr+1):(lastr-1);
            lastc = sign%2==0?(lastc-1):(lastc+1);
        }
        return result;
    }
}
