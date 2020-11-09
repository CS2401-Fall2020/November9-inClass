
public class NumberNode extends ExpressionNode {
 
  private double val;
  
  NumberNode(double inVal){
    val = inVal;
  }
  
  NumberNode(String inVal){
    this(Double.parseDouble(inVal));
  }
  
  public String toString() {
    return String.valueOf(val);
  }
  
  public double value() {
    return val;
  }

}
