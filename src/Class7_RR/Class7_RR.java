package Class7_RR;

import Class7.Modifier;

public class Class7_RR {
  public static void main(String[] args) {
    Modifier no = new Modifier();
    // 全世界，只剩下我看得到你了...
    String iAmPublic = no.iAmPublic = "iAmPublic";
    System.out.println("iAmPublic = " + iAmPublic);
  }
}
