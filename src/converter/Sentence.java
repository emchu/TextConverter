package converter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;


public class Sentence {

    @Getter
    private ArrayList<String> words;

    public Sentence(String[] words) {
        this.words = new ArrayList<>(Arrays.asList(words));
    }
}
