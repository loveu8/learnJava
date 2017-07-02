package Class8.adv;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class MutilsThreadName {
  public static void main(String[] args) {
    List<Thread> threads = new LinkedList<Thread>();
    for (int index = 0; index < 5; index++) {
      threads.add(new Thread());
    }
    for (int index = 0; index < 5; index++) {
      String threadName = UUID.randomUUID() + "_" + System.currentTimeMillis();
      threads.get(index).setName(threadName);
    }
    for (int index = 0; index < 5; index++) {
      System.out.println("this thread name : " + threads.get(index).getName());
      System.out.println("---------------------------");
    }
  }
}

