
public class OperationNode extends ExpressionNode{
  private ExpressionNode left; 
  private ExpressionNode right; 
  private char operation;
  
  OperationNode(char inOperation){
    operation = inOperation;
  }
  
  OperationNode(String inOperation){
    this(inOperation.charAt(0));
  }
  
  public String toString() {
    String rtn = "(";
    rtn += left.toString();
    rtn += operation;
    rtn += right.toString();
    return rtn + ")";
  }
  
  // given a path down the (sub)tree, add in the new node at this position
  // this is a recursive method
  public boolean addNode(String path, boolean isNumber, String inValue) {
    if(path.equals("L")) {
      // populate the left child
      if(isNumber) left = new NumberNode(inValue);
      else left = new OperationNode(inValue);
      return true;
    }else if(path.equals("R")) {
      // populate the right child
      if(isNumber) right = new NumberNode(inValue);
      else right = new OperationNode(inValue);
      return true;
    }
    else if(path.charAt(0) == 'L' && left != null) {
      return left.addNode(path.substring(1), isNumber, inValue);
    }else if(path.charAt(0) == 'R' && right != null) {
      return right.addNode(path.substring(1), isNumber, inValue);
    }
    return false;
  }
  
  public double value() {
    if(operation == '+') {
      return left.value() + right.value();
    }
    if(operation == '*') {
      return left.value() * right.value();
    }
    if(operation == '-') {
      return left.value() - right.value();
    }
    if(operation == '/') {
      return left.value() / right.value();
    }
    if(operation == '%') {
      return left.value() % right.value();
    }
    
    return Double.MIN_VALUE;
  }

}
