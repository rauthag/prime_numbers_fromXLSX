# Prime Numbers From XLSX

This Java program extracts prime numbers from an Excel file (.xlsx) and displays them in the console and logs them via LOGGER to a logfile. It utilizes Apache POI for Excel file parsing and Log4j2 for logging.

## Features
- Parse Excel files (.xlsx) to extract numerical data
- Identify prime numbers within the valid extracted data
- Support for different numeric types, including integers and big integers
- Command-line interface for easy interaction

### Prerequisites
- Java Runtime Environment (JRE) installed
- Excel file containing numbers in .xlsx format (there are some samples)
- In the .xlsx file there must be a "Data" column for specifying the column with data that the program will read, otherwise all cells will be ignored (look at the examples)

### Running the Program
1. Download the zip file from the Releases section. - [Download PrimeNumbersFromXLSX.jar](#) ([Replace # with the actual link](https://github.com/rauthag/prime_numbers/releases/tag/v1.0.0))
2. Open a command-line terminal.
3. Navigate to the directory where the jar file is located.
4. Run the following command, replacing `/path/to/your/excel/file.xlsx` with the path to your Excel file (in the zip, there are some sample XLSX files):

    ```
    java -jar prime_numbers.jar /path/to/your/excel/file.xlsx
    ```

5. Or you can just run the JAR file from the command line (or double click); a Swing window will appear so you can choose your file from the simple Swing UI.

    ```
    java -jar prime_numbers.jar
    ```
<p align="center">
  <img src="https://i.postimg.cc/dtkwK0wP/Screenshot-1.jpg?raw=true" alt="Sublime's custom image"/>
</p>


### Quick Clone

```bash
git clone https://github.com/rauthag/prime_numbers_fromXLSX.git
   

## Releases
- [Download PrimeNumbersFromXLSX.jar](#) ([Replace # with the actual link](https://github.com/rauthag/prime_numbers/releases/tag/v1.0.0))
