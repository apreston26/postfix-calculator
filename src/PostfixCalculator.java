import java.util.List;
import java.util.Map;

public class PostfixCalculator {

    private DoubleStack doubleStack;
    private Map<String, Operator> operatorMap;

    PostfixCalculator() {
//        operatorMap.put("Addition", Addition);
        doubleStack = new DoubleStack();

    }

    public void storeOperand(double operand) {
        doubleStack.push(operand);
    }

    public void evalOperator(String operator) {

    }

    static class Addition implements  Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            double product = 0;
            
            return product;
        }
    }

    static class Subtraction implements  Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            double product = 0;

            return product;
        }
    }

    static class Multiplication implements  Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            double product = 0;

            return product;
        }
    }

    static class Division implements  Operator {

        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            double product = 0;

            return product;
        }
    }

    static class Print implements  Operator {

        @Override
        public int numArgs() {
            return 1;
        }

        @Override
        public double eval(List<Double> args) {
            double product = 0;

            return product;
        }
    }

}
