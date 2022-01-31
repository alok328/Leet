class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> queue;
    
    public MyQueue() {
        stack = new Stack<>();
        queue = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(queue.isEmpty()){
            while(!stack.isEmpty()){
                queue.push(stack.pop());
            }
        }
        if(queue.isEmpty()){
            return -1;
        }
        return queue.pop();
    }
    
    public int peek() {
        if(queue.isEmpty()){
            while(!stack.isEmpty()){
                queue.push(stack.pop());
            }
        }
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
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