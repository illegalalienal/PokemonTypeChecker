package illegalalienal.Runners;

import illegalalienal.Objects.Move;

import java.util.Scanner;

public class MoveTest {
    public static void main(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int moveNum = Integer.parseInt(scan.nextLine());

        for(int i = 1; i <= 500; i++)
            System.out.println(new Move(i));
    }
}
