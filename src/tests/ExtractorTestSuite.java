package tests;

import converter.Sentence;
import converter.SentenceExtractor;
import org.junit.Assert;

import java.util.ArrayList;


public class ExtractorTestSuite {

    @org.junit.Test
    public void sentenceExtractorTest() {
        String textInput = " Mary had a little lamb .  " +
                "Peter called for the wolf , and Aesop came .  " +
                "Cinderella likes shoes.. ";
        SentenceExtractor sentenceExtractor = new SentenceExtractor();

        ArrayList<Sentence> extractedSentences = sentenceExtractor.extractSentences(textInput);

        String[] sentenceString1 = {"a","had","lamb","little","Mary"};
        String[] sentenceString2 = {"Aesop","and","called","came","for","Peter","the","wolf"};
        String[] sentenceString3 = {"Cinderella","likes","shoes"};

        Sentence sentence1 = new Sentence(sentenceString1);
        Sentence sentence2 = new Sentence(sentenceString2);
        Sentence sentence3 = new Sentence(sentenceString3);

        ArrayList<Sentence> sentenceArrayList = new ArrayList<>();
        sentenceArrayList.add(sentence1);
        sentenceArrayList.add(sentence2);
        sentenceArrayList.add(sentence3);

        Assert.assertEquals(sentenceArrayList, extractedSentences);
    }

}
