package converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class WordsExtractor {

    public Sentence extractWords(String sentence) {
        String[] words = sentence.split("\\s+|,\\s*|\\.\\s*");
        String[] sortedWords = sortWords(words);
        String[] cleanSortedWords = removeWhitespaces(sortedWords);
        return new Sentence(cleanSortedWords);
    }

    private String[] sortWords(String[] words) {
        return Arrays.stream(words)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toArray(String[]::new);
    }

    private String[] removeWhitespaces(String[] words) {
        final ArrayList<String> cleanWordsArrayList = new ArrayList<>();
        Collections.addAll(cleanWordsArrayList, words);
        cleanWordsArrayList.remove("");
        String[] cleanWords = cleanWordsArrayList.toArray(new String[cleanWordsArrayList.size()]);
        return cleanWords;
    }
}
