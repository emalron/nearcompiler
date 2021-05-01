package com.company;

import java.text.ParseException;

// '-' <term>
public class MinusTermNode extends Node {
    private TermNode termNode;
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("-");
        termNode = new TermNode();
        termNode.parse(context);
    }

    public String toString() {
        return "- " + termNode.toString();
    }
}
