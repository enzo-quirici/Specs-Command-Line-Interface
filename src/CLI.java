// CLI.java

import java.util.Objects;

public class CLI {

    public static void main(String[] args) {

        Upload uploadHandler = new Upload();

        printSpecs();
    }

    private static void printSpecs() {
        System.out.println("=== Specs ===");
        System.out.println("Operating System :" + " " + Specs.getOperatingSystemName());
        System.out.println("Version :" + " " + Specs.getOperatingSystemVersion());
        System.out.println("CPU :" + " " + Specs.getCpuName());
        System.out.println("Cores :" + " " + Specs.getCpuCores());
        System.out.println("Threads :" + " " + Specs.getCpuThreads());
        System.out.println("GPU :" + " " + Specs.getGpuName());
        System.out.println("Vram :" + " " + Specs.getGpuVram() + " " + "MB");
        System.out.println("RAM :" + " " + Specs.getRamInfo() + " " + "MB");
    }
}
