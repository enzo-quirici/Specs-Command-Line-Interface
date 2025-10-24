package platform;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinuxRamInfo {
    public static String getRamInfo() {
        long totalPhysicalMemory = 0;

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", "cat /proc/meminfo | grep 'MemTotal'");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            long memTotal = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("MemTotal:")) {
                    memTotal = Long.parseLong(line.split("\\s+")[1]);
                }
            }

            totalPhysicalMemory = (long) (memTotal / 1024.0);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving RAM information for Linux.";
        }

        return String.valueOf(totalPhysicalMemory);
    }
}
