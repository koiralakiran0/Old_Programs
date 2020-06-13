package ValidateFloat;

import java.util.Scanner;

public class floatCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        String floatValue = null;
        int i = 0;
        while(again){
            again = false;
            System.out.print("Enter a value to check if it is a float: ");
            floatValue = scanner.nextLine();
            System.out.println( ValidateNumbers.validateFloat(floatValue) );

            System.out.println("Would you like to go again? Enter 1 if you would like to go again");
            i = scanner.nextInt();
            scanner.nextLine();
            if (i == 1){
                again = true;
            }
        }

        scanner.close();
    }
}