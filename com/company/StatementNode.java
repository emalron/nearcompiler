package com.company;

import java.util.ArrayList;
import java.text.ParseException;

// <stmt> ::= '{' <block> '}' | <read command> | <print command>
public class StatementNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if("{".equals(context.currentToken())) {
            context.skipToken("{");
            node = new BlockNode();
            node.parse(context);
            context.skipToken("}");
        } else if("read".equals(context.currentToken())) {
            node = new ReadCommandNode();
            node.parse(context);
        } else if("print".equals(context.currentToken())) {
            node = new PrintCommandNode();
            node.parse(context);
        } else if("if".equals(context.currentToken())) {
            node = new IfCommandNode();
            node.parse(context);
        } else if("while".equals(context.currentToken())) {
            node = new WhileCommandNode();
            node.parse(context);
        } else if("let".equals(context.currentToken())) {
            node = new LetCommandNode();
            node.parse(context);
        } else {
            node = new AssignCommandNode();
            node.parse(context);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(node != null) {
            sb.append(node);
        }
        return sb.toString();
    }
}
