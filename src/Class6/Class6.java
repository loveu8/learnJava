package Class6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Class6 {
  public static void main(String[] args) {
//    new MyMap().doHashMap();
//    new MyMap().doTreeMap();
//    new MyMap().doLinkedHashMap();
//    new MyMap().nullNotice();
    new MyMap().remove();
  }
}


/**
 * <pre> 
 * HashMap Class 實作來至於 java.util.Map
 * TreeMap Class 實作來至於 java.util.AbstractMap
 * LinkedHashMap Class 實作來至於 java.util.Map
 * 
 * Map特性是，可以用Key-value形式，儲存資料
 * 對於尋找資料時，會是很方便的集合物件
 * 如果key值重覆時，將會覆蓋先前資料
 * 但是每個Map特性稍為不太ㄧ樣，以下簡單介紹三種Map
 * 
 * HashMap :
 * 允許null key 與 null value
 * 會針對key值作hashCode動作
 * 確保該筆資料可以儲存
 * 若是有相同key值的資料儲存
 * 將會覆蓋掉原有資料
 * 每次執行放入的資料，是無排序的
 * 
 * TreeMap
 * 不允許 null key , 但允許 null value
 * 該實作基於演算法紅黑樹實現的
 * key值會進行字母自然排序的動作
 * 
 * LinkedHashMap
 * 允許null key 與 null value
 * 該實作與HashMap差異在於
 * 插入的資料，會是按照放入資料的順序擺放
 * 
 * 
 * </pre>
 */
class MyMap{
  
  private String[] randomEngStr = {"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j"};
      
  public void doHashMap(){
    
    Map<String , Integer > myMap = new HashMap<String , Integer>();
    for(int index = 1 ; index < 11 ; index++){
      myMap.put(index + randomEngStr[index-1], index);
    }
    // keySet 會自動把key的資料全部拿出來
    // 這樣我的就可以使用foreach形式
    // 取出Map裡的資料
    for(String key : myMap.keySet()){
      System.out.println("key = " + key + " , value = " + myMap.get(key));
    }
  }
  
  public void doTreeMap(){
    TreeMap<String , Integer > myMap = new TreeMap<String , Integer>();
    for(int index = 1 ; index < 11 ; index++){
      myMap.put(randomEngStr[index-1] + index , index);
    }

    for ( String key :myMap.keySet() ) {
      System.out.println( key + " = " + myMap.get(key) );
    }
    
  }
  
  public void doLinkedHashMap(){
    LinkedHashMap<String , Integer > myMap = new LinkedHashMap<String , Integer>();
    for(int index = 1 ; index < 11 ; index++){
      myMap.put(index + randomEngStr[index-1] , index);
    }

    for ( String key :myMap.keySet() ) {
      System.out.println( key + " = " + myMap.get(key) );
    }
  }
  
  public void nullNotice(){
    Map<String , String> myMap = new HashMap<String , String>();
    // 只能檢驗是不是空的，但不適用已經 new 出來的物件
    System.out.println("is null ? = " + (myMap == null));
    // 適用new出來的物件，但是不確認是不是沒資料，需要使用isEmpty確認
    System.out.println("is isEmpty ? = " + (myMap.isEmpty()));
  }
  
  public void remove(){
    Map<String , String > myMap = new HashMap<String , String>();
    myMap.put(null, null);
    System.out.println("key = " + null + " , value = " + myMap.get(null));
    myMap.remove(null);
    System.out.println("remove , key = " + null + " , value = " + myMap.get(null));
    myMap.put("10", "10");
    System.out.println("key = " + 10 + " , value = " + myMap.get("10"));
    myMap.remove("10");
    System.out.println("remove , key = " + 10 + " , value = " + myMap.get("10"));
  }
  
}