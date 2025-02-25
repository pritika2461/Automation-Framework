package CBSV2Automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TestRunnerClass {

    public static void main(String[] args) throws Exception {
        try {
               AutomationDashboard.PropertiesFile();
            // LoginScreen.RunAutomationScript();
        } catch (Exception e) {
        }
    }

    public static String getBatchFilePath(String batchFileName) throws IOException {
        String projectDir = System.getProperty("user.dir");
        projectDir = URLDecoder.decode(projectDir, "UTF-8");

        File batchFile = new File(projectDir, "target/" + batchFileName);
        if (!batchFile.exists()) {
            throw new IOException("Batch file not found at: " + batchFile.getAbsolutePath());
        }
        return batchFile.getCanonicalPath();
    }

    public static void runBatchFileInBackground(String batchFilePath) {
        new Thread(() -> {
            try {
                String quotedPath = "\"" + batchFilePath + "\"";
                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", quotedPath);
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();
                process.waitFor();

            } catch (IOException | InterruptedException e) {
                System.err.println("Error running batch file: " + e.getMessage());
            }
        }).start();
    }

    public static void GeneratePDFResult() throws IOException {
        String jarPath = new File(Base.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();
        jarPath = URLDecoder.decode(jarPath, "UTF-8");

        // Create a new document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        float pageWidth = page.getMediaBox().getWidth() - 50;
        float startY = page.getMediaBox().getHeight() - 50;
        float lineHeight = 15;
        float currentY = startY;
        float margin = 50;

        BufferedReader reader = new BufferedReader(new FileReader(RunAutomation.consoleReportFile));
        String line;

        while ((line = reader.readLine()) != null) {
            // Split line into chunks that fit the page width
            for (String chunk : splitLineToFitWidth(line, pageWidth)) {
                if (currentY < 50) {
                    contentStream.close();
                    page = new PDPage(PDRectangle.A4);
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                    currentY = startY;
                }
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, currentY);
                contentStream.showText(chunk);
                contentStream.endText();
                currentY -= lineHeight;
            }
        }
        reader.close();
        contentStream.close();
        document.save(RunAutomation.pdfReportFile);
        document.close();
        System.out.println("PDF created successfully at: " + new File(RunAutomation.pdfReportFile));
    }

    private static String[] splitLineToFitWidth(String line, float maxWidth) {
        float charWidth = 6f;
        int maxChars = (int) (maxWidth / charWidth);
        return line.replaceAll("\\t", "    ").split("(?<=\\G.{" + maxChars + "})");
    }

}