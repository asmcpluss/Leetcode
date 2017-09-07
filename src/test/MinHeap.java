package test;

import java.util.ArrayList;

public class MinHeap {
	int heap_size;
	int[] elements;
	int capacity = 0;
	public MinHeap(int heap_size){
		this.heap_size = heap_size;
		elements = new int[heap_size];
	}
	public void insert(int val){
		if(capacity>=heap_size){
			System.err.println("The Heap has no space any more!");
			return;
		}
		elements[capacity] = val;
		capacity += 1;
	}
	public void adjustMHTree(){
	}
	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('l');
		System.out.println(list.contains('a'));
		String str = "googgle";
		System.out.println(FirstNotRepeatingChar(str));
	}

	public static int FirstNotRepeatingChar(String str) {
        if(str.length()==0){
            return -1;
        }
        ArrayList<Character> list = new ArrayList<Character>();
        boolean appearTwice[] = new boolean[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int offset = ch-'a';
            if(list.contains(ch)){
                list.remove(new Character(ch));
                appearTwice[offset] = true;
                continue;
            }
            if(appearTwice[offset]){
                continue;
            }
            list.add(ch);
        }
        if(list.size()==0){
            return -1;
        }
        return str.indexOf(list.get(0));
    }
}
