package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Code1094 {
	public static void main(String args[]){
		Scanner in =new  Scanner(System.in);
		int N,M;
		char usr[][] = new char[3][3];
		N = in.nextInt();
		M = in.nextInt();
		in.nextLine();
		char info[][] = new char[N][M];
		for(int i=0;i<N;i++){
			String str = in.nextLine();
			for(int j=0;j<M;j++){
				info[i][j] = str.charAt(j);
				
			}
		}
		for(int i=0;i<3;i++){
			String str = in.nextLine();
			for(int j=0;j<3;j++){
				usr[i][j] = str.charAt(j);
			}
		}
		computeFourDirection(usr,info,N,M);
	}
	
	private static void computeFourDirection(char[][] usr, char[][] info, int n, int m) {
		// TODO Auto-generated method stub
		char[][] southUsr = southOriented(usr);
		char[][] westUsr = westOriented(usr);
		char[][] eastUsr = eastOriented(usr);
		ArrayList<Integer[]> result1 = lookforPos(info,usr,n,m);
		ArrayList<Integer[]> result2 = lookforPos(info,southUsr,n,m);
		ArrayList<Integer[]> result3 = lookforPos(info,westUsr,n,m);
		ArrayList<Integer[]> result4 = lookforPos(info,eastUsr,n,m);
		ArrayList<String> result = new ArrayList<String>();
		HashSet<String> res = new HashSet<String>();
		res = outputList(result1,res);
		res = outputList(result2,res);
		res = outputList(result3,res);
		res = outputList(result4,res);
		result.addAll(res);
		Collections.sort(result);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}

	private static HashSet<String> outputList(ArrayList<Integer[]> result,HashSet<String> para) {
		// TODO Auto-generated method stub
		for(int i=0;i<result.size();i++){
			String str = result.get(i)[0]+" "+result.get(i)[1];
			para.add(str);
		}
		return para;
	}

	private static char[][] eastOriented(char[][] usr) {
		// TODO Auto-generated method stub
		char realPos[][] = new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				realPos[i][j] = usr[2-j][i];
			}
		}
		return realPos;
	}

	private static char[][] westOriented(char[][] usr) {
		// TODO Auto-generated method stub
		char realPos[][] = new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				realPos[i][j] = usr[j][2-i];
			}
		}
		return realPos;
		
	}

	private static char[][] southOriented(char[][] usr) {
		// TODO Auto-generated method stub
		char realPos[][] = new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				realPos[i][j] = usr[2-i][2-j];
			}
		}
		return realPos;
	}


	public static ArrayList<Integer[]> lookforPos(char[][] info,char[][] usr,int n,int m){
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		for(int i=0;i<n-2;i++){
			for(int j=0;j<m-2;j++){
				if(info[i][j]==usr[0][0]&&info[i][j+1]==usr[0][1]&&info[i][j+2]==usr[0][2]){
					if(info[i+1][j]==usr[1][0]&&info[i+1][j+1]==usr[1][1]&&info[i+1][j+2]==usr[1][2]){
						if(info[i+2][j]==usr[2][0]&&info[i+2][j+1]==usr[2][1]&&info[i+2][j+2]==usr[2][2]){
							Integer[] pos = new Integer[2];
							pos[0] = i+2;
							pos[1] = j+2;
							result.add(pos);
						}
					}
				}
			}
		}
		return result;
	}

}
