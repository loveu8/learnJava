package Class8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Class8 {
  public static void main(String[] args) {
    // 列舉
//    System.out.println(Month.one);
//    Hellworld helloWorld = Hellworld.un;
//    ChooseMonth.un.ChooseMonth();
    
    // 例外捕捉
    new MyTryCatch().exec();
    
    // Thread
//    new MyThread().doNormal();
//    new MyThread().doTheadJoin();
//    new MyThread().doList();
  }
}



/**
 * <pre>
 * 列舉2
 * 
 * 這是一個特別的寫法
 * 我們可以用列舉的特性
 * 產生一個物件來使用
 * 優點是，在某些場合下
 * 可以確保產生的物件只會有一個
 * 
 * </pre>
 */
enum Hellworld {
  un;
  Hellworld(){
    System.out.println("HelleWorld");
  }
}

/**
 * 列舉3
 * 使用在switch case
 */
enum ChooseMonth {
  un;
  private ChooseMonth(){
  }
  public void ChooseMonth(){
    Month chooseMonth = Month.one;
    switch (chooseMonth) {
      case one:
        System.out.println("1月");
        break;
      case two:
        System.out.println("2月");
        break;  
      case three:
        System.out.println("3月");
        break;
      case four:
        System.out.println("4月");
        break;
      case five:
        System.out.println("5月");
        break;
      case six:
        System.out.println("6月");
        break;  
      case seven:
        System.out.println("7月");
        break;
      case eight:
        System.out.println("8月");
        break;
      case nine:
        System.out.println("9月");
        break;
      case ten:
        System.out.println("10月");
        break;  
      case eleven:
        System.out.println("11月");
        break;
      case twelve:
        System.out.println("12月");
        break;
      default:
          
    }
  }
}


/**
 * <pre>
 *  例外捕捉
 *  程式執行，若是出現
 *  可能會無法掌控出錯的時候時
 *  請務必使用try catch做處理
 *  以免程式中斷後，無法執行
 * </pre>
 */
class MyTryCatch{
  public void exec(){
    try{
      System.out.println("執行方法 => EmptyClass qq = null ");
      EmptyClass qq = null;
      qq.name="";
    } catch (Exception e){
      // Exception 是所有錯誤事件的Object一般
      // 所有錯誤事件都繼承來至於 Exception
      e.printStackTrace();
      System.out.println("發生錯誤，捕捉!!");
    } finally {
      // try catch機制下
      // 可以使用finally機制作為最後的處理
      // 若使用到他，可以做一些收尾的動作
      System.out.println("收尾~");
    }
  }
}

class EmptyClass{
  public String name;
}


/**
 * <pre>
 * Thread 執行緒
 * 事情，總是做不完
 * 做不完的時候，就需要人幫忙Share工作
 * 各自分攤自己要完成的責任
 * 大家各自完成自己的事件
 * 發揮短時間內，最快完成的目標
 * 
 * 基本方法有
 * run()        執行
 * getName()    目前執行緒的名稱
 * getState()   目前執行緒的狀態
 * join()       等待上一個執行續完成後，再做事
 * interrupt()  每個Thread必定實作中斷方法
 *              若執行完後，請勿閉關閉他
 *              記憶體會爆炸給你看
 * 
 * </pre>
 */
class MyThread {

  // 最簡單的基本執行緒
  public void doNormal(){
    GoGo t1 = new GoGo();
    GoGo t2 = new GoGo();
    t1.setName("T1");
    t1.setName("T2");
    t1.start();
    t2.start();
    // 取得目前執行緒數量
    System.out.println(Thread.activeCount()); 
  }
  
  // Thread join 範例
  public void doTheadJoin(){

    System.out.println("Thread A 執行");

    Thread threadB = new Thread(new Runnable() {
      public void run() {
        try {
          System.out.println("Thread B 開始..");
          for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Thread B 執行..");
          }
          System.out.println("Thread B 即將結束..");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    threadB.start();

    try {
      // Thread B 加入 Thread A
      threadB.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Thread A 執行");

  }
  
  // 多Thread 簡單範例
  public void doList(){
    List<GoGo> gogoLand = new ArrayList<GoGo>();
    // 我新增10個Thread到List裡面
    for(int index = 0 ; index < 10 ; index++){
      GoGo go = new GoGo();
      go.setName("Thread : " + Integer.toString(index+1));
      gogoLand.add(go);
    }
    // 我啟動10個Thread
    for(GoGo go : gogoLand){
      // start的時候，會去呼叫run方法，執行一些處理
      go.start();
      System.out.println("start => " + go.getName()  + " , status : " + go.getState());
    }
    // 取得目前執行緒數量
    System.out.println("runing number = " + Thread.activeCount()); 
    System.out.println("----------------------------");
    for(GoGo go : gogoLand){
      go.interrupt();
      System.out.println(go.getName()  + " , status : " + go.getState());
    }
    System.out.println("runing end number = " + Thread.activeCount()); 
  }
  
}

// 基本Thread 
class GoGo extends Thread {
  // 必定實作run方法，代表要執行的動作
  public void run() {
    // 做一些事情唷
    try {
      int sleepTime = new Random().nextInt(2000)+1;
      System.out.println(Thread.currentThread().getName() + " , 休息:" + sleepTime + "ms");
      // 內建自動等候機制，單位是千毫秒
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  } 
  @Override
  // 養成良好習慣，完成後要結束他
  public void interrupt() {
    super.interrupt();
  }
}