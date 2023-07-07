import java.util.Random;

public class Program {
    public static void main(String[] args) {
        int arraySize;
        int nThreads;
        int sum = 0;
        Random random = new Random();

        for (String arg : args) {
            if (arg.startsWith("--arraySize=")) {
                try {
                    arraySize = Integer.parseInt(arg.substring(8));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid arraySize value. Using default count of 50.");
                }      
            }
            else if (arg.startsWith("--threadsCount=")){
                try {
                    nThreads = Integer.parseInt(arg.substring(8));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid ThreadsCount value. Using default count of 50.");
                }  
            }
        }

        int[] intArray = new int[arraySize];

        for(int i = 0; i < arraySize; i++){
            intArray[i] = random.nextInt(10);
            sum = sum + intArray[i];
        }

        System.out.println("Sum: " + sum);

        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(() -> {
                
                System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            });

            thread.start();
        }
    }
}