package ValidateFloat;

public class ValidateNumbers {
    public static boolean validateFloat(String floatValue){
        for(int i = 0; i < floatValue.length(); i++){
            char c = floatValue.charAt(i);
            if (!Character.isDigit(c) && c != 'E' && c != '-' && c!= '.') {
                return false;
            } else if (true){

            } 
        }
        return true;
    }
}