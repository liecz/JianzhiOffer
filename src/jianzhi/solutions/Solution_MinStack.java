package jianzhi.solutions;

/**
 * Created by liec on 2017-02-13.
 */
public class Solution_MinStack {
    private int[] elements = new int[15];
    private java.util.Stack<Integer> minStack = new java.util.Stack<>();
    private int minValue = Integer.MAX_VALUE;
    private int top = -1;

    public static void main(String[] args) {
        Solution_MinStack s = new Solution_MinStack();
        s.push(3);
        s.push(1);
        s.push(2);
        int a = s.min();
        s.pop();
        int b = s.min();
        s.pop();
        int c = s.min();
        s.pop();
    }

    private void ensureCapacity(int newsize){
        if(newsize>elements.length){
            int[] newElems = new int[elements.length*2];
            System.arraycopy(elements,0,newElems,0,elements.length);
            elements = newElems;
        }
    }

    public void push(int node) {
        ensureCapacity(top+1);
        elements[++top] = node;
        if(node<minValue){
            minValue = node;
            minStack.push(node);
        }else{
            minStack.push(minValue);
        }
    }

    public void pop() {
        top--;
        if(!minStack.empty()){
            minStack.pop();
            minValue = minStack.empty()?Integer.MAX_VALUE:minStack.peek();
        }
    }

    public int top() {
        return elements[top];
    }

    public int min() {
        return minValue;
    }
}
