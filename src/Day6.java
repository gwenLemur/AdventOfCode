import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Day6 {
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
    int x = 0;
    int y = 0;
    String direction = "w";
    
  
    for (int line = 0; line < text.size(); line++) {
      for (int i = 0; i < text.get(line).length(); i++) {
        if(text.get(line).substring(i,i+1).equals("^")){
          x = i;
          y = line;
          
        }
      }
    }

    System.out.println(text.get(0).length()*text.size());

    int count = 1;
    while(count <= 16900 && x!=0 && x!=text.get(0).length()-1 && y!=0 && y!=text.size()-1){

      if(direction.equals("w")){
        if(!text.get(y-1).substring(x, x+1).equals("#")){
            if(!text.get(y-1).substring(x, x+1).equals("X")) count++;
            System.out.println(count);
          text.set(y, text.get(y).substring(0,x)+"X"+text.get(y).substring(x+1));
          if(!text.get(y-1).substring(x, x+1).equals("X")) count++;
          y--;
        }else{
          direction = "d";
        }
      }

      else if(direction.equals("d")){
        if(!text.get(y).substring(x+1, x+2).equals("#")){
            if(!text.get(y).substring(x+1, x+2).equals("X")) count++;
            System.out.println(count);
          text.set(y, text.get(y).substring(0,x)+"X"+text.get(y).substring(x+1));
          x++;
        }else{
          direction = "s";
        }
      }

      else if(direction.equals("s")){
        if(!text.get(y+1).substring(x, x+1).equals("#")){
            if(!text.get(y+1).substring(x, x+1).equals("X")) count++;
            System.out.println(count);
          text.set(y, text.get(y).substring(0,x)+"X"+text.get(y).substring(x+1));
          y++;
        }else{
          if(!text.get(y-1).substring(x, x+1).equals("X")) count++;
          direction = "a";
        }
      }

      else if(direction.equals("a")){
        if(!text.get(y).substring(x-1, x).equals("#")){
            if(!text.get(y).substring(x-1, x).equals("X")) count++;
            System.out.println(count);
          text.set(y, text.get(y).substring(0,x)+"X"+text.get(y).substring(x+1));
          x--;
        }else{
          if(!text.get(y-1).substring(x, x+1).equals("X")) count++;
          direction = "w";
        }
      }

    }

    //final
    text.set(y, text.get(y).substring(0,x)+"X"+text.get(y).substring(x+1));

    for(String l:text){
        System.out.println(l);
    }

    int sum = 0;

      for (int line = 0; line < text.size(); line++) {
        for (int i = 0; i < text.get(line).length(); i++) {
          
            if(text.get(line).substring(i, i+1).equals("X")){
              sum++;
            }
          
        }
      }

   //final answer
    System.out.println("the result is: "+ sum);
  }

}
