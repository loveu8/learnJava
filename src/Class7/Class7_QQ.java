package Class7;

import Class7.Modifier;

public class Class7_QQ {
  public static void main(String[] args) {
    Modifier test = new Modifier();
    String iAmPublic = test.iAmPublic = "iAmPublic";
    String iAmProtected = test.iAmProtected = "iAmProtected";
    String iAmNotModifier = test.iAmNotModifier = "iAmNotModifier"; 
    System.out.println("iAmPublic = " + iAmPublic);
    System.out.println("iAmProtected = " + iAmProtected);
    System.out.println("iAmNotModifier = " + iAmNotModifier);
  }
}