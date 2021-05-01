package com.company;

import java.text.ParseException;

// <repeat command> ::== repeat <number> <command list>
public class RepeatCommandNode extends Node {
    private int number;
    private StatementNode statementNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        statementNode = new StatementNode();
        statementNode.parse(context);
    }

    @Override
    public String toString() {
        String stmt = statementNode.toString().replaceAll("\n", "\n\t");
        // String msg = String.format("{type: \"repeat\", number: %d, commandList: \n\t%s}", number, stmt);
        String msg = String.format("REPEAT %d \n\t%s", number, stmt);
        return msg;
    }
}
