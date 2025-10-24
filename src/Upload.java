//upload.java

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Upload {

    public void uploadSpecs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose where to send the data:");
        System.out.println("1. Send to a URL");
        System.out.println("2. Save to a JSON file");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Nouvelle récupération directe des infos
        String osName = Specs.getOperatingSystemName();
        String osVersion = Specs.getOperatingSystemVersion();
        String cpuName = Specs.getCpuName();
        String cpuCores = String.valueOf(Specs.getCpuCores());
        String cpuThreads = String.valueOf(Specs.getCpuThreads());
        String gpuName = Specs.getGpuName();
        String gpuVram = Specs.getGpuVram();
        String ramTotal = Specs.getRamInfo();

        // Création du JSON
        String jsonData = String.format(
                "{\"os\": \"%s\", \"version\": \"%s\", \"cpu\": \"%s\", \"cores\": \"%s\", \"threads\": \"%s\", \"gpu\": \"%s\", \"vram\": \"%s\", \"ram\": \"%s\"}",
                osName, osVersion, cpuName, cpuCores, cpuThreads, gpuName, gpuVram, ramTotal
        );

        if (choice == 1) {
            System.out.print("Enter the site URL to send data (e.g., http://localhost/receiver.php): ");
            String siteUrl = scanner.nextLine();

            if (siteUrl.isEmpty()) {
                System.out.println("Site URL is required!");
                return;
            }

            System.out.println("Sending data: " + jsonData);
            if (sendDataToSite(siteUrl, jsonData)) {
                System.out.println("Data sent successfully!");
            } else {
                System.out.println("Failed to send data. Please check the site URL.");
            }
        } else if (choice == 2) {
            System.out.print("Enter the file path to save the data (e.g., /path/to/Specs.json): ");
            String filePath = scanner.nextLine();

            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(jsonData);
                System.out.println("Data saved successfully to JSON file!");
            } catch (IOException e) {
                System.out.println("Failed to save data to the file. Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private boolean sendDataToSite(String siteUrl, String data) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(siteUrl);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = connection.getOutputStream()) {
                os.write(data.getBytes());
                os.flush();
            }

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}