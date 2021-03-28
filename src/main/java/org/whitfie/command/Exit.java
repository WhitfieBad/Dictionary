package org.whitfie.command;

import org.whitfie.model.Result;

public class Exit implements Command {

    @Override
    public Result execute(Result result) {
        System.exit(0);
        return null;
    }
}
