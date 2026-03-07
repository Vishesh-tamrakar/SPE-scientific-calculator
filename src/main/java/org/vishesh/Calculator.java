package org.vishesh;

import java.util.Scanner

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static double sqrt(double x) {
        return Math.sqrt(x);
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double ln(double x) {
        return Math.log(x);
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Scientific Calculator");

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square Root");
        System.out.println("6. Factorial");
        System.out.println("7. Natural Log (ln)");
        System.out.println("8. Power");

        System.out.print("Choose operation: ");

        int choice = scanner.nextInt();

        double a, b;

        switch (choice) {

            case 1:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + add(a, b));
                break;

            case 2:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + subtract(a, b));
                break;

            case 3:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + multiply(a, b));
                break;

            case 4:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + divide(a, b));
                break;

            case 5:
                System.out.print("Enter number: ");
                a = scanner.nextDouble();
                System.out.println("Result: " + sqrt(a));
                break;

            case 6:
                System.out.print("Enter integer: ");
                int n = scanner.nextInt();
                System.out.println("Result: " + factorial(n));
                break;

            case 7:
                System.out.print("Enter number: ");
                a = scanner.nextDouble();
                System.out.println("Result: " + ln(a));
                break;

            case 8:
                System.out.print("Enter base and exponent: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + power(a, b));
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
