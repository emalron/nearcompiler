package com.company;

import java.text.ParseException;

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;
    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        boolean not_matched = !"go".equals(name) && !"right".equals(name) && !"left".equals(name);
        if(not_matched) {
            throw new java.text.ParseException(name + " is not matched.", 3);
        }
    }

    public String toString() {
        String msg = String.format("%s", name);
        return msg;
    }
}
