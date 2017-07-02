package Class8.adv;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MutilsRun {
  public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = new LinkedList<Thread>();
    List<OutSideTwo> evens = new LinkedList<OutSideTwo>();
    for (int index = 0; index < 3; index++) {
      evens.add(new OutSideTwo());
    }
    for (int index = 0; index < 3; index++) {
      threads.add(new Thread(evens.get(index)));
    }
    for (int index = 0; index < 3; index++) {
      threads.get(index).start();
      Thread.sleep(100);
    }
    int count = 0;
    boolean isAllFinish = false;
    while (!isAllFinish) {
      for (int index = 0; index < 3; index++) {
        if (!evens.get(index).getIsFinish() && !threads.get(index).isInterrupted()) {
          evens.get(index).setIsFinish(true);
          threads.get(index).interrupt();
          count++;
        }
      }
      System.out.println("count : " + count);
      if (count == 3) {
        isAllFinish = true;
      }
    }
    System.out.println("finish all thread ,log size: " + Utils_Log.un.getAllThreadListLogsSize());
  }
}


class OutSideTwo implements Runnable {

  private boolean isFinish;

  public OutSideTwo() {
    this.isFinish = false;
  }

  public synchronized void run() {
    Utils_Log log = Utils_Log.un;
    String threadName = UUID.randomUUID() + "_" + System.currentTimeMillis();
    int test = new Random().nextInt(100);
    try {
      System.out.println(threadName + "," + log.collecLogs(threadName, test + ",OutSide ,Start"));
      new InSideTwo().inExec(threadName, test);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(threadName + "," + log.collecLogs(threadName, test + ",OutSide ,End"));
    log.removeLog(threadName);
    System.out.println(threadName + "," + test + ",all size:" + log.getAllThreadListLogsSize());
    System.out.println(threadName + "," + test + ",-----------");
  }

  public void setIsFinish(boolean isFinish) {
    this.isFinish = isFinish;
  }

  public boolean getIsFinish() {
    return this.isFinish;
  }
}


class InSideTwo {
  public void inExec(String threadName, int test) {
    Utils_Log log = Utils_Log.un;
    System.out
        .println(threadName + "," + log.collecLogs(threadName, +test + ",InSide ,Start and stop"));
  }
}

