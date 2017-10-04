package AdvClass1;

/**
 * 過多的if else很常見
 * 我們就來舉例幾種可以簡化的方式
 */
public class AdvClass1 {
  public static void main(String[] args) {
    new SamlpeReturn().exec();
    System.out.println("----------------");
    System.out.println(Codes.valueOf("Name").code);
  }
}

/** 
 * if else 優化方式 1
 * 使用return方式，提早結束判斷
 * return除了返回值以外，還可以減少槽狀if else的問題
 * 以下就舉例常見用法
 * 隨機1~100的數字只要是可以被 2、3、7整除的整數
 * 就回傳true , 不是就回傳false
 */
class SamlpeReturn {
  public void exec(){
    System.out.println(this.normal(7));
    System.out.println(this.advOne(10));
    System.out.println(this.advTwo(9));
  }
  // 一般作法
  public boolean normal(int value){
    boolean ok = false;
    if(value % 2 == 0){
      ok = true;
    } else if (value % 3 == 0){
      ok = true;
    } else if (value % 7 == 0){
      ok = true;
    }
    return ok;
  }
  /** 
   * 進階作法1
   * 利用return方式，減少變數使用
   * @param intValue
   * @return boolean
   */
  public boolean advOne(int intValue){
    if(intValue % 2 == 0){
      return true;
    }
    if (intValue % 3 == 0){
      return true;
    }
    if (intValue % 7 == 0){
      return true;
    }
    return false;
  }
  /** 
   * 進階作法2
   * 這是運用邏輯運算符號 || (或)的方式
   * 來達到減少重覆的if else判斷
   * 以下敘述是只要一種條件成立，即會回傳真假
   * @param intValue
   * @return boolean
   */
  public boolean advTwo(int intValue){
    return intValue % 2 == 0 || intValue % 3 == 0 || intValue % 7 == 0;
  }
}

enum Codes {
  Name(0), Age(1), Address(2);
  public final int code;
  Codes(int code) {
    this.code = code;
  }
}
