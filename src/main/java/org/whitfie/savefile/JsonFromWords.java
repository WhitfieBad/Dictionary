package org.whitfie.savefile;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import org.whitfie.model.TranslatedWord;

import java.lang.reflect.Type;
import java.util.Set;

public class JsonFromWords implements FormatFromWords {

    @Override
    public String getStringFromWords(Set<TranslatedWord> translatedWordSet) {
        Type setType = new TypeToken<Set<TranslatedWord>>(){}.getType();
        return new Gson().toJson(translatedWordSet, setType);
    }
}
