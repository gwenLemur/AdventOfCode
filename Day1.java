import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {

    //scan
    ArrayList<String> text = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        //add all lines to arraylist
        text.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    //var declaration
    ArrayList<int[]> gears = new ArrayList<int[]>();
    int sum = 0;
    
    // for line
    for (int line = 0; line < text.size(); line++) {
      // within line
      for (int i = 0; i < text.get(line).length(); i++) {

       
      }
    }

   //final answer
    System.out.println("the result is: ");
  }
}
