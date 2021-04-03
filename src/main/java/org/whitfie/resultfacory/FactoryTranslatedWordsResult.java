package org.whitfie.resultfacory;

import org.whitfie.model.Parameter;
import org.whitfie.model.TranslatedWordsParameter;

public class FactoryTranslatedWordsResult implements ParametertFactory {

    @Override
    public Parameter create() {
        return new TranslatedWordsParameter();
    }
}
