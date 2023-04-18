import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        System.out.println("Введите пример");
        String exp = scn.nextLine();
        System.out.println(calc(exp));

    }

    public static String calc(String input) throws Exception {
        Converter converter = new Converter();
        String[] str;
        if (input.contains("+")) {
            str = input.split("\\+");
        } else if (input.contains("-")) {
            str = input.split("-");
        } else if (input.contains("*")) {
            str = input.split("\\*");
        } else {
            if (!input.contains("/")) {
                throw new Exception("т.к. строка не является математической операцией");
            }

            str = input.split("/");
        }
        if (str.length != 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (converter.isRoman(str[0]) == converter.isRoman(str[1])) {

            boolean isRoman = converter.isRoman(str[0]);
            int a;
            int b;
            if (isRoman) {
                a = converter.romanToInt(str[0]);
                b = converter.romanToInt(str[1]);
            } else {
                a = Integer.parseInt(str[0]);
                b = Integer.parseInt(str[1]);
            }
            if (a > 10) {
                throw new Exception("Одно из чисел не подходит по условию");
            } else if (b > 10) {
                throw new Exception("Одно из чисел не подходит по условию");
            } else if (a < 1) {
                throw new Exception("Одно из чисел не подходит по условию");
            } else if (b < 1) {
                throw new Exception("Одно из чисел не подходит по условию");
            } else {
                int c;
                if (input.contains("+")) {
                    c = a + b;
                } else if (input.contains("-")) {
                    c = a - b;
                } else if (input.contains("*")) {
                    c = a * b;
                } else {
                    c = a / b;
                }
                if (c <= 0 && isRoman) {
                    throw new Exception("в римской системе нет отрицательных чисел");
                } else {
                    String result;
                    if (isRoman) {
                        result = String.valueOf(converter.intToRoman(c));
                    } else {
                        result = String.valueOf(c);
                    }

                    return result;
                }
            }

        } else {
            throw new Exception("используются одновременно разные системы счисления");
        }
    }

}