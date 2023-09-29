import code.MyArrayBasic;
import code.MyArray_651521;
class L3_ArrayTester_Main {
  public static void main(String[] args) 
  {
    System.out.println("-demo1-------");
    arrayBasic_demo1();
    System.out.println("-demo2-------");
    arrayBasic_demo2();
    System.out.println("-demo3-------");
    arrayBasic_demo3();
  }
  static private void arrayBasic_demo1() 
  {
    MyArrayBasic demo = new MyArrayBasic(7,6,8,1,2,3);
    System.out.println(demo);
  }
  static private void arrayBasic_demo2() 
  {
    MyArray_651521 demo = new MyArray_651521();
    demo.insert(9,0);
    demo.insert(70,0);
    demo.insert(50,0);
    System.out.println(demo);
    System.out.println("5 is at " + demo.find(5));
    System.out.println("5 is at " + demo.binarySearch(5));
    demo.delete(1);
    System.out.println(demo);
  }
  static private void arrayBasic_demo3() 
  {
    MyArrayBasic demo = new MyArrayBasic(null);
    demo.add(3); demo.add(7);
    demo.add(5); demo.add(4);
    demo.add(6);
    //index out of bound due to overflow
    // demo.add(1);
  }
}