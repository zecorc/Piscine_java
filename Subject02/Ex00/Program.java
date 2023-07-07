import java.io.*;
import java.util.*;

public class Program {
    private static Map<String, String> signatures = new HashMap<>();

    public static void main(String[] args) {
        loadSignatures();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter the full path to a file (or 'exit' to quit): ");
                String filePath = scanner.nextLine();

                if (filePath.equals("exit")) {
                    break;
                }

                processFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void loadSignatures() {
        try (BufferedReader reader = new BufferedReader(new FileReader("signatures.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String fileType = parts[0];
                    String signature = parts[1];
                    signatures.put(signature, fileType);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load signatures: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void processFile(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] buffer = new byte[8];
            int bytesRead = fileInputStream.read(buffer);

            if (bytesRead >= 0) {
                String fileSignature = toHexString(buffer, bytesRead);
                System.out.println(fileSignature);
                String fileType = findMatchingFileType(fileSignature);
                writeResultToFile(fileType);
                System.out.println("PROCESSED");
            } else {
                System.out.println("Failed to read file: " + filePath);
            }
        }
    }

    private static String toHexString(byte[] bytes, int length) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            hexString.append(String.format("%02X ", bytes[i]));
        }
        return hexString.toString().trim();
    }

    private static String findMatchingFileType(String signature) {
        return signatures.getOrDefault(signature, "UNDEFINED");
    }

    private static void writeResultToFile(String fileType) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true))) {
            writer.write(fileType);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write result to file: " + e.getMessage());
        }
    }
}
