package SpellChecker;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;
/*During the submission I added photos of the different inputs testing how the different things our algorithm should do. Feel free to test it yourself though.*/
public class Main {

    // Static alphabet for methods to use
    static char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    // Static arraylist so I can add bool to methods.
    // Method validation needed so all methods run whenever the else block activates.
    static ArrayList<String> retList = new ArrayList<>();


    public static void main(String[] args) {
        // Insert any misspelled word from the word list.
        System.out.println(checkSpelling("noteboko"));
    }

    private static List checkSpelling(String s){
        ArrayList<String> retList = new ArrayList<>();
        Hashtable newHash = words();
        try{
            if(newHash.contains(s)){
                    retList.add(s);
                    System.out.println("Word is in Hash Table.");
                    return retList;
            } else {
                if(checkSingleInsert(s ,newHash)){ return retList;} else { retList = new ArrayList<>(); }
                if(checkReplace(s,newHash)){ return retList; } else { retList = new ArrayList<>(); }
                if(checkSwap(s,newHash)){ return retList; } else { retList = new ArrayList<>(); }
                if(checkDelete(s, newHash)){ return retList; } else { retList = new ArrayList<>(); }
            }
            if(retList.isEmpty()){
                System.out.println("Word isn't in Hash Table.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return retList;
    }

    // Done
    private static boolean checkSwap(String s , Hashtable newHash){
        char[] charArr = s.toCharArray();
        char temp;

        for(int i =0; i<s.length(); i++){
            for(int k= i + 1; k<s.length(); k++){

                temp= charArr[i];
                charArr[i] = charArr[k];
                charArr[k] = temp;

                String newString = new String(charArr);
               // System.out.println(newString);

                if(newHash.contains(newString)){
                    System.out.println(newString);
                    retList.add(newString);
                    return true;
                } else {
                    charArr = s.toCharArray();
                }
            }
        }   return false;
    }

    // Done
    private static boolean checkReplace(String s , Hashtable newHash){
        char[] charArr = s.toCharArray();

        for(int i =0; i< s.length() -1; i++){
            for(int k=0; k<26; k++){

                charArr[i] = alph[k];
                String newString = new String(charArr);

                if(newHash.contains(newString)){
                    System.out.println(newString);
                    retList.add(newString);
                    return true;
                } else {
                    charArr = s.toCharArray();
                }
            }
        }   return false;
    }

    // Done
    private static boolean checkDelete(String s , Hashtable newHash){
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);

        for(int i =0; i < s.length() -1; i++){
            sb.deleteCharAt(i);
            String newString = new String(sb);
            if(newHash.contains(newString)){
                System.out.println(newString);
                retList.add(newString);
                return true;
            } else {
                sb = new StringBuilder(s);
            }
        }   return false;
    }



    private static boolean checkSingleInsert(String s , Hashtable newHash) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length() + 1; i++) {
            for (int k = 0; k < 26; k++) {

                sb.insert(i, alph[k]);
                String newString = new String(sb);

                if(newHash.contains(newString)){
                    System.out.println(newString);
                    retList.add(newString);
                    return true;
                } else {
                    sb = new StringBuilder(s);
                }
            }
        } return false;
    }

    // Done
    private static Hashtable words(){
        Hashtable<Integer, String> words = new Hashtable<>();
        try {
            // If you try to run this on your machine change file directory
            File file = new File("/Users/eckzahn/Documents/DSPRJ2/src/SpellChecker/words.rtf");
            Scanner scan = new Scanner(new FileReader(file));
            // traverse through the file then add to hash table
            for(int i=0; i<20; i++) {
                String word = scan.next();
                words.put(i , word);
            i++;//
            } // try catch block for any errors
        } catch (Exception e){
            e.printStackTrace();
        }   return words;
    }
}
