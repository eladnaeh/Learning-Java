package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        try{

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//        System.out.println("\n");
//        //Path filePath = FileSystems.getDefault().getPath("files","SubDirectoryFile.txt");
//        //Path filePath = FileSystems.getDefault().getPath("files/SubDirectoryFile.txt");
//        Path filePath = Paths.get(".","files","SubDirectoryFile.txt"); // --------------
//        printFile(filePath);
//        System.out.println("\n");
//        filePath = Paths.get("C://Users/ejhon/IdeaProjects/OutThere.txt");
//        printFile(filePath);
//        System.out.println("\n");
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//    }
//    private static void printFile(Path path){
//        try(BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while ((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
   }
}
