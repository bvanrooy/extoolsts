package be.abis.courseadministration.util;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileUtil {

	public static void  writeToFile(ArrayList<String> lines,String fileName) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName), StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            for(String line:lines){
                bw.write(line + "\n");
            }
        }
    }
}
