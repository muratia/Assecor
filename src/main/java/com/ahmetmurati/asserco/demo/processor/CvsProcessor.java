package com.ahmetmurati.asserco.demo.processor;


import com.ahmetmurati.asserco.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CvsProcessor {

    private static final String COMMA_DELIMITER = ",";
    Logger logger = LoggerFactory.getLogger (CvsProcessor.class);

    public static boolean IsNullOrEmpty(String value) {
        if (value != null)
            return value.length () == 0;
        else
            return true;
    }

    public List<String> readFile(String path, Charset encoding) throws IOException {
        return Files.readAllLines (Paths.get (path), encoding);
    }

    public List<Person> read(String fileName) {
        List<Person> persons = new ArrayList<> ();

        List<String> lines = new ArrayList<> ();

        try {
            lines = readFile (fileName, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace ();
        }

        String res = String.join ("", lines);
        res = res.replace (System.lineSeparator (), " ");

// In C# the CSV is normalized with this Regular Expression but in Java it does not include the number of the color.gi
        String[] items = res.split ("(\\s[0-9]{1}\\s)");

        for (int i = 0; i < items.length; i += 2) {
            if (!IsNullOrEmpty (items[i]))
                lines.add (items[i] + items[i + 1]);
        }


        List<String> linesStr = new ArrayList<> ();
        System.err.println (linesStr);

        logger.debug (String.valueOf (linesStr));
        String line;
        for (int i = 0; i < linesStr.size (); i++) {
            line = linesStr.get (i);
            String[] values = line.split (COMMA_DELIMITER);
            if (values.length == 4) {

                Person p = new Person ();
                p.setId (0L);
                p.setName (values[0]);
                p.setLastName (values[1]);
                String[] zipCodeAndCity = values[2].split ("\\s");
                p.setZipCode (zipCodeAndCity[0]);
                p.setCity (zipCodeAndCity[1]);
                p.setColor (Integer.parseInt (values[3]));
                persons.add (p);
            }
        }

        return persons;

    }

}
