package org.whitfie.command;

import org.whitfie.model.Result;

public interface Command {
    Result execute(Result result);
}
