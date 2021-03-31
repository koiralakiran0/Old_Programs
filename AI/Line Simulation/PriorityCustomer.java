import java.util.Random;		

public class PriorityCustomer {
	
	private int serviceTime; 				// ServiceTime for this Customer
   private int priority;               // Priority for this Customer
	
	/// Constructor
	public PriorityCustomer() {										
		serviceTime = new Random().nextInt(5) + 1;	// Randomly assign required service time 1-5
      priority = new Random().nextInt(5) + 1;   // Randomly assign priority 1-5
	}
   
   public int getPriority(){
      return priority;
   }
  	
	/// Getter for ServiceTime
	public int getServiceTime() {							
		return serviceTime;
	}
	
	/// Decrement ServiceTime by 1
	public void decServiceTime() {		
		serviceTime--;
	}
}