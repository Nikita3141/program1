import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите два числа (арабских или римских) пример заполнения (7 + 7)");
            String input = scanner.nextLine();
            input=input.toUpperCase();
            System.out.println(process(input));

        }

    public static String process (String input)  throws Exception  {
        int number1 ;
        int number2 ;
        String op ;
        String result ;
        boolean isRoman;


        String[] strings = input.split("\\W");
        String[] operator = input.split("\\w");
        if (strings.length!=4) throw new Exception("Введите два числа");
        if (Roman.isRoman(strings[0])&& Roman.isRoman(strings[strings.length-1])){
            number1= Roman.convert(strings[0]);
            number2= Roman.convert(strings[strings.length-1]);
            op = operator[operator.length-1];
            isRoman=true;
        }
        else if (!Roman.isRoman(strings[0])&&!Roman.isRoman(strings[strings.length-1])){
            number1= Integer.parseInt(strings[0]);
            number2= Integer.parseInt(strings[strings.length-1]);
            op = operator[operator.length-1];
            isRoman=false;
        }
        else {

            throw  new Exception("Числа должны быть в одном формате");
        }
        if (number1>10||number2>10){

            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calc(number1,number2,op);
        if(isRoman){
            if(arabian<=0){
                throw new Exception("Римское число должно быть больше нуля");
            }
            result= Roman.convertToRoman(arabian);
        }
        else {
            result= String.valueOf(arabian);
        }

        return result;
    }
    static int calc (int a,int b, String op){
        char[] op1 = op.toCharArray() ;
        if(op1[1] == '+') return a + b;
        else if(op1[1] =='-') return a - b;
        else if(op1[1] =='*') return a * b;
        else return a / b;
    }
}



class Roman {
    static String[] romanNumber = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI",
            "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
            "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    public static boolean isRoman(String string) {
        for (int i = 0; i < romanNumber.length; i++) {
            if (string.equals(romanNumber[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convert(String roman) {
        for (int i = 0; i < romanNumber.length; i++) {
            if (roman.equals(romanNumber[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanNumber[arabian];

    }
}
