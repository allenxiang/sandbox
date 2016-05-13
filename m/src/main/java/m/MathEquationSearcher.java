package m;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zxiang on 5/7/2016.
 */
public class MathEquationSearcher {
    public void findAndPrintSolutions(List<Integer> inputNumbers) {
        for (int i = 0; i < inputNumbers.size() - 1; i++) {
            List<MathExpression> lefExpList = findExpressions(inputNumbers, 0, i + 1);
            List<MathExpression> rightExpList = findExpressions(inputNumbers, i + 1, inputNumbers.size());
            lefExpList.forEach(leftExp -> {
                rightExpList.forEach(rightExp -> {
                    if (leftExp.eval() == rightExp.eval()) {
                        System.out.println(leftExp + "=" + rightExp);
                    }
                });
            });
        }

    }

    private List<MathExpression> findExpressions(List<Integer> inputNumbers, Integer start, Integer end) {
        List<MathExpression> mathExpList = new ArrayList<>();

        if (end - start == 1) {
            mathExpList.add(new MathExpression(null, null, 'n', inputNumbers.get(start)));
        } else {
            for (int i = start; i < end - 1; i++) {
                List<MathExpression> lefExpList = findExpressions(inputNumbers, start, i + 1);
                List<MathExpression> rightExpList = findExpressions(inputNumbers, i + 1, end);

                lefExpList.forEach(leftExp -> {
                    rightExpList.forEach(rightExp -> {
                        mathExpList.add(new MathExpression(leftExp, rightExp, '+', 0));
                        mathExpList.add(new MathExpression(leftExp, rightExp, '-', 0));
                        mathExpList.add(new MathExpression(leftExp, rightExp, '*', 0));
                        if (rightExp.eval() != 0) {
                            mathExpList.add(new MathExpression(leftExp, rightExp, '/', 0));
                        }
                    });
                });
            }
        }

        return mathExpList;
    }
}
