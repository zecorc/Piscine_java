public class Program {
    private static volatile boolean eggTurn = true;

    public static void main(String[] args) {
        int count = 50;

        for (String arg : args) {
            if (arg.startsWith("--count=")) {
                try {
                    count = Integer.parseInt(arg.substring(8));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid count value. Using default count of 50.");
                }
            }
        }

        final int finalCount = count;

        Thread eggThread = new Thread(() -> {
            for (int i = 0; i < finalCount; i++) {
                if (eggTurn) {
                    System.out.println("Egg");
                    eggTurn = false;
                } else {
                    i--;
                }
            }
        });

        Thread henThread = new Thread(() -> {
            for (int i = 0; i < finalCount; i++) {
                if (!eggTurn) {
                    System.out.println("Hen");
                    eggTurn = true;
                } else {
                    i--;
                }
            }
        });

        eggThread.start();
        henThread.start();

        try {
            eggThread.join();
            henThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
