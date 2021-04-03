package org.whitfie.resultfacory;

import org.whitfie.model.Parameter;
import org.whitfie.model.WordsParameter;

public class FactoryWordsResult implements ParametertFactory {

    @Override
    public Parameter create() {
        return new WordsParameter();
    }
}
