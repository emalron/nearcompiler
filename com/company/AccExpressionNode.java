package com.company;

import java.text.ParseException;
import java.util.ArrayList;

// <aexpr> ::= <term> {'+' <term> | '-' <term>}
public class AccExpressionNode extends Node {
    private ArrayList termList;

    @Override
    public void parse(Context context) throws ParseException {
        termList = new ArrayList();
        TermNode termNode = new TermNode();
        termNode.parse(context);
        termList.add(termNode);
        while(true) {
            String current = context.currentToken();
            if("+".equals(current)) {
                PlusTermNode plusTermNode = new PlusTermNode();
                plusTermNode.parse(context);
                termList.add(plusTermNode);
            } else if("-".equals(current)) {
                MinusTermNode minusTermNode = new MinusTermNode();
                minusTermNode.parse(context);
                termList.add(minusTermNode);
            } else {
                break;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<termList.size(); i++) {
            sb.append(termList.get(i) + " ");
        }
        return sb.toString();
    }
}
