class MyQueue {

    Stack<Integer> queueStack;
    Stack<Integer> backUp;
    
    public MyQueue() {
        queueStack = new Stack<>();
        backUp = new Stack<>();
    }
    
    public void push(int x) {
        while(!queueStack.isEmpty()){
            backUp.push(queueStack.pop());
        }
        queueStack.push(x);
        while(!backUp.isEmpty()){
            queueStack.push(backUp.pop());
        }
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        return queueStack.pop();
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }
        return queueStack.peek();
    }
    
    public boolean empty() {
        return queueStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */