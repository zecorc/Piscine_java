public class Program {
    public static void main(String[] args) {
        int n = 479598;
        int i = 0;
        while (n != 0) {
            i = i + n % 10;
            n = n - n % 10;
            n = n / 10;
        }
        System.out.println(i);
    }
}