package com.prime.numbers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(final String[] args) {
        try {
            File file = null;

            if (args.length == 1) {
                file = new File(args[0]);
            } else {
                LOGGER.info("Choose XLSX file please...");
                file = chooseFile();
            }

            if (file == null) {
                LOGGER.info("NO FILE SELECTED.");
                file = getFileFromCL();
                if (file == null) {
                    throw new IllegalArgumentException("No FILE SELECTED or WRONG PATH.");
                }
            }

            final var xlsxReader = new XLSXReader(file);
            xlsxReader.readXLSX();
            System.out.println("Selected file: " + file.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred in Main.", e);
        }
    }

    public static File chooseFile() {
        final String resourcesPath = new File("./src/main/resources").getAbsolutePath();
        final JFileChooser fileChooser = new JFileChooser(resourcesPath);

        fileChooser.setDialogTitle("Select XLSX File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("XLSX files (*.xlsx)", "xlsx"));

        final int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public static File getFileFromCL() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE PATH OF THE XLSX FILE:");
        final String filePath = scanner.nextLine();
        return new File(filePath);
    }
}