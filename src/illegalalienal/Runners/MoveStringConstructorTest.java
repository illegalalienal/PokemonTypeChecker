package illegalalienal.Runners;

import com.sun.tools.jconsole.JConsoleContext;
import illegalalienal.Constants;
import illegalalienal.Objects.Move;
import static illegalalienal.Constants.*;

import java.util.Scanner;

public class MoveStringConstructorTest {
    public static void main(String... args) throws Exception {
        Constants.init();

        for(int i = 0; i < moveRecords.size(); i++)
            System.out.println(new Move(moveRecords.get(i).get("identifier")));
    }
}
