package Class5;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HomeWork5 {
  public static void main(String[] args) {
    new Q5_1().exec();
    new Q5_2().exec();
    new Q5_3().exec();
    new Q5_4().exec();
  }
}



/**
 * <pre> 
 *  使用String與StringBuffer,StringBuilder
 *  
 *  第一題
 *  有一串英文敘述是
 *  I have a pen.
 *  請幫我找到pen的字串位置把pen這個字串修改成apple
 *  變成以下例句
 *  I have a apple.
 *  
 *  第二題
 *  請幫我幫我把這兩段敘述串聯在一起
 *  I have a pen. 
 *  I have a apple.
 *  I have a pen , I have a apple.
 * </pre>
 */
class Q5_1 {
  public void exec(){
    this.doStringPartOne();
    this.doStringBufferPartOne();
    this.doStringBuilderPartOne();
    this.doStringPartTwo();
    this.doStringBufferPartTwo();
    this.doStringBuilderPartTwo();
  }
  
  private void doStringPartOne(){
    System.out.println("doStringPartOne");
    String originStr = "I have a pen.";
    System.out.println("originStr = " + originStr);
    String replaceStr = originStr.replaceAll("pen", "apple");
    System.out.println("replaceStr = " + replaceStr);
    System.out.println("-------------");
  }
  
  
  private void doStringBufferPartOne(){
    System.out.println("doStringBufferPartOne");
    StringBuffer originStr = new StringBuffer("I have a pen.");
    System.out.println("originStr = " + originStr);
    StringBuffer replaceStr = originStr.replace(originStr.indexOf("pen"), originStr.length()-1, "apple");
    System.out.println("replaceStr = " + replaceStr);
    System.out.println("-------------");
  }
  
  
  private void doStringBuilderPartOne(){
    System.out.println("doStringBuilderPartOne");
    StringBuilder originStr = new StringBuilder("I have a pen.");
    System.out.println("originStr = " + originStr);
    StringBuilder replaceStr = originStr.replace(originStr.indexOf("pen"), originStr.length()-1, "apple");
    System.out.println("replaceStr = " + replaceStr);
    System.out.println("-------------");
  }
  
  
  private void doStringPartTwo(){
    System.out.println("doStringPartTwo");
    String originStr = "I have a pen.";
    System.out.println("originStr = " + originStr);
    String replaceStr = new String(originStr).replaceAll("pen", "apple");
    System.out.println("replaceStr = " + replaceStr);
    String concatStr = originStr.replaceAll("\\.", " , ") + replaceStr;
    System.out.println("concatStr = " + concatStr);
    System.out.println("-------------");
  }
  
  
  private void doStringBufferPartTwo(){
    System.out.println("doStringBufferPartTwo");
    StringBuffer originStr = new StringBuffer("I have a pen.");
    System.out.println("originStr = " + originStr);
    StringBuffer replaceStr = new StringBuffer(originStr).replace(originStr.indexOf("pen"), originStr.length()-1, "apple");
    System.out.println("replaceStr = " + replaceStr);
    StringBuffer concatStr = originStr.replace(originStr.indexOf("."), originStr.length(), " , ").append(replaceStr);
    System.out.println("concat = " + concatStr);
    System.out.println("-------------");
  }
  
  
  private void doStringBuilderPartTwo(){
    System.out.println("doStringBuilderPartTwo");
    StringBuilder originStr = new StringBuilder("I have a pen.");
    System.out.println("originStr = " + originStr);
    StringBuilder replaceStr = new StringBuilder(originStr).replace(originStr.indexOf("pen"), originStr.length()-1, "apple");
    System.out.println("replaceStr = " + replaceStr);
    StringBuilder concatStr = originStr.replace(originStr.indexOf("."), originStr.length(), " , ").append(replaceStr);
    System.out.println("concat = " + concatStr);
    System.out.println("-------------");
  }
  
}

/**
 * <pre>
 *  使用Date物件與Calendar物件
 *  計算下一個年度2025的4/1
 *  那天是禮拜幾
 *  以及離現在還有多少天
 * </pre>
 */
class Q5_2 {
  
  public void exec(){
    Calendar calendar = this.setTime(2018,3,1);
    System.out.println(this.format(calendar));
    this.dayBtween(calendar);
  }
  
  private Calendar setTime(int year , int month , int day){
    Calendar c = Calendar.getInstance();
    c.set(year, month, day);
    return c;
  }
  
  // calendar可以轉型成date
  // 並使用SimpleDateFormat
  // 進行時間的格式化
  private String format(Calendar calendar){
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss.SSS");
    Date date = calendar.getTime();
    return df.format(date);
  }
  
  public void dayBtween(Calendar calendar){
    Calendar now = Calendar.getInstance();
    System.out.println("相差 " + daysBetweenCount(now , calendar) + " 天");
  }
  
  private long daysBetweenCount(Calendar begin, Calendar end) {
    Calendar calendar = (Calendar) begin.clone(); // 複製
    long daysBetween = 0;
    while(calendar.before(end)) {
      calendar.add(Calendar.DAY_OF_MONTH, 1);
      daysBetween++;
    }
    return daysBetween;
  }
}

/**
 * <pre>
 *  使用Calendar物件
 *  實作出2017年的日曆表
 *  EX :
 *  2017 3月
 *  日 ㄧ 二  三  四  五  六
 *             1   2   3   4
 *   5  6  7   8   9  10  11
 *   .......................
 *   .................31
 * </pre>
 */
class Q5_3 {
  public void exec(){
    printlnCalendar(2017);
  }
  
  private void printlnCalendar(int year){
    System.out.println("--------------------------");
    Calendar now = Calendar.getInstance();
    now.set(Calendar.YEAR , year);
    now.set(Calendar.MONTH , 0);
    now.set(Calendar.DATE , 1);
    for(int index = 0 ; index < 12 ; index ++){
      System.out.println(now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH) + 1 ) + "月");
      System.out.println("日\tㄧ\t二\t三\t四\t五\t六");
      int theMonth = now.get(Calendar.MONTH) ;
      
      int spaceCount = now.get(Calendar.DAY_OF_WEEK);
      for(int tag = 0 ; tag < spaceCount - 1 ; tag++){
        System.out.print("\t");
      }
      
      while(true){
        System.out.print((now.get(Calendar.DATE) <10  ? " " + now.get(Calendar.DATE) :  now.get(Calendar.DATE) )+ "\t");
        now.add(Calendar.DATE, 1);
        if(theMonth!= now.get(Calendar.MONTH)){
          System.out.println();
          break;
        }
        if(now.get(Calendar.DAY_OF_WEEK) == 1){
          System.out.print("\n");
        }
        System.out.print("");
      }
      System.out.print("----------------------\n");
    }
  }
}

/**
 * <pre> 
 *  使用BigDecimal版本
 *  讓使用者輸入兩個數字
 *  並讓使用者選擇要使用 加減乘除 的功能
 *  Hint: 必須使用到system.in 與 switch case
 * </pre>
 */
class Q5_4 {
  
  public void exec(){
    boolean flag = true;
    BigDecimal numberOne = null;
    BigDecimal numberTwo = null;
    char doMath = '\0';
    
    while(flag){
      System.out.println("請輸入兩個數字，並選擇要執行的加減乘除動作，會幫您進行運算");
      Scanner scanner = new Scanner(System.in);
      System.out.print("請輸入第一個數字:");
      if(!scanner.hasNextInt()){
        System.out.println("輸入錯誤，重新開始\n");
        continue;
      }
      numberOne = new BigDecimal(scanner.next());
      System.out.println("第一個數字:"+numberOne);
      System.out.print("\n請輸入第二個數字:");
      if(!scanner.hasNextInt()){
        System.out.println("輸入錯誤，重新開始\n");
        continue;
      }
      numberTwo = new BigDecimal(scanner.next());
      System.out.println("第二個數字:"+numberTwo);
      System.out.println("\n請輸入要運算的符號 +(加) , -(減) , *(乘法) , /(除)");
      System.out.print("符號:");
      doMath = scanner.next().charAt(0);
      if( !(doMath == '+' || doMath == '-' || doMath == '*' || doMath == '/') ){
        System.out.println("輸入符號錯誤，重新開始\n");
        continue;
      }
      System.out.println();
      switch(doMath){
        case '+':
          System.out.println("您選了加法 , "+numberOne + "+" + numberTwo + " = " + (numberOne.add(numberTwo)));
          break;
        case '-':
          System.out.println("您選了減法 , "+numberOne + "-" + numberTwo + " = " + (numberOne.subtract(numberTwo)));
          break;
        case '*':
          System.out.println("您選了乘法 , "+numberOne + "*" + numberTwo + " = " + (numberOne.multiply(numberTwo)));
          break;
        case '/':
          System.out.println("您選了除法 , "+numberOne + "/" + numberTwo + " = " + (numberOne.divide(numberTwo,5, BigDecimal.ROUND_HALF_UP)));

          break;
        default:
          System.out.println("輸入錯誤的符號，請重新開始\n");
          continue;
      }
      System.out.println("是否要繼續執行?，若要取消請輸入N。繼續執行輸入任意字，Enter後繼續。");
      System.out.print("請輸入:");
      if("N".equals(scanner.next())){
        System.out.println("運算結束，掰掰");
        flag = false;
      }
      System.out.println();
    } // end while
  }
}
