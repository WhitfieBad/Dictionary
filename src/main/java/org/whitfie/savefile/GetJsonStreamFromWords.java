package org.whitfie.savefile;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import org.whitfie.model.TranslatedWord;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class GetJsonStreamFromWords implements GetFileStreamFromWords {

    @Override
    public InputStream getStreamFromWords(Set<TranslatedWord> translatedWordSet) {
        Type setType = new TypeToken<Set<TranslatedWord>>(){}.getType();
        return new ByteArrayInputStream(new Gson().toJson(translatedWordSet, setType).getBytes(StandardCharsets.UTF_8));
    }
}
