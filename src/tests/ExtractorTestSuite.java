package tests;

import converter.Sentence;
import converter.SentenceExtractor;
import converter.WordsExtractor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ExtractorTestSuite {
    String[] sentenceString1 = {"a", "had", "lamb", "little", "Mary"};
    String[] sentenceString2 = {"Aesop", "and", "called", "came", "for", "Peter", "the", "wolf"};
    String[] sentenceString3 = {"Cinderella", "likes", "shoes"};

    Sentence sentence1 = new Sentence(sentenceString1);
    Sentence sentence2 = new Sentence(sentenceString2);
    Sentence sentence3 = new Sentence(sentenceString3);

    @Test
    public void sentenceExtractorTest() {
        String textInput = " Mary had a little lamb .  " +
                "Peter called for the wolf , and Aesop came .  " +
                "Cinderella likes shoes.. ";
        SentenceExtractor sentenceExtractor = new SentenceExtractor();

        List<Sentence> extractedSentences = sentenceExtractor.extractSentences(textInput);

        List<Sentence> sentenceList = new ArrayList<>();
        sentenceList.add(sentence1);
        sentenceList.add(sentence2);
        sentenceList.add(sentence3);

        Assert.assertEquals(sentenceList, extractedSentences);
    }

    @Test
    public void wordsExtractorTest() {
        WordsExtractor wordsExtractor = new WordsExtractor();

        String sentenceString1 = "Mary had a little lamb";
        String sentenceString2 = "Peter called for the wolf , and Aesop came";
        String sentenceString3 = "Cinderella likes shoes";

        Sentence sortedSentence1 = wordsExtractor.extractWords(sentenceString1);
        Sentence sortedSentence2 = wordsExtractor.extractWords(sentenceString2);
        Sentence sortedSentence3 = wordsExtractor.extractWords(sentenceString3);

        Assert.assertEquals(sentence1, sortedSentence1);
        Assert.assertEquals(sentence2, sortedSentence2);
        Assert.assertEquals(sentence3, sortedSentence3);
    }
}
