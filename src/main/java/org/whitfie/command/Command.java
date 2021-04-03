package org.whitfie.command;

import org.whitfie.model.Parameter;

public interface Command {
    Parameter execute(Parameter result);
}
