package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHelper {



    public static List<String> slurp(String filepath){
        List<String> list =  null;


        try{
            list = Files.readAllLines(Paths.get(filepath));
            for (int i = 0; i < list.size(); i += 1) {
                System.out.println(list.get(i));
            }
            return list;

        }catch(IOException e){
            System.out.println("there is an error");
            e.printStackTrace();
            System.exit(1);
        }
        return list;

    }

    public static void spit(String filename, List<String> contents){
        try{
            Files.write(Paths.get(filename), contents, StandardOpenOption.CREATE);
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static void spit(String filename, List<String>contents, boolean append){
        try{
            Files.write(Paths.get(filename), contents,StandardOpenOption.APPEND);
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void makeExciting(String filename) {
        List<String> data = new ArrayList<>();
        for(String line : slurp(filename)) {
            data.add(line.toUpperCase() + "!");
        }
        spit(filename, data);
    }

    public static void main(String[] args) {
        List<String> test = Arrays.asList("hello", "i am ", "a new file.");
        spit("test", test);
        makeExciting("test");
    }
}



