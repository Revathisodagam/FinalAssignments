package com.wipro.app;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class FileHandler {

    public static void main(String[] args) {
        Path inputFile = Paths.get("C:\\Users\\Ganesh Achanta\\Revathi Workspace\\Day18-Assignments\\src\\com\\main\\resources\\input.txt");
        Path outputFile = Paths.get("C:\\Users\\Ganesh Achanta\\Revathi Workspace\\Day18-Assignments\\src\\com\\main\\resources\\output.txt");

        try {
          
            FileChannel inputChannel = FileChannel.open(inputFile, StandardOpenOption.READ);
            FileChannel outputChannel = FileChannel.open(outputFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (inputChannel.read(buffer) > 0) {
                buffer.flip(); // flip the buffer for writing

                outputChannel.write(buffer);

                buffer.clear(); 
            }

            inputChannel.close();
            outputChannel.close();

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

