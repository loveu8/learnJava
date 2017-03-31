package Class6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HomeWork6 {
  public static void main(String[] args) {
    new Q6_1().exec();
    new Q6_2().exec();
    new Q6_3().exec();
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
 * 2.算出每位會員的平均消費金額
 *   輸出格式 => 編號 姓名 平均金額
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
  }
  private void printMemberBuy(){
    for(String no : members.keySet()){
      for(String key : infos.keySet()){
        if(no.equals(infos.get(key).getNo())){
          System.out.println("編號:" + no + ", 姓名:"+);
        }
      }
    }
  }
  private void printAvgCost(){
    
  }
  private void printHighCostOrder(){
    
  }
  private void printLowCostOrder(){
    
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
 * O002     C1        3C       1999
 * O003     C2      遊戲       1899
 * O004     C2    保養品       3300
 * O005     C3    攝影機      14999
 * 
 * 請用新增會員與訂單類別(Class)
 * 設定每位會員資料以及訂單資料後
 * 
 * 1.用會員編號找出會員買的商品
 *   輸出格式 => 編號 姓名 訂單 訂購內容 金額
 *   
 * 2.算出每位會員的平均消費金額
 *   輸出格式 => 編號 姓名 平均金額
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
  }
  private void printMemberBuy(){
    
  }
  private void printAvgCost(){
    
  }
  private void printHighCostOrder(){
    
  }
  private void printLowCostOrder(){
    
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

