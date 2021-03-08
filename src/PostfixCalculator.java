import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class PostfixCalculator {

    private final DoubleStack doubleStack;
    private HashMap<String, Operator> operatorMap;

    public PostfixCalculator() {
        operatorMap = new HashMap<>();
        this.operatorMap.put("add", new Addition());
        this.operatorMap.put("+", new Addition());
        this.operatorMap.put("sub", new Addition());
        this.operatorMap.put("-", new Addition());
        this.operatorMap.put("mult", new Addition());
        this.operatorMap.put("*", new Addition());
        this.operatorMap.put("div", new Addition());
        this.operatorMap.put("/", new Addition());
        this.operatorMap.put("print", new Addition());
        this.operatorMap.put("=", new Addition());
        doubleStack = new DoubleStack();

    }

    public void storeOperand(double operand) {
        doubleStack.push(operand);
    }

    public void evalOperator(String operator) {
        List<Double> operands = new LinkedList<>();
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Multiplication multiplication = new Multiplication();
        Division division = new Division();
        Print print = new Print();
        operatorMap.get(operator);

        while (!doubleStack.isEmpty()) {
            double val = doubleStack.pop();
            operands.add(val);
        }
        if (operator.equals("+") || operator.equals("add")) {
            double sum = addition.eval(operands);
            doubleStack.push(sum);
            System.out.println(sum);
        }

        if (operator.equals("-") || operator.equals("sub")) {
            double difference = subtraction.eval(operands);
            doubleStack.push(difference);
            System.out.println(difference);
        }

        if (operator.equals("*") || operator.equals("mult")) {
            double product = multiplication.eval(operands);
            doubleStack.push(product);
            System.out.println(product);
        }

        if (operator.equals("/") || operator.equals("div")) {
            double quotient = division.eval(operands);
            doubleStack.push(quotient);
            System.out.println(quotient);
        }

        if (operator.equals("=") || operator.equals("print")) {
            double result = print.eval(operands);
            doubleStack.push(result);
            System.out.println(result);
        }

    }

    static class Addition implements Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            return args.get(0) + args.get(1);
        }
    }

    static class Subtraction implements Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            return args.get(0) - args.get(1);
        }
    }

    static class Multiplication implements Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            return args.get(0) * args.get(1);
        }
    }

    static class Division implements Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            return args.get(0) / args.get(1);
        }
    }

    static class Print implements Operator {

        @Override
        public int numArgs() {
            return 1;
        }

        @Override
        public double eval(List<Double> args) {
            return  args.get(0);
        }
    }

}
