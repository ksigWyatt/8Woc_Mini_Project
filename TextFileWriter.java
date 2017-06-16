import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author ann_ejones
 */
public class TextFileWriter {
    
    public static void main(String args[]){

        Scanner scan = new Scanner(/*file name of results from API?*/System.in);
        String text = scan.nextLine();
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try
        {
          fWriter = new FileWriter("Translation.txt");
          writer = new BufferedWriter(fWriter);
          writer.write(text);
          writer.newLine();
          writer.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

}

