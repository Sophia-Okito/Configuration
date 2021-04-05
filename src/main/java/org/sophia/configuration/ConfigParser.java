package org.sophia.configuration;

import java.util.Map;

public class ConfigParser {
    /**
     * A parses the file into a LinkedHashMap
     */
    String nameOfFile;
    Map<String, String> currentMap;
    MapGenerator theMap;

    public ConfigParser(String nameOfFile) {
        this.nameOfFile = nameOfFile;
        theMap = new MapGenerator(this.nameOfFile);
        currentMap = theMap.mapGen();
    }


    public String get(Object key) {
        return currentMap.get(key);
    }
}
