# Implementation of Queue in JavaScript

```
class Queue
{
    // Array is used to implement a Queue
    constructor() 
    {
        this.items = [];
    }

    // Functions to be implemented
    // enqueue(item)
    // adding element to the queue
    enqueue(element){
        this.items.push(element);
    }
    // dequeue
    // Removes element from the queue 
    // returns underflow when called on empty queue
    dequeue() {
        // removing element fromt the queue
        // returns underflow when called on empty queue
        if(this.isEmpty()) {
            return "Underflow";
        }
        return this.items.shift();
    }
    // front()
    front()
    {
        // returns the Front element of
        // the queue without removing it.
        if(this.isEmpty()) {
            return "No elements in Queue";
        }
        return this.items[0];
    }

    // Helper functions
    isEmpty()
    {
        // return true if the queue is empty
        return this.items.length == 0;
    }

    printQueue() 
    {
        let str = "";
        for(let i=0; i < this.items.length; i++)
            str += this.items[i] + " ";
        return str;
    }
}

// creating object for queue class
let queue = new Queue();

// Testing dequeue and pop on an empty queue
// returns Underflow
console.log(queue.dequeue());

// return true 
console.log(queue.isEmpty());

// Adding elements to the queue
// queue contains [10, 20, 30, 40, 50]
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);
queue.enqueue(40);
queue.enqueue(50);
queue.enqueue(60);

// return 10 
console.log(queue.front());

// removes 10 from the queue
// queue contains [20, 30, 40, 50, 60]
console.log(queue.dequeue());

// return 20
console.log(queue.front());

// removes 20
// queue contains [30, 40, 50, 60]
console.log(queue.dequeue());

// printing the elements of the queue
// prints [30, 40, 50, 60]
console.log(queue.printQueue());

```

Queue has an array similar data structure that using elements to store values in linear way. There are multiple functions in this class, such as enqueue(), dequeue(), front(), isEmpty() and printQueue(). The enqueue function, front function and dequeue function time complexity are O(1), isEmpty and printQueue functions are O(n).

# Implementation of Priority Queue in JavaScript
```
// Prority Queue is the priority queue has an property associated with it. 
// Elements are added to the queue as per the prority
// Lowest priority elements are removed first. 

// User defined class
// to store element and its priority
class QElement {
    constructor(element, priority)
    {
        this.element = element;
        this.priority = priority;
    }
}

// PriorityQueue class
class PriorityQueue {

    // An array is used to implement priority
    constructor()
    {
        this.items = [];
    }

    // functions to be implemented
    // adds an element to the queue according to its priority
    enqueue(element, priority)
    {
        // create object from queue element
        let qElement = new QElement(element, priority); 
        let contain = false; 

        // iterating through the entire item array to add element at 
        // correct location of the Queue 
        for (var i = 0; i < this.items.length; i++) { 
            if (this.items[i].priority > qElement.priority) {
                // Once the correct location is found it is
                // enqueued 
                this.items.splice(i, 0, qElement); 
                console.log(this.items);
                contain = true;
                break;
            }    
        }
        // if the element have the highest priority
        // it is added at the end of the queue 
        if (!contain) { 
            this.items.push(qElement); 
        } 
    }
    
    // Removes an element from the highest priority
    dequeue() {
        // return the dequeued element and removed it.
        // if the queue is empty
        // return Underflow
        if(this.isEmpty())
            return "Underflow";
        return this.items.shift();
    }
    // returns the front eleement of the Priority element
    front() {
        // returns the highest priority element 
        // in the Priority queue without removing it.
        if(this.isEmpty())
            return "No elements in Queue."
        return this.items[0];
    }
    // returns the last element of the Priority queue 
    rear() {
        // returns the lowest priority element of the queue 
        if(this.isEmpty())
            return "No elements in Queue";
        return this.items[this.items.length - 1];
    }
    // Helper Method
    // Returns true if the Priority queue is empty
    isEmpty() {
        // return true if the queue is empty
        return this.items.length === 0;
    }
    // It prints the element of the queue as per the priority starting from highest to lowest
    printPQueue() {
        // console.log(this.items)
        let str = "";
        for(let i=0; i<this.items.length; i++)
            str += this.items[i].element + " ";
        return str
    }
}

// creating object for queue class
let priorityQueue = new PriorityQueue();

// testing is Empty and front on an empty queue 11
// return true
console.log(priorityQueue.isEmpty());

// return "No elements in Queue"
console.log(priorityQueue.front());

// adding elements to the queue 
priorityQueue.enqueue("Sumit", 2); 
priorityQueue.enqueue("Gourav", 1);
priorityQueue.enqueue("Piyush", 1);
priorityQueue.enqueue("Sunny", 2);
priorityQueue.enqueue("Sheru", 3);

// prints [Gourav, Piyush, Sumit, Sunny, Sheru]
console.log(priorityQueue.printPQueue());

// prints Gourav
console.log(priorityQueue.front().element);

// prints Sheru
console.log(priorityQueue.rear().element);

// removes Gourav
// priorityQueue contains 
// [Piyush Sumit Sunny Sheru]
console.log(priorityQueue.dequeue().element);

// Adding another element to the queue
priorityQueue.enqueue("Sunil", 2);

// prints [Piyush Sumit Sunny Sunil Sheru]
console.log(priorityQueue.printPQueue());


```

Priority Queue is an extension of Queue having some properties as follows: 

1. Prority Queue is the priority queue has an property associated with it. 
2. Elements are added to the queue as per the prority
3. Lowest priority elements are removed first. 

There are multiple functions in this class, such as enqueue(), dequeue(), front(), rear(), isEmpty(), printPQueue(). In the Priortiy Queue, each element is object-like data structure, that each element contains a element property and a priority property. The enqueue function, printPQueueand function and isEmpty function's time complexity is O(n). The dequeue function, rear function and front function's time complexity is O(1).