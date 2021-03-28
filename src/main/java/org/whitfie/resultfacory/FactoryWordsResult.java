package org.whitfie.resultfacory;

import org.whitfie.model.Result;
import org.whitfie.model.WordsResult;

import java.util.Set;

public class FactoryWordsResult implements ResultFactory {

    @Override
    public Result create() {
        return new WordsResult();
    }
}
