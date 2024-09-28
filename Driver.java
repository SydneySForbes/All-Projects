import java.util.Scanner;

class Driver {
    public static void main(String[] args) {
        int fib;
        Scanner s = new Scanner(System.in);
        FibFormula ff = new FibFormula();
        FibIteration fi = new FibIteration();
        System.out.println("Enter the number you want to find the Fibonacci Series for: ");
        fib = s.nextInt();
        System.out.println("Fib of " + fib + " by iteration is: " +fi.calculate_fib(fib) );

        System.out.println("Fib of " + fib + " by formula is: " + ff.calculate_fib(fib));

    }
}

