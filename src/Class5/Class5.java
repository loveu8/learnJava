package Class5;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Class5 {
  public static void main(String[] args) {
//    MyStringBuffer myStringBuffer =  new MyStringBuffer();
//    myStringBuffer.testCreateSpeed();
//    myStringBuffer.testAppendSpeed();
//    myStringBuffer.testThreadBuffer();
//
//    System.out.println("--------------------");
//    System.out.println("常用字串方法");
//    // String方法 indexOf 可以出字串或字元出現的位置
//    // 若沒有出現時，會回傳-1
//    // 可以用來判斷一個字串內，是否有出現關鍵字
//    // indexOf test
//    System.out.println("X出現的位置 => " + "XXXX".indexOf("X"));
//    System.out.println("空白也可以支援 => " + "XX X".indexOf(" "));
//    System.out.println("不存在時 => " + "XX1X".indexOf("2"));
//    // replace 取代文字
//    System.out.println("XXXX".replace("X", "*"));
//    
//    
//    System.out.println("--------------------");
//    System.out.println("常用Date方法");
//    MyDate date = new MyDate();
//    date.showCommonDate();
//    date.showFormatTime();
//    
//    System.out.println("--------------------");
//    System.out.println("常用BigDecimal方法");
//    MyBigDecimal bigDecimal = new MyBigDecimal();
//    bigDecimal.showCompute("1", "2");
//    bigDecimal.trick();
//    
//    System.out.println("--------------------");
//    System.out.println("常用Calendar方法");
//    MyCalendar calendar = new MyCalendar();
//    calendar.defaultSet();
//    calendar.testBetween();
//    calendar.testBetweenTwo();
  }
}


/**
 * <pre>
 * String vs StringBuffer vs StringBuilder 差異
 * 
 * String
 * [Good]
 *  當你的字串很少變動時
 *  單純生成一個字串使用時
 *  速度會比StringBuffer與StringBuilder還快
 *  
 * [Bad] 
 *  如果當你需要對他增加或減少字串內容時
 *  在Java裡面其實都會生成一個新的String物件
 *  可是之前的內容還會存在JVM裡面
 *  如果過度增加減少，JVM本身內建GC(自動垃圾回收機制)
 *  也會被啟動，可能會導致效能低落
 *  
 * StringBuffer
 * [Good]
 *  當你的字串很經常變動時，可以考慮使用StringBuffer
 *  因為在Java生成物件時，我們對StringBuffer的物件
 *  進行增加或刪除文字，都會操作到同一個StringBuffer物件
 *  相對於Java記憶體負擔，會降低許多
 *  
 *  Java.lang.StringBuffer 為執行緒安全的可變字串. 
 *  類似於 String 的字串，但不能修改，
 *  可將字符串緩衝區安全地用於多個執行緒
 *  
 *  當我們要轉換成String物件時，只要使用toString即可轉換
 *  
 *  他是一個同步的物件，會等待每個執行緒執行完畢
 *  相對處理會比較慢
 *  
 * [Bad] 
 *  若只是單純生成一個可以使用的字串時
 *  速度會比StringBuilder與String還慢
 * 
 * StringBuilder
 * [Good] 
 *  StringBuilder相對於StringBuffer，只能在單一執行緒使用
 *  基本上操作跟StringBuffer大多一致，但是速度上會比StringBuffer
 *  許多
 *  
 * [Bad]
 *  他是一個非同步的物件，每個執行緒執行會自動自己自行
 *  但是多執行緒時，使用並不安全
 *  
 *  字串生成速度
 *  String > StringBuilder > StringBuffer
 *  
 *  經常變動，修改速度
 *  StringBuilder > StringBuffer > String
 * 
 *  多執行緒使用
 *  StringBuffer
 * 
 * </pre>
 */
class MyStringBuffer {
  
  public void testCreateSpeed(){
    int timer = 100000000;
    Date date = new Date();
    for(int index = 0 ; index < timer ; index++){
      String srting = "";
    }
    System.out.println("String 生成速度 : "+ (new Date().getTime() - date.getTime())/ 1000.0 + "s");
    Date date2 = new Date();
    for(int index = 0 ; index < timer ; index++){
      new StringBuffer("");
    }
    System.out.println("StringBuffer 生成速度 : "+ (new Date().getTime() - date2.getTime())/ 1000.0  + "s");
    Date date3 = new Date();
    for(int index = 0 ; index < timer ; index++){
      new StringBuilder("");
    }
    System.out.println("StringBuilder 生成速度 : "+ (new Date().getTime() - date3.getTime())/ 1000.0  + "s");
  }
  
  public void testAppendSpeed(){
    int timer = 10000;
    Date date = new Date();
    String srting = "";
    for(int index = 0 ; index < timer ; index++){
      srting = srting + String.valueOf(index);
    }
    System.out.println("String 增加字串，處理速度 : "+ (new Date().getTime() - date.getTime())/ 1000.0 + "s");
    Date date2 = new Date();
    StringBuffer buffer = new StringBuffer("");
    for(int index = 0 ; index < timer ; index++){
      buffer.append(index);
    }
    System.out.println("StringBuffer 增加字串，處理速度 : "+ (new Date().getTime() - date2.getTime())/ 1000.0  + "s");
    Date date3 = new Date();
    StringBuilder builder = new StringBuilder("");
    for(int index = 0 ; index < timer ; index++){
      builder.append(index);
    }
    System.out.println("StringBuilder 增加字串，處理速度 : "+ (new Date().getTime() - date3.getTime())/ 1000.0  + "s");
  }
  
  public void testThreadBuffer(){
    int timer = 10;
    Date date = new Date();
    String string = "";
    for(int index = 0 ; index < 10 ; index ++){
      new MyStringThread(string , timer).run();
    }
    System.out.println("String Thread處理速度 : "+ (new Date().getTime() - date.getTime())/ 1000.0 + "s");
    Date date2 = new Date();
    StringBuffer stringBuffer = new StringBuffer(); 
    for(int index = 0 ; index < 10 ; index ++){
      new MyStringBufferThread(stringBuffer , timer).run();
    }
    System.out.println("StringBuffer Thread處理速度 : "+ (new Date().getTime() - date2.getTime())/ 1000.0  + "s");
    Date date3 = new Date();
    StringBuilder stringBuilder = new StringBuilder("");
    for(int index = 0 ; index < 10 ; index ++){
      new MyStringBuilderThread(stringBuilder , timer).run();
    }
    System.out.println("StringBuilder Thread處理速度 : "+ (new Date().getTime() - date3.getTime())/ 1000.0  + "s");
  }
  
}

class MyStringThread extends Thread implements Runnable{
  
  private String string ;
  private int timer;
  
  public MyStringThread(String string , int timer){
    this.string = string;
    this.timer = timer;
  }
  
  public void testAppendSpeed(){
    Date date = new Date();
    for(int index = 0 ; index < timer ; index++){
      string = string + String.valueOf(index);
    }
    string = string + " | ";
    System.out.println("srting = " + string);
    terminate();
  }
  
  public void run() {
    testAppendSpeed();
  }
  
  private boolean isContinue = true;

  public void terminate() {
    isContinue = false;
    interrupt();
  } 
  
}

class MyStringBufferThread extends Thread implements Runnable{
  
  private StringBuffer buffer;
  private int timer;
  
  public MyStringBufferThread(StringBuffer buffer , int timer){
    this.buffer = buffer;
    this.timer = timer;
  }
  
  public void testAppendSpeed(){
    Date date2 = new Date();
    for(int index = 0 ; index < timer ; index++){
      buffer.append(index);
    }
    buffer.append(" | ");
    System.out.println("buffer = " + buffer);
    terminate();
  }
  public void run() {
    testAppendSpeed();
  }
  
  private boolean isContinue = true;

  public void terminate() {
    isContinue = false;
    interrupt();
  } 
  
}

class MyStringBuilderThread extends Thread implements Runnable{
  
  private StringBuilder builder;
  private int timer;
  
  public MyStringBuilderThread(StringBuilder builder , int timer){
    this.builder = builder;
    this.timer = timer;
  }
  
  public void testAppendSpeed(){
    Date date3 = new Date();
    for(int index = 0 ; index < timer ; index++){
      builder.append(index);
    }
    builder.append(" | ");
    System.out.println("builder = " + builder);
    terminate();
  }
  
  public void run() {
    testAppendSpeed();
  }
  
  private boolean isContinue = true;

  public void terminate() {
    isContinue = false;
    interrupt();
  } 
  
}

/**
 * <pre>
 * Java內建的時間物件
 * 但新版本Java很多方法被註釋不建議使用
 * 所以我們只簡單介紹一些常見的即可
 * 
 * 僅剩下列四個是常用的方法 
 *  after(Date when) : 檢查日期物件時間是否在本物件後 (true/false)   
 *  before(Date when) : 檢查日期物件時間是否在本物件前 (true/false)   
 *  getTime() : 傳回自 1970/1/1 以來之毫秒數
 *  setTime(int ms) : 將時間設定為 1970/1/1 後之毫秒數
 *  toString() : 把 Date 物件轉成字
 * </pre>
 */
class MyDate {
  public void showCommonDate(){
    Date now = new Date();                    //建立目前時間之 Date 物件
    System.out.println(now.getTime());   //輸出 1396313616224
    System.out.println(System.currentTimeMillis());  //輸出 1396313616224
    System.out.println(now.toString());   //輸出 Tue Apr 01 08:53:36 CST 2014
    Date before=new Date(1);                 //建立時間戳記為 1ms 之 Date 物件 (自 1970/1/1)
    System.out.println(before.before(now));    //輸出 true
    System.out.println(now.before(before));    //輸出 false
    System.out.println(before.after(now));     //輸出 false
    System.out.println(now.after(before));     //輸出 true
    before.setTime(4396267507921L);            //須為長整數
    System.out.println(now.after(before));     //輸出 false
  }
  
  public void showFormatTime(){
    //  直接格式化輸出現在時間的方法
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date current = new Date();
    System.out.println(sdFormat.format(current));
  }
}


/**
 * <pre>
 * 如果我們要使用於要精算數字的事務上
 * 那我們會建議來使用BigDecimal來實作功能
 * 他也有基本的加減乘除與比較的功能
 * 但是更為精確
 * </pre>
 */
class MyBigDecimal{
  
  public void showCompute(String num1 , String num2){
    System.out.println(num1 + " + " + num2 + " = " + new BigDecimal(num1).add(new BigDecimal(num2)) );
    System.out.println(num1 + " - " + num2 + " = " + new BigDecimal(num1).subtract(new BigDecimal(num2)) );
    System.out.println(num1 + " * " + num2 + " = " + new BigDecimal(num1).multiply(new BigDecimal(num2)) );
    System.out.println(num1 + " / " + num2 + " = " + new BigDecimal(num1).divide(new BigDecimal(num2)) );
    System.out.println(num1 + " = " + num2 + " = " + new BigDecimal(num1).compareTo(new BigDecimal(num2)) );
  }
  
  // 初始化陷阱
  public void trick(){
    System.out.println("1.25959 float  => " + new BigDecimal(1.25959));    
    System.out.println("1.25959 Double => " + new BigDecimal(new Double(1.25959)));
    System.out.println("1.25959 String => " + new BigDecimal("1.25959"));
  }
  
}


/**
 * <pre> 
 * Calendar
 * 是Java世界裡，操作時間的工具
 * 不同於Date
 * Calendar可以實作做加減的運算
 * 以下我們就練習吧
 * </pre>
 */
class MyCalendar {
  
  public void defaultSet(){
    Calendar c = Calendar.getInstance();
    c.set(2017, 11, 12);                       // 設定日期為2017年11月12日，
    System.out.println("初始時間:" + format(c));             // 在Calendar類別中月份的編號是由0~11

    c.set(Calendar.YEAR, 2013);                // 將年改成2013年 
    System.out.println("修改年份:" + format(c));
    
    c.set(Calendar.MONTH, Calendar.JANUARY);  // 將月份改成1月
    System.out.println("修改月份:" + format(c));
    
    c.set(Calendar.DAY_OF_MONTH , 31);         // 將日改成31日
    System.out.println("修改日期:" + format(c));
    
    // 時間是24小時制
    c.set(Calendar.HOUR_OF_DAY, 18);           // 將hour改成下午六點
    System.out.println("修改時間:" + format(c));                     
    
    c.set(Calendar.AM_PM, Calendar.PM);        // 將hour改成下午六點 
    System.out.println("修改時間:" + format(c));
    
    c.set(Calendar.HOUR, 6);
    System.out.println("修改時間:" + format(c));
    
  }
  
  // calendar可以轉型成date
  // 並使用SimpleDateFormat
  // 進行時間的格式化
  private String format(Calendar calendar){
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date date = calendar.getTime();
    return df.format(date);
  }
  
  // 時間比較陷阱
  public void testBetween(){
    Calendar birth = Calendar.getInstance();
    birth.set(1990, Calendar.MAY, 26);
    Calendar now = Calendar.getInstance();
    System.out.println(daysBetween(birth, now));
    System.out.println(daysBetween(birth, now)); // 顯示 0？
  }
  
  // 如果傳送物件型態Calendar，在這方法修改的值，都會被影響到
  private long daysBetween(Calendar begin, Calendar end) {
    long daysBetween = 0;
    while(begin.before(end)) {
        begin.add(Calendar.DAY_OF_MONTH, 1);
        daysBetween++;
    }
    return daysBetween;
  }
  
  public void testBetweenTwo(){
    Calendar birth = Calendar.getInstance();
    birth.set(1986, Calendar.FEBRUARY, 6);
    Calendar now = Calendar.getInstance();
    System.out.println(daysBetweenTwo(birth, now) + "天");
    System.out.println(daysBetweenTwo(birth, now) + "天"); 
  }
  
  private long daysBetweenTwo(Calendar begin, Calendar end) {
    Calendar calendar = (Calendar) begin.clone(); // 複製
    long daysBetween = 0;
    while(calendar.before(end)) {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        daysBetween++;
    }
    return daysBetween;
  }
  
  
}
