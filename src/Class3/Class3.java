package Class3;

public class Class3 {
  public static void main(String[] args) {
    System.out.println("字串比較與大於小於比較補充");
    System.out.println("new String(\"Tom\") == new String(\"Tom\")  => " + new MyString().equalsString());
    System.out.println("new String(\"Tom\").equals(new String(\"Tom\")) => " + new MyString().equalsString2());
    System.out.println("1>2  =>" + (1>2));
    System.out.println("1>=2 =>" + (1>=2));
    System.out.println("1<=2 =>" + (1<=2));
    System.out.println("1<2 =>" + (1<2));
    System.out.println("1==2 =>" + (1==2));
    System.out.println("if else");
    MyIfElseIfElse myIfElseIfElse = new MyIfElseIfElse();
    System.out.println("10會被 2 整除 ? => "+ myIfElseIfElse.isDivideBy2(10));
    System.out.println("整數相除，不會有餘數=>" + (3/10));
    System.out.println("2,3,5整除="+myIfElseIfElse.isDivideBy235(30));
    // for迴圈
    System.out.println("for迴圈");
    MyFor for1 = new MyFor();
    for1.testForOne(10);
    for1.testForOne();
    System.out.println("while迴圈");
    MyWhile myWhile = new MyWhile();
    myWhile.testWhile();
  }
}


class MyString {
  public boolean equalsString(){
    return new String("Tom") == new String("Tom");
  }
  
  public boolean equalsString2(){
    return new String("Tom").equals(new String("Tom"));
  }
  
}


class MyIfElseIfElse {
  public boolean isDivideBy2(int num) {
    System.out.println("isDivideBy2 result = " + (num % 2));
    if ((num % 2) == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  public boolean isDivideBy235(int num) {
    System.out.println(num);
    if ((num % 2 == 0) && (num % 3 == 0) && (num % 5 == 0)) {
      return true;
    } else {
      return false;
    }
  }
    
}


class MyFor {

  // 印出 0~10
  public int[] testForOne(int size){
    // 初始長度為10的一維陣列
    int[] intArray = new int[size];
    // 初始值 ; true or false ; 變數值加或減
    for(int index = 0 ; index < intArray.length ; index++){
      intArray[index] = index;
      System.out.println("index = " + index + ", testArray = " + intArray[index]);
    }
    System.out.println();
    return intArray; 
  }
  
  // 1*1=1 , 1*2=2 ...... 1*9=9
  public void testForOne(){
    System.out.println("題目 :　1*1=1 , 1*2=2 ...... 1*9=9");
    int sum[]=new int[10];
    for(int i=1;i<10;i++){
      sum[i]=i*1;     
      System.out.print("1*"+ i +"="+sum[i]);
      if(i<9){
        System.out.print(",");
      } 
    }
    System.out.println();
  }
  
}


class MyWhile {
  public void testWhile(){
    System.out.println("題目 :　1*1=1 , 1*2=2 ...... 1*9=9");
    int i = 1 ;
    while(i<10){
      System.out.print("1*"+ i +"="+1*i);
      if(i<9){
        System.out.print(",");
      }
      i++; //=> i = i + 1;
    }
  }
}

class MyDoWhile {
  
}

class MyArray {
  int[] oneArray;
  int[][] twoArray;
}