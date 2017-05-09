package Class7;

/**
 * <pre> 
 * 再論物件導向學習
 * 
 * 物件導向的精華就是
 * 找出幾件事物異同的部分
 * 並把關鍵事務，提升到類似規格一般
 * 大家必須照著基本規範走
 * 會大幅減少不必要的重覆程式碼
 * 
 * Extends(繼承)
 * 繼承就是，接受對方所有一切，不管好壞
 * 
 * Encapsulation(封裝)
 * 就跟餐廳點菜一樣，上來就是一道料理
 * 一般客人就會覺得可以吃就好了
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
 * </pre>
 */
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
    
    // 繼承
//    ONE_PIECE ONE_PIECE = new 魯夫();
//    System.out.println("ONE_PIECE.大祕寶 = " + ONE_PIECE.大祕寶);
//    魯夫 魯夫 = null;
//    // Java 的 instanceof 運算子 (instanceof operator) 
//    // 測試某一物件是否為另一類別 (class) 的子類別 (subclass) 
//    if(ONE_PIECE instanceof 魯夫){
//      魯夫 = (魯夫) ONE_PIECE;
//    }
//    System.out.println("魯夫.大祕寶 = " + 魯夫.大祕寶);
//    魯夫.serach();
    
    // 繼承，抽象，多型，封裝
//    Food cake = new Cake();
//    cake.setName("戚風蛋糕");
//    cake.setRaw("麵粉，奶油，鮮奶，香草精，攪拌器，烤箱");
//    cake.cooking();
//    Food tea = new Tea();
//    tea.setName("紅茶");
//    tea.setRaw("台茶十八號");
//    tea.cooking();
    
    // Overloading 多載
    new Overloading().exec();
    role test =new knife("95%","20" );
    test.attack();
    test.special();
    test.getLevel();
    test.getLife();
    System.out.println(test.getLevel());
    System.out.println(test.getLife());
    
  }
}

/**
 * <pre>
 *  abstract修飾子，放在類別之前，代表成為抽象類別
 *  我們無法直接使用抽象類型產生物件來使用，
 *  必須要有人繼承他的遺志 
 * </pre>
 */
abstract class ONE_PIECE {
  // 建構子優先順序
  public ONE_PIECE(){
    System.out.println("故事開始了!!");
  }
  public String 大祕寶 = "???";
  
}

class 魯夫 extends ONE_PIECE{
  //建構子優先順序
  public 魯夫(){
    System.out.println("肉!!!!!!!");
  }
  public void serach(){
    System.out.println("尾田大大，還沒畫完...");
  }
}

/** 
 * <pre> 
 * Interface(介面)
 * 他的存在就是，我只告知應該
 * 該傳入的材料與應該回傳的料理
 * 至於料理方式，讓大家實作後
 * 自行發揮~
 * </pre>
 */
interface FoodAction{
  public void setRaw(String raw);
  public String getRaw();
  public void cooking();
}

// 抽象類別 蛋糕，繼承了食物，實作了料理過程
// 為什麼需要抽像類別的原因是
// 食物是一個大型類別，可以用這個方式
// 定義出大家相同的部分，剩下給想要繼承的類別
// 自己做出想要的東西即可
abstract class Food implements FoodAction{
  protected String raw;
  private String name;
  // 封裝name(名字)目的是，不可以讓外界隨意更改名字
  // 以免被說成產品標示不名
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
}
class Cake extends Food {

  @Override
  public void setRaw(String raw) {
    this.raw = raw;
  }

  @Override
  public String getRaw() {
    return raw;
  }

  @Override
  public void cooking() {
    System.out.println("現在要做的料理是 : " + getName());
    System.out.println("材料 : " + getRaw());
    System.out.println("Step 1 : 蛋黃+糖打至糖溶");
    System.out.println("Step 2 : 加入沙拉油 拌勻");
    System.out.println("Step 3 : 加入液體&香草莢醬 ");
    System.out.println("Step 4 : 粉類混合過篩加入");
    System.out.println("etc...");
  }

}

// 類別 茶，繼承了食物，實作了料理過程
class Tea extends Food {

  @Override
  public void setRaw(String raw) {
    this.raw = raw;
  }

  @Override
  public String getRaw() {
    return raw;
  }

  @Override
  public void cooking() {
    System.out.println("現在要做的料理是 : " + getName());
    System.out.println("材料 : " + getRaw());
    System.out.println("Step 1 : 熱水");
    System.out.println("Step 2 : 熱水燙過茶壺後，倒掉");
    System.out.println("Step 3 : 放入茶葉");
    System.out.println("Step 4 : 加入熱水，簡單過沖後倒掉");
    System.out.println("Step 5 : 再次加入熱水，依照濃度等待1~3分鐘後，即可");
  }
  
}

/**
 * <pre>
 * Overloading 
 * 多載的用途是
 * 方法名稱保持一致
 * 但是接收的參數不同而已
 * 最常使用到的就是
 * System.out 物件
 * </pre>
 */
class Overloading{
  public void exec(){
    sleep(1000);
    sleep(2000.0f);
  }
  
  private void sleep(int time){
    System.out.println("睡多久 = " + time + "s");
  }
  
  private void sleep(float time){
    System.out.println("睡多久 = " + time  + "s");
  }
}


// 練習
// 遊戲中有許多"角色"
// 角色有血量，等級
// 角色有三種職業
// 戰士、魔法師、弓箭手
// 每個人都會"基本攻擊" 以及"特殊技能"
// 設計出相關類別與介面
// 並且請幫我用繼承，抽象，多型，封裝方式設計


abstract class role implements Action{  //抽項類別
 private String life;
 private String level;
 
public String getLife() {
  return life;
}
public void setLife(String life) {
  this.life = life;
}
public String getLevel() {
  return level;
}
public void setLevel(String level) {
  this.level = level;
}
  
}

interface Action{  //有相同功能介面
  public void attack();
  public void special();
 
}



class soward extends role {

  public soward(String life,String level){
    setLife(life);
    setLevel(level);
  }
  @Override
  public void attack() {
    
    System.out.println("A++");
  }

  @Override
  public void special() {
    System.out.println("level--");
    
  }
  
}

class magic extends role {

  public magic(String life,String level){
    setLife(life);
    setLevel(level);
  }
  @Override
  public void attack() {
    
    System.out.println("A+++");
  }

  @Override
  public void special() {
    System.out.println("level---");
    
  }
  
}


class knife extends role {

  public knife(String life,String level){
    setLife(life); //初始化值
    setLevel(level);
  }
  @Override
  public void attack() {
    
    System.out.println("A++++");
  }

  @Override
  public void special() {
    System.out.println("level----");
    
  }
  
}




