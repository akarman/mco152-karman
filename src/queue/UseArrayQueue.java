package queue;

public class UseArrayQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> myList;
		myList = new Queue();
		try{
		myList.enqueue("Bluma");
		myList.enqueue("Freda");
		myList.enqueue("Shaindy");
		myList.enqueue("Yael");
		myList.enqueue("Devora");
		myList.enqueue("MPlonczak");
		}
		catch(QueueException e){
		  try{
			  while (true){
				  System.out.println("Serving " + myList.peek());
				  myList.dequeue();
				  
				  
			  }
			  
			  
		  }	
		  catch(QueueException qe){
			  System.out.println("end queue application");
			  
		  }
			
		}
		// TODO Auto-generated method stub

	}

}
