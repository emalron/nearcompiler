package com.company;

import java.text.ParseException;
import java.util.regex.Pattern;

// <multiple factor> ::= '*' <factor>
public class MultiFactorNode extends Node {
    private FactorNode factorNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("*");
        factorNode = new FactorNode();
        factorNode.parse(context);
    }

    public String toString() {
        return "* " + factorNode.toString();
    }
}
