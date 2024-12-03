import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Part 2
class Day2 {
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
    int numOfSafe = 0;
    
    // for line
    for (int line = 0; line < text.size(); line++) {
      
      //make a line into arraylist
      ArrayList<Integer> report = new ArrayList<Integer>();
      int i = 0;
      while(i<text.get(line).length()){
        String currIntS = "";
        while(i < text.get(line).length() && !text.get(line).substring(i, i+1).equals(" ")){
          currIntS += text.get(line).substring(i, i+1);
          i++;
        }
        report.add(Integer.parseInt(currIntS));
        i++;
      }

      //check is there exists a safe posibility
      int safeCases = 0;
      for(int j = 0; j<report.size(); j++){

        ArrayList<Integer> copiedList = new ArrayList<>();
        for(int x : report){
          copiedList.add(x);
        }
        copiedList.remove(j);
        safeCases += isSafe(copiedList);
      }

      if(safeCases > 0)
        numOfSafe++;
      
    }

    //final answer
    System.out.println("the result is: "+ numOfSafe);
  }


  public static int isSafe(ArrayList<Integer> text){

    boolean isIncreasing = true;

    //set increase/decrease
    if(text.get(0)<text.get(1))
      isIncreasing = true;
    if(text.get(0)>text.get(1))
      isIncreasing = false;

    //if there is a probelm, note it
    for(int i=0; i<text.size()-1; i++){
      if((text.get(i)>text.get(i+1) && isIncreasing || text.get(i)<text.get(i+1) && !isIncreasing)//slope sign change
      || (text.get(i)==text.get(i+1) || Math.abs(text.get(i)-text.get(i+1))>3)){//change is 0 or >3
        return 0;
      }
    }
    
    return 1;
  }
}



//Part 1
/*
 class Day2 {
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
    int numOfSafe = 0;
    
    // for line
    for (int line = 0; line < text.size(); line++) {
      if(isSafe(text, line))
        numOfSafe++;
      System.out.println();
    }

   //final answer
    System.out.println("the result is: "+ numOfSafe);
  }



  public static boolean isSafe(ArrayList<String> text, int line){
    String currIntS = "";
    String nextIntS = "";
    int nextInt;
    int currInt = 0;
    boolean isIncreasing = true;

    // get first pair
    int i = 0;
    while(i < text.get(line).length() && !text.get(line).substring(i, i+1).equals(" ")){
      currIntS += text.get(line).substring(i, i+1);
      i++;
    }System.out.print(currIntS + " ");
    
    //to get over the space
    i++;

    while(i < text.get(line).length() && !text.get(line).substring(i, i+1).equals(" ")){
      nextIntS += text.get(line).substring(i, i+1);
      i++;
    }System.out.print(nextIntS +" ");

    //translate
    currInt = Integer.parseInt(currIntS);
    nextInt = Integer.parseInt(nextIntS);
    
    //set increase/decrease
    if(currInt<nextInt)
      isIncreasing = true;
    if(currInt>nextInt)
      isIncreasing = false;

    //check first pair
    if(nextInt==currInt || Math.abs(currInt-nextInt)>3)
      return false;
    
    //switch back
    currInt = nextInt;
    //get over the space
    i++;

    //check the rest
    while(i < text.get(line).length()){
      nextIntS = "";

      while(i < text.get(line).length() && !text.get(line).substring(i, i+1).equals(" ")){
        nextIntS += text.get(line).substring(i, i+1);
        i++;
      }System.out.print(nextIntS +" ");

      //translate
      nextInt = Integer.parseInt(nextIntS);
      
      if(currInt>nextInt && isIncreasing || currInt<nextInt && !isIncreasing)
        return false;
      if(nextInt==currInt || Math.abs(currInt-nextInt)>3)
        return false;

      //switch back
      currInt = nextInt;
      //get over the space
      i++;

    }


    return true;
  }
}

 */