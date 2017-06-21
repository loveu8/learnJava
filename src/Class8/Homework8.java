package Class8;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Homework8{
  public static void main(String[] args) {
//    new Q8_1().exec();
    new Q8_2().exec();
  }
}


/**
 * <pre>
 *  使用try catch
 *  捕捉1/0的錯誤，要顯示不可除以0
 *   捕捉類似1/3的錯誤，提示會無限循環小數，並只格式化到小數點第三位
 * </pre>
 */
class Q8_1{
  public void exec(){
    one();
    two();
  }
  public void one(){
    try{
      int i = 1;
      i = i/0;
    } catch(Exception e){
      e.printStackTrace();
      System.out.println("不可以除以0");
    }
  }
  
  public void two() {
    NumberFormat formatter = new DecimalFormat("#0.000");
    System.out.println("hi = " + formatter.format(1 / 3.0));
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
class Q8_2{
  public void exec(){
    Animal tortoise = new Animal("烏龜"  , 1.0 , 350 , 550 ,10);
    Animal pig = new Animal("小豬"  , 2.0 , 350 , 3500 ,10);
    Animal rabbit = new Animal("兔子"  , 3.0 , 2600 , 4000 ,10);
    tortoise.start();
    pig.start();
    rabbit.start();
  }
  
  class Animal extends Thread{
    private String name;
    private double speed;
    private double avgSpeed;
    private int sleepMinTime;
    private int sleepMaxTime;
    private double track;
    private double runTotalTime;
    private double relaxTotalTime;
    private double totalTime;
    public Animal(String name , double speed , int sleepMinTime , int sleepMaxTime , long track){
      this.name = name;
      this.speed = speed;
      this.avgSpeed = 1/speed;
      this.sleepMinTime = sleepMinTime;
      this.sleepMaxTime = sleepMaxTime;
      this.track = track + 1;
    }
    public void run(){
      try{
        double lastTrack = this.track;
        long sleepTime = 0;
        while (lastTrack > 0){
          boolean isSleep = true;
          // 因為速度是持續跑，所以要區分前進1m花了多少秒
          // 假設速度 3 m/s , 每前進1 m 花費0.333秒
          for(int index = 0 ; index < speed ; index++){
            lastTrack = lastTrack - 1;
            runTotalTime = runTotalTime + avgSpeed * 1000;
            if(lastTrack <= 0){
              // 跑完了
              isSleep = false;
              break;
            }
          }
          if(isSleep){
            sleepTime = ThreadLocalRandom.current().nextInt(sleepMinTime,sleepMaxTime);
            relaxTotalTime = relaxTotalTime + sleepTime;
            
            System.out.println(name+" , 平均每公尺需要 : "+ avgSpeed +"s , 目前跑了 " + (track - lastTrack) + "m" + 
                                    " , 計時:" + ((runTotalTime+relaxTotalTime)/1000.0) + "s" + 
                                    " , 休息:"+ (sleepTime /1000.0) +"s");
          }
        }
        totalTime = runTotalTime + relaxTotalTime ;
        System.out.println(name+"跑完了!! ,  總共花了:" + (totalTime / 1000.0) + "s");
      } catch(Exception e){
        e.printStackTrace();
      }
    }
    
  }
}


