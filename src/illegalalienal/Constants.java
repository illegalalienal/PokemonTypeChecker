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
    public static File type_efficacy = new File("src/illegalalienal/CSVs/type_efficacy.csv");
    public static FileReader typeReader;
    public static FileReader typeEfficacyReader;
    public static CSVParser typeParser;
    public static CSVParser typeEfficacyParser;
    public static List<CSVRecord> typeRecords;
    public static List<CSVRecord> typeEfficacyRecords;

    public static void init() throws Exception
    {
        typeReader = new FileReader(types);
        typeEfficacyReader = new FileReader(type_efficacy);
        typeParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(typeReader);
        typeEfficacyParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(typeEfficacyReader);
        typeRecords = typeParser.getRecords();
        typeEfficacyRecords = typeEfficacyParser.getRecords();
    }



}
