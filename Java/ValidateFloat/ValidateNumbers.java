package ValidateFloat;

public class ValidateNumbers {
    public static boolean validateFloat(String floatValue){
        for(int i = 0; i < floatValue.length(); i++){
            char c = floatValue.charAt(i);
            if (!Character.isDigit(c) && c != 'E' && c != '-' && c!= '.') {
                return false;
            } else if (c == 'E'){
                if (i != floatValue.lastIndexOf('E')){
                    return false;
                }
            } else if (c == '.'){
                if (i != floatValue.lastIndexOf('.')){
                    return false;
                }
            } else if (c == '-'){
                if (i != 0){
                    if (floatValue.charAt(i-1) != 'E'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}