import java.util.Scanner;

public class TruthTableGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yay you made it!!! Welcome to the Truth Table Generator.");
        System.out.println("Use 0 to represent 'false' and 1 to represent 'true' in the formula.");
        System.out.print("Enter the number of propositional variables (ex.- 2 for p and q): ");
        int numVariables = scanner.nextInt();
        int numRows = (int) Math.pow(2, numVariables);

        System.out.print("Enter the logical formula (ex.- p AND q). Please note that this program does not accept parenthesis." +
                "\nIf you plan to enter operations such as OR and NOT, put AND first, then OR and lastly NOT. This will ensure the accuracy of this program.: ");
        scanner.nextLine();
        String formula = scanner.nextLine();

        // Generate headers for variables and result
        StringBuilder header = new StringBuilder();
        for (int i = 1; i <= numVariables; i++) {
            header.append((char) ('p' + i - 1)).append(" | ");
        }
        header.append("Result");

        System.out.println(header);

        // Loop through all possible combinations of variable values
        for (int row = 0; row < numRows; row++) {
            StringBuilder rowData = new StringBuilder();

            // Calculate variable values based on the binary representation of row
            int[] values = new int[numVariables];
            for (int var = 0; var < numVariables; var++) {
                values[var] = (row >> var) & 1;
                rowData.append(values[var]).append(" | ");
            }

            // Evaluate the formula for the current variable values
            int result = evaluateFormula(formula, values);
            rowData.append(result).append(" | ");

            System.out.println(rowData);
        }
    }

    // Method to evaluate a logical formula given variable values
    private static int evaluateFormula(String formula, int[] values) {
        // Replace variable names with their corresponding values
        for (int var = 0; var < values.length; var++) {
            char variable = (char) ('p' + var);
            formula = formula.replace(variable, Character.forDigit(values[var], 10));
        }

        // Evaluate the resulting formula
        return evaluateExpression(formula);
    }

    // Method to recursively evaluate a logical expression
    private static int evaluateExpression(String expression) {
        if (expression.startsWith("NOT")) {
            String notOperand = expression.substring(4);
            return 1 - evaluateExpression(notOperand.trim());
        } else if (expression.contains("AND")) {
            String[] parts = expression.split(" AND ");
            int left = evaluateExpression(parts[0]);
            int right = evaluateExpression(parts[1]);
            return left * right;
        } else if (expression.contains("OR")) {
            String[] parts = expression.split(" OR ");
            int left = evaluateExpression(parts[0]);
            int right = evaluateExpression(parts[1]);
            return (left + right) > 0 ? 1 : 0;
        } else {
            return Integer.parseInt(expression.trim());
        }
    }
}
