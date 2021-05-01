package com.company;

import java.text.ParseException;

// <or bexpr> ::= '|' <bexpr>
public class OrBoolExpressionNode extends Node {
    private BoolExpressionNode boolExpressionNode;
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("|");
        boolExpressionNode = new BoolExpressionNode();
        boolExpressionNode.parse(context);
    }

    public String toString() {
        return "| " + boolExpressionNode.toString();
    }
}
