package org.whitfie.command;

import org.whitfie.model.Parameter;

public class NotSelectedCommand implements Command {

    @Override
    public Parameter execute(Parameter result) {
        System.out.println("Not Selected");
        return result;
    }
}
