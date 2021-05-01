package com.company;


import java.text.ParseException;

// <command> ::= <repeat command> | <primitive command> | <print command> | <read command>
public class CommandNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if("repeat".equals(context.currentToken())) {
            node = new RepeatCommandNode();
        } else if("print".equals(context.currentToken())) {
            node = new PrintCommandNode();
        } else if("read".equals(context.currentToken())) {
            node = new ReadCommandNode();
        } else {
            node = new PrimitiveCommandNode();
        }
        node.parse(context);
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
