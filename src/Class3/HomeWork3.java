package Class3;

import java.util.Random;

public class HomeWork3 {
  public static void main(String[] args) {
    new Q3_1().print(9);
    new Q3_1().printDot(5);
    System.out.println("---------------------");
    new Q3_2().usingFor();
    new Q3_2().usingWhile();
    System.out.println("---------------------");
    new Q3_3().printLeap();
    System.out.println("---------------------");
    new Q3_4().print();
    System.out.println("---------------------");
    new Q3_5().gneDefaultCard();
  }

}


/**
  <pre>
    3-1.請使用for迴圈，練習印出以下圖案
    *
    **
    ***
    ****
    *****
    ****
    ***
    **
    *
  </pre>
*/
class Q3_1{
  public void print(int size){
    System.out.println("q3-1:印出星星");
    // top 最高頂點 
    // ex => size: (9+1)/2 = 5
    // size 實際最大範圍
    // ex => size:9 + 1 =10
    int top = 0;
    if(size%2 != 0){
      top = (size/2+1);
      size = size + 1;
    } else {
      top = (size/2);
    }
    
    // 第一層迴圈
    for (int index = 1; index < size; index++) {
      
      // 計算要印出星星的迴圈數
      int printSize = 0;
      
      // 這邊要用來判斷，如果還沒超過頂點時，正常印出
      // ex 1 <= 5  
      if(index <= top){
        printSize = index;
      } else {
        // 若是超過頂點之後，星星數與行數相加，會等於實際大小
        // 以此類推 第二層 loop 範圍大小可以這樣判斷
        // ex Star 4 = Size 10 - Line 6  
        printSize = size - index;
      }
      
      // 第二層迴圈
      for (int tag = 0; tag < printSize ; tag++) {
        System.out.print("*");
      } // end for int tag 
      
      // 最後換行
      System.out.println();
      
    } // end for int index 
  }
  
  /**
   * 傳入最長寬度，計算出對映星星位子
   */
  public void printDot(int maxWidth) {
    int eqaulHeight = maxWidth * 2 - 1;
    for (int i = 0; i < eqaulHeight; i++) {
      if (i < maxWidth) {
        System.out.println(this.charToStrringPrint(i+1 , "*"));
      } else {
        System.out.println(this.charToStrringPrint(eqaulHeight - i , "*"));
      }
    }
  }
  
  /**
   * <pre>
   * 這是一個技巧
   * 1.先初始一個一定長度的字元陣列 
   * 2.初始完畢後，把陣列初始值會是空白更換成*號
   * \0代表一個半形空白
   * </pre>
   */
  private String charToStrringPrint(int size , String strReplace){
    return new String(new char[size]).replace("\0", strReplace);
  }
  
}


/**
   3-2. 請使用for迴圈與While迴圈，寫出99乘法表
 */
class Q3_2{
  
  public void usingFor(){
    System.out.println("q3_2 : for迴圈九九乘法表");
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        System.out.print(j + "*" + i + "=" + j*i + "\t");
      }
      System.out.println();
    }
  }
  
  public void usingWhile(){
    int i=1 , j=1;
    System.out.println("q3_2 : while迴圈九九乘法表");
    while(i<10){
      while(j<10){
        System.out.print(j + "*" + i + "=" + j*i + "\t");
        j++;
      }
      System.out.println();
      j=1; // 恢復初始值
      i++; // 印出第二行
    }
  }
}


/** 
  3-3. 請使用for迴圈，先用一個整數一維陣列儲存1900~2017年後，判斷那幾年是閏年? 
 */
class Q3_3 {
  
  public void printLeap(){
    System.out.println("q3_3 : 閏年計算");
    int[] years = this.initailYears(1900, 2017);
    for (int index = 0; index < years.length; index++) {
      boolean isLeapYear = this.isLeap(years[index]);
      System.out.println("Year:" + years[index] + " , 是閏年嗎? " + isLeapYear);
    }
  }
  
  // 送入開始年份與結束年份，產出對應的年份陣列
  // index = 0 , 1900 ...
  // index = 1 , 1901 ...
  // ...
  // index = ? , 2017 ...
  public int[] initailYears(int startYear , int endYear){
    int size = endYear - startYear + 1 ;
    int[] years = new int[size];
    int index = 0 ;
    for(int countYear = startYear ; countYear <= endYear ; countYear++){
      years[index] = countYear;
      index ++;
    }
    return years;
  }
  
  
  // 西元年分是400的倍數)或(西元年分是4的倍數但不是100的倍數)
  public boolean isLeap(int year){
//    if((year % 400 == 0) || (year % 4 == 0 && ! (year % 100 ==0))){
//      return true;
//    } else {
//      return false;
//    }
    return (year % 400 == 0) || (year % 4 == 0 && !(year % 100 ==0));
  }
  
  
}


/**
 * <pre>
 * 有三個學生，期末考結束了，公佈了三科成績，請幫我算一下各科平均分數，每個人平均分數，需要精確到小數點兩位。
 *
 *  姓名  數學    國文   英文
 *  小乖   95    80   77
 *  小忍   55    87   89
 *  小天   71    78   88
 * </pre>
 */
class Q3_4 {
  public void print() {
    System.out.println("q3_4 : 計算成績");
    Student[] students = genStudents();
    float[] avgScore = new float[students.length];
    float avgMath = 0.0f;
    float avgChinese = 0.0f;
    float avgEnglish = 0.0f;
    for(int index = 0 ; index < students.length ; index++){
      avgMath = avgMath + students[index].math;
      avgChinese = avgChinese + students[index].chinese;
      avgEnglish = avgEnglish + students[index].english;
      avgScore[index] = (students[index].math + students[index].chinese + students[index].english) / 3;
      System.out.printf("學生:"+students[index].name + " , 平均分數:%.2f \n" , avgScore[index]);
    }
    System.out.printf("數學平均:%.2f\n" , avgMath / 3);
    System.out.printf("中文平均:%.2f\n" , avgChinese / 3);
    System.out.printf("英文平均:%.2f\n" , avgEnglish / 3);
    
  }
  
  public Student[] genStudents(){
    Student[] students = new Student[3];
    // 小乖
    students[0] = new Student();
    students[0].name = "小乖";
    students[0].math = 95;
    students[0].chinese = 80;
    students[0].english = 77;
    
    // 小忍
    students[1] = new Student();
    students[1].name = "小忍";
    students[1].math = 55;
    students[1].chinese = 87;
    students[1].english = 89;
    
    // 小天
    students[2] = new Student();
    students[2].name = "小天";
    students[2].math = 71;
    students[2].chinese = 78;
    students[2].english = 88;
    
    return students;
  }
}

// 學生
class Student{
  public String name;
  public float math;
  public float chinese;
  public float english;
}


/**
 * 3-5.有一組52張撲克牌(不含鬼牌)，請幫我進行發牌動作，並且發給四個人(不重覆)。 
 */
class Q3_5 {

  /**
   * 預設花色，小到大排序
   */
  public final String cardOfColor[]  = { "梅花", "磚塊", "愛心", "黑桃" };
  
  /**
   * 預設點數，小到大排序
   */
  public final String cardOfNumber[] = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
  
  /**
   * 所有的卡片 
   */
  public final String allCards[] = new String[52];
  
  public void gneDefaultCard(){
    System.out.println("q3_5 : 洗牌");
    String[] cards = this.setCardOrder();
    System.out.println("洗牌前");
    this.printCards(cards);
    System.out.println("洗牌後");
    suffleCard(cards , 100);
    this.printCards(cards);
  }
  
  public void printCards(String[] cards){
    int count = 1;
    for(int index = 0 ; index < 52 ; index++){
      System.out.print(cards[index] + "\t");
      if(count%13==0){
        System.out.println();
      }
      count++;
    }
  }
  
  /**
   * 例:梅3 = 0、磚3 = 1，以此類推
   */
  public String[] setCardOrder(){
    //order最小點數，0開始起跳，從最小的牌開始放
    int order = 0;
    for(int cardsNum = 0 ; cardsNum < cardOfNumber.length ; cardsNum++){
      for(int colorNum = 0 ; colorNum < cardOfColor.length ; colorNum++){
        allCards[order] = cardOfColor[colorNum]+cardOfNumber[cardsNum];
        order++;
      }
    }
    return allCards;
  }
  
  /**
   * 隨機取得變數來隨意找兩張牌交換
   */
  public void suffleCard(String[] cards, int suffetTime){
    Random ran = new Random();
    for (int time = 0; time < suffetTime; time++) {
      for (int i = 0; i < 52; i++) {
        int key1 = ran.nextInt(51); // 0~51
        int key2 = ran.nextInt(51) + 1; // 1~52
        swapCard(cards, key1, key2);
      }
    }
  }
  
  public static void swapCard(String[] cards , int key1, int key2){
    String tempCard = cards[key1];
    cards[key1] = cards[key2];
    cards[key2] = tempCard;
  }
}

