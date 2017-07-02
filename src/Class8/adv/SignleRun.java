package Class8.adv;

import java.util.UUID;

public class SignleRun {
  public static void main(String[] args) {
    new OutSide().exec();
  }
}


class OutSide {
  public void exec() {
    Utils_Log log = Utils_Log.un;
    String threadName = UUID.randomUUID() + "_" + System.currentTimeMillis();
    try {
      log.collecLogs(threadName, "OutSide , Start");
      Thread.sleep(500);
      new InSide().inExec(threadName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    log.collecLogs(threadName, "OutSide , End");
    for (String data : log.getLogs(threadName)) {
      System.out.println(data);
    }
  }
}


class InSide {
  public void inExec(String threadName) {
    Utils_Log log = Utils_Log.un;
    log.collecLogs(threadName, "InSide , Start and stop");
  }
}

