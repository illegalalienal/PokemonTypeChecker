package illegalalienal.Runners;

import illegalalienal.Objects.Move;

import java.util.Scanner;

public class MoveTest {
    public static void main(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);

        for(int i = 1; i <= 728; i++)
            System.out.println(new Move(i));
    }
}
