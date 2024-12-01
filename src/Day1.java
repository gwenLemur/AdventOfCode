import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//Part 2
class Day1 {
  public static void main(String[] args) {

    //scan
    ArrayList<String> text = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("text.md"))) {
      String line;
      while ((line = br.readLine()) != null) {
        //add all lines to arraylist
        text.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    //var declarations
    int[] first = new int[text.size()];
    int[] second = new int[text.size()];
    
    // assign values from input
    for (int line = 0; line < text.size(); line++) {
      first[line] = Integer.parseInt(text.get(line).substring(0,5));
      second[line] = Integer.parseInt(text.get(line).substring(8));
    }

    for (int intFirst = 0; intFirst < text.size(); intFirst++) {
      //find how many times number from first appears in second
      int sum = 0;
      for (int intSecond = 0; intSecond < text.size(); intSecond++) {
        if( first[intFirst] == second[intSecond])
          sum++;
      }
      //update ints in first accordingly
      first[intFirst] *= sum;
    }

    //total ints from first
    int sum = 0;
    for(int i : first){
      sum += i;
    }

   //final answer
    System.out.println("the result is: "+ sum);

  }
}

//Part 1
/*   
 class Day1 {
  public static void main(String[] args) {

    //scan
    ArrayList<String> text = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("text.md"))) {
      String line;
      while ((line = br.readLine()) != null) {
        //add all lines to arraylist
        text.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    //var declarations
    int[] first = new int[text.size()];
    int[] second = new int[text.size()];
    
    // assign values from input
    for (int line = 0; line < text.size(); line++) {
      first[line] = Integer.parseInt(text.get(line).substring(0,5));
      second[line] = Integer.parseInt(text.get(line).substring(8));
    }

    //sort each
    Arrays.sort(first);
    Arrays.sort(second);

    //tally
    int sum = 0;
    for (int line = 0; line < text.size(); line++) {
      sum += Math.abs(first[line] - second[line]);
    }

   //final answer
    System.out.println("the result is: "+ sum);

  }
}
*/