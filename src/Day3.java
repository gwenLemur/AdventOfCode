import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Part 2
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


    //var declarations
    int sum = 0;
    int first = 0;
    int second = 0;
    boolean isRecording = true;

    // for line
    for (int line = 0; line < text.size(); line++) {
      // within line
      for (int i = 0; i < text.get(line).length()-3; i++) {

        //check for on/off switch
        if(text.get(line).substring(i, i+4).equals("do()"))
          isRecording=true;
        if(i < text.get(line).length()-6 && text.get(line).substring(i, i+7).equals("don't()"))
          isRecording=false;

        //set up for first
        if(isRecording &&  text.get(line).substring(i, i+4).equals("mul(")){
          i+=4;
          
          //add digits
          String currIntS = "";
          while(i < text.get(line).length() && isDigit(text.get(line).substring(i, i+1))){
            currIntS += text.get(line).substring(i, i+1);
            i++;
          }
          if(currIntS.equals("")) 
            currIntS = "0";
          first = Integer.parseInt(currIntS);

          //set up for second
          if(text.get(line).substring(i, i+1).equals(",")){
            i++;

            //add digits
            currIntS = "";
            while(i < text.get(line).length() && isDigit(text.get(line).substring(i, i+1))){
              currIntS += text.get(line).substring(i, i+1);
              i++;
            }
            if(currIntS.equals("")) 
              currIntS = "0";
            second = Integer.parseInt(currIntS);

            //final check
            if(text.get(line).substring(i, i+1).equals(")")){
              //System.out.println(first+", "+second);
              sum += first*second;
            }
          }  
        }
      }
    }

   //final answer
    System.out.println("the result is: "+ sum);
  }

  public static boolean isDigit(String x){
    if(x.equals("1") || x.equals("2") ||
    x.equals("3") || x.equals("4") ||
    x.equals("5") || x.equals("6") ||
    x.equals("7") || x.equals("8") ||
    x.equals("9") || x.equals("0") ){
      return true;
    }
    return false;
  }
}

//Part 1
/*
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


    //var declarations
    int sum = 0;
    int first = 0;
    int second = 0;

    // for line
    for (int line = 0; line < text.size(); line++) {
      // within line
      for (int i = 0; i < text.get(line).length()-3; i++) {

        //set up for first
        if(text.get(line).substring(i, i+4).equals("mul(")){
          i+=4;

          //add digits
          String currIntS = "";
          while(i < text.get(line).length() && isDigit(text.get(line).substring(i, i+1))){
            currIntS += text.get(line).substring(i, i+1);
            i++;
          }
          if(currIntS.equals("")) 
            currIntS = "0";
          first = Integer.parseInt(currIntS);

          //set up for second
          if(text.get(line).substring(i, i+1).equals(",")){
            i++;

            //add digits
            currIntS = "";
            while(i < text.get(line).length() && isDigit(text.get(line).substring(i, i+1))){
              currIntS += text.get(line).substring(i, i+1);
              i++;
            }
            if(currIntS.equals("")) 
              currIntS = "0";
            second = Integer.parseInt(currIntS);

            //final check
            if(text.get(line).substring(i, i+1).equals(")")){
              //System.out.println(first+", "+second);
              sum += first*second;
            }
          }  
        }
      }
    }
    
   //final answer
    System.out.println("the result is: "+ sum);
  }

  public static boolean isDigit(String x){
    if(x.equals("1") || x.equals("2") ||
    x.equals("3") || x.equals("4") ||
    x.equals("5") || x.equals("6") ||
    x.equals("7") || x.equals("8") ||
    x.equals("9") || x.equals("0") ){
      return true;
    }
    return false;
  }
}
 */