package Class4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
  public static void main(String[] args) {
    System.out.println("-----");
    new Q4_1().sortSmallToBig();
    new Q4_1().sortBigToSmall();
    System.out.println("-----");
    new Q4_2().compute();
    System.out.println("-----");
    new Q4_3().printYearOfDay(2007,2017);
    System.out.println("-----");
    new Q4_4().guessNumber(100);
  }
}


/**
 * <pre>
 * 有一個整數陣列，請幫我完成由大到小排序與小到大排序
 * { 100 , 10 , 7 , 78 , 87 , 45 , 32 , 11 , 10}
 * </pre>
 */
class Q4_1 {
  
  int[] number = {100 , 10 , 7 , 78 , 87 , 45 , 32 , 11 , 10};
  
  public void sortSmallToBig(){
    System.out.println("由小到大排序前");
    this.print();
    System.out.println("排序後");
    this.sortNumberSmallToBig();
    this.print();
    System.out.println();
  }
  
  public void sortBigToSmall(){
    System.out.println("由大到小排序前");
    this.print();
    System.out.println("排序後");
    this.sortNumberBigToSmall();
    this.print();
    System.out.println();
  }
  
  public void print(){
    for (int i = 0; i < number.length; i++) {
      System.out.print(number[i]);
      if(i < number.length-1){
        System.out.print(",");
      }
    }
    System.out.print("\n");
  }
  
  public void sortNumberSmallToBig(){
    for(int i = 0; i < number.length - 1 ; i++){
      for (int j = 1 ; j < number.length; j++) {
        if(number[j-1]>number[j]){
          swap(j-1,j);
        }
      }
    }
  }
  
  public void sortNumberBigToSmall(){
    for(int i = 0; i < number.length - 1 ; i++){
      for (int j = 1 ; j < number.length; j++) {
        if(number[j-1]<number[j]){
          swap(j-1,j);
        }
      }
    }
  }
  
  public void swap(int beforeIndex , int afterIndex){
    int temp = number[afterIndex];
    number[afterIndex] = number[beforeIndex];
    number[beforeIndex] = temp;
  }
  
}


/**
 * <pre>
 * 讓使用者輸入兩個數字
 * 並讓使用者選擇要使用 加減乘除 的功能
 * Hint: 必須使用到system.in 與 switch case
 * </pre>
 */
class Q4_2 {
  public void compute(){
    boolean flag = true;
    double numberOne = 0;
    double numberTwo = 0;
    char doMath = '\0';
    
    while(flag){
      System.out.println("請輸入兩個數字，並選擇要執行的加減乘除動作，會幫您進行運算");
      Scanner scanner = new Scanner(System.in);
      System.out.print("請輸入第一個數字:");
      numberOne = Double.parseDouble(scanner.next());
      System.out.println("第一個數字:"+numberOne);
      System.out.print("\n請輸入第二個數字:");
      numberTwo = Double.parseDouble(scanner.next());
      System.out.println("第二個數字:"+numberTwo);
      System.out.println("\n請輸入要運算的符號 +(加) , -(減) , *(乘法) , /(除)");
      System.out.print("符號:");
      doMath = scanner.next().toCharArray()[0];
      System.out.println();
      switch(doMath){
        case '+':
          System.out.println("您選了加法 , "+numberOne + "+" + numberTwo + " = " + (numberOne + numberTwo));
          break;
        case '-':
          System.out.println("您選了減法 , "+numberOne + "-" + numberTwo + " = " + (numberOne - numberTwo));
          break;
        case '*':
          System.out.println("您選了乘法 , "+numberOne + "*" + numberTwo + " = " + (numberOne * numberTwo));
          break;
        case '/':
          System.out.println("您選了除法 , "+numberOne + "/" + numberTwo + " = " + (numberOne / numberTwo));
          break;
        default:
          System.out.println("輸入錯誤的符號，請重新開始");
          break;
      }
      System.out.println("是否要繼續執行?，若要取消請輸入N。繼續執行按下任意鍵，Enter後繼續。");
      System.out.print("請輸入:");
      if("N".equals(scanner.next())){
        System.out.println("運算結束，掰掰");
        flag = false;
      }
      System.out.println();
    } // end while
  }
}


/**
 * <pre>
 * 
 * 使用  array
 * 印出 2007~2017 的年月日  
 * 
 * ex :
 * 2017
 * 1月
 * 1,2,3,4,....,31
 * 2月 
 * 1,2,3,....,29
 * 
 * Hint:建議初始化陣列平年與閏年每月的天數
 * 
 * </pre>
 */
class Q4_3 {
  
  int[] normalYear = {31,28,31,30,31,30,31,31,30,31,30,31};
  int[] leapYear = {31,29,31,30,31,30,31,31,30,31,30,31};
  String[] chineseMonth = {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
  
  public void printYearOfDay(int startYear , int endYear){
    int[] yearArray = this.initYears(startYear, endYear);
    this.printYearOfDay(yearArray);
  } // end printYearOfDay
  
  // 送入開始年份與結束年份，產出對應的年份陣列
  // index = 0 , 1900 ...
  // index = 1 , 1901 ...
  // ...
  // index = ? , 2017 ...
  private int[] initYears(int startYear , int endYear){
    int size = endYear - startYear + 1 ;
    int[] years = new int[size];
    int index = 0 ;
    for(int countYear = startYear ; countYear <= endYear ; countYear++){
      years[index] = countYear;
      index ++;
    } // end countYear
    return years;
  } // end initYears
  
  // 印出每一年的月份的天數
  private void printYearOfDay(int[] yearArray){
    for(int index = 0 ; index < yearArray.length ; index++){
      int[] months = findMonthOfDay(yearArray[index]);
      System.out.println(+yearArray[index]+"年");
      for(int month = 0 ; month< months.length ; month ++){
        System.out.println(chineseMonth[month]);
        for(int day = 1 ; day < months[month]+1; day++){
          System.out.print(day);
          if(day<months[month]){
            System.out.print(",");
          }
        } // end day
        System.out.println();
      } // end month
      System.out.println();
    } // end yearArray
  } // end printYearOfDay
    
  // 找出那一年，每月有幾天
  public int[] findMonthOfDay(int year){
    return isLeap(year) ? leapYear : normalYear;
  } // end findMonthOfDay
  
  // 閏年判斷
  public boolean isLeap(int year){
    return (year % 400 == 0) || (year % 4 == 0 && !(year % 100 ==0));
  } // end isLeap
  
}


/**
 * <pre>
 * 這是一個小遊戲請使用者猜測1~100
 * 請使用者每次輸入100內的數字
 * 每次輸入完，需要印出輸入過的數字
 * 以及這個數字的在某個區間範圍內
 * 直到使用者猜到那個數字，程式停止
 * Hint : 使用While迴圈，並使用break機制中斷
 * </pre>
 */
class Q4_4 {
  
  public void guessNumber(int size){
    int answer = new Random().nextInt(size) + 1;
    int topNumber = 1 ;
    int endNumber = size;
    int guessNumber = 0;
    String guessNumberStr="";
    int countGuessTime = 0;
    System.out.println("終極密碼開始，請你們猜測1~"+size+"範圍內的數字，若猜中，會停止遊戲~");
    
    while(true){
  
      Scanner scanner = new Scanner(System.in);
      System.out.print("請輸入猜測的數字:");
      guessNumber = Integer.parseInt(scanner.next());
      
      // 判斷輸入的數字是否超過範圍，超過範圍，使用者需要重新輸入
      if(guessNumber < topNumber || guessNumber > endNumber){
        System.out.println("你輸入超過範圍的數字，請輸入這個範圍內的數字，" + topNumber + "~" + endNumber);
        System.out.println("----------------------");
        continue;
      }
      
      guessNumberStr = guessNumberStr + guessNumber;
      countGuessTime++;
      
      // 若猜中終極密碼結束
      if(guessNumber == answer){
        System.out.println("我們在第 " + countGuessTime + " 次，猜中終極密碼 : " + answer);
        System.out.println("總共猜測了這些數字 = " + guessNumberStr);
        break;
      }
      guessNumberStr = guessNumberStr + ",";
      
      // 根據數字，設定範圍數字
      if(guessNumber > answer){
        // answer = 30
        // guess  = 40
        // range  = 1~ 40
        endNumber = guessNumber;
      } else {
        // answer = 30
        // guess  = 10
        // range  = 10 ~ 100
        topNumber = guessNumber;
      }
      
      System.out.println("已猜測數字 = " + guessNumberStr + " 猜了 " +countGuessTime+ "次");
      System.out.println("沒有猜中，數字範圍在 " + topNumber + "~" + endNumber);
      System.out.println("----------------------");
    }
        
  }// end guessNumber
  
}












