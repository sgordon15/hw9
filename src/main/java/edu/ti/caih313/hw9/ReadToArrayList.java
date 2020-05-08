package edu.ti.caih313.hw9;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadToArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList> sentencesList = new ArrayList<ArrayList>();

        String homeFolder = System.getenv("HOMEPATH");
        String fileName = homeFolder + "/Documents/out.txt";

        Scanner inputStream = null;
        try {
//the File class knows how to negotiate the file system to access data
            File file = new File(fileName);
            inputStream = new Scanner(file);
            while (inputStream.hasNextLine()) {
                ArrayList<String> words = new ArrayList<String>();
                String line = inputStream.nextLine();

                String stringArray[] = line.split(" ");
                for(int i = 0; i <stringArray.length; i++) {
                    String s = stringArray[i];
                    words.add(s);
                    sentencesList.add(words);
                }
            }
        } catch (FileNotFoundException e) {

            System.out.println("Error opening the file " + fileName + ": " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter sentence number: ");
        int sentenceNumber = keyboard.nextInt();
        System.out.println("Enter word number: ");
        int wordNumber = keyboard.nextInt();

        if(sentenceNumber<=0||sentenceNumber> sentencesList.size()){
            System.out.println("sentence number must be in between 1 and" + sentencesList.size()+"inclusive.");
            System.exit(0);
        }
        if (wordNumber<=0|| wordNumber> sentencesList.get((int) (sentenceNumber-1)).size()){
            System.out.println("word number must be in between 1 and" + sentencesList.get((int) (sentenceNumber-1)).size() + "inclusive");
            System.exit(0);
        }

        ArrayList desireSentence = sentencesList.get( sentenceNumber-1 );
        Object desiredWord = desireSentence.get( wordNumber -1);
        System.out.println("the word on sentence "+ sentenceNumber + "at position" +wordNumber+ "is" +desiredWord);
    }
}


    //hi my mane is sara
       // i love to read
       // I also like chocolate