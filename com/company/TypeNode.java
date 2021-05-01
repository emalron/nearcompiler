package com.company;

import java.text.ParseException;
import java.util.regex.Pattern;

// <type> ::= int | bool
public class TypeNode extends Node {
    private String name;
    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        boolean not_matched = !"int".equals(name) && !"bool".equals(name);
        if(not_matched) {
            throw new ParseException(name + " is not type.", 4);
        }
        context.skipToken(name);
    }

    public String toString() {
        String msg = String.format("%s", name);
        return msg;
    }
}
