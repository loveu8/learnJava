package Class8.adv;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public enum Utils_Log {

  un;

  private volatile Map<String, LinkedList<String>> threadListLogs;

  private Utils_Log() {
    threadListLogs = new HashMap<String, LinkedList<String>>();
  }

  public String collecLogs(String threadName, String log) {
    if (threadListLogs.get(threadName) == null) {
      LinkedList<String> logs = new LinkedList<String>();
      logs.add(log);
      threadListLogs.put(threadName, logs);
    } else {
      threadListLogs.get(threadName).add(log);
    }
    return log;
  }

  public LinkedList<String> getLogs(String threadName) {
    return threadListLogs.get(threadName);
  }

  public boolean removeLog(String threadName) {
    threadListLogs.remove(threadName);
    return threadListLogs.get(threadName) == null ? true : false;
  }

  public int getAllThreadListLogsSize() {
    return threadListLogs.size();
  }
}
