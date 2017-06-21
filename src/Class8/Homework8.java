package Class8;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    List<RaceResult> raceResults = new ArrayList<RaceResult>();
    List<Race> races = new ArrayList<Race>();
    List<Thread> threads = new ArrayList<Thread>();
    int timer = 10000;
    for(int index = 0 ; index < timer ;index ++){
      raceResults.add(new RaceResult());
    }
    for(int index = 0 ; index < timer ;index ++){
      races.add(new Race(raceResults.get(index)));
    }
    for(int index = 0 ; index < races.size() ;index ++){
      threads.add(new Thread(races.get(index)));
    }
    // 比賽開始
    for(int index = 0 ; index < threads.size() ;index ++){
      threads.get(index).start();
    }
    
    // 等待全部Thread 結束
    int allRaces = timer;
    int finishRaces = 0;
    boolean stop = false;
    while(!stop){
      for(int index = 0 ; index < threads.size() ; index++){
        if(races.get(index).isStop()){
          threads.get(index).interrupt();
          finishRaces = finishRaces + 1;
        } else {
          try{
            Thread.sleep(1000);
          } catch (Exception e){
            e.printStackTrace();
          }
        }
      }
      if(finishRaces > allRaces){
        stop = true;
      }
    }
    
    // 設定性名
    List<Animal> animals = new Animals().init();
    Map<String , Integer> summary= new HashMap<String , Integer>();
    for(int index = 0 ; index < animals.size() ; index ++){
      summary.put(animals.get(index).getName() , 0);
    }
    int count =  0 ;
    for(RaceResult raceResult : raceResults){
      for(int index = 0 ; index < animals.size() ; index ++){
        count ++ ;
        System.out.println("count = " + count + " , index = " + index  + " , "+ raceResult.getWinner());
        if(raceResult.getWinner().equals(animals.get(index).getName())){
          summary.put(animals.get(index).getName() , summary.get(animals.get(index).getName()) + 1);
        }
      }
    }
    for(String name :summary.keySet()){
      System.out.println(name + " , 贏了 : " + summary.get(name));
    }
    
  }
  
}

class RaceResult {
  
  private String winner;

  public String getWinner() {
    return winner;
  }

  public void setWinner(String winner) {
    this.winner = winner;
  }
  
}

class Race implements Runnable {

  private RaceResult raceResult;
  private volatile boolean isStop;
  public Race(RaceResult raceResult){
    this.raceResult = raceResult;
    this.isStop = false;
  }
  @Override
  public void run() {
    // 準備賽跑的動物們
    List<Animal> animals = new Animals().init();
    List<AnimalRun> animalRuns = new ArrayList<AnimalRun>();
    List<Thread> threads = new ArrayList<Thread>();
    for(int index = 0 ; index < animals.size() ;index ++){
      animalRuns.add(new AnimalRun(animals.get(index)));
    }
    for(int index = 0 ; index < animals.size() ;index ++){
      animalRuns.add(new AnimalRun(animals.get(index)));
      threads.add(new Thread(animalRuns.get(index)));
    }
    // 比賽結束開始
    for(int index = 0 ; index < animals.size() ;index ++){
      threads.get(index).start();
    }
    // 等待全部Thread 結束
    int allRacer = animals.size();
    int finishRacer = 0;
    boolean stop = false;
    while(!stop){
      for(int index = 0 ; index < threads.size() ; index++){
        if(animalRuns.get(index).isStop()){
          threads.get(index).interrupt();
          finishRacer = finishRacer + 1;
        } else {
          try{
            Thread.sleep(1000);
          } catch (Exception e){
            e.printStackTrace();
          }
        }
      }
      if(finishRacer > allRacer){
        stop = true;
      }
    }
    
    // 印出最後的比賽結果
    for(int index = 0 ; index < animals.size() ; index ++){
      System.out.println(animals.get(index).getName() + 
                         " , runTotalTime : "+animals.get(index).getRunTotalTime() + 
                         " , relaxTotalTime : "+animals.get(index).getRelaxTotalTime() + 
                         " , totalTime : "+animals.get(index).getTotalTime());
    }
    
    // 找出最後贏家
    for(int index = 0 ; index < animals.size() ; index ++){
      for(int tag = index ; tag < animals.size() ; tag ++){
        if(animals.get(tag).getTotalTime() < animals.get(index).getTotalTime()){
          raceResult.setWinner(animals.get(tag).getName());
        }
      }
    }
    System.out.println("贏家:"+raceResult.getWinner());
    this.isStop = true;
    Thread.currentThread().interrupt();
  }
  public boolean isStop(){
    return isStop;
  }
  
}

class Animals {
  public List<Animal> init(){
    List<Animal> animals = new ArrayList<Animal>();
    animals.add(new Animal("烏龜"  , 1.0 , 350 , 550 ,10));
    animals.add(new Animal("小豬"  , 2.0 , 350 , 3500 ,10));
    animals.add(new Animal("兔子"  , 3.0 , 2600 , 4000 ,10));
    return animals;
  }
}

class Animal {
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
    this.totalTime = 0;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getSpeed() {
    return speed;
  }
  public void setSpeed(double speed) {
    this.speed = speed;
  }
  public double getAvgSpeed() {
    return avgSpeed;
  }
  public void setAvgSpeed(double avgSpeed) {
    this.avgSpeed = avgSpeed;
  }
  public int getSleepMinTime() {
    return sleepMinTime;
  }
  public void setSleepMinTime(int sleepMinTime) {
    this.sleepMinTime = sleepMinTime;
  }
  public int getSleepMaxTime() {
    return sleepMaxTime;
  }
  public void setSleepMaxTime(int sleepMaxTime) {
    this.sleepMaxTime = sleepMaxTime;
  }
  public double getTrack() {
    return track;
  }
  public void setTrack(double track) {
    this.track = track;
  }
  public double getRunTotalTime() {
    return runTotalTime;
  }
  public void setRunTotalTime(double runTotalTime) {
    this.runTotalTime = runTotalTime;
  }
  public double getRelaxTotalTime() {
    return relaxTotalTime;
  }
  public void setRelaxTotalTime(double relaxTotalTime) {
    this.relaxTotalTime = relaxTotalTime;
  }
  public double getTotalTime() {
    return totalTime;
  }
  public void setTotalTime(double totalTime) {
    this.totalTime = totalTime;
  }
  
}

class AnimalRun implements Runnable{
  private Animal animal;
  private volatile boolean stopped = false;
  public AnimalRun(Animal animal){
    this.animal = animal;
  }
  public void run(){
    try{
      while(!stopped){
        double lastTrack = this.animal.getTrack();
        long sleepTime = 0;
        while (lastTrack > 0){
          boolean isSleep = true;
          // 因為速度是持續跑，所以要區分前進1m花了多少秒
          // 假設速度 3 m/s , 每前進1 m 花費0.333秒
          for(int index = 0 ; index < this.animal.getSpeed() ; index++){
            lastTrack = lastTrack - 1;
            this.animal.setRunTotalTime(this.animal.getRunTotalTime() + this.animal.getAvgSpeed() * 1000);
            if(lastTrack <= 0){
              // 跑完了
              isSleep = false;
              break;
            }
          }
          if(isSleep){
            sleepTime = ThreadLocalRandom.current().nextInt(this.animal.getSleepMinTime(),this.animal.getSleepMaxTime());
            this.animal.setRelaxTotalTime(this.animal.getRelaxTotalTime() + sleepTime);
            System.out.println(this.animal.getName()+" , 平均每公尺需要 : "+ this.animal.getAvgSpeed() +"s , 目前跑了 " + 
                                    (this.animal.getTrack() - lastTrack) + "m" + 
                                    " , 計時:" + ((this.animal.getRunTotalTime()+this.animal.getRelaxTotalTime())/1000.0) + "s" + 
                                    " , 休息:"+ (sleepTime /1000.0) +"s");
          }
        }
        this.animal.setTotalTime(this.animal.getRunTotalTime() + this.animal.getRelaxTotalTime()) ;
        System.out.println(this.animal.getName() + "跑完了!! ,  總共花了:" + (this.animal.getTotalTime() / 1000.0) + "s");
        stop();
        Thread.currentThread().interrupt();
      }
    } catch(Exception e){
      e.printStackTrace();
    }
  }
  public void stop(){
    this.stopped = true;
  }
  public boolean isStop(){
    return this.stopped;
  }
}

