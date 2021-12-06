package tests;

import converter.Sentence;
import converter.ToCSVConverter;
import converter.ToXMLConverter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToFilesConvertorsTestSuite {
    ToXMLConverter toXMLConverter = new ToXMLConverter();
    ToCSVConverter toCSVConverter = new ToCSVConverter();
    String resourcesPath = System.getProperty("user.dir") + "/resources/";

    String[] sentenceString1 = {"a", "had", "lamb", "little", "Mary"};
    String[] sentenceString2 = {"Aesop", "and", "called", "came", "for", "Peter", "the", "wolf"};
    String[] sentenceString3 = {"Cinderella", "likes", "shoes"};

    Sentence sentence1 = new Sentence(sentenceString1);
    Sentence sentence2 = new Sentence(sentenceString2);
    Sentence sentence3 = new Sentence(sentenceString3);

    List<Sentence> sentenceList = new ArrayList<>();

    @Before
    public void init() {
        sentenceList.add(sentence1);
        sentenceList.add(sentence2);
        sentenceList.add(sentence3);
    }

    @Test
    public void toXMLConvertorTest() {
        toXMLConverter.saveToXML(sentenceList, Optional.of(resourcesPath));

        File actualXMLFile = new File(resourcesPath + "actualXML.xml");
        File testXMLFile = new File(resourcesPath + "XMLfile.xml");

        try {
            boolean result = FileUtils.contentEquals(actualXMLFile, testXMLFile);
            Assert.assertTrue(result);
        } catch (IOException e) {
            Assert.fail("Failed to read file contents");
        }
    }

    @Test
    public void toCSVConvertorTest() {
        toCSVConverter.saveToCSV(sentenceList, Optional.of(resourcesPath));

        File actualCSVFile = new File(resourcesPath + "actualCSV.xml");
        File testCSVFile = new File(resourcesPath + "CSVfile.xml");

        try {
            boolean result = FileUtils.contentEquals(actualCSVFile, testCSVFile);
            Assert.assertTrue(result);
        } catch (IOException e) {
            Assert.fail("Failed to read file contents");
        }
    }
}
