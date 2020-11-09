
public class driver {
  public static void main(String[] args) {
    
    ExpressionNode tree1 = new NumberNode(4);
    System.out.println("Number should be 4: " + tree1.value());
    
    ExpressionNode tree2 = new OperationNode('+');
    System.out.println("Adding '1': " + tree2.addNode("L", true, "1"));
    System.out.println("Adding '2': " + tree2.addNode("R", true, "2"));
    System.out.println("Equation 1+2 should equal 3: " + tree2.value()); 
    
    ExpressionNode tree3 = new OperationNode('*');
    System.out.println("Adding '3': " + tree3.addNode("L", true, "3"));
    System.out.println("Adding '+': " + tree3.addNode("R", false, "+"));
    System.out.println("Adding '7': " + tree3.addNode("RL", true, "7"));
    System.out.println("Adding '4': " + tree3.addNode("RR", true, "4"));
    System.out.println("Equation 3*(7+4) should equal 33: " + tree3.value());
    
    ExpressionNode tree4 = new OperationNode('%');
    System.out.println("Adding '8': " + tree4.addNode("L", true, "8"));
    System.out.println("Adding '3': " + tree4.addNode("R", true, "3"));
    System.out.println("Equation 8%3 should equal 0: " + tree4.value());
    
    // (20 / 6) - 10
    ExpressionNode tree5 = new OperationNode('-');
    System.out.println("Adding '/': " + tree5.addNode("L", false, "/"));
    System.out.println("Adding '10': " + tree5.addNode("R", true, "10"));
    System.out.println("Adding '20': " + tree5.addNode("LL", true, "20"));
    System.out.println("Adding '6': " + tree5.addNode("LR", true, "6"));
    System.out.println("Equation " + tree5 + " should equal -6: " + tree5.value());
    
    // ( 20 / 4 ) - ( 7 * (3 + 2) )
    tree5.addNode("LR", true, "4");
    System.out.println("Equation " + tree5 + " should equal -5: " + tree5.value());
    tree5.addNode("R", false, "*");
    tree5.addNode("RL", true, "7");
    tree5.addNode("RR", false, "+");
    tree5.addNode("RRL", true, "3");
    tree5.addNode("RRR", true, "2");
    System.out.println("Equation " + tree5 + " should be -30: " + tree5.value());
    
  }
}
