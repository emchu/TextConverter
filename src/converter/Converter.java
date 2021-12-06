package converter;

import java.util.List;
import java.util.Optional;


public class Converter {
    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner();
        SentenceExtractor sentenceExtractor = new SentenceExtractor();
        ToXMLConverter toXMLConverter = new ToXMLConverter();
        ToCSVConverter toCSVConverter = new ToCSVConverter();

        String textInput = inputScanner.scanInput();

        List<Sentence> sortedSentencesList = sentenceExtractor.extractSentences(textInput);
        toXMLConverter.saveToXML(sortedSentencesList, Optional.empty());
        toCSVConverter.saveToCSV(sortedSentencesList, Optional.empty());
    }
}
