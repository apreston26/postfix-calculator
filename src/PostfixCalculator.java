import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class PostfixCalculator {

    private final DoubleStack doubleStack;
    private HashMap<String, Operator> operatorMap;
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Print print = new Print();

    public PostfixCalculator() {
        operatorMap = new HashMap<>();
        this.operatorMap.put("add", new Addition());
        this.operatorMap.put("+", new Addition());
        this.operatorMap.put("sub", new Subtraction());
        this.operatorMap.put("-", new Subtraction());
        this.operatorMap.put("mult", new Multiplication());
        this.operatorMap.put("*", new Multiplication());
        this.operatorMap.put("div", new Division());
        this.operatorMap.put("/", new Division());
        this.operatorMap.put("print", new Print());
        this.operatorMap.put("=", new Print());
        doubleStack = new DoubleStack();

    }

    public void storeOperand(double operand) {
        doubleStack.push(operand);
    }

    public void evalOperator(String operator) {
        List<Double> operands = new LinkedList<>();
        operatorMap.get(operator);

        while (!doubleStack.isEmpty()) {
            double val = doubleStack.pop();
            operands.add(val);
        }

        switch (operator) {
            case "add":
            case "+":
                double sum = addition.eval(operands);
                doubleStack.push(sum);
                break;
            case "sub":
            case "-":
                double difference = subtraction.eval(operands);
                doubleStack.push(difference);
                break;
            case "mult":
            case "*":
                double product = multiplication.eval(operands);
                doubleStack.push(product);
                break;
            case "div":
            case "/":
                double quotient = division.eval(operands);
                doubleStack.push(quotient);
                break;
            case "print":
            case "=":
                double result = print.eval(operands);
                doubleStack.push(result);
        }

        System.out.println(doubleStack.peek());

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
            return args.get(0);
        }
    }

}
