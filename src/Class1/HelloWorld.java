package Class1;
public class HelloWorld {

  public static void main(String[] args) {
    Bc bc = new Bc();
    bc.setName("Human");
    bc.setWeight(100);
    System.out.println(bc.getWeight());
    System.out.println(bc.getName());
    System.out.println(bc.toString());
  }

}

class Bc {
  
  private int weight;

  private String name;
  
  public int getWeight() {
    return weight;
  }
  
  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // toString 是來至於 java.lang.Object的方法
  // 如果我們對這個方法，需要改善還是重寫時
  // 我可以覆寫(改寫)我們想要的結果
  public String toString(){
    return "this bc's name = " + name + ", weight = " + weight;
  }
  
}
