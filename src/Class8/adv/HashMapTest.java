package Class8.adv;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashMapTest implements Runnable {



  private String name;

  private static Map<Integer, String> map = new HashMap<Integer, String>();

  public HashMapTest(Integer number, String name) {
    this.name = name;
    map.put(number, name);
  }

  public void run() {

    try {

      Iterator<Integer> it = map.keySet().iterator();

      while (it.hasNext()) {
        Integer key = it.next();
        map.put(key + 1, name);
      }

      System.out.println(name + " inserted");

    } catch (Exception e) {

      e.printStackTrace();

    } finally {

    }

  }

  public static void main(String[] args) {

    HashMapTest not1 = new HashMapTest(1, "Apple");

    HashMapTest not2 = new HashMapTest(2, "Beagle");

    ExecutorService executor = Executors.newCachedThreadPool();

    executor.execute(not1);

    executor.execute(not2);

    for (Entry<Integer, String> entry : map.entrySet()) {

      System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());

    }

    executor.shutdownNow();

  }

}
