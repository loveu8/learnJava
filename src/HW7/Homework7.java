package HW7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
  
  // 建立訂單資料
  LinkedList<Order> orders;

  // 執行
  public void exec() {
    genDrinkInfo();
    genDefaultOrders();
    genOrderSystem();
  }
  

  private void genDrinkInfo(){
    drinkInfo = new GenDrinkInfo().initdrinkData(); 
    for (String key : drinkInfo.keySet()) {
      System.out.println(drinkInfo.get(key).toString());
    }
  }
  
  private void genDefaultOrders() {
    orders = new LinkedList<Order>();
  }
  
  private void genOrderSystem(){
    boolean system = true;
    
    while(system){
      System.out.println("--------------------");
      System.out.println("飲料點餐系統");
      Scanner scanner = new Scanner(System.in);
      System.out.println("1.點餐系統，請按1");
      System.out.println("2.訂單查詢，請按2");
      System.out.println("3.飲料維護，請按3");
      System.out.println("0.結束功能，請按0");
      System.out.print("請輸入要執行的功能:");
      if(!scanner.hasNextInt()){
        System.out.println("輸入錯誤，重新開始\n");
        continue;
      }
      int functionFlag = Integer.parseInt(scanner.next()); 
      System.out.println("--------------------");
      switch(functionFlag){
        case 1:
          orderDrink();
          break;
        case 2:
          orderQuery();
          break;
        case 3:
          adjDrink();
          break;
        case 0:
          system = false;
          System.out.println("飲料點餐系統結束");
          break;
        default:
          System.out.println("您尚未選取到任何功能，請重新開始");
          break;
      }
    }
  }
  
  private void adjDrink() {
    System.out.println("--------------------");
    System.out.println("3.1 您進入飲料維護介面");
    boolean adjDrink = true;
    while(adjDrink){
      Scanner scanner = new Scanner(System.in);
      System.out.println("1 : 新增飲料");
      System.out.println("2 : 調整飲料");
      System.out.println("3 : 移除飲料");
      System.out.println("4 : 查詢目前的飲料");
      System.out.println("0 : 離開");
      System.out.print("請選擇你要的維護功能(1~3):");
      String input = scanner.next();
      if("0123".indexOf(input) < 0){
        System.out.println("請選擇正確的功能");
      }
      if("0".equals(input)){
        System.out.println("3.1 維護結束");
        System.out.println("-------------------");
        adjDrink = false;
        break;
      }
      int functionFlag = Integer.parseInt(input);
      switch(functionFlag){
        case 1:
          // drink.put("1", new Drink("1" , DrinkName.大正紅茶.getName() , "茶葉  原產地：印度", "茶葉" , "L" , 30 , "700", "140"));

          System.out.print("請輸入飲料的名稱(離開請按0):");
          String name = scanner.next();
          if("0".equals(name)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的說明(離開請按0):");
          String desc = scanner.next();
          if("0".equals(desc)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的原料(離開請按0):");
          String raw = scanner.next();
          if("0".equals(raw)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的大小杯(離開請按0):");
          String bigSmall = scanner.next();
          if("0".equals(bigSmall)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的價格(離開請按0):");
          String price = scanner.next();
          if("0".equals(price)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的容量(離開請按0):");
          String ml = scanner.next();
          if("0".equals(ml)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的卡洛里(離開請按0):");
          String kcal = scanner.next();
          if("0".equals(kcal)){
            System.out.println("取消設定");
            break;
          }
          drinkInfo.put(String.valueOf(drinkInfo.size() + 1),  new Drink( String.valueOf(drinkInfo.size() + 1), name , desc, raw , "L" , Integer.parseInt(price) , ml, kcal));
          
          System.out.println("新增後資料的飲料清單");
          for(String key : drinkInfo.keySet()){
            System.out.println("編號 : " + drinkInfo.get(key).getProdNumber()+ 
                               " 飲料 : " + drinkInfo.get(key).getName() + 
                               " 大小 : " + drinkInfo.get(key).getBigsmall() + 
                               " 價格 : " + drinkInfo.get(key).getPrice());
          }
          break;
        case 2:
          System.out.println("請輸入想要修改的飲料(離開請按0):");
          for(String key : drinkInfo.keySet()){
            System.out.println("編號 : " + drinkInfo.get(key).getProdNumber()+ 
                               " 飲料 : " + drinkInfo.get(key).getName() + 
                               " 大小 : " + drinkInfo.get(key).getBigsmall() + 
                               " 價格 : " + drinkInfo.get(key).getPrice());
          }
          String prodNumber = scanner.next();
          if(drinkInfo.get(prodNumber) == null){
            System.out.print("請入的飲料編號錯誤，請重新選擇維護飲料功能重新開始");
            break;
          }
          System.out.print("請輸入飲料的名稱(離開請按0):");
          String editName = scanner.next();
          if("0".equals(editName)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的說明(離開請按0):");
          String editDesc = scanner.next();
          if("0".equals(editDesc)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的原料(離開請按0):");
          String editRaw = scanner.next();
          if("0".equals(editRaw)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的大小杯(離開請按0):");
          String editBigSmall = scanner.next();
          if("0".equals(editBigSmall)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的價格(離開請按0):");
          String editPrice = scanner.next();
          if("0".equals(editPrice)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的容量(離開請按0):");
          String editMl = scanner.next();
          if("0".equals(editMl)){
            System.out.println("取消設定");
            break;
          }
          
          System.out.print("請輸入飲料的卡洛里(離開請按0):");
          String editKcal = scanner.next();
          if("0".equals(editKcal)){
            System.out.println("取消設定");
            break;
          }
          drinkInfo.put(drinkInfo.get(prodNumber).getProdNumber() ,  new Drink( drinkInfo.get(prodNumber).getProdNumber(), editName , editDesc, editRaw , "L" , Integer.parseInt(editPrice) , editMl, editKcal));
          for(String key : drinkInfo.keySet()){
            System.out.println("編號 : " + drinkInfo.get(key).getProdNumber()+ 
                               " 飲料 : " + drinkInfo.get(key).getName() + 
                               " 大小 : " + drinkInfo.get(key).getBigsmall() + 
                               " 價格 : " + drinkInfo.get(key).getPrice());
          }
          break;
        case 3:
          for(String key : drinkInfo.keySet()){
            System.out.println("編號 : " + drinkInfo.get(key).getProdNumber()+ 
                               " 飲料 : " + drinkInfo.get(key).getName() + 
                               " 大小 : " + drinkInfo.get(key).getBigsmall() + 
                               " 價格 : " + drinkInfo.get(key).getPrice());
          }
          System.out.print("請輸入要刪除的飲料(離開請按0):");
          String removeProdNumber = scanner.next();
          if("0".equals(removeProdNumber)){
            System.out.println("取消設定");
            break;
          }

          if(drinkInfo.get(removeProdNumber) == null){
            System.out.print("請入的飲料編號錯誤，請重新選擇維護飲料功能重新開始");
            break;
          }
          
          drinkInfo.remove(removeProdNumber);
          
          System.out.println("移除資料的飲料清單");
          for(String key : drinkInfo.keySet()){
            System.out.println("編號 : " + drinkInfo.get(key).getProdNumber()+ 
                               " 飲料 : " + drinkInfo.get(key).getName() + 
                               " 大小 : " + drinkInfo.get(key).getBigsmall() + 
                               " 價格 : " + drinkInfo.get(key).getPrice());
          }
          break;
        case 4:
          for(String key : drinkInfo.keySet()){
            System.out.println("編號 : " + drinkInfo.get(key).getProdNumber()+ 
                               " 飲料 : " + drinkInfo.get(key).getName() + 
                               " 大小 : " + drinkInfo.get(key).getBigsmall() + 
                               " 價格 : " + drinkInfo.get(key).getPrice());
          }
          break;
        case 0:
          System.out.println("飲料維護結束");
          adjDrink = false;
          break;
      }
      System.out.println("--------------------");
    }
  }


  private void orderDrink(){
    System.out.println("--------------------");
    System.out.println("1.1 您進入點餐介面");
    boolean orderDrinkSystem = true;
    Order order = new Order();
    while(orderDrinkSystem){
      Scanner scanner = new Scanner(System.in);
      // 姓名
      System.out.print("請輸入顧客姓名(離開請按0):");
      String input = scanner.next();
      if("0".equals(input)){
        System.out.println("取消點餐");
        orderDrinkSystem = false;
        break;
      }
      order.setCusName(input);
      
      // 電話
      System.out.print("請輸入顧客電話(離開請按0):");
      input = scanner.next();
      if("0".equals(input)){
        System.out.println("取消點餐");
        orderDrinkSystem = false;
        break;
      }
      order.setCusTelphone(input);
      
      // 外帶還內用
      System.out.print("外帶請按1，內用請按2(離開請按0):");
      input = scanner.next();
      if("0".equals(input)){
        System.out.println("取消點餐");
        orderDrinkSystem = false;
        break;
      }
      if("1".equals(input)){
        order.setToGo(true);
      } else {
        order.setToGo(false);
      }
      
      // 地址
      if(order.isToGo()){
        System.out.print("請輸入顧客地址(離開請按0):");
        input = scanner.next();
        if("0".equals(input)){
          System.out.println("取消點餐");
          orderDrinkSystem = false;
          break;
        }
        order.setAddress(input);
      }
      
      // 顯示飲料清單
      System.out.println("-------------------");
      System.out.println("以下是飲料清單，請根據下方清單進行點選");
      List<Drink> drinks = new LinkedList<Drink>();
      boolean settingDrinkSystem = true;
      while(settingDrinkSystem){
        Map<String, Drink> drinkInfoDetail = drinkInfo;
        for(String key : drinkInfoDetail.keySet()){
          System.out.println("編號 : " + drinkInfoDetail.get(key).getProdNumber()+ 
                             " 飲料 : " + drinkInfoDetail.get(key).getName() + 
                             " 大小 : " + drinkInfoDetail.get(key).getBigsmall() + 
                             " 價格 : " + drinkInfoDetail.get(key).getPrice());
        }
        System.out.print("請選擇飲料編號(離開請按0):");
        input = scanner.next();
        if("0".equals(input)){
          System.out.println("取消點餐");
          orderDrinkSystem = false;
          break;
        }
        boolean isTheProdNumber = false; 
        for(String key : drinkInfoDetail.keySet()){
          if(input.equals(key)){
            isTheProdNumber = true;
            break;
          }
        }
        if(!isTheProdNumber){
          System.out.println("請選擇正確的飲料");
          continue;
        }
        System.out.println("--------------------");
        // 根據編號取得飲料，開始設定冰塊，糖度，etc...
        Drink drink = drinkInfoDetail.get(input);
        System.out.print("糖度(全糖:1，七分糖:2，五分糖:3，三分糖:4，無糖:5)(離開請按0):");
        String sugar = scanner.next();
        if("0".equals(sugar)){
          System.out.println("取消點餐");
          orderDrinkSystem = false;
          break;
        }
        if("12345".indexOf(sugar) < 0){
          System.out.println("請選擇正確的糖度");
          continue;
        }
        
        System.out.print("冷熱(冷:1，熱:2)(離開請按0):");
        String hot = scanner.next();
        if("0".equals(hot)){
          System.out.println("取消點餐");
          orderDrinkSystem = false;
          break;
        }
        if("12".indexOf(hot) < 0){
          System.out.println("請選擇正確的冷熱");
          continue;
        }
        
        String ice = "";
        if("1".equals(hot)){
          System.out.print("冰量(正常冰:1，少冰:2，微冰:3，去冰:4)(離開請按0):");
          ice = scanner.next();
          if("0".equals(ice)){
            System.out.println("取消點餐");
            orderDrinkSystem = false;
            break;
          }
          if("1234".indexOf(ice) < 0){
            System.out.println("請選擇正確的冰量");
            continue;
          }
        }
        
        System.out.print("幾杯(數字)(離開請按0):");
        String strNumber = scanner.next();
        if("0".equals(strNumber)){
          System.out.println("取消點餐");
          orderDrinkSystem = false;
          break;
        }
        if(Integer.parseInt(strNumber) <= 0 ){
          System.out.println("請選擇正確的杯數");
          continue;
        }
        
        
        drink.setting(sugar , (hot.equals("1") ?  false : true) , ice , Integer.parseInt(strNumber));
        drinks.add(drink);
                
        System.out.print("是否還需要繼續點餐? (1:繼續  , 0:離開) : ");
        String isOrderAgain = scanner.next();
        if("1".indexOf(isOrderAgain) == 0){
          System.out.println("(繼續點餐)");
          System.out.println("-------------------");
          continue;
        } else {
          order.setNo(String.valueOf(orders.size() + 1));
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH:mm:ss:SSS");
          order.setOrderDate(sdf.format(new Date()));
          order.setDrinks(drinks);
          orders.add(order);
          System.out.println("(點餐完畢)");
          System.out.println("-------------------");
          System.out.println(order.toString());
          settingDrinkSystem = false;
          orderDrinkSystem = false;
        }
      }
    }
  }
  
  private void orderQuery(){
    boolean isQuery = true;
    System.out.println("-------------------");
    System.out.println("2.1 您進入點餐查詢介面");
    while(isQuery){

      Scanner scanner = new Scanner(System.in);
      System.out.println("1 : 查詢全部交易");
      System.out.println("2 : 查詢編號");
      System.out.println("3 : 查詢訂購者");
      System.out.println("4 : 查詢訂購者電話");
      System.out.println("5 : 查詢單日訂單(ex:20170517)");
      System.out.println("0 : 離開");
      System.out.print("請選擇你要的查詢功能(1~5):");
      String input = scanner.next();
      if("012345".indexOf(input) < 0){
        System.out.println("請選擇正確的功能");
      }
      if("0".equals(input)){
        System.out.println("2.1 查詢結束");
        System.out.println("-------------------");
        isQuery = false;
        break;
      }
      int functionFlag = Integer.parseInt(input);
      switch(functionFlag){
        case 1:
          for(Order data : orders){
            System.out.println(data.toString());
          }
          break;
        case 2:
          System.out.print("請輸入要查詢的編號:");
          input = scanner.next();
          boolean checkNo = false;
          for(Order data : orders){
            if(input.equals(data.getNo())){
              System.out.println(data.toString());
              checkNo = true;
            }
          }
          if(!checkNo){
            System.out.println("查無資料!!");
          }
          break;
        case 3:
          System.out.print("請輸入要查詢的訂購者:");
          input = scanner.next();
          boolean checkCusName = false;
          for(Order data : orders){
            if(input.equals(data.getCusName())){
              System.out.println(data.toString());
              checkCusName = true;
            }
          }
          if(!checkCusName){
            System.out.println("查無資料!!");
          }
          break;
        case 4:
          System.out.print("請輸入要查詢的訂購者電話:");
          input = scanner.next();
          boolean checkCusTelphone = false;
          for(Order data : orders){
            if(input.equals(data.getCusTelphone())){
              System.out.println(data.toString());
              checkCusTelphone = true;
            }
          }
          if(!checkCusTelphone){
            System.out.println("查無資料!!");
          }
          break;
        case 5:
          System.out.print("請輸入要查詢的訂購日期(ex:20170517):");
          input = scanner.next();
          boolean checkOrderDate = false;
          for(Order data : orders){
            if(data.getOrderDate().indexOf(input) >= 0){
              System.out.println(data.toString());
              checkOrderDate = true;
            }
          }
          if(!checkOrderDate){
            System.out.println("查無資料!!");
          }
          break;
      }
      System.out.println("-------------------");
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
  public Drink(String prodNumber , String name , String desc , String raw , String bigsmall , int price , String ml , String kcal) {
    super(name, desc);
    setProdNumber(prodNumber);
    setRaw(raw);
    setBigsmall(bigsmall);
    setPrice(price);
    setMl(ml);
    setKcal(kcal);
  }
  // 不可變動
  private String prodNumber;
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

  public String getProdNumber() {
    return prodNumber;
  }

  public void setProdNumber(String prodNumber) {
    this.prodNumber = prodNumber;
  }

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
         + ",bigsmall =" + getBigsmall() + ",sugar = " + getSugar() + ",hot =" + isHot() 
         + ",ice =" + getIce() + ",number =" + getNumber();
  }
  
  public String printDrink(){
    DrinkSettingConvert convert = new DrinkSettingConvert();
    return "飲料 : " + getName() + " , 價格 : " + getPrice()
            + " , 大小 : " + getBigsmall() + " , 糖量 : " + convert.sugarName(getSugar()) + " , 冷熱 : " + convert.coldOrHot(isHot()) 
            + " , 冰量 : " + convert.iceAmount(getIce()) + " , 杯數 : " + getNumber();
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

class DrinkSettingConvert {
  public String sugarName(String sugar){
    if("1".equals(sugar)){
      return "全糖";
    }
    if("2".equals(sugar)){
      return "七分糖";
    }
    if("3".equals(sugar)){
      return "五分糖";
    }
    if("4".equals(sugar)){
      return "三分糖";
    }
    if("5".equals(sugar)){
      return "無糖";
    }
    return "";
  }
  public String coldOrHot(boolean hot){
    // 冷:false，熱:True
    return hot ? "熱": "冷";
  }
  public String iceAmount(String ice){
    // 正常冰:1，少冰:2，微冰:3，去冰:4
    if("1".equals(ice)){
      return "正常冰";
    }
    if("2".equals(ice)){
      return "少冰";
    }
    if("3".equals(ice)){
      return "微冰";
    }
    if("4".equals(ice)){
      return "去冰";
    }
    return "";
  }
}

class GenDrinkInfo {
  public Map<String, Drink> initdrinkData() { // initdrinkData方法名稱
    Map<String, Drink> drink = new LinkedHashMap<String, Drink>();
    drink.put("1", new Drink("1" , DrinkName.大正紅茶.getName() , "茶葉  原產地：印度", "茶葉" , "L" , 30 , "700", "140"));
    drink.put("2", new Drink("2" ,DrinkName.初露青茶.getName() , "茶葉  原產地：台灣", "茶葉" , "L" , 30 , "700", "140"));
    drink.put("3", new Drink("3" ,DrinkName.珍珠紅茶拿鐵.getName() , "茶葉  原產地：印度", "茶葉 , 牛奶 , 珍珠" , "M" , 50 , "500", "100"));
    drink.put("4", new Drink("4" ,DrinkName.珍珠紅茶拿鐵.getName() , "茶葉  原產地：印度", "茶葉 , 牛奶 , 珍珠" , "L" , 60 , "700", "120"));
    return drink;
  }
}

class Order {
  private String no;
  private String cusName;
  private String cusTelphone;
  private String address;
  private boolean toGo;
  private String orderDate;
  private List<Drink> drinks;
  
  public String getNo() {
    return no;
  }
  public void setNo(String no) {
    this.no = no;
  }
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
  public String getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }
  public List<Drink> getDrinks() {
    return drinks;
  }
  public void setDrinks(List<Drink> drinks) {
    this.drinks = drinks;
  }
  
  public String toString(){
    StringBuilder builder = new StringBuilder();
    builder.append("-------------------");
    builder.append("\n訂購資訊");
    builder.append("\n編號     : " + getNo());
    builder.append("\n顧客姓名 : " + getCusName());
    builder.append("\n手機號碼 : " + getCusTelphone());
    builder.append("\n是否外帶 : " + isToGo());
    builder.append("\n地址     : " + getAddress());
    builder.append("\n訂購日期 : " + getOrderDate());
    builder.append("\n-------------------");
    if(getDrinks()!=null){
      builder.append("\n飲料清單");
      for(Drink data : getDrinks()){
        builder.append("\n" + data.printDrink());
      }
    } else {
      builder.append("\n尚未設定飲料");
    }
    builder.append("\n-------------------");
    return builder.toString();
  }
}