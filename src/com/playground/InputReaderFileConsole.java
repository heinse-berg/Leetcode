package com.playground;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class InputReaderFileConsole {

    static String pathString = "E:/Coding/resources/sample.txt";
    static Path samplePath = Paths.get(pathString);

    private static void readFile() throws Exception {

        List<String> allLinesInMemory = Files.readAllLines(samplePath);
        String fileContents = new String(Files.readAllBytes(samplePath));

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(pathString))) {
            int b;
            while((b = bufferedInputStream.read()) != -1) {
                System.out.println((char) b);
            }
        }

        //read only line at a time
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathString))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void readConsoleUtility() {
        Console console = System.console();
        String input;
        while((input = console.readLine("Enter input")) != null) {
            System.out.println("You had entered : " + input);
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Pleas eneter");
        while(scanner.hasNextLine()) {
            input = scanner.nextLine();
            System.out.println("You had entered : " + input);
            System.out.println("Pleas eneterrr");
        }
        scanner.close();
    }

    public static void main(String[] args) throws Exception {

        readFile();
        readConsoleUtility();
    }
}
