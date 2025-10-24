// platform/WindowsRamInfo.java

package platform;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class WindowsRamInfo {
    public static String getRamInfo() {
        OperatingSystemMXBean osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        long totalPhysicalMemory = (long) Math.ceil(osMXBean.getTotalMemorySize() / (1024.0 * 1024.0));

        return String.valueOf(totalPhysicalMemory);
    }
}
