import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Day5 {
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

    //scan2
    ArrayList<String> text2 = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("text2.md"))) {
      String line2;
      while ((line2 = br.readLine()) != null) {
        //add all lines to arraylist
        text2.add(line2);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


    //var declarations
   int[][] rules = new int[text.size()][2];

    // make X and Ys usable
    for (int line = 0; line < text.size(); line++) {
        rules[line][0] = Integer.parseInt(text.get(line).substring(0,2));
        rules[line][1] = Integer.parseInt(text.get(line).substring(3,5));
    }

    //add
    int sum = 0;
    for (int line = 0; line < text2.size(); line++) {
        sum += inOrder(text2.get(line), rules);
    }

   //final answer
    System.out.println("the result is: "+ sum);
  }



  public static int inOrder(String lin,  int[][] rules){

    ArrayList<String> li = new ArrayList<String>();
    for (int i = 0; i < lin.length(); i+=3) {
        li.add(lin.substring(i, i+2));
    }
   
    for (int i = 0; i < li.size(); i++) {
        
        for(int j=0; j<rules.length; j++){
            if(li.get(i).equals(""+rules[j][0]) && contains(lin.substring(0,i*3),""+rules[j][1])
            || li.get(i).equals(""+rules[j][1]) && contains(lin.substring(i*3), ""+rules[j][0])){
                return getMiddle(li, rules, lin);
            }
            
        }
         
    }

    return 0;
  }


  //sorting algorithm
  public static int getMiddle(ArrayList<String> li,  int[][] rules, String lin){
    
    //what place is being filled
    for(int i=0; i<li.size()-1; i++){
        //what its being compared to
        for(int j=i+1; j<li.size(); j++){
            //rules
            for(int k=0; k<rules.length; k++){
                if(li.get(i).equals(""+rules[k][1]) && li.get(j).equals(""+rules[k][0])){
                    //preform a swap
                    String x = li.get(i);
                    li.set(i, li.get(j));
                    li.set(j, x);
                    j=i;
                }
            }

        }
    }

    return Integer.parseInt(li.get(li.size()/2));
    }
    

  public static boolean correct(ArrayList<String> li,  int[][] rules, String lin){

    for (int i = 0; i < li.size(); i++) {
        for(int j=0; j<rules.length; j++){
            if(li.get(i).equals(""+rules[j][0]) && contains(lin.substring(0,i*3),""+rules[j][1])){
                //System.out.println(rules[j][0]+"|"+rules[j][1] +" for "+lin+" because "+lin.substring(0,i*3).indexOf(rules[j][1]));
                return false;
            }

            if(li.get(i).equals(""+rules[j][1]) && contains(lin.substring(i*3), ""+rules[j][0])){
                //System.out.println(rules[j][0]+"||"+rules[j][1] +" for "+lin+" because "+lin.substring(i*3).indexOf(rules[j][0]));
                return false;
            }
        }
    }
    return true;
  }


  public static int indexOf(String base, String query){
    for(int i = 0; i<base.length()-query.length(); i++){
        if(base.substring(i, i+query.length()).equals(query)){
            return i;
        }
    }
    return -1;
    }


  public static boolean contains(String base, String query){
        for(int i = 0; i<base.length()-query.length(); i++){
            if(base.substring(i, i+query.length()).equals(query)){
                return true;
            }
        }
        return false;
  }

}

//Part 1
/*class Day5 {
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

    //scan2
    ArrayList<String> text2 = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("text2.md"))) {
      String line2;
      while ((line2 = br.readLine()) != null) {
        //add all lines to arraylist
        text2.add(line2);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }



    //var declarations
   int[][] rules = new int[text.size()][2];

    // make X and Ys usable
    for (int line = 0; line < text.size(); line++) {
        rules[line][0] = Integer.parseInt(text.get(line).substring(0,2));
        rules[line][1] = Integer.parseInt(text.get(line).substring(3,5));
      
    }

    //eliminate the bad lines
    int sum = 0;
    for (int line = 0; line < text2.size(); line++) {
        // within line
        sum += inOrder(text2.get(line), rules);
    
    }

   //final answer
    System.out.println("the result is: "+ sum);
  }


  public static int inOrder(String lin,  int[][] rules){

    ArrayList<String> li = new ArrayList<String>();
    for (int i = 0; i < lin.length(); i+=3) {
        li.add(lin.substring(i, i+2));
    }
   
    for (int i = 0; i < li.size(); i++) {
        
     //System.out.println(i);

        for(int j=0; j<rules.length; j++){
            if(li.get(i).equals(""+rules[j][0]) && contains(lin.substring(0,i*3),""+rules[j][1])){
                //System.out.println(rules[j][0]+"|"+rules[j][1] +" for "+lin+" because "+lin.substring(0,i*3).indexOf(rules[j][1]));
                return 0;
            }

            if(li.get(i).equals(""+rules[j][1]) && contains(lin.substring(i*3), ""+rules[j][0])){
                //System.out.println(rules[j][0]+"||"+rules[j][1] +" for "+lin+" because "+lin.substring(i*3).indexOf(rules[j][0]));
                return 0;
            }
            
        }
         
    }

    return Integer.parseInt(li.get(li.size()/2));
  }

  public static boolean contains(String base, String query){
        for(int i = 0; i<base.length()-query.length(); i++){
            if(base.substring(i, i+query.length()).equals(query)){
                return true;
            }
        }
        return false;
  }

} */