package managers;

import dataproviders.ConfigFileReader;
import dataproviders.ExcelFileReader;

public class FileReaderManager {

    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private static ExcelFileReader excelFileReader;

    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public ExcelFileReader getExcelFileReader() {
        return (excelFileReader == null) ? new ExcelFileReader() : excelFileReader;
    }
}
