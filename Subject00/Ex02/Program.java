import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int primeCount = 0;
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            number = scanner.nextInt();
            if(number == 42){
                break;
            }
            number = digitSum(number);
            if (isPrime(number)){
                primeCount++;
            }
        }

        scanner.close();
    
        System.out.println("Count of coffee - request - " + primeCount);

        return;
    }

    public static int digitSum(int n) {
        int i = 0;
        while (n != 0) {
            i = i + n % 10;
            n = n - n % 10;
            n = n / 10;
        }
        return(i);
    }
    
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        int i = 0;

        if (n <= 1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        for (i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                isPrime = false;
        }

        if (isPrime)
            return (true);
        else
            return (false);
    }

}