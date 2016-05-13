package m;

/**
 * Created by zxiang on 5/7/2016.
 */
public class MathExpression {
    MathExpression left;
    MathExpression right;
    char mathOperation;
    int value;

    public MathExpression(MathExpression left,
                          MathExpression right,
                          char mathOperation,
                          int value
    ) {
        this.left = left;
        this.right = right;
        this.mathOperation = mathOperation;
        this.value = value;
    }

    @Override
    public String toString() {
        return toString(this);
    }

    private String toString(MathExpression exp) {
        if (exp.mathOperation == 'n') return Integer.toString(exp.value);

        String leftStr = exp.left.toString();
        String rightStr = exp.right.toString();
        if (exp.right.mathOperation == '+' || exp.right.mathOperation == '-')
            rightStr = "(" + rightStr + ")";

        if (exp.mathOperation == '*' || exp.mathOperation == '/') {
            if (exp.left.mathOperation == '+' || exp.left.mathOperation == '-')
                leftStr = "(" + leftStr + ")";
        }

        switch (exp.mathOperation) {
            case '+':
                return leftStr + "+" + rightStr;
            case '-':
                return leftStr + "-" + rightStr;
            case '*': {
                return leftStr + "*" + rightStr;
            }
            case '/': {
                return leftStr + "/" + rightStr;
            }
            default:
                return Integer.toString(exp.value);
        }
    }

    public double eval() {
        return eval(this);
    }

    private double eval(MathExpression exp) {
        switch (exp.mathOperation) {
            case '+':
                return eval(exp.left) + eval(exp.right);
            case '-':
                return eval(exp.left) - eval(exp.right);
            case '*':
                return eval(exp.left) * eval(exp.right);
            case '/':
                return eval(exp.left) / eval(exp.right);
            default:
                return exp.value;
        }
    }
}
