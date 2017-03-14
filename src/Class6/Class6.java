package Class6;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * <pre>
 * Collection (集合)，或稱為 contain (容器)
 * 在Java世界裡，當我們希望去儲存物件資料時
 * 就會需要使用到Collection類型的物件
 * 去收集我們想要儲存的物件
 * 常見的集合物件有
 * Set , List , Queue , Deque , SortSet
 * 類似集合物件有
 * Map
 * 以下只說明常用的 Map , List , Set
 * 以及常用foreach
 * </pre>
 */
public class Class6 {
  public static void main(String[] args) {
    // new MyMap().doHashMap();
    // new MyMap().doTreeMap();
    // new MyMap().doLinkedHashMap();
    // new MyMap().nullNotice();
    // new MyMap().removeAndSize();
    // new MyList().doArrayListAddSpeed();
    // new MyList().doLinkedListAddSpeed();
    // new MyList().doArrayListRemoveSpeed();
    // new MyList().doLinkedListRemoveSpeed();
    // new MySet().testSetSort();
    // new MySet().testSpeed();
    // new MyLoop().basic();
    // new MyLoop().doArrayLoop();
    // new MyLoop().doListLoop();
    // new MyLoop().doMapLoop();
    // new MyLoop().doSetLoop();
  }
}


/**
 * <pre>
 * HashMap Class 實作來至於 java.util.Map
 * TreeMap Class 實作來至於 java.util.AbstractMap
 * LinkedHashMap Class 實作來至於 java.util.Map
 * 
 * 
 * Map特性是，可以用Key-value形式，儲存物件資料
 * Map類似於集合物件是因為
 * 因為採用Key-value形式，並不允許重覆的key資料
 * 跟Collection設計理念有差異
 * 
 * 
 * EX : Map<String , Integer > myMap = new HashMap<String , Integer>();
 * <>小於內，格式是 < key , value > 的資料型態
 * key 是 String物件, value 是 Integer物件
 * Map格式只能接受物件的資料型態，無法使用基本資料型態
 * Map裡面也可以包含集合物件 Map，List，Set，或者自定義的物件都是可行的
 * 
 * Map對於尋找資料時，會是很方便的物件
 * 如果key值重覆時，將會覆蓋先前資料
 * 但是每種Map特性稍為不太ㄧ樣，以下簡單介紹三種Map
 * 
 * HashMap 
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
 * 常用方法有
 * 增加元素         => put(key , value) 
 * 資料大小         => size()
 * 取得資料         => get(key)
 * 刪除元素         => remove()
 * 移除所有元素     => clear()
 * 取出所有key資料  => keySet()
 * 
 * </pre>
 */
class MyMap {

  private String[] randomEngStr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

  public void doHashMap() {

    Map<String, Integer> myMap = new HashMap<String, Integer>();
    for (int index = 1; index < 11; index++) {
      myMap.put(index + randomEngStr[index - 1], index);
    }
    // keySet 會自動把key的資料全部拿出來
    // 這樣我的就可以使用foreach形式
    // 取出Map裡的資料
    for (String key : myMap.keySet()) {
      System.out.println("key = " + key + " , value = " + myMap.get(key));
    }
  }

  public void doTreeMap() {
    TreeMap<String, Integer> myMap = new TreeMap<String, Integer>();
    for (int index = 1; index < 11; index++) {
      myMap.put(randomEngStr[index - 1] + index, index);
    }
    for (String key : myMap.keySet()) {
      System.out.println(key + " = " + myMap.get(key));
    }

  }

  public void doLinkedHashMap() {
    LinkedHashMap<String, Integer> myMap = new LinkedHashMap<String, Integer>();
    for (int index = 1; index < 11; index++) {
      myMap.put(index + randomEngStr[index - 1], index);
    }

    for (String key : myMap.keySet()) {
      System.out.println(key + " = " + myMap.get(key));
    }
  }

  public void nullNotice() {
    Map<String, String> myMap = new HashMap<String, String>();
    // 只能檢驗是不是空的，但不適用已經 new 出來的物件
    System.out.println("is null ? = " + (myMap == null));
    // 適用new出來的物件，但是不確認是不是沒資料，需要使用isEmpty確認
    System.out.println("is isEmpty ? = " + (myMap.isEmpty()));
  }


  public void removeAndSize() {
    Map<String, String> myMap = new HashMap<String, String>();
    myMap.put(null, null);
    System.out.println("key = " + null + " , value = " + myMap.get(null) + " , size = "
        + myMap.size());
    myMap.remove(null);
    System.out.println("remove , key = " + null + " , value = " + myMap.get(null) + " , size = "
        + myMap.size());
    myMap.put("10", "10");
    System.out.println("key = " + 10 + " , value = " + myMap.get("10") + " , size = "
        + myMap.size());
    myMap.remove("10");
    System.out.println("remove , key = " + 10 + " , value = " + myMap.get("10") + " , size = "
        + myMap.size());
  }

}


/**
 * <pre>
 * 
 * ArrayList Class  實作來至於 java.util.AbstractList
 * LinkedList Class 實作來至於 java.util.AbstractList
 * 
 * List本身很類似於Array
 * 優點是它不需要像Array去初始陣列大小
 * 只要new出來之後，即可用Add增加List裡的資料
 * 但是跟Map跟Set不一樣的點是
 * 可以允許重覆資料的新增
 * 要取出資料的時候
 * 要使用index(索引)去尋找資料
 * 
 * EX : Array<String> list = new ArrayList<String>();
 * <>大於小於內的String，意思是指定加入的物件型態
 * 一樣只能加入物件型態的資料，而無法用List去add基本型態資料
 * 
 * ArrayList 
 * 所以對於快速的隨機取得物件來說，使用ArrayList可以得到較好的效能，不過
 * 在移除物件或插入物件時，ArrayList就比較慢（使用 LinkedList 在這方面就好的多）。
 * 
 * LinkedList
 * 如果您的物件加入之後大都是為了取出，而不會常作移除或插入（Insert）的動作，則使用ArrayList，
 * 如果您會經常從容器中作移除或插入物件的動作，則使用LinkedList會獲得較好的效能。
 * 
 * 
 * ArrayList + LinkedList 常用方法有
 * 增加元素         => add(data) 
 * 資料大小         => size()
 * 取得資料(位址)   => get(index)
 * 刪除元素         => remove()
 * 移除所有元素     => clear()
 * 
 * LinkedList 實作方式不同，多新增了幾種方法
 * 在list最前增加資料 => addFirst()
 * 在list最後增加資料 => addLast()
 * 取得list第一筆資料 => getFirst()
 * 取得list最後一筆資料 => getLast()
 * 移除第一個元素     => removeFirst()
 * 移除最後一個元素   => removeLast()
 * 
 * </pre>
 */
class MyList {

  public void doArrayListAddSpeed() {
    Date date = new Date();
    ArrayList<String> list = new ArrayList<String>();
    for (int index = 0; index < 1000000; index++) {
      list.add(Integer.toString(index));
    }
    System.out.println("ArrayList 增加字串速度 : " + (new Date().getTime() - date.getTime()) / 1000.0
        + "s");
  }

  public void doLinkedListAddSpeed() {
    Date date = new Date();
    LinkedList<String> list = new LinkedList<String>();
    for (int index = 0; index < 1000000; index++) {
      list.add(Integer.toString(index));
    }
    System.out.println("LinkedList 增加字串速度 : " + (new Date().getTime() - date.getTime()) / 1000.0
        + "s");
  }

  public void doArrayListRemoveSpeed() {
    Date date = new Date();
    ArrayList<String> list = new ArrayList<String>();
    for (int index = 0; index < 300000; index++) {
      list.add(Integer.toString(index) + "a");
    }
    for (int index = 0; index < list.size(); index++) {
      list.remove(index);
    }
    System.out
        .println("ArrayList 刪除速度 : " + (new Date().getTime() - date.getTime()) / 1000.0 + "s");
  }

  public void doLinkedListRemoveSpeed() {
    Date date = new Date();
    ArrayList<String> list = new ArrayList<String>();
    for (int index = 0; index < 300000; index++) {
      list.add(Integer.toString(index) + "a");
    }
    for (int index = 0; index < list.size(); index++) {
      list.remove(index);
    }
    System.out.println("LinkedList 刪除速度 : " + (new Date().getTime() - date.getTime()) / 1000.0
        + "s");
  }

}


/**
 * <pre>
 * 
 * Set
 * Set特性是不允許儲存重覆的資料
 * 若是有重覆資料，將會被覆蓋掉
 * 當你有這種需求時，可以考慮直接用Set物件實作
 * 
 * EX : HashSet <String> sets = new HashSet<String> ();
 * <>大於小於內的String，意思是指定加入的物件型態
 * 
 * HashSet
 * 一個按著Hash演算法來存儲集合中的元素，其元素值可以是NULL。
 * 它不能保證元素的排列順序。新增物件時速度表現較佳。
 * 
 * 
 * TreeSet
 * 會按照字母或字數的來自然排序
 * 提供相關的方法讓您有序的取出對應位置的物件
 * 唯一實作SortedSet介面的類別，它使用紅黑樹結構來對加入的物件進行排序
 * 
 * LinkedHashSet
 * 元素的擺入，會按照你新增的順序作擺放
 * 
 * 常用的方法有
 * 增加元素     => add(value) 
 * 刪除元素     => remove(value)
 * 移除所有元素 => clear()
 * </pre>
 */
class MySet {
  public void testSetSort() {
    HashSet<String> hs = new HashSet<String>();
    hs.add("B1");
    hs.add("1A");
    hs.add("2D");
    hs.add("E2");
    hs.add("C3");
    hs.add("3F");
    System.out.println("HashSet 顺序:\n" + hs);

    LinkedHashSet<String> lhs = new LinkedHashSet<String>();
    lhs.add("B1");
    lhs.add("1A");
    lhs.add("D2");
    lhs.add("2E");
    lhs.add("C3");
    lhs.add("3F");

    System.out.println("LinkedHashSet 顺序:\n" + lhs);

    TreeSet<String> ts = new TreeSet<String>();
    ts.add("B1");
    ts.add("1A");
    ts.add("D2");
    ts.add("2E");
    ts.add("C3");
    ts.add("3F");
    System.out.println("TreeSet 顺序:\n" + ts);
  }

  public void testSpeed() {
    Random r = new Random();

    HashSet<Dog> hashSet = new HashSet<Dog>();
    TreeSet<Dog> treeSet = new TreeSet<Dog>();
    LinkedHashSet<Dog> linkedSet = new LinkedHashSet<Dog>();

    // start time
    long startTime = System.nanoTime();

    for (int i = 0; i < 1000; i++) {
      int x = r.nextInt(1000 - 10) + 10;
      hashSet.add(new Dog(x));
    }
    // end time
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("HashSet: " + duration);

    // start time
    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      int x = r.nextInt(1000 - 10) + 10;
      treeSet.add(new Dog(x));
    }
    // end time
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("TreeSet: " + duration);

    // start time
    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      int x = r.nextInt(1000 - 10) + 10;
      linkedSet.add(new Dog(x));
    }
    // end time
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("LinkedHashSet: " + duration);
  }
}


// 建立可以可以排序的Dog
class Dog implements Comparable<Dog> {
  int size;

  public Dog(int s) {
    size = s;
  }

  public String toString() {
    return size + "";
  }

  @Override
  public int compareTo(Dog o) {
    return size - o.size;
  }
}


/**
 * <pre>
 * 
 * foreach 
 * for-each語法就是當我們想要存取元素時、更有效率的語法。
 * 只適用在 Array或Collection 
 *  
 * 只適用於 Java 5.0 以後的版本
 * 只適用於有 implement Iterable的類別基本上 Array 與 Collection 類別都沒問題。
 * 只能存取裡面元素而不能置換掉它，記住，for-each 裡面的變數是 local 
 * 變數離開 for-each 之後就會消失。
 * 只能同時針對一個 Array 或 Collection 進行操作。
 * 只能同時針對一個元素操作。
 * 只能從頭開始訪問每個元素。
 *
 * Iterator : 
 * 稱為迭代器，或者游標，主要功能是可以尋訪整個容器(集合)內的元素
 * 若物件有實作Iterator的時候，都可以使用foreach
 * 
 * </pre>
 */
class MyLoop {
  
  public void basic(){
    System.out.println("doBasic--------------");
    ArrayList<String> list = new ArrayList<String>();
    for (int index = 0; index < 10; index++) {
      list.add(Integer.toString(index));
    }
    
    /**
     * 以下是實際foreach實作的內容
     * list本身有實作 Iterator，變可以使用iterator()方式，取出元素內的物件
     * hasNext() 代表是，還有下一個元素
     * next()，會取出目前指到元素內容
     */
    for(Iterator<String> i = list.iterator(); i.hasNext(); ) {
      String item = i.next();
      System.out.println(item);
    }
    System.out.println("-------------------------");
  }
  
  public void doArrayLoop(){
    System.out.println("doArrayLoop--------------");
    String[] strArrays = new String[10];
    for(int index = 0 ; index < strArrays.length ; index ++){
      strArrays[index] = Integer.toString(index);
    }
    for(String value : strArrays){
      System.out.println("value = " + value);
    }
    System.out.println("-------------------------");
  }
  
  public void doMapLoop(){
    System.out.println("doMapLoop--------------");
    Map<String, String> myMap = new HashMap<String, String>();
    for(int index = 0 ; index < 11 ; index ++){
      myMap.put(Integer.toString(index) , Integer.toString(index));
    }
    for(String key : myMap.keySet()){
      System.out.println("key = " + key + " , value = " + myMap.get(key));
    }
    System.out.println("-------------------------");
  }
  
  public void doListLoop(){
    System.out.println("doListLoop--------------");
    ArrayList<String> list = new ArrayList<String>();
    for(int index = 0 ; index < 11 ; index ++){
      list.add(Integer.toString(index));
    }
    for(String value : list){
      System.out.println("value = " + value);
    }
    System.out.println("-------------------------");
  }
  
  public void doSetLoop(){
    System.out.println("doSetLoop--------------");
    HashSet<String> hs = new HashSet<String>();
    for(int index = 0 ; index < 11 ; index ++){
      hs.add(Integer.toString(index));
    }
    for(String value : hs){
      System.out.println("value = " + value);
    }
    System.out.println("-------------------------");
  }
  
}