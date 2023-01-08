import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d = calc(sc.nextLine());
        System.out.println(d);
    }

    public static String calc(String input) {
        String[] array = input.split(" ");
        int firstNum;
        int secondNum;

        if (input.contains("I") || input.contains("V") || input.contains("X")) {
            firstNum = Converter.romanToArabic(array[0]);
            secondNum = Converter.romanToArabic(array[2]);
        } else {
            firstNum = Integer.parseInt(array[0]);
            secondNum = Integer.parseInt(array[2]);
        }

        if ((firstNum < 1 || firstNum > 10) || (secondNum < 1 || secondNum > 10)) {
            throw new IllegalArgumentException("Неверная операция.");
        }
        int result = switch (array[1]) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            case "/" -> firstNum / secondNum;
            default -> throw new IllegalArgumentException(array[1] + " неверный знак.");
        };

        if (input.contains("I") || input.contains("V") || input.contains("X")) {
            return Converter.arabicToRoman(result);
        }
        return Integer.toString(result);
    }
}












