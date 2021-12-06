package converter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ToCSVConverter {
    public void saveToCSV(List<Sentence> sortedSentencesList, Optional<String> path) {
        String pathString = path.orElse("");

        try (PrintWriter writer = new PrintWriter(pathString + "CSVfile.csv")) {
            StringBuilder firstLine = new StringBuilder();

            StringBuilder CSVStringBuilder = new StringBuilder();
            int numberOfSentences = 1;
            int maxNumberOfWords = 1;

            for (Sentence sentence : sortedSentencesList) {
                CSVStringBuilder.append("Sentence ").append(numberOfSentences).append(",");
                numberOfSentences++;

                List<String> sortedWords = sentence.getWords();
                int numberOfWords = 0;

                for (String word : sortedWords) {
                    CSVStringBuilder.append(" ").append(word).append(",");
                    numberOfWords++;
                }

                if (numberOfWords > maxNumberOfWords) {
                    maxNumberOfWords = numberOfWords;
                }
                CSVStringBuilder.append('\n');
            }

            for (int i = 1; i <= maxNumberOfWords; i++) {
                firstLine.append(",").append(" Word ").append(i);
            }
            firstLine.append('\n');
            CSVStringBuilder.insert(0, firstLine);

            writer.write(CSVStringBuilder.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

