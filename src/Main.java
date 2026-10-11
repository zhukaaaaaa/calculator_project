import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Тесты ---");
        System.out.println("9 + 3 = " + calculate(9, 3, "+"));
        System.out.println("9 / 3 = " + calculate(9, 3, "/"));
        System.out.println("9 - 3 = " + calculate(9, 3, "-"));
        System.out.println("9 * 3 = " + calculate(9, 3, "*"));
        System.out.println("--- Конец тестов ---\n");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                break;
            }

            try {
                String[] parts = input.split("\\s+");

                if (parts.length != 3) {
                    System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
                    continue;
                }
                int a = Integer.parseInt(parts[0]);
                String operator = parts[1];
                int b = Integer.parseInt(parts[2]);

                int result = calculate(a, b, operator);

                System.out.println(a + " " + operator + " " + b + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println("Ошибка: деление на ноль");

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: неизвестный оператор. Доступны: + - * /");
            }
        }
    }

    private static int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                if (b == 0) {
                    throw new ArithmeticException();
                }
                return a / b;

            default:
                throw new IllegalArgumentException();
        }
    }
}
