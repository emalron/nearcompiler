package com.company;

import java.text.ParseException;

public class ProgramNode extends Node {
    private Node stmtNode;

    @Override
    public void parse(Context context) throws ParseException {
        stmtNode = new StatementNode();
        stmtNode.parse(context);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(stmtNode.toString());
        return sb.toString();
    }
}
