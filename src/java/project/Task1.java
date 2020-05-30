package project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) throws IOException {


        List<LogLine> logLines = LogConverter.convertLogFile(new File(Task1.class.getClassLoader().getResource("web-access.log").getFile()));

        //1

        List<Map.Entry<String, Integer>> ipList = countIp(logLines);

        // Вывод ответа 1
        System.out.println("Вывод ответа 1");
        System.out.println(ipList.stream().sorted((x,y) -> y.getValue().compareTo(x.getValue())).limit(5).collect(Collectors.toList()));

        // 2

        List<Map.Entry<String, Integer>> ipList2 = countIp(logLines.stream().filter(logLine -> "404".equals(logLine.getStatus())).collect(Collectors.toList()));

        // Вывод ответа 2
        System.out.println("\nВывод ответа 2");
        System.out.println(ipList2.stream().sorted((x,y) -> y.getValue().compareTo(x.getValue())).findFirst().orElse(null));

        //3

        Map<Integer, Integer> hours = new HashMap<>();

        logLines.forEach(line -> {
            if (hours.get(line.getTimeLocal().getHour()) == null){
                hours.put(line.getTimeLocal().getHour(), 1);
            } else {
                hours.put(line.getTimeLocal().getHour(), hours.get(line.getTimeLocal().getHour()) + 1);
            }
        });

        List<Map.Entry<Integer, Integer>> hoursList = new ArrayList<>(hours.entrySet());

        // Вывод ответа 3
        System.out.println("\nВывод ответа 3");
        Map.Entry<Integer, Integer> activeHour = hoursList.stream().sorted((x,y) -> y.getValue().compareTo(x.getValue())).findFirst().orElse(null);
        System.out.println("Самый активный час: " + activeHour.getKey() + " Количество запросов: " + activeHour.getValue());


    }

    public static List<Map.Entry<String, Integer>> countIp(List<LogLine> logLines){
        Map<String, Integer> ip = new HashMap<>();

        logLines.forEach(line -> {
            if (ip.get(line.getRemoteAddr()) == null){
                ip.put(line.getRemoteAddr(), 1);
            } else {
                ip.put(line.getRemoteAddr(), ip.get(line.getRemoteAddr()) + 1);
            }
        });

        return new ArrayList<>(ip.entrySet());
    }
}
