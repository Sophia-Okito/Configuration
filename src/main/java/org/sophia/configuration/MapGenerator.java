package org.sophia.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapGenerator {
    /**
     * Reads the configuration file and generates a LinkedHashMap
     */
    private final String fileName;
    private final Map<String, String> map;

    public MapGenerator(String fileName) {
        this.fileName = fileName;
        map = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, String> mapGen() {
        try {

            String filePath;
            switch (fileName) {
                case "development":
                    filePath = "src/main/resources/config_dev.txt";
                    break;
                case "staging":
                    filePath = "src/main/resources/config_staging.txt";
                    break;
                default:
                    filePath = "src/main/resources/config.txt";
                    break;
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String strCurrentLine;

            //reads line by line from file and adding keys and values into the map.
            while ((null != (strCurrentLine = reader.readLine()))) {
                String[] arr;
                if (strCurrentLine.isEmpty()) { //boycotting empty lines
                    continue;
                } else {
                    arr = strCurrentLine.split("=");
                }

                //boycotting lines that reads [Application]
                if (arr.length > 1) {
                    if (((!arr[0].equals("dbname") && !arr[0].equals("host")))) {
                        arr[0] = "application." + arr[0];
                    }
                    map.putIfAbsent(arr[0], arr[1]);
                }
            }
            reader.close();
           return (LinkedHashMap<String, String>) map;

        } catch (
                IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

}
