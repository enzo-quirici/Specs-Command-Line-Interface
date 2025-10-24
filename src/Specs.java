//Specs.java

import java.io.IOException;
import java.util.Locale;
import platform.*;

public class Specs {

    public static String getOperatingSystemName() {
        String osName = System.getProperty("os.name");

        osName = osName.replace("-", " ");

        return osName;
    }

    public static String getOperatingSystemVersion() {
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");

        if (osName.toLowerCase().equals("linux")) {
            osVersion = LinuxOSInfo.getLinuxOSVersion();
        }

        osVersion = osVersion.replace("-", " ");

        return osVersion;
    }

    public static String getCpuName() {
        String cpuName = "";
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            cpuName = MacCpuInfo.getCpuName();
        } else if (osName.contains("linux")) {
            cpuName = LinuxCpuInfo.getCpuName();
        } else if (osName.contains("win")) {
            cpuName = WindowsCpuInfo.getCpuName();
        } else {
            cpuName = "Unknown CPU";
        }

        cpuName = cpuName.replaceAll("\\(.*?\\)", "").trim();

        return cpuName;
    }

    public static int getCpuCores() {
        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        try {
            if (osName.contains("win")) {
                return WindowsCpuInfo.getWindowsPhysicalCores();
            } else if (osName.contains("mac")) {
                return MacCpuInfo.getMacPhysicalCores();
            } else if (osName.contains("linux")) {
                return LinuxCpuInfo.getLinuxPhysicalCores();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Runtime.getRuntime().availableProcessors();
    }

    public static int getCpuThreads() {
        return Runtime.getRuntime().availableProcessors();
    }


    public static String getGpuName() {
        String gpuName = "";
        long gpuVram = 0;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            gpuName = MacGpuInfo.getGpuName();
        } else if (osName.contains("linux")) {
            gpuName = LinuxGpuInfo.getGpuName();
        } else if (osName.contains("win")) {
            gpuName = WindowsGpuInfo.getGpuName();
        } else {
            gpuName = "Unknown GPU";
        }

        if (!osName.contains("linux")) {
            gpuName = gpuName.replaceAll("\\(.*?\\)", "").trim();
        }

        return gpuName;
    }

    public static String getGpuVram() {
        String gpuName = "";
        long gpuVram = 0;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            gpuVram = MacGpuInfo.getGpuVram();
        } else if (osName.contains("linux")) {
            gpuVram = LinuxGpuInfo.getGpuVram();
        } else if (osName.contains("win")) {
            gpuVram = WindowsGpuInfo.getGpuVram();
        } else {
            gpuVram = Long.parseLong("Unknown Vram");
        }

        return String.valueOf(gpuVram);
    }

    public static String getRamInfo() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("linux")) {
            return LinuxRamInfo.getRamInfo();
        } else if (osName.contains("mac")) {
            return MacRamInfo.getRamInfo();
        } else if (osName.contains("win")) {
            return WindowsRamInfo.getRamInfo();
        } else {
            return "OS not supported for RAM info retrieval.";
        }
    }
}