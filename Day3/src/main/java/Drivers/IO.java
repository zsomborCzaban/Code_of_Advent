package Drivers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {
    public static String readCorruptedMemory(String path) throws Exception {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException exception) {
            throw new Exception("reading input file failed: " + exception);
        }
    }
}