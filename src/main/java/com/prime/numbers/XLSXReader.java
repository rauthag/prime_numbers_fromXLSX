package com.prime.numbers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.common.io.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {

    private static final Logger LOGGER = LogManager.getLogger(XLSXReader.class.getName());
    private static final String DATA_COLUMN_ID = "Data";
    private static final String XLSX_EXTENSION = "xlsx";

    private final File file;

    public XLSXReader(final File file) {
        if (!isXlsxFormat(file)) {
            throw new IllegalArgumentException("The file must be in the xlsx format.");
        }
        this.file = file;
    }

    public void readXLSX() {
        try {
            final FileInputStream fis = new FileInputStream(file);
            final Workbook workbook = new XSSFWorkbook(fis);
            final DataFormatter dataFormatter = new DataFormatter();
            final int dataColumnIndex = findDataColumnIndex(workbook, dataFormatter);

            for (final Sheet sheet : getAllSheets(workbook)) {
                for (final Row row : sheet) {
                    final Cell cell = row.getCell(dataColumnIndex);

                    switch (cell.getCellType()) {
                        case NUMERIC -> {
                            final double cellValue = cell.getNumericCellValue();
                            final PrimeNumbChecker<?> numberChecker = PrimeNumbCheckerFactory.check(cellValue);
                            if (numberChecker.isPrime()) {
                                LOGGER.info(numberChecker.getNumber());
                            }
                        }
                        case STRING -> {
                            final String cellValue = cell.getStringCellValue();
                            if (PrimeNumbCheckerFactory.isNumeric(cellValue)) {
                                final double value = Double.parseDouble(cellValue);
                                final PrimeNumbChecker<?> numberChecker = PrimeNumbCheckerFactory.check(value);
                                if (numberChecker.isPrime()) {
                                    LOGGER.info(numberChecker.getNumber());
                                }
                            }
                        }
                    }
                }
            }
            workbook.close();
            fis.close();
        } catch (final IOException e) {
            LOGGER.error( "Error reading XLSX file.", e);
        }
    }


    public static int findDataColumnIndex(final Workbook workbook, final DataFormatter dataFormatter) {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            final Sheet sheet = workbook.getSheetAt(i);

            for (final Row row : sheet) {
                for (final Cell cell : row) {
                    final String cellValue = dataFormatter.formatCellValue(cell);
                    if (cellValue.equals(DATA_COLUMN_ID)) {
                        return cell.getColumnIndex();
                    }
                }
            }
        }
        throw new IllegalArgumentException("Data column haven't been found!");
    }

    private static boolean isXlsxFormat(final File file) {
        return Files.getFileExtension(file.getName()).equals(XLSX_EXTENSION);


    }

    private static List<Sheet> getAllSheets(final Workbook workbook) {
        final List<Sheet> sheets = new ArrayList<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheets.add(workbook.getSheetAt(i));
        }
        return sheets;
    }

    public static boolean isNumeric(final String str) {
        return str.matches("-?\\d+(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}