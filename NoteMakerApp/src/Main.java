import java.io.FileWriter;
import java.io.IOException;
public class Main{
    public static void main(String[] args){
        try{
            FileWriter writer = new FileWriter("Text.txt");
            writer.write("This is my first fileeee!!");
            writer.close();
            System.out.println("Writing operation done!!");
        }
        catch(IOException e){
            System.out.println(e);
        }

    }
}