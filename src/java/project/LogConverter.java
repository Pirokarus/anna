package project;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LogConverter {

    public static List<LogLine> convertLogFile(File file) throws IOException {
        List<LogLine> out = new ArrayList<>();

        try (Reader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String stringLine;

            while ((stringLine = br.readLine()) != null){
                String[] line = stringLine.split(" ");
                out.add(new LogLine(
                        LocalDateTime.parse(line[2].replace("[", ""), DateTimeFormatter.ofPattern("dd/LLL/yyyy:HH:mm:ss", Locale.US)),
                        line[0],
                        line[7]
                ));
            }

        }

        return out;
    }

}
