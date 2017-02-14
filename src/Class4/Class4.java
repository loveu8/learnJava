package Class4;

public class Class4 {

}

// 三元運算
class MyOtherIfElse {
  public void isDivide2(int num){
    System.out.println("num = " + num +"是否可被2整除" + (num % 2 == 0 ? true : false));
  }
  
  public void isTom(String str){
    System.out.println("Name is " + str +". is Tom ? " + ("Tom".equals(str) ? true : false) );
  }
}


class MySwtichCase {
  public void MyNumberSwtichCase(int num){
    switch (num) {
      case 0:
        System.out.println("Hello world");
        break;
      default:
        System.out.println("WTF??");
        break;
    }
  }
  
  public void MyStringSwitchCase(String str){
    switch (str) {
      case "Tom":
        System.out.println("WelCome Back Admin , " + str);
        break;
      default:
        System.out.println("Hi , " + str);
        break;
    }
  }
}


class MyBreakContinue{
  public void test1(){
    for(int i = 0 ; i < 10 ; i++){
      if(i % 2 == 0){
        continue;
      }
      if(i%7 == 0){
        break;
      }
      System.out.println(" i = " + i );
    }
  }
}