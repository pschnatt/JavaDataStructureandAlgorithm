import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Puzzle8_651521
{
  public static void main(String[] args)
  {
    demo3();
  }
  int size = 3;
  int[] sequence;
  ArrayList<Puzzle8State> explored;
  Stack<Puzzle8State> dfs;
  boolean goalreach = false;
  int popinvocation = 0;

  public Puzzle8_651521(int[] sequence)
  {
    this.sequence = new int[size*size];
    int val = 0, index = 0;
    for (int i = 0; i < sequence.length; i++)
    {
      if (i % size == 0)
        val = sequence[i];
      else if(i % size == 1)
        index += sequence[i]*size;
      else
      {
        index += sequence[i];
        this.sequence[index] = val;
        index = 0;
      } 
    }
    explored = new ArrayList<>();
    dfs = new Stack<>();
  }

  public void displayBoard()
  {
    for (int i = 0; i < sequence.length; i++)
    {
      if (i % size == 0 && i != 0)
        System.out.println();
      if (sequence[i] != size*size)
        System.out.print(sequence[i] + " ");
      else
        System.out.print("  ");
    }
  }

  public void generateNextMove()
  {
    int target = 9;
    int blankindex = -1;

    for (int i = 0; i < sequence.length; i++)
    {
      if (sequence[i] == target)
      {
        blankindex = i;
        break;
      }
    }
    if (blankindex == -1)
      return ;
    
    if (blankindex + 3 < size*size && goalreach == false)
      generateNextMoveHelper(blankindex + 3, blankindex, "south ");
    if (blankindex % 3 < 2 && goalreach == false)
      generateNextMoveHelper(blankindex + 1, blankindex, "east ");
    if (blankindex - 3 > -1 && goalreach == false)
      generateNextMoveHelper(blankindex - 3, blankindex, "north ");
    if (blankindex % 3 > 0 && goalreach == false)
      generateNextMoveHelper(blankindex - 1, blankindex, "west ");
  }

  public void generateNextMoveHelper(int swapindex, int blankindex ,String label)
  {
    
    swap(swapindex, blankindex);
    Puzzle8State seqState = new Puzzle8State(Arrays.copyOf(this.sequence,this.sequence.length));
    if (isGoal(seqState.sequence))
    {
      goalreach = true;
      return ;
    }
    if (!explored.contains(seqState))
    {
      explored.add(seqState);
      dfs.push(new Puzzle8State(Arrays.copyOf(seqState.sequence, seqState.sequence.length)));
    }
    swap(swapindex, blankindex);
  }

  public void swap(int index1, int index2)
  {
    this.sequence[index1] = this.sequence[index1] ^ this.sequence[index2];
    this.sequence[index2] = this.sequence[index1] ^ this.sequence[index2];
    this.sequence[index1] = this.sequence[index1] ^ this.sequence[index2];
  }

  public void nextMoveWithStack()
  {
    Puzzle8State start = new Puzzle8State(Arrays.copyOf(this.sequence,this.sequence.length));
    dfs.push(start);
    while (!dfs.isEmpty())
    {
      popinvocation++;
      this.sequence = dfs.pop().sequence;
      generateNextMove();
      if (goalreach == true){break ;}
    }
  }

  private boolean isGoal(int[] seq)
  {
    Puzzle8State currentState = new Puzzle8State(seq);
    Puzzle8State goalState = new Puzzle8State(new int[]{1,2,3,4,5,6,7,8,9});
    return goalState.equals(currentState);
  }

  static void demo1()
  {
    Puzzle8_651521 game = new Puzzle8_651521(new int[]{9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
    game.displayBoard();
  }

  static void demo2()
  {
    Puzzle8_651521 game = new Puzzle8_651521(new int[]{9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
    game.generateNextMove();
  }

  static void demo3()
  {
    Puzzle8_651521 game = new Puzzle8_651521(new int[]{9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
    game.nextMoveWithStack();
    System.out.println("number of pop invocation = " + game.popinvocation);
    System.out.println("stack size = " + game.dfs.size());
    System.out.println("explored size = " + game.explored.size());
    System.out.println("Partial Explored State");
    for (Puzzle8State s : game.explored)
    {
      if (s.sequence[0] == 1 && s.sequence[1] == 2 && s.sequence[2] == 3 && s.sequence[3] == 4)
        System.out.println(Arrays.toString(s.sequence));
    }
    System.out.println("Note that the Program terminates prior to pushing goal state into explored!!");
  }
}