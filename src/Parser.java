/*
Name : Mohammad Anan Abo Jazar
Id Number : 1192956
 */

import java.util.*;

public class Parser {

    //2D array for storing the ll1 table , number 0 is mean there is no production rule with terminal and non-terminal
    // if not 0 mean number of production rule
    public static int[][] ll1Table = new int[31][38];
    //Hash map to store all non-terminal , the key is non-terminal value
    // and the value is a counter from 1 that represent the non-terminal in ll1 table
    public static HashMap<String,Integer> nonTerminalHashMap = new HashMap<>();
    //Hash map to store all terminal , the key is terminal value
    // and the value is a counter from 1 that represent the terminal in ll1 table
    public static HashMap<String, Integer> terminalHashMap = new HashMap<>();
    //Hash map to store all production rule , the key is number of production in ll1 parse table and the value is the rule
    public static HashMap<Integer, String> productionRuleHashMap = new HashMap<>();
    //Set of string to store reserved words , to prevent user to create variable name with a reserve word
    public static Set<String> reservedWords = new HashSet<>();
    //Stack for storing tokens during the parse operation
    public static Stack<String> parserStack = new Stack<>();


    // parse function that to implement the ll1 parser algorithm to decide if input is valid or not
    //if input not valid to parse there is exception show where is the error in token
    public static void parse(String input) {

        // push to stack symbol that should the input end with
        parserStack.push(".");
        //push to stack the first non-terminal in the table
        parserStack.push("project-declaration");
        int inputIndex = 0;
        String[] inputArray = input.split(" ");

        while (!parserStack.isEmpty()) {

            String top = parserStack.peek();

            //Remove the symbol from the parse stack if the top symbol matches the current symbol in the input string
            if (top.equals(inputArray[inputIndex])) {

                parserStack.pop();
                inputIndex++;

            } else {

                int nonTerminalIndex ;

                // Find the non-terminal in non-terminal hashmap , if it's not found store -1 and throw to an exception
                if(nonTerminalHashMap.get(top) == null)
                    nonTerminalIndex = -1;
                else
                    nonTerminalIndex = nonTerminalHashMap.get(top);


                if (nonTerminalIndex == -1)
                    throw new ParsingException("Unexpected symbol " + top + " at input index " + inputIndex);

                // Get the current token from the input string
                String terminal = inputArray[inputIndex];

                int terminalIndex ;
                if (terminalHashMap.get(terminal) == null)
                    throw new ParsingException("No terminal found for " + terminal );
                else
                    terminalIndex = terminalHashMap.get(terminal);


                String production = null ;

                // If the current token in user define is a reserved word, throw an exception
                if (reservedWords.contains(terminal))
                    throw new ParsingException("Reserved word " + terminal + " cannot be used as a user-defined symbol");


                // Get the production rule for the top token and current rule from the ll1 parse table
                if (ll1Table[nonTerminalIndex-1][terminalIndex - 1] != 0){

                    int indexProductionRule = ll1Table[nonTerminalIndex-1][terminalIndex-1];
                    production = productionRuleHashMap.get(indexProductionRule);
                    System.out.println(production);

                }


                if (production == null){

                    throw new ParsingException("No production found for " + top + " and " + terminal);

                }else{

                    parserStack.pop();
                    String[] symbols = production.split(" ");

                    for (int i = symbols.length - 1; i >= 0; i--)
                        parserStack.push(symbols[i]);

                }
            }
        }
    }

    public static void printLL1Table(){

        for (int[] ints : ll1Table) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    // flag --> 0 = terminal , 1 = non-terminal , 2 = production_rule .
    public static void printData(int flag){

        if (flag == 0){

            for (HashMap.Entry<String, Integer> entry : terminalHashMap.entrySet())
                System.out.println(entry.getKey() + ": " + entry.getValue());

        }else if (flag == 1){

            for (HashMap.Entry<String, Integer> entry : nonTerminalHashMap.entrySet())
                System.out.println(entry.getKey() + ": " + entry.getValue());

        }else{

            for (HashMap.Entry<Integer, String> entry : productionRuleHashMap.entrySet())
                System.out.println(entry.getKey() + ": " + entry.getValue());


        }

    }

    public static void storeReservedWord(){

        reservedWords.add("project");
        reservedWords.add("const");
        reservedWords.add("var");
        reservedWords.add("int");
        reservedWords.add("subroutine");
        reservedWords.add("begin");
        reservedWords.add("end");
        reservedWords.add("scan");
        reservedWords.add("print");
        reservedWords.add("if");
        reservedWords.add("then");
        reservedWords.add("endif");
        reservedWords.add("else");
        reservedWords.add("while");
        reservedWords.add("do");

    }

}
