package illegalalienal;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Constants {
    public static File types = new File("src/illegalalienal/CSVs/types.csv");
    public static FileReader typeReader;
    public static CSVParser typesParser;
    public static List<CSVRecord> typeRecords;

    public static void init() throws Exception
    {
        typeReader = new FileReader(types);
        typesParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(typeReader);
        typeRecords = typesParser.getRecords();
    }



}
