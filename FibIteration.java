


public class FibIteration implements FindFib{
    public int calculate_fib(int fib){

        int first = 0, second = 1, result = 0, i;

        if (fib == 1 || fib == 2){
            return second;
        }

        else {
            for (i=1; i< fib; i++){

                result = first + second;
                first = second;
                second = result;


            }
            return result;
        }

    }
    



}
