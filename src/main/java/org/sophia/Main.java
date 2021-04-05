package org.sophia;

import org.sophia.configuration.ConfigParser;

/**
 * Java application that parse and read values from config files.
 */


public class Main {
    public static void main( String[] args ) {
        String file;
        if (args.length == 0) file = "production"; //Reads from production file by default
        else {
            file = args[0];
        }
//        ConfigParser config = new ConfigParser(file);
    }
}
