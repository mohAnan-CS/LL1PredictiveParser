/*
Name : Mohammad Anan Abo Jazar
Id Number : 1192956
 */
public class Runner {

    public static void main(String[] args) {

        // flag --> 0 = terminal , 1 = non-terminal , 2 = production_rule .
        ReadData.readLL1Table("C:\\Users\\twitter\\IdeaProjects\\LL1PredictiveParser\\src\\file_data\\ll1-table.csv");
        ReadData.read("C:\\Users\\twitter\\IdeaProjects\\LL1PredictiveParser\\src\\file_data\\terminal.txt", 0);
        ReadData.read("C:\\Users\\twitter\\IdeaProjects\\LL1PredictiveParser\\src\\file_data\\non-terminal.txt", 1);
        ReadData.read("C:\\Users\\twitter\\IdeaProjects\\LL1PredictiveParser\\src\\file_data\\production.txt", 2);
        Parser.storeReservedWord();

        Parser.printLL1Table();
        System.out.println("----------");
        Parser.printLL1Table();
        System.out.println("---------");
        System.out.println("Terminal Data");
        Parser.printData(0);
        System.out.println("--------------");
        System.out.println("Non Terminal Data");
        Parser.printData(1);
        System.out.println("--------------");
        System.out.println("Production Rule Data");
        Parser.printData(2);
        System.out.println("--------------");
        System.out.println("Parser input based on ll1 table ...");
        System.out.println();
        Parser.parse("projec name ; var var-name : int subroutine name .");

    }

}
