package org.whitfie.command;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}