import java.util.Arrays;

public class Puzzle8State {
  int[] sequence;
  int score = 0;

  public Puzzle8State(int[] seq)
  {
    this.sequence = seq;
  }

  @Override
  public boolean equals(Object obj)
  {
    Puzzle8State that = (Puzzle8State) obj; 
    return Arrays.equals(that.sequence, this.sequence);
  }

  @Override
  public String toString() {
    return Arrays.toString(sequence);
  }

  
}
