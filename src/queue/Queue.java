package queue;

public class Queue <T>{
  private final int MAX_QUEUE = 6000;
  private  T items[];
  private int front, back , count;
  
  public Queue(){
	  items = (T[])new Object[MAX_QUEUE];
	  front =count =0;
	  back = MAX_QUEUE -1;
	  
  }
  public boolean isEmpty(){
	  return count ==0;
	  
	  
  }
  public boolean isFull(){
	  return count == MAX_QUEUE;
  }
  public void enqueue(T newItem)throws QueueException{
	  if (!isFull()){
		  back = (back+1)% (MAX_QUEUE);
		  items[back] = newItem;
		  ++count;
		  
	  }
	  else throw new QueueException("Queue full");
	  
	  
  }
  public T dequeue()throws QueueException{
	  if (!isEmpty()){
		  //queue is not empty , remove first element
		  T queueFront = items[front];
		  front = (front +1)% (MAX_QUEUE);
		  --count;
		  return queueFront;

	  }
	  else
		  throw new QueueException("Queue empty");
	  
	  
  }
  public void dequeueAll(){
 	  //garbage collector will remove current array
	  items = (T[]) new Object[MAX_QUEUE];
	  front = count =0;
	  back = MAX_QUEUE -1;
	  
  }
  public T peek() throws QueueException{
	  if (!isEmpty()){
		  return items[front];
	  }
	  else
		  throw new QueueException("Queue empty");
	  
  }
}

