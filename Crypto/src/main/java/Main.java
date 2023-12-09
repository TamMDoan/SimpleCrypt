
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static String readFile(String fileName){
        Caesar caesar = new Caesar('A', 'N');
        String encryptedText = "";
        try{
            File baseFile = new File(fileName);
            Scanner scanner = new Scanner(baseFile);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                encryptedText += caesar.crypt(line) + "\n";
            }

        }
        catch(IOException e){
            System.out.println("Cannot find file!");
        }

        return encryptedText;
    }

    public static void writeFile(String text, String fileName){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(text);
            printWriter.close();

        }
        catch(IOException e){
            System.out.println("Cannot write to file!");
        }
    }

    public static void main(String[] args){
        String encrytypedText = readFile("sonnet18.txt");
        writeFile(encrytypedText, "sonnet18.enc");

        String decryptedText = readFile("sonnet18.enc");
        writeFile(decryptedText, "sonnet18_decrypted.txt");

    }
}
