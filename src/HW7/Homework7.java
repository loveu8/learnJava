package HW7;

import java.util.HashMap;
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

  Map<String, Drink> menu; // 6.建立一個menu

  public void exec() {
    menu = new Gendrink().initdrinkData(); // 7.把值建立出來=>利用gendrink類別的方法(initdrinkData) =>show值
    for (String key : menu.keySet()) {
      System.out.println(menu.get(key).toString());
    }
  }
}


abstract class food { // 1.建立共同food類別
  private String desc;
  private String name;

  public food(String desc, String name) { // 2.建立建構子初始化
    setDesc(desc);
    setName(name);
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}


// 設定飲料的動作
interface SetDrinkAction {
  public void setting(String ice, String sugar, String bigsmall);
}



class Drink extends food implements SetDrinkAction { // 3.繼承food 類別 並在新增屬於自己的內容物
  public Drink(String desc, String name, String raw, String kcal, int price) { // 4.父類別的建構子會super(food
                                                                               // 內的內容),在繼續建立屬於drink的建構子
    super(desc, name);
    setRaw(raw);
    setKcal(kcal);
    setPrice(price);

  }

  // "材料"，"容量"，"卡洛里"與"價格"
  private String raw;

  private String ml;

  private String kcal;

  private int price;

  private String ice;

  private String sugar;

  private String bigsmall;

  public String getRaw() {
    return raw;
  }

  public void setRaw(String raw) {
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

  public void setPrice(int price) {
    this.price = price;
  }

  public String toString() { // 內建system.out.println toString方法
    return "name = " + getName() + ",desc = " + getDesc() + ",raw = " + getRaw()
         + ",ml = " + getMl() + ",kcal = " + getKcal() + ",price = " + getPrice()
         + ",ice = " + getIce() + ",sugar =" + getSugar() + ",bigsmall =" + getBigsmall();
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

  @Override
  public void setting(String ice, String sugar, String bigsmall) {
    this.ice = ice;
    this.sugar = sugar;
    this.bigsmall = bigsmall;
    this.ml = "L".equals(bigsmall) ? "700" : "500";
  }


}


// "材料"，"容量"，"卡洛里"與"價格"
class Gendrink {
  public Map<String, Drink> initdrinkData() { // initdrinkData方法名稱
    Map<String, Drink> drink = new HashMap<String, Drink>();
    drink.put("大正紅茶", new Drink("茶葉  原產地：印度", "大正紅茶", "茶葉", "190", 30)); // 5.預設值
    drink.put("初露青茶", new Drink("茶葉  原產地：台灣", "初露青茶", "茶葉", "140", 30));
    return drink;
  }

}

