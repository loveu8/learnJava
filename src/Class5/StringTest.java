package Class5;

public class StringTest {

  public static void main(String[] args) {
    new MyStringTestOne().exec();
    new MyStringTestTwo().exec();
  }
}

class MyStringTestOne{
  static boolean running = true;
  public void exec(){

      StringBuilder sb = new StringBuilder();
      System.out.println("before , StringBuilder = " + sb.toString());
      new Thread(new Runnable() { public void run() {
        while (running) sb.append("test");
      }}).start();
      System.out.println("start, StringBuilder = " + sb.toString());
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for (int i = 0; i < 100; i++) {
        sb.append("hello");
      }
      running = false;
      System.out.println("StringBuilder , replace = " + sb.toString().replace("test", ""));
      System.out.println("StringBuilder , end = " + sb.toString());
      System.out.println("---------------------------------------------------------------");
  }
}

class MyStringTestTwo{
  static boolean running = true;
  public void exec(){

      StringBuffer sb = new StringBuffer();
      System.out.println("before , StringBuilder = " + sb.toString());
      new Thread(new Runnable() { public void run() {
        while (running) sb.append("test");
      }}).start();
      System.out.println("start, StringBuilder = " + sb.toString());
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for (int i = 0; i < 100; i++) {
        sb.append("hello");
      }
      running = false;
      System.out.println("StringBuilder , replace = " + sb.toString().replace("test", ""));
      System.out.println("StringBuilder , end = " + sb.toString());
      System.out.println("---------------------------------------------------------------");
  }
}