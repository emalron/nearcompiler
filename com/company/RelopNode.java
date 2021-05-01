package com.company;

import java.text.ParseException;

// <relop> ::= ("==" | "!=" | "<=" | ">=" | ">" | "<")
public class RelopNode extends Node {
    private String name;
    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        switch(name) {
            case "{{ge}}":
                name = ">=";
                break;
            case "{{le}}":
                name = "<=";
                break;
            case "{{neq}}":
                name = "!=";
                break;
        }
    }

    public String toString() {
        String msg = String.format("%s ", name);
        return msg;
    }
}
