import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        int max_week = 18;
        int actualWeek = 1;
        int n = 0;
        int minN = 0;
        long saved = 0;

        while(actualWeek <= max_week) {
            String str = scannerStr.nextLine();
            if (str.equals("42")){
                break;
            }
            if (!str.equals("Week " + actualWeek)){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            for (int r = 0; r < 5; r++) {
                n = scanner.nextInt();
                if (r == 0){
                    minN = n;
                }
                else if (minN > n){
                    minN = n;
                }
            }
            saved = saveN(minN, saved);
            actualWeek++;
        }

        scanner.close();
        scannerStr.close();         

        printAllWeeks(saved);
    }


    public static void printAllWeeks(long saved) {
        int count = 1;
        long n = 0;

        while (saved != 0){
            System.out.print("Week " + (count) + " ");
            n = saved % 10;
            saved = saved / 10;
            for (int i = 0; i < n; i++){    
                System.out.print("=");
            }
            System.out.println(">");
            count ++;
        }

    }

    public static long saveN(int n, long saved) {
        int c = 1;
        long s2;

        s2 = saved;
        if (s2 != 0){
            while(s2 != 0){
                s2 = s2 / 10;
                c = c * 10;
            }
        }
        else {
            saved = n;
            return (saved);
        }
            n = n * c;
            saved = saved + n;
        return (saved);
    }
}