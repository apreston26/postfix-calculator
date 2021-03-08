import java.util.LinkedList;

public class DoubleStack  implements Stack<Double> {

  public LinkedList<Double> stackList = new LinkedList<>();

  @Override
  public boolean isEmpty() {
    if (stackList.isEmpty()) {
      return true;
    }
    return false;
  }

  @Override
  public void push(Double val) {
    stackList.add(val);
  }

  @Override
  public Double pop() {
    return stackList.removeLast();
  }

  @Override
  public Double peek() {
    return stackList.getLast();
  }
}
