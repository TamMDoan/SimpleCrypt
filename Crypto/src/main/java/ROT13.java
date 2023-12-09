import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Character cs;
    Character cf;
    Map<Character, Character> encryptionMap;
    boolean encrypted = false;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this. cf = cf;
        createLookUpTable();
    }

    ROT13() {
        this.cs = 'A';
        this.cf = 'N';
        createLookUpTable();
    }

    private void createLookUpTable(){
        Map<Character, Character> map = new HashMap<>();
        int shift = this.cf - this.cs;

        // inputting values for capital letters
        for(int i = 65; i <= 90; i++){
            if(i + shift <= 90) {
                map.put((char) i, (char) (i + shift));
            }
            else{
                int loopAround = (i + shift) - 26;
                map.put((char) i, (char) loopAround);
            }
        }

        // inputting values for lowercase letters
        for(int i = 97; i <= 122; i++){
            if(i + shift <= 122){
                map.put((char) i, (char) (i + shift));
            }
            else{
                int loopAround = (i + shift) - 26;
                map.put((char) i, (char) loopAround);
            }
        }
        this.encryptionMap = map;

    }


    public String crypt(String text) throws UnsupportedOperationException {

        if(encrypted){
            text = decrypt(text);
        }
        else{
            text = encrypt(text);
        }
        return text;
    }

    public String encrypt(String text) {
        String encryptedString = "";
        for(int i = 0; i < text.length(); i++){
            if(!encryptionMap.containsKey(text.charAt(i))){
                encryptedString += text.charAt(i);
            }
            else {
                encryptedString += encryptionMap.get(text.charAt(i));
            }
        }
        encrypted = true;
        return encryptedString;
    }

    public String decrypt(String text) {
        String decryptedString = "";
        for(int i = 0; i < text.length(); i++){
            if(!encryptionMap.containsKey(text.charAt(i))){
                decryptedString += text.charAt(i);
            }
            else {
                decryptedString += encryptionMap.get(text.charAt(i));
            }
        }
        encrypted = false;
        return decryptedString;
    }

    public static String rotate(String s, Character c) {
        int index = s.indexOf(c);
        String rotatedString = s.substring(index);
        rotatedString += s.substring(0, index);

        return rotatedString;
    }

}
