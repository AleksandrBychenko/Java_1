package Calculator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;


public class Calculator {
    public static void main(String[] args) {
        System.out.println("Type of input(x sign y):");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int spaceCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        String[]  masstr = s.split(" ");



        if (masstr.length != 3 & spaceCount != 2){
            System.out.println("Incorrect input format!!!");
            exit(1);
        }

        int[] number;
        number = new int[2];

        try {
            number[0] = Integer.parseInt (masstr[0]);
            number[1] = Integer.parseInt (masstr[2]);

        }
        catch (NumberFormatException nonumbers){
            //System.out.println(nonumbers.getMessage());
            System.out.println("You writ no numbers or on the wrong place !!!");
            exit(1);
        }





        System.out.println(s);
        
        
        





    }


}
