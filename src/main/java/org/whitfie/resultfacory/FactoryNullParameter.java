package org.whitfie.resultfacory;

import org.whitfie.model.NullParameter;
import org.whitfie.model.Parameter;

public class FactoryNullParameter implements ParametertFactory {

    @Override
    public Parameter create() {
        return new NullParameter();
    }
}
