package Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RunApplet {
    public static void runApplet() {
        // Path to the batch file
        String batchFilePath = "D:\\Pritika\\AppletLess CBSV2\\AppletLess12072024_DC & CASHIER CHANGES\\ClientApplicationLaunch.bat";

        ProcessBuilder processBuilder = new ProcessBuilder(batchFilePath);

        try {
            // Start the process
            Process process = processBuilder.start();

            // Capture and print the output of the process (console output)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Output the result to console
            }

            // Capture and print any errors (error stream)
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);  // Print errors to standard error
            }

            // Wait for the batch process to finish and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Batch file execution completed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
