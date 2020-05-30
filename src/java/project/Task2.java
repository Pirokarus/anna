package project;

public class Task2 {

    public static void main(String[] args) {
        String checkString = "[][][[[][]]]";

        char [] charArray = checkString.toCharArray();

        int check = 0;

        for (int i = 0; i < charArray.length; ++i){

            char c = charArray[i];

            if(c == '['){
                check++;
            }

            if(c == ']'){
                check--;
            }

            if (c != '[' && c != ']'){
                throw new AssertionError("Не верный символ: " + c);
            }

            if(check < 0){
                throw new AssertionError("Закрывающая скобка без открывающей");
            }
        }

        if (check != 0){
            throw new AssertionError("Не все скобки закрыты");
        }

    }

}
