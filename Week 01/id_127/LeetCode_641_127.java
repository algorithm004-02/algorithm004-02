public class MyCircularDeque {
	Stack<Integer> stack_first_forward = new Stack<Integer>();
	Stack<Integer> stack_first_back = new Stack<Integer>();
	Stack<Integer> stack_last_forward = new Stack<Integer>();
	Stack<Integer> stack_last_back = new Stack<Integer>();
	int length;
	int count = 0;
	 public MyCircularDeque(int k) {
		 length = k;
	    }
	    
	    /** Adds an item at the front of Deque. Return true if the operation is successful. */
	    public boolean insertFront(int value) {
	    	if(count == length) {
	    		return false;
	    	}
	    	if(!stack_first_back.isEmpty()) {
	    		while(!stack_first_back.isEmpty()) {
	    			stack_first_forward.push(stack_first_back.pop());
	    		}
	    	}
	    	stack_first_forward.push(value);
	    	count++;
			return true;
	        
	    }
	    
	    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
	    public boolean insertLast(int value) {
	    	if(count == length) {
	    		return false;
	    	}
	    	if(!stack_last_back.isEmpty()) {
	    		while(!stack_last_back.isEmpty()) {
	    			stack_last_forward.push(stack_last_back.pop());
	    		}
	    	}
	    	stack_last_forward.push(value);
	    	count++;
			return true;
	        
	    }
	    
	    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
	    public boolean deleteFront() {
	    	if(count == 0) {
	    		return false;
	    	} else if(!stack_first_forward.isEmpty()) {
	    		stack_first_forward.pop();
	    	} else if(!stack_first_back.isEmpty()) {
	    		while(!stack_first_back.isEmpty()) {
	    			stack_first_forward.push(stack_first_back.pop());
	    		}
	    		stack_first_forward.pop();
	    	} else if(!stack_last_back.isEmpty()) {
	    		stack_last_back.pop();
	    	} else if(!stack_last_forward.isEmpty()) {
	    		while(!stack_last_forward.isEmpty()) {
	    			stack_last_back.push(stack_last_forward.pop());
	    		}
	    		stack_last_back.pop();
	    	}
	    	count--;
			return true;
	        
	    }
	    
	    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	    public boolean deleteLast() {
	    	if(count == 0) {
	    		return false;
	    	} else if(!stack_last_forward.isEmpty()) {
	    		stack_last_forward.pop();
	    	} else if(!stack_last_back.isEmpty()) {
	    		while(!stack_last_back.isEmpty()) {
	    			stack_last_forward.push(stack_last_back.pop());
	    		}
	    		stack_last_forward.pop();
	    	} else if(!stack_first_back.isEmpty()) {
	    		stack_first_back.pop();
	    	} else if(!stack_first_forward.isEmpty()) {
	    		while(!stack_first_forward.isEmpty()) {
	    			stack_first_back.push(stack_first_forward.pop());
	    		}
	    		stack_first_back.pop();
	    	}
	    	count--;
			return true;
	        
	    }
	    
	    /** Get the front item from the deque. */
	    public int getFront() {
	    	int result = -1;
	    	if(!stack_first_forward.isEmpty()) {
	    		result = stack_first_forward.peek();
	    	} else if(!stack_first_back.isEmpty()) {
	    		while(!stack_first_back.isEmpty()) {
	    			stack_first_forward.push(stack_first_back.pop());
	    		}
	    		result = stack_first_forward.peek();
	    	} else if(!stack_last_back.isEmpty()) {
	    		result = stack_last_back.peek();
	    	} else if(!stack_last_forward.isEmpty()) {
	    		while(!stack_last_forward.isEmpty()) {
	    			stack_last_back.push(stack_last_forward.pop());
	    		}
	    		result = stack_last_back.peek();
	    	}
			return result;
	        
	    }
	    
	    /** Get the last item from the deque. */
	    public int getRear() {
	    	int result = -1;
	    	if(!stack_last_forward.isEmpty()) {
	    		result = stack_last_forward.peek();
	    	} else if(!stack_last_back.isEmpty()) {
	    		while(!stack_last_back.isEmpty()) {
	    			stack_last_forward.push(stack_last_back.pop());
	    		}
	    		result = stack_last_forward.peek();
	    	} else if(!stack_first_back.isEmpty()) {
	    		result = stack_first_back.peek();
	    	} else if(!stack_first_forward.isEmpty()) {
	    		while(!stack_first_forward.isEmpty()) {
	    			stack_first_back.push(stack_first_forward.pop());
	    		}
	    		result = stack_first_back.peek();
	    	}
			return result;
	        
	    }
	    
	    /** Checks whether the circular deque is empty or not. */
	    public boolean isEmpty() {
	    	if(count == 0) {
	    		return true;
	    	}
			return false;
	        
	    }
	    
	    /** Checks whether the circular deque is full or not. */
	    public boolean isFull() {
	    	if(count == length) {
	    		return true;
	    	}
			return false;
	        
	    }
}