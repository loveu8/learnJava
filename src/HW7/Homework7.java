package HW7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Homework7 {
  public static void main(String[] args) {
    new Q7_1().exec();
  }
}


/**
 * <pre>
 *  
 * 
 *  今天各位要準備開一家飲料店
 *  請使用物件導向方式
 *  設計出以下幾個類別以及簡潔的點餐系統
 *  
 *  1.點餐系統
 *  2.訂單查詢
 *  3.飲料維護   (進階)
 *  4.飲料統計   (進階)
 *  5.點餐修改   (進階)
 *  
 *  飲料 : 要有"基本說明"，"材料"，"容量"，"卡洛里"與"價格"
 *  
 *  飲料調整方式 : 飲料基本上會有"冰塊"，"甜度"，"大杯中杯"
 *                的調整，請思考一下，如何搭配飲料類別去實作?
 *                
 *  菜單 : 裡面需要包含一些基本飲料
 *         (建議一開始，自己初始化ㄧ些飲料)
 *  
 *  點餐系統 : 1.使用者執行這個程式後
 *              看到一個簡單的飲料清單
 *           
 *            2.使用者開始點餐，需要記錄使用者點了甚麼飲料
 *              還有冰塊，糖度，等等
 *          
 *            3.點餐完畢，顯示使用者點完的結果   
 *                
 *  訂單查詢 : 我們需要一個訂單查詢系統
 *            我們需要產生訂單號碼，使用者的姓名與電話
 *            並紀錄點了多少飲料
 *  
 *  -----------------------------------------------
 *  
 *  進階題 
 *  飲料統計 : 每次點餐完畢之後，可以根據功能選項
 *            看到總共賣出多少飲料，消費總金額
 *            以及統計每杯飲料點的數量            
 *  
 *  飲料維護  : 可以在維護介面新增飲料與修改
 *
 *  點餐修改 : 可以在這個選項裡，新增、修改、刪除客人的訂單
 *  
 *  Hit : 需要看到繼承，多型，封裝這三種物件導向基礎的類別設計
 * </pre>
 */
class Q7_1 {

  // 建立一個drinkInfo
  Map<String, Drink> drinkInfo; 

  // 執行
  public void exec() {
    drinkInfo = new GenDrinkInfo().initdrinkData(); 
    for (String key : drinkInfo.keySet()) {
      System.out.println(drinkInfo.get(key).toString());
    }
  }
  
}


//1.建立共同food類別
abstract class Food { 
  private String name;
  private String desc;

  public Food(String name , String desc) { // 2.建立建構子初始化
    setName(name);
    setDesc(desc);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}

//設定飲料的動作(可變動)
interface SetDrinkAction {
public void setting(String sugar , boolean hot , String ice , int number);
}

class Drink extends Food implements SetDrinkAction {
  
  // 初始不可變動飲料參數
  public Drink(String name , String desc , String raw , String bigsmall , int price , String ml , String kcal) {
    super(name, desc);
    setRaw(raw);
    setBigsmall(bigsmall);
    setPrice(price);
    setMl(ml);
    setKcal(kcal);
  }
  // 不可變動
  private String raw;
  private String bigsmall;
  private int price;
  private String ml;
  private String kcal;

  // 可以變動
  private boolean hot;
  private String ice;
  private String sugar;
  private int number;

  public String getRaw() {
    return raw;
  }

  private void setRaw(String raw) {
    this.raw = raw;
  }

  public String getMl() {
    return ml;
  }

  public String getKcal() {
    return kcal;
  }

  public void setKcal(String kcal) {
    this.kcal = kcal;
  }

  public int getPrice() {
    return price;
  }

  private void setPrice(int price) {
    this.price = price;
  }

  public String getIce() {
    return ice;
  }

  public String getSugar() {
    return sugar;
  }

  public String getBigsmall() {
    return bigsmall;
  }
  
  private void setBigsmall(String bigsmall) {
    this.bigsmall = bigsmall;
  }
  
  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public boolean isHot() {
    return hot;
  }

  public void setHot(boolean hot) {
    this.hot = hot;
  }

  private void setMl(String ml) {
    this.ml = ml;
  }

  public void setIce(String ice) {
    if(this.hot){
      ice = "";
    } else {
      this.ice = ice;
    }
  }

  public void setSugar(String sugar) {
    this.sugar = sugar;
  }
  
  @Override
  public void setting(String sugar , boolean hot , String ice , int number) {
    this.sugar = sugar;
    this.hot = hot;
    // 需要確認冷熱後，才能決定冰塊
    setIce(ice);
    this.number = number;
  }
  
  //內建system.out.println toString方法
  public String toString() { 
    return "name = " + getName() + ",desc = " + getDesc() + ",raw = " + getRaw()
         + ",ml = " + getMl() + ",kcal = " + getKcal() + ",price = " + getPrice()
         + ",ice = " + getIce() + ",sugar =" + getSugar() + ",bigsmall =" + getBigsmall()
         + ",sugar = " + getSugar() + ",hot =" + isHot() + ",ice =" + getIce() + ",number =" + getNumber();
  }

}


enum DrinkName {

  大正紅茶("大正紅茶"),
  初露青茶("初露青茶"), 
  珍珠紅茶拿鐵("珍珠紅茶拿鐵");
  
  private final String name;
  
  DrinkName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }
  
}


class GenDrinkInfo {
  public Map<String, Drink> initdrinkData() { // initdrinkData方法名稱
    Map<String, Drink> drink = new HashMap<String, Drink>();
    drink.put("大正紅茶-L", new Drink(DrinkName.大正紅茶.getName() , "茶葉  原產地：印度", "茶葉" , "L" , 30 , "700", "140"));
    drink.put("初露青茶-L", new Drink(DrinkName.初露青茶.getName() , "茶葉  原產地：台灣", "茶葉" , "L" , 30 , "700", "140"));
    drink.put("珍珠紅茶拿鐵-M", new Drink(DrinkName.珍珠紅茶拿鐵.getName() , "茶葉  原產地：印度", "茶葉 , 牛奶 , 珍珠" , "M" , 50 , "500", "100"));
    drink.put("珍珠紅茶拿鐵-L", new Drink(DrinkName.珍珠紅茶拿鐵.getName() , "茶葉  原產地：印度", "茶葉 , 牛奶 , 珍珠" , "L" , 60 , "700", "120"));
    return drink;
  }
}


class Order {
  private String cusName;
  private String cusTelphone;
  private String address;
  private boolean toGo;
  List<Drink> drinks;
  public String getCusName() {
    return cusName;
  }
  public void setCusName(String cusName) {
    this.cusName = cusName;
  }
  public String getCusTelphone() {
    return cusTelphone;
  }
  public void setCusTelphone(String cusTelphone) {
    this.cusTelphone = cusTelphone;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public boolean isToGo() {
    return toGo;
  }
  public void setToGo(boolean toGo) {
    this.toGo = toGo;
  }
  public List<Drink> getDrinks() {
    return drinks;
  }
  public void setDrinks(List<Drink> drinks) {
    this.drinks = drinks;
  }
}
