
public abstract class ExpressionNode {

  abstract public double value();
  abstract public String toString();
  
  public boolean addNode(String path, boolean isNumber, String inValue) {
    return false;
  }

}
