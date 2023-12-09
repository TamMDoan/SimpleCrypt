
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static String readFile(){
        Caesar caesar = new Caesar('A', 'N');
        String encryptedText = "";
        try{
            File baseFile = new File("sonnet18.txt");
            Scanner scanner = new Scanner(baseFile);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                encryptedText += caesar.encrypt(line) + "\n";
            }

        }
        catch(IOException e){
            System.out.println("Cannot find file!");
        }

        return encryptedText;
    }

    public static void writeFile(String text){
        try {
            FileWriter fileWriter = new FileWriter("sonnet18.enc");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(text);
            printWriter.close();

        }
        catch(IOException e){
            System.out.println("Cannot write to file!");
        }
    }

    public static void main(String[] args){
        String encrytypedText = readFile();
        writeFile(encrytypedText);
    }
}
