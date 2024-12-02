import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Day3 {
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

    //use ArrayList "text" to solve the problem here

    //final answer
    System.out.println("the result is: ");
  }
}





