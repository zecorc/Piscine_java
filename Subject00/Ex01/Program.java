import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        boolean isPrime = true;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        if (number <= 1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        for (i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                isPrime = false;
        }

        if (isPrime)
            System.out.println("true " + (i - 2));
        else
            System.out.println("false " + (i - 2));
        return;
    }
}
