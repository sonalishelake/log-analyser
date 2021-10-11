package com.github.sonalishelake.loganalyser.utilities;

import com.github.sonalishelake.loganalyser.model.EventInfo;
import com.github.sonalishelake.loganalyser.model.EventTypeInfo;
import com.github.sonalishelake.loganalyser.model.StateInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LogFileGenerator {

    private LogFileGenerator() {

    }

    public static void generateFile(String path, int numberOfEvents) {
        List<EventInfo> events = new ArrayList<>();

        for (int i = 0; i < numberOfEvents * 2; i++) {
            String id = generateRandomUuid();
            StateInfo state = chooseFrom(StateInfo.STARTED, StateInfo.FINISHED);
            EventTypeInfo type = chooseFrom(EventTypeInfo.APPLICATION_LOG, null);
            long timestamp = System.currentTimeMillis();
            String host = chooseFrom(generateRandomIp(), null);
            EventInfo startEvent = new EventInfo();
            startEvent.setId(id);
            startEvent.setState(StateInfo.STARTED);
            startEvent.setHost(host);
            startEvent.setType(type);
            startEvent.setTimestamp(timestamp);

            EventInfo endEvent = new EventInfo();
            endEvent.setId(id);
            endEvent.setState(StateInfo.FINISHED);
            endEvent.setHost(host);
            endEvent.setType(type);
            endEvent.setTimestamp((long) (timestamp + Math.random() * System.nanoTime() % 10));

            events.add(startEvent);
            events.add(endEvent);
        }
        writeToFile(path, events);
    }

    private static void writeToFile(String path, List<EventInfo> events) {
        System.out.println(">>> Writing to " + path);
        File file = null;
        FileOutputStream fileOutputStream = null;
        try {
            file = new File(path);
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            for (EventInfo e : events) {
                fileOutputStream.write(e.toString().getBytes(StandardCharsets.UTF_8));
                fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            System.out.println("Size: " + Math.round(file.length()/1024.0) + "KB");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SafeVarargs
    private static <T> T chooseFrom(T... values) {
        return values[(int) (Math.random() * System.nanoTime() % values.length)];
    }

    public static String generateRandomIp() {
        return (int) (Math.random() * System.nanoTime() % 255) + "." +
                (int) (Math.random() * System.nanoTime() % 255) + "." +
                (int) (Math.random() * System.nanoTime() % 255) + "." +
                (int) (Math.random() * System.nanoTime() % 255);
    }

    public static String generateRandomUuid() {
        String seed = "e0A1f2E3D4a5Bd6b7c8CF9";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            sb.append(seed.charAt((int) ((Math.random() * System.nanoTime()) % seed.length())));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LogFileGenerator.generateFile("src/main/resources/samples/logfile.txt", 50000);
    }
}
