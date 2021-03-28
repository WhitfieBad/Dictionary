package org.whitfie.resultfacory;

import org.whitfie.model.Result;
import org.whitfie.model.TranslatedWord;
import org.whitfie.model.TranslatedWordsResult;

import java.util.Set;

public class FactoryTranslatedWordsResult implements ResultFactory {

    @Override
    public Result create() {
        return new TranslatedWordsResult();
    }
}
