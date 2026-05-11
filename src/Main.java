import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class Main{
    public static void main(String[] args){
       File productfile= new File("C:\\Users\\FAHIM\\Downloads\\ECOM_DATASHEET (1).txt");

       HashMap<String,Integer>map=new HashMap<>();
       try{
           Scanner vc=new Scanner(productfile);
           vc.nextLine();

           while(vc.hasNextLine()){
               String line=vc.nextLine();
               String[] parts= line.trim().split("\\s+");
               String product = parts[7]+" "+parts[8];
               int amount = Integer.parseInt(parts[9]);
               if (map.containsKey(product)) {
                   map.put(product,map.get(product)+amount);
               } else {
                   map.put(product,amount);
               }
           }
           vc.close();
           for(String key : map.keySet()){
               System.out.println(key + " " + map.get(key));
           }
       } catch (FileNotFoundException e){
           e.printStackTrace();
       }
    }
}
