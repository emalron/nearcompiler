package com.company;

import java.text.ParseException;
import java.util.regex.Pattern;

// identifier ::= ^([a-zA-Z]|_[\s\S])[a-zA-Z0-9]*
public class IdentifierNode extends Node {
    private String name;
    @Override
    public void parse(Context context) throws ParseException {
        String pattern = "^[a-zA-Z][a-zA-Z0-9_-]*$";
        name = context.currentToken();
        context.skipToken(name);
        boolean not_matched = !Pattern.matches(pattern, name);
        if(not_matched) {
            throw new ParseException(name + " is not identifier.", 4);
        }
    }

    public String toString() {
        String msg = String.format("%s", name);
        return msg;
    }
}
