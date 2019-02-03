package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static final String joinedFile = "joinedFile.txt";
    public static final String File1 = "file1.txt";
    public static final String File2 = "file2.txt";


    public static String data = null;


    public static void main(String[] args) {

        Object[] obj = findExtraInfo(File1, File2);
        manipulateData(obj);
        //joinFiles(data, joinedFile);

    }

    public static void joinFiles(String data, String fileName){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(data);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static Object[] findExtraInfo(String file1, String file2){

        try{
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            String line = null;

            ArrayList<String[]> wordsListReader1 = new ArrayList<>();
            while ((line = reader1.readLine()) != null){
                String[] words = line.split(",");
                //System.out.println(Arrays.toString(words));
                wordsListReader1.add(words);
            }

            ArrayList<String[]> wordsListReader2 = new ArrayList<>();
            while ((line = reader2.readLine()) != null){
                String[] words = line.split(",");
                wordsListReader2.add(words);
            }

            return new Object[]{wordsListReader1, wordsListReader2};

        }
        catch (IOException e){
            e.printStackTrace();
            return new Object[]{};
        }

    }

    public static void manipulateData(Object[] object){

        ArrayList listAll = new ArrayList();

        ArrayList<String[]> words = new ArrayList<>();

        ArrayList<String[]> words1 = new ArrayList<>();
        ArrayList<String[]> words2 = new ArrayList<>();
        words1 = (ArrayList) object[0];
        words2 = (ArrayList) object[1];

        words = combineFiles(words1, words2);




        for (String[] word : words){

            for(int i=0; i<words.size(); i++){
                if( (words.get(i)[0]).equals(word[0]) && (words.get(i)[1]).equals(word[1])){
                    if(words.get(i)[0] != word[0] && words.get(i)[1] != word[1]){
                        //System.out.println(Arrays.toString(word) + " --- " + Arrays.toString(words.get(i)));
                        List list = new ArrayList(Arrays.asList(word));
                        list.addAll(Arrays.asList(words.get(i)));
                        listAll.add(list);
                    }
                    if(words.get(i)[0] == word[0] && words.get(i)[1] == word[1]){

                    }
                }
            }
        }



        System.out.println(listAll);



    }

    public static ArrayList<String[]> combineFiles(ArrayList<String[]> array1, ArrayList<String[]> array2){
        for (String[] array : array1){
            array2.add(array);
        }
        return array2;
    }
}
