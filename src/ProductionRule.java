import java.util.HashMap;

public class ProductionRule {

    public static HashMap<String, Integer> nonTerminalHashmap = new HashMap<>();
    public static HashMap<String, Integer> terminalHashmap = new HashMap<>();
    public static HashMap<Integer, String> productionRule = new HashMap<>();

    public static void store(){
        storeNonTerminal();
        storeTerminal();
        storeProductionRule();
    }

    private static void storeProductionRule() {

        productionRule.put(1, "project-def .");
        productionRule.put(2,"project-heading declarations compound-stmt");
        productionRule.put(3, "project name ;");
        productionRule.put(4, "const-decl var-decl subroutine-decl");
        productionRule.put(5, "const-list");
        productionRule.put(6, "");
        productionRule.put(7, "“const-name” = “integer-value” ; const-list");
        productionRule.put(8, "");
        productionRule.put(9, "var var-list");
        productionRule.put(10, "");
        productionRule.put(11, "var-item ; var-list");
        productionRule.put(12 , "");
        productionRule.put(13, "name-list : int");
        productionRule.put(14, "var-name  more-names");
        productionRule.put(15, ", name-list");
        productionRule.put(16, "");
        productionRule.put(17, "subroutine-heading declarations compound-stmt ;");
        productionRule.put(18, "");
        productionRule.put(19, "subroutine name ;");
        productionRule.put(20, "begin stmt-list end");
        productionRule.put(21, "statement ; stmt-list");
        productionRule.put(22, "");
        productionRule.put(23, "ass-stmt");
        productionRule.put(24, "inout-stmt");
        productionRule.put(25, "if-stmt");
        productionRule.put(26, "while-stmt");
        productionRule.put(27, "compound-stmt");
        productionRule.put(28, "");
        productionRule.put(29, "name := arith-exp");
        productionRule.put(30, "term arith-exp-prime");
        productionRule.put(31, "add-sign term arith-exp-prime");
        productionRule.put(32, "");
        productionRule.put(33, "factor term-prime");
        productionRule.put(34, "mul-sign factor term-prime");
        productionRule.put(35, "");
        productionRule.put(36, "( arith-exp )");
        productionRule.put(37, "name-value");
        productionRule.put(38,  "name");
        productionRule.put(39, "integer-value");
        productionRule.put(40, "+");
        productionRule.put(41, "-");
        productionRule.put(42, "*");
        productionRule.put(43, "/");
        productionRule.put(44, "%");
        productionRule.put(45, "scan ( name )");
        productionRule.put(46, "print (name-value )");
        productionRule.put(47, "if bool-exp then statement else-part endif");
        productionRule.put(48, "else statement");
        productionRule.put(49, "");
        productionRule.put(50, "while bool-exp do statement");
        productionRule.put(51, "name-value relational-oper name-value");
        productionRule.put(52, "=");
        productionRule.put(53, "|=");
        productionRule.put(54, "<");
        productionRule.put(55, "=<");
        productionRule.put(56, ">");
        productionRule.put(57, "=>");

    }

    private static void storeTerminal() {
    }

    private static void storeNonTerminal() {
    }


}
