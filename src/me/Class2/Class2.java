package me.Class2;

public class Class2 {

  public static void main(String[] args) {
    System.out.println("基本資料型態");
    BasicType basicType = new BasicType();
    System.out.println("1+1=" + basicType.b1());
    System.out.println("1-1=" + basicType.c1());
    System.out.println("1/1=" + basicType.d1());
    System.out.println("1*10=" + basicType.e1());
    System.out.println("( 1 + 1 ) / 1=" + basicType.f1());
    System.out.println("10 * 1 / 0=" + basicType.g1());
    System.out.println(" int == float , 1 == 1 = " + basicType.h1());
    System.out.println(" float == double , 1 == 1 = " + basicType.h2());
    System.out.println(" int == double , 1 == 1.0 = " + basicType.h3());

    System.out.println("比較屬性與物件是否一致-1");
    Cat catOne = new Cat();
    catOne.name = "Tom";
    Cat catTwo = new Cat();
    catTwo.name = "Tom";
    System.out.println("catOne.name.equals(catTwo.name) => " + catOne.name.equals(catTwo.name));
    System.out.println("catOne.name == catTwo.name      => " + (catOne.name == catTwo.name));
    System.out.println("catOne.equals(catTwo)           => " + catOne.equals(catTwo));
    System.out.println("catOne == catTwo                => " + (catOne == catTwo));
    
    System.out.println("比較屬性與物件是否一致-2");
    Cat catThree = new Cat();
    catThree.name = "Tom";
    Cat catFour = new Cat();
    catFour.name = "Tom";
    catFour = catThree;
    catFour.name = "QQ";
    System.out.println("catThree name = " + catThree.name);

    GlobalAndLocal andLocal = new GlobalAndLocal();
    andLocal.a();
    int b = andLocal.b();
    int temp = b + b;
  }
  // 基本資料型態 primitive data type


}


class BasicType {
  // 正整數
  int iAmInt;
  // 浮點數
  float iAmFloat;
  // 雙倍精度浮點數
  double iAmDouble;
  // 布林值
  boolean iAmBool;

  /** 1 + 1 */
  public int b1() {
    iAmInt = 1;
    return iAmInt + 1;
  }

  // 1 - 1
  public int c1() {
    iAmInt = 1;
    return iAmInt + 1;

  }

  // 1 / 1
  public int d1() {
    iAmInt = 1;
    return iAmInt / 1;

  }


  // 1 * 10
  public int e1() {
    iAmInt = 1;
    return iAmInt * 10;
  }

  // ( 1 + 1 ) / 1
  public int f1() {
    iAmInt = 1;
    iAmInt = iAmInt + 1;
    return iAmInt / 1;

  }
  // 10 * 1 / 0

  public float g1() {
    iAmFloat = 10;
    return iAmFloat * 1 / 0;

  }

  // int == float , 1 == 1
  public boolean h1() {
    iAmInt = 1;
    iAmFloat = 1;
    return iAmInt == iAmFloat;
  }


  // float == double , 1 == 1
  public boolean h2() {
    iAmFloat = 1;
    iAmDouble = 1;
    return iAmFloat == iAmDouble;
  }

  // int == double , 1 == 1.0
  public boolean h3() {
    iAmInt = 1;
    iAmDouble = 1.0;
    return iAmInt == iAmDouble;

  }
}


// name => equals
// object => equals
// name => ==
// object => ==
class Cat {
  public String name;
}


class BigCat {
  public String name;
}


// 區域與全域變數
class GlobalAndLocal {
  int a = 5; // 全域

  public int a() {
    return a;
  }

  public int b() {
    int b = 10; // 區域
    return b;
  }
}