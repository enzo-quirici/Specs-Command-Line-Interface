// platform/MacRamInfo.java

package platform;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class MacRamInfo {

    public static String getRamInfo() {
        long totalPhysicalMemory = 0;

        try {
            OperatingSystemMXBean osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            totalPhysicalMemory = (long) (osMXBean.getTotalMemorySize() / (1024.0 * 1020.0));

        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving RAM information for macOS.";
        }

        return String.valueOf(totalPhysicalMemory);
    }
}
