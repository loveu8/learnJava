package Class5.lana;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HomeWork5 {
  public static void main(String[] args) {
//    new Q5_1().doMethods();
//    new Q5_2().printAns();
    new Q5_3().printCalendar();
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
  final String PEN = "I have a pen.";

  public void doMethods() {
    stringPPAP();
    stringBufferPPAP();
    stringBuilderPPAP();
  }

  public void stringPPAP() {
    System.out.println("\nSrting:");
    String str = PEN;
    int penIndex = str.indexOf("p");
    String newStr = str.substring(0, penIndex - 1) + "n apple.";
    System.out.println(PEN);
    System.out.println(newStr);
    System.out.println(str.substring(0, str.length() - 1) + ", " + newStr);
  }

  public void stringBufferPPAP() {
    System.out.println("\nStringBuffer:");
    StringBuffer sb = new StringBuffer();
    sb.append(PEN);
    System.out.println(sb);
    int penIndex = sb.indexOf("p");
    sb.replace(penIndex - 1, sb.length(), "n apple.");
    System.out.println(sb);
    sb.insert(0, ", ");
    sb.insert(0, PEN.substring(0, PEN.length() - 1));
    System.out.println(sb);
  }

  public void stringBuilderPPAP() {
    System.out.println("\nStringBuilder:");
    StringBuilder sb = new StringBuilder();
    sb.append(PEN);
    System.out.println(sb);
    int penIndex = sb.indexOf("p");
    sb.replace(penIndex - 1, sb.length(), "n apple.");
    System.out.println(sb);
    sb.insert(0, ", ");
    sb.insert(0, PEN.substring(0, PEN.length() - 1));
    System.out.println(sb);
  }
}



/**
 * <pre>
 *  使用Date物件與Calendar物件
 *  計算下一個年度的4/1
 *  那天是禮拜幾
 * </pre>
 */
class Q5_2 {
  public void printAns() {
    Calendar calendar = Calendar.getInstance();
    int thisYear = calendar.get(Calendar.YEAR);
    System.out.println(findWeekDay(thisYear+1, 4, 1));
  }
  public String findWeekDay(int year, int month, int day) {
    Calendar wantDate = new GregorianCalendar(year, month - 1, day);
    System.out.println(wantDate.getTime());
    SimpleDateFormat sdf = new SimpleDateFormat("E");
    String weekDay = sdf.format(wantDate.getTime());
    return weekDay;
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
  public void printCalendar() {
    Calendar calendar = Calendar.getInstance();
    int thisYear = calendar.get(Calendar.YEAR);
    for(int i = 1; i <= 12; i++) {
      System.out.println("\n" + thisYear + "年 " + i + "月");
      System.out.println(chtCalendarTitle());
      System.out.println(monthCalendar(thisYear, i));
    }
  }
  public String monthCalendar(int year, int month) {
    Calendar calendar = new GregorianCalendar(year, month-1, 1);
    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    int firstWeekday = calendar.get(Calendar.DAY_OF_WEEK);
    int firstSat = 7 - firstWeekday + 1;
    StringBuilder thisMonth = new StringBuilder();
    for(int j = 0; j < firstWeekday - 1; j++) {
      thisMonth.append("\t");
    }
    for(int i = 1; i <= daysInMonth; i++) {
      thisMonth.append(String.format("%2d", i)).append("\t");
      if(firstSat == 7) {
        if (i%7 == 0) {
          thisMonth.append("\n");
        }
      } else {
        if(i == firstSat || i%7 == firstSat) {
          thisMonth.append("\n");
        }
      }
    }
    return thisMonth.toString();
  }
  public String chtCalendarTitle() {
    return "日\t一\t二\t三\t四\t五\t六\t";
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

}
