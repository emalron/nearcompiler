package com.company;

import java.text.ParseException;
import java.util.ArrayList;

// <block> ::= { <statement> }
public class BlockNode extends Node {
    private ArrayList list = new ArrayList();
    private String next_token;

    @Override
    public void parse(Context context) throws ParseException {
        while(true) {
            Node stmtNode = new StatementNode();
            stmtNode.parse(context);
            list.add(stmtNode);
            boolean end_codition = "}".equals(context.currentToken()) || "end".equals(context.currentToken());
            if(end_codition) {
                break;
            } else if(context.currentToken() == null) {
                throw new ParseException("missing end", 4);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i;
        for(i=0; i<list.size()-1; i++) {
            sb.append(list.get(i).toString() + "\n");
        }
        sb.append(list.get(i).toString());
        return sb.toString();
    }
}
