import code.MyArray_651521;

public class L3_ArrayTesterPackx {
  public static void main(String[] args) 
  {
    System.out.println("-demo4-----");
    myArray_demo4();
    System.out.println("-task2-----");
    task2();
  }
  static private void myArray_demo4() 
  {
    MyArray_651521 demo = new MyArray_651521(5);
    demo.delete(0);
    demo.add(3);
    demo.add(7);
    demo.add(5);
    demo.add(4);
    demo.add(6);
    demo.add(1);
    System.out.println(demo);
  }
  static private void task2() 
  {
    for (int N = 200_000;N <= 10 * 200_000; N += 200_000) {
    long start = System.currentTimeMillis();
    MyArray_651521 mArray = new MyArray_651521(N);
    for (int n = 1; n <N; n++)
    mArray.add((int)(Math.random()*1000));
    long time = (System.currentTimeMillis() - start);
    System.out.println(N + "\t\t" + time);
  }
  System.out.println("with expansion");
  for (int N = 200_000;N <= 10 * 200_000; N += 200_000) 
    {
      long start = System.currentTimeMillis();
      MyArray_651521 mArray = new MyArray_651521();
      for (int n = 1; n <N; n++)
      mArray.add((int)(Math.random()*1000));
      long time = (System.currentTimeMillis() - start);
      System.out.println(N + "\t\t" + time);
    }
  }
}


