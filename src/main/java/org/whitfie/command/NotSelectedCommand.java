package org.whitfie.command;

import org.whitfie.model.Result;

public class NotSelectedCommand implements Command {

    @Override
    public Result execute(Result result) {
        System.out.println("Not Selected");
        return result;
    }
}
