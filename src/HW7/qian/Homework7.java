package HW7.qian;

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
  public void setting(String sugar , boolean hot , String ice , int number);      //6.變動的變數  
}



class Drink extends food implements SetDrinkAction { // 3.繼承food 類別 並在新增屬於自己的內容物
  public Drink(String desc, String name,String no, String raw, String kcal,String ml,String bigsmall, int price) { // 4.父類別的建構子會super(food
                                                                               // 內的內容),在繼續建立屬於drink的建構子
    super(desc, name);
    setNo(no);
    setRaw(raw);
    setKcal(kcal);
    setPrice(price);
    setMl(ml);
    setBigsmall(bigsmall);

  }

  // 編號、"材料"，"大小杯"，"卡洛里"與"價格"  =>固定的 預設值
  private String no;
  private String raw;
  private String ml;
  private String kcal;
  private int price;
  private String bigsmall;
  

  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }
  
  public String getRaw() {
    return raw;
  }

  public void setRaw(String raw) {
    this.raw = raw;
  }

  public String getMl() {
    return ml;
  }
  
  public void  setMl(String ml) {
    this.ml=ml;
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
  
  public String getBigsmall() {
    return bigsmall;
  }

  public void setBigsmall(String bigsmall) {
    this.bigsmall = bigsmall;
  }
  

  //可以變動的
  private String sugar;
  private boolean hot;
  private String ice;
  private int number;
  
  
  
  public boolean isHot() {
    return hot;
  }

  public void setHot(boolean hot) {
    this.hot = hot;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setSugar(String sugar) {
    this.sugar = sugar;
  }

  public void setIce(String ice) {
    this.ice = ice;
  }
  
  public String getIce() {
    return ice;
  }

  public String getSugar() {
    return sugar;
  }

  public String toString() { // 內建system.out.println toString方法
    return "name = " + getName() + ",desc = " + getDesc() + ",raw = " + getRaw()
         +  ",no = " + getNo()+",ml = " + getMl() + ",kcal = " + getKcal() + ",price = " + getPrice()
         + ",bigsmall =" + getBigsmall()+ ",sugar =" + getSugar()+ ",hot =" + isHot()+ ",ice = " + getIce() +",number = " + getNumber()  ;
  }

 
  @Override
  //糖度 ,冷熱 ,冰量, 數量
  public void setting(String sugar, boolean hot, String ice, int number) {
    this.ice = ice;
    this.sugar = sugar;
    this.hot=hot;
    this.number = number;
    
  }


}

//public Drink(String desc, String name,String no, String raw, String kcal,String bigsmall, int price)
// "材料"，"容量"，"卡洛里"與"價格"
class Gendrink {
  public Map<String, Drink> initdrinkData() { // initdrinkData方法名稱
    Map<String, Drink> drink = new HashMap<String, Drink>();
    drink.put("1", new Drink("茶葉  原產地：印度", "大正紅茶","1","茶葉","100", "700","L", 30)); // 5.預設值
    drink.put("2", new Drink("茶葉  原產地：台灣", "初露青茶","2","茶葉","100", "700","L", 30));
    drink.put("3", new Drink("茶葉  原產地：台灣", "大正紅茶拿鐵","3","茶葉","100", "500","M", 45));
    drink.put("4", new Drink("茶葉  原產地：台灣", "大正紅茶拿鐵","4","茶葉","100","700", "L", 55));
    drink.put("5", new Drink("茶葉  原產地：台灣", "仙草凍紅茶拿鐵","5","茶葉", "140","500","M", 50));
    drink.put("6", new Drink("茶葉  原產地：台灣", "仙草凍紅茶拿鐵","6","茶葉", "140","700","L", 60));
    return drink;
  }

}

//--=======================訂單類別=======================

  class Order {
    
    private String custname;
    private String addr;
    private String phone;
    private String outin;
    private List <Drink> orderdrink;
    
    
    
    public List<Drink> getOrderdrink() {
      return orderdrink;
    }
    public void setOrderdrink(List<Drink> orderdrink) {
      this.orderdrink = orderdrink;
    }
    
    public String getCustname() {
      return custname;
    }
    public void setCustname(String custname) {
      this.custname = custname;
    }
    public String getAddr() {
      return addr;
    }
    public void setAddr(String addr) {
      this.addr = addr;
    }
    public String getPhone() {
      return phone;
    }
    public void setPhone(String phone) {
      this.phone = phone;
    }
    public String getOutin() {
      return outin;
    }
    public void setOutin(String outin) {
      this.outin = outin;
    }
    
    
    
}













