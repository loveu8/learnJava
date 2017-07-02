package Class8.qian;

import java.text.DecimalFormat;

public class Homework8 {
  public static void main(String[] args) {
    new Q1().exec(); 
    new Q1().exec1(); 
  }
}


/**
 * <pre>
 *  使用try catch
 *  捕捉1/0的錯誤，要顯示不可除以0
 *  捕捉類似1/3的錯誤，提示會無限循環小數，並只格式化到小數點第三位
 * </pre>
 */
class Q1 {
  public void exec() {
    

    try {

      int num1=1;
      int num2=0;
      System.out.println(num1/num2);


    } catch (Exception a) {
      a.printStackTrace();
      System.out.println("無法除0");
    }

  }
  public void exec1(){
    try {

      double num1=1.0;
      double num2=3.0;
      double sum;
     
      sum=num1/num2;
      
      DecimalFormat df = new DecimalFormat("#,###.###"); 
      System.out.println(df.format(sum));

    } catch (Exception a) {
      a.printStackTrace();
      
    }
    
  }
  
  
}

/**
 * <pre>
 *  我們要進行動物賽跑比賽
 *  目前有三個參賽者
 *  烏龜，兔子，小豬
 *  烏龜每一秒前進一公尺，每次休息0.35~0.55秒
 *  小豬每一秒前進兩公尺，每次休息0.35~3.5秒
 *  兔子每一秒前進三公尺，每次休息2.6~4秒
 *  賽道長度是100M
 *  每次比賽都是同時出發
 *  請問10000次比賽下來，誰是常勝軍
 *  
 *  Hit : 用Random產生隨機數字 1000~1500，產生出來後，
 *        就會在秒數就會在1秒~1.5秒之間，以此類推
 *        Thread.Sleep(1500)，單位是千毫秒
 * </pre>
 */
