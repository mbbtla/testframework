package dataproviders;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelFileReader {
    private static final String FILE_NAME = "data/logindata.xlsx";


    ArrayList<UserPassword> userPasswordArrayList;

    public ExcelFileReader() {
        userPasswordArrayList = new ArrayList<>();
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                int colCount =0;
                String userName ="";
                String password="";
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    String temp="";
                    if (currentCell.getCellType() == CellType.STRING) {
                        temp = currentCell.getStringCellValue();
                        System.out.print(currentCell.getStringCellValue() + "--");
                    }
                    /*else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }*/
                    if(colCount == 0)
                        userName = temp;
                    else
                        password= temp;

                }
                UserPassword up = new UserPassword(userName,password);
                userPasswordArrayList.add(up);
                System.out.println("added one item");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public UserPassword getUserPassword(int index) {
        return userPasswordArrayList.get(index);
    }
}
