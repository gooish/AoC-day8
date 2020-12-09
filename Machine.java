/* 
*  Machine.java
*  program for doing part two of advent of code 2020 day 8
*  i sadly wrote over part 1 rip
*/
import java.util.Scanner;
import java.io.*;

public class Machine {

    public static void main(String[] args) {


        String[] instructions = loadFile("data.txt");

        for (int i = 0; i < instructions.length; i++) {
            String[] testInstructions = instructions.clone();
            int iNmb = Integer.parseInt(instructions[i].split(" ")[1]);
            String instruction = instructions[i].split(" ")[0].trim();

            /* 
            *  I thought array2 = array1 copies the array
            *  it just passes the pointer
            *  this was a bitch to debug
            */

            if (instruction.contains("jmp")) {
                testInstructions[i] = "nop" + " " + iNmb;
                tryMachine(testInstructions);
            }
            if (instruction.contains("nop")) {
                testInstructions[i] = "jmp" + " " + iNmb;
                tryMachine(testInstructions);
            }
        }


    }

    /*
    *  COMPOOOTER
    *  I kinda wish this comes back
    *  I like making machines like this
    */

    public static int tryMachine (String[] instructions)
    {
        int a = 0;
        int i = 0;
        int programcount = 0;
        while (programcount < 10000) {

            if (i == instructions.length) {
                System.out.println("Final accumulator value is " + a);
                break;
            }

            int iNmb = Integer.parseInt(instructions[i].split(" ")[1]);

            switch (instructions[i].split(" ")[0]) {
                case "acc":
                    a += iNmb;
                    i++;
                    break;
    
                case "jmp":
                    i += iNmb;
                    break;

                case "nop":
                    i++;
                    break;

            }

            programcount++;
        }
        return a;
    }
        
    public static String[] loadFile(String fName) {
        try {
            Scanner input = new Scanner(new File(fName));
            String[] rivit = new String[590];
            for (int i = 0; i < rivit.length; i++) {
                rivit[i] = input.nextLine();
            }
            return rivit;
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        return null;
    }
}