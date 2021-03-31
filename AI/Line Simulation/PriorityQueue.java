public class PriorityQueue {
    private PriorityCustomer[] customers;
    private int size;
    
    public PriorityQueue(){
        customers = new PriorityCustomer[60];
        size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public PriorityCustomer peek(){
        return customers[1];
    }
    
    public void add(PriorityCustomer customer){
        int index = size + 1;
        customers[index] = customer;
        
        while (index > 3){
            int parent = index/2;
            //This switches the objects and makes parent have more priority than the child
            if (customers[parent].getPriority() < customer.getPriority()){
                customers[index] = customers[parent];
                customers[parent] = customer;
                
                index = parent;
            }
            else{
                break;
            }
        }
        size++;
    }
    
    public void remove(){
        PriorityCustomer root_customer = customers[1];
        
        PriorityCustomer last_customer = customers[size];
        customers[1] = last_customer;
        
        customers[size] = null;
        int index = 1;
        
        while((index * 2) < size){
            int leftIndex = index * 2;
            int rightIndex = leftIndex + 1;
            
            PriorityCustomer leftCustomer = customers[leftIndex];
            PriorityCustomer rightCustomer = null;
            if (rightIndex < size)
                rightCustomer = customers[rightIndex];
            
            PriorityCustomer max_priority_customer;
            int maxIndex;
            

            if (rightCustomer == null || leftCustomer.getPriority() >= rightCustomer.getPriority() ){
                max_priority_customer = leftCustomer;
                maxIndex = leftIndex;
            }
            else{
                max_priority_customer = rightCustomer;
                maxIndex = rightIndex;
            }
            
            if (last_customer.getPriority() < max_priority_customer.getPriority()){
                customers[index] = max_priority_customer;
                customers[maxIndex] = last_customer;
                index = maxIndex;
            }
            else
                break;
        }
        
        size--;
        //return root_customer;
    }
}
