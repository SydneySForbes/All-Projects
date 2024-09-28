public class FibFormula implements FindFib{

    public int calculate_fib(int fib){

        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5)/2;
        int nthTerm = (int) ((Math.pow(phi, fib) - Math.pow(-phi, -fib))/sqrt5);
        return nthTerm;
    }

}
