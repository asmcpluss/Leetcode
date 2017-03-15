package test;

import java.util.Stack;
/**
 * use stack to implement queue's operation
 * @author Dell
 *
 */
public class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    static boolean hasPop = false;
    
    public void push(int node) {
        if(stack1.isEmpty()&&stack2.isEmpty()){
        	stack1.push(node);
        }
        else if(stack1.isEmpty()){
        	if(hasPop){
        		while(!stack2.isEmpty()){
        			stack1.push(stack2.pop());
        		}
        		stack1.push(node);
        	}
        	else stack2.push(node);
        	hasPop = false;
        }
        else{
        	if(hasPop){
        		while(!stack1.isEmpty()){
        			stack2.push(stack1.pop());
        		}
        		stack2.push(node);
        	}
        	else stack1.push(node);
        	hasPop = false;
        }
    }
    
    public int pop() {
    	if(stack1.isEmpty()&&stack2.isEmpty()){
    		return -1;
    	}
    	int val = -1;
    	if(hasPop){
    		if(!stack1.isEmpty()){
    			val =  stack1.pop();
    		}
    		else if(!stack2.isEmpty()){
    			val =  stack2.pop();
    		}
    	}
    	else{
    		hasPop = true;
    		if(!stack1.empty()){
    			while(!stack1.empty()){
    				stack2.push(stack1.pop());
    			}
    			val =  stack2.pop();
    		}
    		else{
    			while(!stack2.empty()){
    				stack1.push(stack2.pop());
    			}
    			val =  stack1.pop();
    		}
    	}
    	return val;
    }
}