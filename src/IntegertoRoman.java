import java.util.*;

public class IntegertoRoman {
    public static void main(String[] args) {
        System.out.printf(intToRoman(3749));
    }

//    public static String intToRoman(int num) {
//        String M[] = {"", "M", "MM", "MMM"};
//        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
//    }

//    public static String intToRoman(int num) {
//        Map<Integer, String> symbols = new HashMap<>();
//        symbols.put(1000, "M");
//        symbols.put(500, "D");
//        symbols.put(100, "C");
//        symbols.put(50, "L");
//        symbols.put(10, "X");
//        symbols.put(5, "V");
//        symbols.put(1, "I");
//
//        String result = "";
//        int temp = 1;
//
//        while (num > 0) {
//            int digit = num % 10;
//            num /= 10;
//
//            String part = "";
//            if (digit == 9) {
//                part = symbols.get(temp) + symbols.get(temp * 10);
//            } else if (digit >= 5) {
//                part = symbols.get(temp * 5);
//                for (int j = 0; j < digit - 5; j++) {
//                    part += symbols.get(temp);
//                }
//            } else if (digit == 4) {
//                part = symbols.get(temp) + symbols.get(temp * 5);
//            } else {
//                for (int j = 0; j < digit; j++) {
//                    part += symbols.get(temp);
//                }
//            }
//
//            result = part + result;
//            temp *= 10;
//        }
//
//        return result;
//    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

}
