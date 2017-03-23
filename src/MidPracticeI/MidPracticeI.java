package MidPracticeI;

import java.util.Random;

/**
 * <pre>
 * 練習題1
 * </pre> 
 */
public class MidPracticeI {
  public static void main(String[] args) {
    new mi_1().exec(10);
    System.out.println("-----------");
    new mi_2().exec(5);
    System.out.println("-----------");
    new mi_3().exec();
  }
}

/**
  <pre>
  請使用for迴圈，練習印出以下圖案
    
    *       *
     *     *
      *   *
       * *
        *
       * *
      *   *
     *     *
    *       *
 </pre> 
 */
class mi_1{
  public void exec(int size){
    for(int index = 1 ; index < size ; index ++){
      char[] starChars = new char[size+1];
      starChars[index] = '*';
      starChars[size-index] = '*';
      System.out.println("one = " + index + " , two = " + (size-index) + "\t" + new String(starChars));
    }
  }
}


/**
 * <pre>
 * 1. 首先產生一組陣列，裡面擺放正整數 0~5
 * 2. 產生一個目標答案，亂數答案是 1~9 之間
 * 3. 利用第一組陣列，隨機兩個元素相加，會等於目標答案，並印出兩個陣列位置
 * </pre>
 */
class mi_2{
  public void exec(int size){
    // Step 1
    System.out.print("arrays => ");
    int [] intsArrays = new int[size+1];
    for(int index = 0 ; index < intsArrays.length ; index++){
      intsArrays[index] = index;
      System.out.print(intsArrays[index] + ( index < intsArrays.length -1 ? "," : "\n"));
    }
    // Step 2
    int ranger = size + (size-1);
    int answer = new Random().nextInt(ranger) + 1;
    System.out.println("answer = " + answer);
    
    // Step 3
    int[] results = findAnswer(intsArrays , answer);
    System.out.println("one index = " + results[0] + " , two index = " + results[1]);
    System.out.println("one value = " + intsArrays[results[0]] + " , two value = " + intsArrays[results[1]]);
  }
  
  private int[] findAnswer(int[] intsArrays , int answer){
    int [] results = new int [2];
    for(int index = 0 ; index < intsArrays.length ; index++){
      for(int tag = index + 1 ; tag < intsArrays.length ; tag++){
        if((intsArrays[index] + intsArrays[tag]) == answer){
          results[0] = index;
          results[1] = tag;
          break;
        }
      }
    }
    return results;
  }
}


/**
 * <pre>
 * 學生資料
 * 學號  姓名
 * S1    小天
 * S2    小忍
 * S3    小玉
 * 
 * 成績資料
 * 學號  數學  英文  國文
 * S1     80   100    87
 * S2     99    94    78
 * S3     55    79    77
 * 
 * 請用新增學生與成績類別(Class)
 * 設定每位學生資料以及設定各科成績資料後
 * 
 * 1.請幫我用學號查詢學生各科的成績
 * 2.每位學生的平均成績
 * 3.各科的平均成績
 * 4.每科最高分數
 * 5.每科最低分數
 * </pre> 
 */
class mi_3{
  public void exec(){
    Student[] students = new GenStudents().doInit();
    Grades[] grades = new GenGrades().doInit();
    printStudentGrade(students, grades);
    printStudentAvgGrade(students, grades);
    printAvgGrade(grades);
    printHighGrade(grades);
    printLowGrade(grades);
  }

  private void printStudentGrade(Student[] students , Grades[] grades){
    System.out.println("學號查詢學生各科的成績");
    for(int index = 0 ; index < students.length ; index ++){
      for(int tag = 0 ; tag < grades.length ; tag++){
        if(students[index].studentNo.equals(grades[tag].studentNo)){
          System.out.println("學號 : " + students[index].studentNo + 
                             " , 性名 : " + students[index].name   +
                             " , 數學 : " + grades[tag].math       +
                             " , 英文 : " + grades[tag].english    +
                             " , 國文 : " + grades[tag].chinese     );
        }
      }
    }
    System.out.println("-------------------------------");
  }
  
  private void printStudentAvgGrade(Student[] students , Grades[] grades){
    System.out.println("每位學生的平均成績");
    for(int index = 0 ; index < students.length ; index ++){
      for(int tag = 0 ; tag < grades.length ; tag++){
        if(students[index].studentNo.equals(grades[tag].studentNo)){
          System.out.print("學號 : " + students[index].studentNo + 
                           " , 性名 : " + students[index].name   +
                           " , 平均 : ");
          float avg = (grades[tag].math + grades[tag].english + grades[tag].chinese)/3.0f;
          System.out.printf("%.2f\n" , avg);
        }
      }
    }
    System.out.println("-------------------------------");
  }
  
  private void printAvgGrade(Grades[] grades){
    System.out.println("各科的平均成績");
    float allMath = 0;
    float allEnglish = 0 ;
    float allChinese = 0;
    for(int index = 0 ; index < grades.length ; index ++){
      allMath += grades[index].math;
      allEnglish += grades[index].english;
      allChinese += grades[index].chinese;
    }
    System.out.printf("數學平均 : %.2f\n" , (allMath / grades.length));
    System.out.printf("英文平均 : %.2f\n" , (allEnglish / grades.length));
    System.out.printf("國文平均 : %.2f\n" , (allChinese / grades.length));
    System.out.println("-------------------------------");
  }
  
  private void printHighGrade(Grades[] grades){
    System.out.println("每科最高分數");
    int [] maths = new int[grades.length];
    int [] englishs = new int[grades.length];
    int [] chineses = new int[grades.length];
    for(int index = 0 ; index < grades.length ; index++){
      maths[index] = grades[index].math;
      englishs[index] = grades[index].english;
      chineses[index] = grades[index].chinese;
    }
    for(int index = 0 ; index < grades.length-1 ; index++){
      for(int tag = 1 ; tag < grades.length ; tag++){
        if(maths[index] < maths[tag]){
          swap(maths , index , tag);
        }
        if(englishs[index] < englishs[tag]){
          swap(englishs , index , tag);
        }
        if(chineses[index] < chineses[tag]){
          swap(chineses , index , tag);
        }
      }
    }
    System.out.println("數學最高 : " + maths[0]);
    System.out.println("英文最高 : " + englishs[0]);
    System.out.println("國文最高 : " + chineses[0]);
    System.out.println("-------------------------------");
  }
  
  private void printLowGrade(Grades[] grades){
    System.out.println("每科最低分數");
    int [] maths = new int[grades.length];
    int [] englishs = new int[grades.length];
    int [] chineses = new int[grades.length];
    for(int index = 0 ; index < grades.length ; index++){
      maths[index] = grades[index].math;
      englishs[index] = grades[index].english;
      chineses[index] = grades[index].chinese;
    }
    for(int index = 0 ; index < grades.length-1 ; index++){
      for(int tag = 1 ; tag < grades.length ; tag++){
        if(maths[index] > maths[tag]){
          swap(maths , index , tag);
        }
        if(englishs[index] > englishs[tag]){
          swap(englishs , index , tag);
        }
        if(chineses[index] > chineses[tag]){
          swap(chineses , index , tag);
        }
      }
    }
    System.out.println("數學最低 : " + maths[0]);
    System.out.println("英文最低 : " + englishs[0]);
    System.out.println("國文最低 : " + chineses[0]);
    System.out.println("-------------------------------");
  }
  
  private void swap( int[] numbers , int beforeIndex , int afterIndex){
    int temp = numbers[afterIndex];
    numbers[afterIndex] = numbers[beforeIndex];
    numbers[beforeIndex] = temp;
  }
  
}

class GenStudents{
  public Student[] doInit(){
    Student[] students = new Student[3];
    students[0] = new Student("S1" , "小天");
    students[1] = new Student("S2" , "小忍");
    students[2] = new Student("S3" , "小玉");
    return students;
  }
}

class GenGrades{
  public Grades[] doInit(){
    Grades[] grades = new Grades[3];
    grades[0] = new Grades("S1",80,100,87);
    grades[1] = new Grades("S2",99,94,78);
    grades[2] = new Grades("S3",55,79,77);
    return grades;
  }
}

class Student {
  public final String studentNo;
  public final String name;
  public Student(String studentNo , String name){
    this.studentNo = studentNo;
    this.name = name;
  }
}

class Grades {
  public final String studentNo;
  public final int math;
  public final int english;
  public final int chinese;
  public Grades(String studentNo ,int math , int english , int chinese){
    this.studentNo = studentNo;
    this.math = math;
    this.english = english;
    this.chinese = chinese;
  }
}