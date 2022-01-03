package com.tripp.command;

import java.util.ArrayList;
import java.util.List;

abstract class Command {
    abstract void execute();
    abstract void undo();
}

class Content {
    String msg = "Hello, world";
}

class CopyCommand extends Command {
    Content content;

    public CopyCommand(Content content) {
        this.content = content;
    }

    @Override
    void execute() {
        this.content.msg += "Hello, world";
    }

    @Override
    void undo() {
        this.content.msg = this.content.msg.substring(this.content.msg.length() / 2);
    }
}

class DeleteCommand extends Command {
    Content content;
    String deleteMsg;

    public DeleteCommand(Content content) {
        this.content = content;
    }

    @Override
    void execute() {
        this.deleteMsg = this.content.msg.substring(5);
        this.content.msg = this.content.msg.substring(0, 5);
    }

    @Override
    void undo() {
        this.content.msg += this.deleteMsg;
    }
}

class CorCommand {
    List<Command> commandList = new ArrayList<>();
    int index = 0;

    void execute(Command command) {
        command.execute();
        commandList.add(command);
        index++;
    }

    void undo() {
        if (index < 0) {
            return;
        }
        Command command = commandList.get(index - 1);
        command.undo();
        commandList.remove(command);
        index--;
    }
}

public class Main {
    public static void main(String[] args) {
        Content content = new Content();
        CorCommand corCommand = new CorCommand();

        CopyCommand copyCommand = new CopyCommand(content);
        DeleteCommand deleteCommand = new DeleteCommand(content);

        corCommand.execute(copyCommand);
        corCommand.execute(deleteCommand);

        corCommand.undo();
        corCommand.undo();

        System.out.println(content.msg);
    }
}
