import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Part 2
class Day4 {
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
    int sum = 0;

    // M  S    S  M    S  S    M  M
    //  A       A       A       A
    // M  S   S  M    M  M    S  S

    // M S
    for (int line = 0; line < text.size()-2; line++) {
        for (int i = 0; i < text.get(line).length()-2; i++) {
          if(text.get(line).substring(i, i+1).equals("M") && text.get(line).substring(i+2, i+3).equals("S") 
                    && text.get(line+1).substring(i+1, i+2).equals("A") 
          && text.get(line+2).substring(i, i+1).equals("M") && text.get(line+2).substring(i+2, i+3).equals("S") ){
              sum++;
          }
        }
    }

    // S M
    for (int line = 0; line < text.size()-2; line++) {
        for (int i = 0; i < text.get(line).length()-2; i++) {
          if(text.get(line).substring(i, i+1).equals("S") && text.get(line).substring(i+2, i+3).equals("M") 
                    && text.get(line+1).substring(i+1, i+2).equals("A") 
          && text.get(line+2).substring(i, i+1).equals("S") && text.get(line+2).substring(i+2, i+3).equals("M") ){
              sum++;
          }
        }
    }

    // S S
    for (int line = 0; line < text.size()-2; line++) {
        for (int i = 0; i < text.get(line).length()-2; i++) {
          if(text.get(line).substring(i, i+1).equals("S") && text.get(line).substring(i+2, i+3).equals("S") 
                    && text.get(line+1).substring(i+1, i+2).equals("A") 
          && text.get(line+2).substring(i, i+1).equals("M") && text.get(line+2).substring(i+2, i+3).equals("M") ){
              sum++;
          }
        }
    }

    // M M
    for (int line = 0; line < text.size()-2; line++) {
        for (int i = 0; i < text.get(line).length()-2; i++) {
          if(text.get(line).substring(i, i+1).equals("M") && text.get(line).substring(i+2, i+3).equals("M") 
                    && text.get(line+1).substring(i+1, i+2).equals("A") 
          && text.get(line+2).substring(i, i+1).equals("S") && text.get(line+2).substring(i+2, i+3).equals("S") ){
              sum++;
          }
        }
    }

   //final answer
    System.out.println("the result is: "+ sum);
  }
}

//Part 1
/*
 class Day4 {
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
    int sum = 0;

    //horizontal
    //vertical
    //diagonal left
    //diagonal right
    
    // -
    for (int line = 0; line < text.size(); line++) {
      for (int i = 0; i < text.get(line).length()-3; i++) {
        if(text.get(line).substring(i, i+4).equals("XMAS")
        || text.get(line).substring(i, i+4).equals("SAMX")){
            sum++;
        }
      }
    }

    // |
    for (int line = 0; line < text.size()-3; line++) {
        for (int i = 0; i < text.get(line).length(); i++) {
          if(text.get(line).substring(i, i+1).equals("X") && text.get(line+1).substring(i, i+1).equals("M") && text.get(line+2).substring(i, i+1).equals("A") && text.get(line+3).substring(i, i+1).equals("S")
          || text.get(line).substring(i, i+1).equals("S") && text.get(line+1).substring(i, i+1).equals("A") && text.get(line+2).substring(i, i+1).equals("M") && text.get(line+3).substring(i, i+1).equals("X")){
              sum++;
          }
        }
    }

    // \
    for (int line = 0; line < text.size()-3; line++) {
        for (int i = 0; i < text.get(line).length()-3; i++) {
          if(text.get(line).substring(i, i+1).equals("X") && text.get(line+1).substring(i+1, i+2).equals("M") && text.get(line+2).substring(i+2, i+3).equals("A") && text.get(line+3).substring(i+3, i+4).equals("S")
          || text.get(line).substring(i, i+1).equals("S") && text.get(line+1).substring(i+1, i+2).equals("A") && text.get(line+2).substring(i+2, i+3).equals("M") && text.get(line+3).substring(i+3, i+4).equals("X")){
              sum++;
          }
        }
    }

    // /
    for (int line = 0; line < text.size()-3; line++) {
        for (int i = 3; i < text.get(line).length(); i++) {
          if(text.get(line).substring(i, i+1).equals("X") && text.get(line+1).substring(i-1, i).equals("M") && text.get(line+2).substring(i-2, i-1).equals("A") && text.get(line+3).substring(i-3, i-2).equals("S")
          || text.get(line).substring(i, i+1).equals("S") && text.get(line+1).substring(i-1, i).equals("A") && text.get(line+2).substring(i-2, i-1).equals("M") && text.get(line+3).substring(i-3, i-2).equals("X")){
              sum++;
          }
        }
    }

   //final answer
    System.out.println("the result is: "+ sum);
  }
}

 */