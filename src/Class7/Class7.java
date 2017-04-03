package Class7;


public class Class7 {
  public static void main(String[] args) {
    // 修飾子
//    Modifier modifier = new Modifier();
//    modifier.iAmPublic = "iAmPublic";
//    modifier.iAmProtected = "iAmProtected";
//    modifier.iAmNotModifier = "iAmNotModifier";
//    System.out.println("iAmPublic = " + modifier.iAmPublic);
//    System.out.println("iAmProtected = " + modifier.iAmProtected);
//    System.out.println("iAmNotModifier = " + modifier.iAmNotModifier);
    // 繼承與抽象
    ONE_PIECE ONE_PIECE = new 魯夫();
    System.out.println("ONE_PIECE.大祕寶 = " + ONE_PIECE.大祕寶);
    魯夫 魯夫 = null;
    // Java 的 instanceof 運算子 (instanceof operator) ，測試某一物件是否為另一類別 (class) 的子類別 (subclass) 
    if(ONE_PIECE instanceof 魯夫){
      魯夫 = (魯夫) ONE_PIECE;
    }
    System.out.println("魯夫.大祕寶 = " + 魯夫.大祕寶);
    魯夫.serach();
  }
}

/**
 * <pre> 
 * 再論物件導向學習
 * 
 * Extends(繼承)
 * 繼承就是，接受所有，不管好壞
 * 
 * Encapsulation(封裝)
 * 就跟餐廳點菜一樣，上來就是一道料理
 * 一般客人就會覺得吃就對了
 * 不會去過分了解怎麼詳細料理的
 * 料理的是，就交給店家處理!
 * 負責吃就對了
 * 
 * Polymorphism(多型)
 * 意思大概就是
 * 世界這麼大，美食很多
 * 大家料理方式就會差異
 * 就會有多樣性出現了
 * 就會有各地美食拉
 * 吃吃吃!!
 * 
 * Interface(介面)
 * 他的存在就是，我只告知方式
 * 料理方式，大家各自發揮~
 * 
 * </pre>
 */

// 抽象類別，無法直接產生物件來使用，必須要有人繼承他的遺志?? 
abstract class ONE_PIECE {
  public String 大祕寶 = "???";
}

class 魯夫 extends ONE_PIECE{
  public void serach(){
    System.out.println("尾田大大，還沒畫完...");
  }
}


abstract class Food{
  protected String raw;
}

interface FoodAction{
  public void setRaw(String raw);
  public String getRaw();
}

class Cake extends Food implements FoodAction{

  @Override
  public void setRaw(String raw) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public String getRaw() {
    // TODO Auto-generated method stub
    return null;
  }

}

class Tea extends Food implements FoodAction{

  @Override
  public void setRaw(String raw) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public String getRaw() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
