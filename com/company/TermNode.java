package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

// <term> ::= <factor> { '*' <factor> | '/' <factor> }
public class TermNode extends Node {
    ArrayList factorList;
    @Override
    public void parse(Context context) throws ParseException {
        factorList = new ArrayList();
        FactorNode factorNode = new FactorNode();
        factorNode.parse(context);
        factorList.add(factorNode);
        while(true) {
            String current = context.currentToken();
            if("*".equals(current)) {
                MultiFactorNode multiFactorNode = new MultiFactorNode();
                multiFactorNode.parse(context);
                factorList.add(multiFactorNode);
            } else if("/".equals(current)) {
                DivideFactorNode divideFactorNode = new DivideFactorNode();
                divideFactorNode.parse(context);
                factorList.add(divideFactorNode);
            } else {
                break;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<factorList.size(); i++) {
            sb.append(factorList.get(i));
        }
        return sb.toString();
    }
}
