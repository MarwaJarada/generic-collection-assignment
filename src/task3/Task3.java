package task3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) throws IOException {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        Map<String,Integer> wordsMap=new HashMap<>();
        Map<Character, Integer> charMap=new HashMap<>();

         file=new File("txt.txt");
         fileReader=new FileReader(file);
         bufferedReader=new BufferedReader(fileReader);
        Scanner s=new Scanner(file);
        while (s.hasNext()){
            String word= s.next();
            if (wordsMap.containsKey(word)) {
                wordsMap.replace(word,wordsMap.get(word)+1);
            }else
                wordsMap.put(word,1);
        }
        System.out.println(wordsMap);

        int charactreNum=fileReader.read();
        while (charactreNum!=-1) {
            char charactre = (char) charactreNum;
            if (charMap.containsKey(charactre)) {
                charMap.replace(charactre,charMap.get(charactre)+1);
            }else charMap.put(charactre, 1);
            charactreNum=fileReader.read();
        }
        System.out.println(charMap);
    }
}
