import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Output:");
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static String calc(String input) throws Exception {
        input = input.trim();

        // Проверим, содержит ли выражение ровно два операнда и один оператор
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new Exception("throws Exception // Неверный формат. Должно быть два операнда и один оператор");
        }

        int a, b;
        String operator = tokens[1];

        try {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new Exception("throws Exception // Операнды должны быть целыми числами");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("throws Exception // Числа должны быть от 1 до 10 включительно");
        }

        int result;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b; // целочисленное деление
                break;
            default:
                throw new Exception("throws Exception // Недопустимая операция");
        }

        return String.valueOf(result);
    }
}
