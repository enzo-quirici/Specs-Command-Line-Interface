// Main.java

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Check if "upload" is passed as a command-line argument
        if (args.length > 0 && args[0].equalsIgnoreCase("upload")) {
            // Trigger the upload functionality
            Upload uploadHandler = new Upload();
            uploadHandler.uploadSpecs();
        } else {
            // Launch the graphical user interface if no argument or other argument is passed
            SwingUtilities.invokeLater(() -> CLI.main(args));
        }
    }
}
