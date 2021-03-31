import java.util.Random;

public class Line {

    public static void main(String[] args) {
        PriorityQueue line1 = new PriorityQueue();
        int numberServiced, maxLength, length;
        numberServiced = maxLength = length = 0;
        
        for (int i = 0; i < 60; i++){
            if (new Random().nextInt(4) == 0){
                line1.add(new PriorityCustomer());
                length++;
                System.out.println("New customer added");
            }
            
            if (maxLength < length){
                maxLength = length;
            }
            
            if (line1.peek() == null){
            }
            else if (line1.peek().getServiceTime() == 1){
                line1.remove();
                numberServiced++;
                length--;
                System.out.println("Customer Serviced and Removed");
            }
            else
                line1.peek().decServiceTime();
            System.out.println("-------------------------------------------------------" + i);  
        }
        
        System.out.println("Customers Serviced: " + numberServiced);
        System.out.println("Maximum Length: " + maxLength);
    }

}
