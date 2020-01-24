package illegalalienal;

import illegalalienal.Objects.Type;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static illegalalienal.Constants.typesParser;

public class Main {

    public static void main(String[] args) throws Exception {

        Constants.init();

        ArrayList<String> typeNames = new ArrayList<>();

        List<CSVRecord> typeRecords = typesParser.getRecords();

        Scanner scan = new Scanner(System.in);

        Type type = new Type(scan.nextLine());

        System.out.println(type);

    }
}
