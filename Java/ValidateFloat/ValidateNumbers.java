package ValidateFloat;

public class ValidateNumbers {
    private String floatValue;
    private StringBuilder errors;

    public ValidateNumbers(){
        floatValue = "";
        errors = new StringBuilder();
    }

    public String getFloatValue (){
        return this.floatValue;
    }

    public StringBuilder getErrors(){
        return this.errors;
    }
    
    public boolean validateFloat(String floatValue){
        if (validCharacters(floatValue) && checkE(floatValue) && checkDot(floatValue) && checkNegativeSign(floatValue)) {
            return true;
        }
        return false;
    }

    //float value cannot have characters other than digits, E, - or .
    private boolean validCharacters(String floatValue){
        for (int i = 0; i < floatValue.length(); i++){
            char c = floatValue.charAt(i);
            if (!Character.isDigit(c) && c != 'E' && c != '-' & c!= '.') {
                return false;
            }
        }
        return true;
    }
    //the dot cannot come after E

    //float value cannot have more than one E
    private boolean checkE(String floatValue){
       if (floatValue.contains("E") && ( floatValue.indexOf('E') != floatValue.lastIndexOf('E') ) ){
            return false;
       }
       return true;
    }

    //float value cannot have more than one .
    private boolean checkDot(String floatValue){
        if (floatValue.contains(".") && ( floatValue.indexOf('.') != floatValue.lastIndexOf('.') ) ){
             return false;
        }
        return true;
     }

     //float can have two negatives but on specific places
     private boolean checkNegativeSign(String floatValue){
        if (floatValue.contains("-")){
            return false;
        }
        return true;
     }
}