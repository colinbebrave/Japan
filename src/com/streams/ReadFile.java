package com.streams;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) throws IOException
    {
        String contents = new String(Files.readAllBytes(
                Paths.get("/Users/wangqi/Downloads/alice.txt")
        ), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split(" "));
        long count_1 = 0;
        for (String w : words)
        {
            if (w.length() > 8) System.out.println(w);
        }
        //System.out.println(count_1);
    }
}
