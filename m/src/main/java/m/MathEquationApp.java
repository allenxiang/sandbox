package m;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zxiang on 5/7/2016.
 */
public class MathEquationApp {
    public static void main(String args[]) {
        List<Integer> inputIntList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        new MathEquationSearcher().findAndPrintSolutions(inputIntList);
    }
}
