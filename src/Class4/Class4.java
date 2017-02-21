package Class4;

import java.util.Random;
import java.util.Scanner;

public class Class4 {
  public static void main(String[] args) {
    new MySwapNum().swapNumber(100, 10);
    new MyOtherIfElse().isDivide2(2);
    new MyOtherIfElse().isDivide235(31);
    
    
//    new MySystemIn().whileInput();
    
    System.out.println("MyNumberSwtichCase");
    new MySwtichCase().MyNumberSwtichCase(1);
    new MySwtichCase().MyNumberSwtichCase(0);
    new MySwtichCase().MyNumberSwtichCase(3);
    new MySwtichCase().MyStringSwitchCase("QQ");
    new MySwtichCase().MyStringSwitchCase("Tom");
    System.out.println("MyRandom");
    new MyRandom().random(30);
  }
}

// 交換
class MySwapNum{
  public void swapNumber(int headNum , int footNum){
    System.out.println("交換前 : " + headNum + " , " + footNum);
    int temp = headNum;
    headNum = footNum;
    footNum = temp;
    System.out.println("交換後 : " + headNum + " , " + footNum);
  }
}


/**
 * 三元運算其實就是if else，只是寫成一行的敘述而已
 * 條件式(true) ? 結果為真對應處理 : 結果為假的對應處理
 */
class MyOtherIfElse {
  public void isDivide2(int num){
    System.out.println("num = " + num +" , 是否可被2整除? " + (num % 2 == 0 ? true : false) );
  }
  
  public void isTom(String str){
    System.out.println("Name is " + str +". is Tom ? " + ("Tom".equals(str) ? true : false) );
  }
  
  // 練習，傳入一個數字，回傳是否可以被 2 3 5整除，請使用三元運算
  public void isDivide235(int num){
    System.out.println("num = " + num +" , 是否可被2 3 5整除? " + (num % 2 == 0  && num % 3 == 0  && num % 5 == 0 ? true : false) );
  }
  
}

/**
 * <pre>
 * 使用者輸入
 * 我們可以用內建System.in
 * 看使用者輸入了什麼內容
 * 做對應的處理 
 * </pre>
 */
class MySystemIn {
  public void input(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please input your name: ");
    System.out.printf("Hello! %s!", scanner.next());
  }
  
  // 練習 請使用While無窮迴圈，讓使用者持續輸入文字，直到輸入0，結束程式
  public void whileInput(){
    Scanner scanner = new Scanner(System.in);
    // 當作一個flag
    boolean flag = true;
    while(flag){
      System.out.print("Please input your number: ");
      String s = scanner.next();
      System.out.printf("Hello! %s \n!", s);
      if("0".equals(s)){
        flag = false;
      }
    }
  }
  
}

/**
 * Switch Case類似於if else
 * 可以接收數字，字元，字串，進行處理 
 * 每一種情況可以使用CASE當作案例發生時
 * 處理以下內容，最後記得一定要使用break不在判斷下去
 * 若是都沒有成立的條件時
 * 可以寫default 預設值，代表預設值要處理什麼
 */
class MySwtichCase {
  public void MyNumberSwtichCase(int num){
    switch (num) {
      case 0:
        System.out.println("Hello world");
        break;
      default:
        System.out.println("WTF??");
        break;
    }
  }
  
  public void MyStringSwitchCase(String str){
    switch (str) {
      case "Tom":
        System.out.println("WelCome Back Admin , " + str);
        break;
      default:
        System.out.println("Hi , " + str);
        break;
    }
  }
}

/**
 * Random是Java內建亂數產生器
 * ran.nextInt 意旨產生範圍0~? 的正整數
 * 若是要從1開始，記得要加1
 */
class MyRandom {
  public void random(int size){
    Random ran = new Random();
    String str = "";
    for (int i = 1; i < size; i++) {
      str += Integer.toString(ran.nextInt(size)+1);
      if(i<size-1){
        str += ",";
      }
    }
    System.out.println(str);
  }
}


class MyBreakContinue{
  public void test1(){
    for(int i = 0 ; i < 10 ; i++){
      if(i % 2 == 0){
        continue;
      }
      if(i%7 == 0){
        break;
      }
      System.out.println(" i = " + i );
    }
  }
}