/*
Name : Mohammad Anan Abo Jazar
Id Number : 1192956
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

    // flag --> 0 = terminal , 1 = non-terminal , 2 = production_rule .
    public static void read(String path, int flag){

        File file = new File(path);

        try {

            Scanner input = new Scanner(file);
            int counter = 1 ;

            while (input.hasNextLine()) {

                String line = input.nextLine();

                if (flag == 0)
                    Parser.terminalHashMap.put(line, counter);
                else if (flag == 1)
                    Parser.nonTerminalHashMap.put(line, counter);
                else
                    Parser.productionRuleHashMap.put(counter, line);

                counter++;
            }

            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File path not found: " + path);

        }

    }

    public static void readLL1Table(String path){

        File file = new File(path);

        try {

            Scanner input = new Scanner(file);
            int counter = 0 ;

            while (input.hasNextLine()) {

                String line = input.nextLine();
                String[] lineSplit = line.split(",");

                for (int i = 0; i < lineSplit.length; i++)
                    Parser.ll1Table[counter][i] = Integer.parseInt(lineSplit[i]);

                counter++;

            }

            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File path not found: " + path);

        }

    }

}
