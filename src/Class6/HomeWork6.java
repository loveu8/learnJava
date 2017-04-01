package Class6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HomeWork6 {
  public static void main(String[] args) {
    new Q6_1().exec();
    new Q6_2().exec();
    new Q6_3().exec();
    new Q6_4().exec();
    new Q6_5().exec();
  }
}

/**
 * <pre> 
 * 
 * 請使用Map物件，處理以下問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    藍色
 * C2    香菇
 * C3    小草
 * 
 * 1.會員編號C1的姓名更改成紅色，並印出前後修改的內容
 * 2.會員編號C2已被停止使用，新增一個新的會員資料
 *   編號:C4 ,  姓名: 天天，並印出整體會員資料
 * 
 * </pre> 
 */
class Q6_1{
  private Map<String , Member> datas;
  
  public void exec(){
    datas = new GenMemberData().initMemberMapData();
    this.printChangeName();
    this.printDeleteAndNewMember();
  }
  private void printChangeName(){
    this.printMemberData();
    System.out.println("printChangeName");
    for (String key : datas.keySet()) {
      if("C1".equals(datas.get(key).getNo())){
        datas.get(key).setName("紅色");
      }
    }
    this.printMemberData();
  }
  
  private void printDeleteAndNewMember(){
    this.printMemberData();
    System.out.println("printDeleteAndNewMember");
    for (String key : datas.keySet()) {
      if("C2".equals(datas.get(key).getNo())){
        datas.remove("C2", datas.get(key));
        datas.put("C4" , new Member("C4" , "天天"));
      }
    }
    this.printMemberData();
  }
  
  private void printMemberData(){
    System.out.println("-------------------");
    for (String key : datas.keySet()) {
      System.out.println("no = " + datas.get(key).getNo() + " , name = " + datas.get(key).getName());
    }
    System.out.println("-------------------");
  }
}

/**
 * <pre> 
 * 請使用List物件，處理以下問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    藍色
 * C2    香菇
 * C3    小草
 * 
 * 1.會員編號C1的姓名更改成紅色，並印出前後修改的內容
 * 2.會員編號C2已被停止使用，新增一個新的會員資料
 *   編號:C4 ,  姓名: 天天，並印出整體會員資料
 *   
 * </pre> 
 */
class Q6_2{
  List<Member> members ;
  public void exec(){
    members = new GenMemberData().initMemberListData();
    printChangeName();
    printDeleteAndNewMember();
  }
  private void printChangeName(){
    printMemberData();
    System.out.println("printChangeName");
    for (Member member : members) {
      if("C1".equals(member.getNo())){
        member.setName("紅色");
      }
    }
    printMemberData();
  }
  private void printDeleteAndNewMember(){
    printMemberData();
    System.out.println("printDeleteAndNewMember");
    for (Member member : members) {
      if("C2".equals(member.getNo())){
        members.remove(member);
        break;
      }
    }
    members.add(new Member("C4" , "天天"));
    printMemberData();
  }
  
  private void printMemberData(){
    System.out.println("-------------------");
    for (Member member : members) {
      System.out.println("no = " + member.getNo() + " , name = " + member.getName());
    }
    System.out.println("-------------------");
  }
}

class GenMemberData {
  public Map<String , Member> initMemberMapData(){
    Map <String , Member> members = new HashMap<String , Member>();
    members.put("C1", new Member("C1" , "藍色"));
    members.put("C2", new Member("C2" , "香菇"));
    members.put("C3", new Member("C3" , "小草"));
    return members;
  }
  public List<Member> initMemberListData(){
    List<Member> members = new ArrayList<Member>();
    members.add(new Member("C1" , "藍色"));
    members.add(new Member("C2" , "香菇"));
    members.add(new Member("C3" , "小草"));
    return members;
  }
}

class Member {
  private String no;
  private String name;
  public Member(String no , String name){
    this.setNo(no);
    this.setName(name);
  }
  public String getNo() {
    return no;
  }
  public void setNo(String no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}

/**
 * <pre>
 * 使用Set物件與Random物件搭配
 * 產生10組大樂透號碼 
 * </pre>
 */
class Q6_3{
  public void exec(){
    List<Set<Integer>> datas = new ArrayList<Set<Integer>>();
    for(int index = 0 ; index < 10 ; index++){
      datas.add(new GenRandomBigLotter().exec());
    }
    int count = 1 ;
    for ( Set<Integer> data: datas) {
      Object[] numbers = data.toArray();
      System.out.print("第"+count+"組  ");
      for(int index = 0 ; index < numbers.length ; index ++){
        System.out.print(numbers[index] + ( (index < numbers.length -1) ? " , " : "\n" ));
      }
      count++;
    }
  }
}

class GenRandomBigLotter{
  public Set<Integer> exec(){
    Set<Integer> data = new HashSet<Integer>();
    while(data.size() < 6){
      int number = new Random().nextInt(49) + 1;
      data.add(number);
    }
    return data;
  }
}

/**
 * <pre>
 * 
 * 以下請使用Map物件儲存以下資訊
 * 並解決四個問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    小Q
 * C2    小咪
 * C3    查理
 * 
 * 訂單資料
 * 訂單 會員編號  訂購內容     金額
 * O001     C1      衣服        789
 * O002     C1        3C       1999
 * O003     C2      遊戲       1899
 * O004     C2    保養品       3300
 * O005     C3    攝影機      14999
 * 
 * 請用新增會員與訂單類別(Class)
 * 設定每位會員資料以及訂單資料後
 * 
 * 1.用會員編號查詢會員買的商品
 *   輸出格式 => 編號 姓名 訂單 訂購內容 金額
 *   
 * 2.算出每位會員的平均每筆消費金額
 *   輸出格式 => 編號 姓名 平均消費金額
 *   
 * 3.依照消費總金額高到低排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * 4.依照消費總金額低到高排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * </pre> 
 */
class Q6_4{
  Map<String , OrderInfo> infos;
  Map<String , Member> members;
  public void exec(){
    members = new GenMemberData().initMemberMapData();
    infos = new GenOrderInfoData().initOrderInfoMapData();
    this.printMemberBuy();
    this.printAvgCost();
    this.printHighCostOrder();
    this.printLowCostOrder();
  }
  private void printMemberBuy(){
    System.out.println("printMemberBuy");
    for(String no : members.keySet()){
      for(String key : infos.keySet()){
        if(no.equals(infos.get(key).getNo())){
          System.out.println("編號:" + no + 
                             " , 姓名:" + members.get(no).getName() + 
                             " , 訂單號碼:" + infos.get(key).getNo() +
                             " , 訂購內容:" + infos.get(key).getOrderDesc() +
                             " , 金額:" + infos.get(key).getAmount());
        }
      }
    }
    System.out.println("---------------");
  }
  private void printAvgCost(){
    System.out.println("printAvgCost");
    for(String no : members.keySet()){
      System.out.print("編號:" + no + 
                       " , 姓名:" + members.get(no).getName() );
      float totalAmout = 0 ; 
      float count = 0 ;
      for(String key : infos.keySet()){
        if(no.equals(infos.get(key).getNo())){
          count++;
          totalAmout = totalAmout + infos.get(key).getAmount();
        }
      }
      float avgAmount = totalAmout / count; 
      System.out.printf(" , 平均消費金額 : %.2f \n" , avgAmount);
    }
    System.out.println("---------------");
  }
  
  private void printHighCostOrder(){
    System.out.println("printHighCostOrder");
    // 利用總金額當作Key，value儲存會員編號
    Map<Integer , String> sumMemberPayMap = sortSumMemberPayMap();
    // 用陣列方式，放入總金額
    Integer[] orderByHighAmount = addMemberAmount(sumMemberPayMap);
    // 根據總金額開始排序
    for(int index = 0 ; index < orderByHighAmount.length-1 ; index++){
      for(int tag = 1 ; tag < orderByHighAmount.length ;tag++){
        if(orderByHighAmount[index] < orderByHighAmount[tag]){
          swap(orderByHighAmount , index , tag);
        }
      }
    }
    // 利用總金額的排序，利用sumMemberPayMap，去找出會員編號，印出相關資料
    this.printOrderAmount(orderByHighAmount, sumMemberPayMap);
    System.out.println("---------------");
  }
  
  private LinkedHashMap <Integer , String> sortSumMemberPayMap(){
    LinkedHashMap<Integer , String> sumMemberPayMap = new LinkedHashMap<Integer , String>();
    for(String no : members.keySet()){
      int totalAmt = 0 ;
      for(String key : infos.keySet()){
        if(no.equals(infos.get(key).getNo())){
          totalAmt = totalAmt + infos.get(key).getAmount();
        }
      }
      sumMemberPayMap.put(totalAmt,no);
    }
    return sumMemberPayMap;
  }
  
  private Integer[] addMemberAmount(Map<Integer , String> sumMemberPayMap){
    Integer[] orderByHighAmount = new Integer[sumMemberPayMap.size()];
    int count = 0;
    for(Integer totalAmt :sumMemberPayMap.keySet()){
      orderByHighAmount[count] = totalAmt; 
      count++;
    }
    return orderByHighAmount;
  }
  
  private void printOrderAmount(Integer[] orderByHighAmount , Map<Integer , String> sumMemberPayMap){
    // 利用總金額的排序，利用sumMemberPayMap，去找出會員編號，印出相關資料
    for(int index = 0 ; index < orderByHighAmount.length ; index++){
      String no = sumMemberPayMap.get(orderByHighAmount[index]);
      System.out.println("編號 : " + no + " , 姓名 : " + members.get(no).getName() + " , 消費總金額  : " + orderByHighAmount[index]);
    }
  }
  
  private void swap(Integer[] totalAmt , int index , int changeIndex){
    Integer temp = totalAmt[index];
    totalAmt[index] = totalAmt[changeIndex];
    totalAmt[changeIndex] = temp;
  }
  
  private void printLowCostOrder(){
    System.out.println("printLowCostOrder");
    // 利用總金額當作Key，value儲存會員編號
    Map<Integer , String> sumMemberPayMap = sortSumMemberPayMap();
    // 用陣列方式，放入總金額
    Integer[] orderByHighAmount = addMemberAmount(sumMemberPayMap);
    // 根據總金額開始排序
    for(int index = 0 ; index < orderByHighAmount.length-1 ; index++){
      for(int tag = 1 ; tag < orderByHighAmount.length ;tag++){
        if(orderByHighAmount[index] > orderByHighAmount[tag]){
          swap(orderByHighAmount , index , tag);
        }
      }
    }
    // 利用總金額的排序，利用sumMemberPayMap，去找出會員編號，印出相關資料
    this.printOrderAmount(orderByHighAmount, sumMemberPayMap);
    System.out.println("---------------");
  }
  
}

/**
 * <pre>
 * 
 * 以下請使用List物件儲存以下資訊
 * 並解決四個問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    小Q
 * C2    小咪
 * C3    查理
 * 
 * 訂單資料
 * 訂單 會員編號  訂購內容     金額
 * O001     C1      衣服        789
 * O002     C1        3C    1999
 * O003     C2      遊戲       1899
 * O004     C2    保養品       3300
 * O005     C3    攝影機      14999
 * 
 * 請用新增會員與訂單類別(Class)
 * 設定每位會員資料以及訂單資料後
 * 
 * 1.用會員編號查詢會員買的商品
 *   輸出格式 => 編號 姓名 訂單 訂購內容 金額
 *   
 * 2.算出每位會員的平均每筆消費金額
 *   輸出格式 => 編號 姓名 平均消費金額
 *   
 * 3.依照消費總金額高到低排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * 4.依照消費總金額低到高排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * </pre> 
 */
class Q6_5{
  List<Member> members ;
  List<OrderInfo> infos ;
  
  public void exec(){
    members = new GenMemberData().initMemberListData();
    infos = new GenOrderInfoData().initOrderInfoListData();
    this.printMemberBuy();
    this.printAvgCost();
    this.printHighCostOrder();
    this.printLowCostOrder();
  }
  
  private void printMemberBuy(){
    System.out.println("printMemberBuy");
    for(int index = 0 ; index < members.size() ; index++){
      for(int tag = 0 ; tag < infos.size() ; tag++){
        if(members.get(index).getNo().equals(infos.get(tag).getNo())){
          System.out.println("編號:" + members.get(index).getNo() + 
                             " , 姓名:" + members.get(index).getName() + 
                             " , 訂單號碼:" + infos.get(tag).getNo() +
                             " , 訂購內容:" + infos.get(tag).getOrderDesc() +
                             " , 金額:" + infos.get(tag).getAmount());
        }
      }
    }
    System.out.println("---------------");
  }
  
  private void printAvgCost(){
    System.out.println("printAvgCost");
    for(Member mem : members){
      System.out.print("編號:" + mem.getNo() + 
                       " , 姓名:" + mem.getName() );
      float totalAmout = 0 ; 
      float count = 0 ;
      for(OrderInfo orderInfo : infos){
        if(mem.getNo().equals(orderInfo.getNo())){
          count++;
          totalAmout = totalAmout + orderInfo.getAmount();
        }
      }
      float avgAmount = totalAmout / count; 
      System.out.printf(" , 平均消費金額 : %.2f \n" , avgAmount);
    }
    System.out.println("---------------");
  }
  
  private void printHighCostOrder(){
    System.out.println("printHighCostOrder");
    // 利用逗點，串聯資料
    // ex : 會員編號,總金額
    String[] concatData = this.concatData();
    // 進行排序
    for(int index = 0 ; index < concatData.length-1 ; index++){
      for(int tag = 1 ; tag < concatData.length ; tag++){
        if(Integer.parseInt(concatData[index].split(",")[1]) 
           <
           Integer.parseInt(concatData[tag].split(",")[1]) ){
          swap(concatData , index , tag);
        }
      }
    }
    this.printOrderAmount(concatData);
    System.out.println("---------------");
  }
  
  private String[] concatData(){
    String[] concatData = new String[members.size()];
    int count = 0 ;
    for(Member mem : members){
      int totalAmout = 0 ; 
      for(OrderInfo orderInfo : infos){
        if(mem.getNo().equals(orderInfo.getNo())){
          totalAmout = totalAmout + orderInfo.getAmount();
        }
      }
      concatData[count] = mem.getNo()+","+totalAmout;
      count++;
    }
    return concatData;
  }
  
  private void printOrderAmount(String[] concatData){
    for(int index = 0 ; index < concatData.length ; index++){
      String no = concatData[index].split(",")[0];
      Integer totalAmount = Integer.parseInt(concatData[index].split(",")[1]);
      for(Member mem : members){
        if(no.equals(mem.getNo())){
          System.out.println("編號 : " + no + " , 姓名 : " + mem.getName() + " , 消費總金額  : " + totalAmount);
        }
      }
    }
  }
  
  private void swap (String[] concatData , int index , int changeIndex){
    String temp = concatData[index];
    concatData[index] = concatData[changeIndex];
    concatData[changeIndex] = temp;
  }
  
  private void printLowCostOrder(){
    System.out.println("printLowCostOrder");
    // 利用逗點，串聯資料
    // ex : 會員編號,總金額
    String[] concatData = this.concatData();
    // 進行排序
    for(int index = 0 ; index < concatData.length-1 ; index++){
      for(int tag = 1 ; tag < concatData.length ; tag++){
        if(Integer.parseInt(concatData[index].split(",")[1]) 
           >
           Integer.parseInt(concatData[tag].split(",")[1]) ){
          swap(concatData , index , tag);
        }
      }
    }
    this.printOrderAmount(concatData);
    System.out.println("---------------");
  }
}

class GenOrderInfoData{
  public Map<String , OrderInfo> initOrderInfoMapData(){
    Map<String , OrderInfo> infos = new HashMap<String , OrderInfo>();
    infos.put("O001", new OrderInfo("O001","C1","衣服",789));
    infos.put("O002", new OrderInfo("O002","C1","3C",1999));
    infos.put("O003", new OrderInfo("O003","C2","遊戲",1899));
    infos.put("O004", new OrderInfo("O004","C2","保養品",3300));
    infos.put("O005", new OrderInfo("O005","C3","攝影機",14999));
    return infos;
  }
  
  public List<OrderInfo> initOrderInfoListData(){
    List<OrderInfo> infos = new ArrayList<OrderInfo>();
    infos.add(new OrderInfo("O001","C1","衣服",789));
    infos.add(new OrderInfo("O002","C1","3C",1999));
    infos.add(new OrderInfo("O003","C2","遊戲",1899));
    infos.add(new OrderInfo("O004","C2","保養品",3300));
    infos.add(new OrderInfo("O005","C3","攝影機",14999));
    return infos;
  }
}

// 訂單資料
class OrderInfo{
  private String orderNo;
  private String no;
  private String orderDesc;
  private int amount;
  public OrderInfo(String orderNo , String no , String orderDesc , int amount){
    setOrderNo(orderNo);
    setNo(no);
    setOrderDesc(orderDesc);
    setAmount(amount);
  }
  public String getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }
  public String getNo() {
    return no;
  }
  public void setNo(String no) {
    this.no = no;
  }
  public String getOrderDesc() {
    return orderDesc;
  }
  public void setOrderDesc(String orderDesc) {
    this.orderDesc = orderDesc;
  }
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }
}

