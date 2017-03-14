package Class5.linda;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HW5 {
  public static void main(String[] args) {
    Q5_1 q5_1 = new Q5_1();
    q5_1.replace();
    q5_1.replace2();
    Q5_2 q5_2 = new Q5_2();
    q5_2.date20180401();
    Q5_3 q5_3 = new Q5_3();
    q5_3.calendar2017();
    Q5_4 q5_4 = new Q5_4();
    q5_4.bigDecimal();

  }

}


class Q5_1 {
  public void replace() {
    String aaa = "I have a pen.";
    System.out.println(aaa.replace("pen", "apple"));
    StringBuffer stringBuffer = new StringBuffer("I have a pen.");
    System.out.println(stringBuffer.replace(stringBuffer.indexOf("p"),
        stringBuffer.indexOf("n") + 1, "apple"));
    StringBuilder stringBuilder = new StringBuilder("I have a pen.");
    System.out.println(stringBuilder.replace(stringBuilder.indexOf("p"),
        stringBuilder.indexOf("n") + 1, "apple"));
  }

  public void replace2() {
    String aaa = "I have a pen.";
    System.out.println(aaa + aaa.replace("pen", "apple"));
    StringBuffer stringBuffer = new StringBuffer("I have a pen.");
    StringBuffer stringBuffer1 = new StringBuffer(stringBuffer);
    stringBuffer1.replace(stringBuffer1.indexOf("p"), stringBuffer1.indexOf("n") + 1, "apple");
    System.out.println(stringBuffer.append(stringBuffer1));
    StringBuilder stringBuilder = new StringBuilder("I have a pen.");
    StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
    stringBuilder1.replace(stringBuilder1.indexOf("p"), stringBuilder1.indexOf("n") + 1, "apple");
    System.out.println(stringBuilder.append(stringBuilder1));
  }
}


class Q5_2 {
  public void date20180401() {
    Calendar c = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    c.set(2018, Calendar.APRIL, 1);
    int d = c.get(Calendar.DAY_OF_WEEK);
    // System.out.println(c);
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH) + 1;
    int day = c.get(Calendar.DAY_OF_MONTH);
    int year1 = now.get(Calendar.YEAR);
    int month1 = now.get(Calendar.MONTH) + 1;
    int day1 = now.get(Calendar.DAY_OF_MONTH);
    switch (d) {
      case 1:
        System.out.println(year + "年" + month + "月" + day + "日是" + "星期天");
        break;
      case 2:
        System.out.println(year + "年" + month + "月" + day + "日是" + "星期一");
        break;
      case 3:
        System.out.println(year + "年" + month + "月" + day + "日是" + "星期二");
        break;
      case 4:
        System.out.println(year + "年" + month + "月" + day + "日是" + "星期三");
        break;
      case 5:
        System.out.println(year + "年" + month + "月" + day + "日是" + "星期四");
        break;
      case 6:
        System.out.println(year + "年" + month + "月" + day + "日是" + "星期五");
        break;
      case 7:
        System.out.println(year + "年" + month + "月" + day + "日是" + "星期六");
        break;
    }
    System.out.println(year1 + "年" + month1 + "月" + day1 + "日到" + year + "年" + month + "月" + day
        + "日差" + daysBetween(now, c) + "天");
  }

  private long daysBetween(Calendar begin, Calendar end) {
    long daysBetween = 0;
    while (begin.before(end)) {
      begin.add(Calendar.DAY_OF_MONTH, 1);
      daysBetween++;
    }
    return daysBetween;
  }
}


class Q5_3 {
  public void calendar2017() {
    int a = 2017;
    for (int b = 1; b <= 12; b++) {
      System.out.println();
      System.out.println(a + "年" + b + "月");
      System.out.println("日   一   二   三   四   五   六");
      Calendar cal = new GregorianCalendar(a, b - 1, 1);
      int day = cal.getActualMaximum(Calendar.DATE);
      int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
      int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

      for (int c = 1; c < day_of_week; c++) {
        System.out.print("\t");
      }
      for (day_of_month = 1; day_of_month <= day; day_of_month++) {
        System.out.print(day_of_month + "\t");
        if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
          System.out.println();
        }
        cal.add(Calendar.DAY_OF_MONTH, 1);

      }
    }
    System.out.println();
  }

}


class Q5_4 {
  public void bigDecimal() {
    System.out.println("請輸入第一個數字");
    Scanner scanner = new Scanner(System.in);
    BigDecimal a = scanner.nextBigDecimal();
    System.out.println("請輸入第二個數字");
    Scanner scanner1 = new Scanner(System.in);
    BigDecimal b = scanner1.nextBigDecimal();// hasnextInt()判斷是不是int
    System.out.println("請輸入運算子");
    Scanner scanner2 = new Scanner(System.in);
    String c = scanner2.next();
    switch (c) {
      case "+":
        System.out.println(a.add(b));
        break;
      case "-":
        System.out.println(a.subtract(b));
        break;
      case "*":
        System.out.println(a.multiply(b));
        break;
      case "/":
        System.out.println(a.divide(b));
        break;
    }


  }
}
