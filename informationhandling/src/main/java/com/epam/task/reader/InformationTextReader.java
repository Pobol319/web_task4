package com.epam.task.reader;

import com.epam.task.exception.InformationTextReaderException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InformationTextReader {

    public String read(String path) throws InformationTextReaderException {
        StringBuilder text = new StringBuilder();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                text.append(temp);
            }
        } catch (FileNotFoundException e) {
            throw new InformationTextReaderException("File not found");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new InformationTextReaderException("FileReader not initialize");
            }
        }
        return text.toString();
    }
}
