package lianxi0421;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class test0421 {
    public static void main(String[] args) {

    }
}

//用栈实现队列
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty()&&stack2.empty();
    }
}


//用队列实现栈
class MyStack {
    private Queue<Integer>queue1;
    private Queue<Integer> queue2;
    private int count = 0;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()){
            queue2.add(x);
        }else if(queue2.isEmpty()){
            queue1.add(x);
        }else{
            queue1.add(x);
        }
        count ++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        if(count == 1){
            if(queue1.isEmpty()){
                count --;
                return queue2.poll();
            }
            count --;
            return queue1.poll();
        }
        int a = count;
        if(queue1.isEmpty()){
            while(a != 1){
                queue1.add(queue2.poll());
                a--;
            }
            count --;
            return queue2.poll();
        }else{
            while(a != 1){
                queue2.add(queue1.poll());
                a--;
            }
        }
        count --;
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {

        if(count == 1){
            if(queue1.isEmpty()){
                return queue2.peek();
            }
            return queue1.peek();
        }
        int a = count;
        if(queue1.isEmpty()){
            while(a != 1){
                queue1.add(queue2.poll());
                a--;
            }
            int b = queue2.poll();
            queue1.add(b);
            return b;
        }else{
            while(a != 1){
                queue2.add(queue1.poll());
                a--;
            }
        }
        int c = queue1.poll();
        queue1.add(c);
        return c;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }
        return false;
    }
}