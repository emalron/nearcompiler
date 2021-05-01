package com.company;

import java.text.ParseException;

// <and bexpr> ::= '&' <bexpr>
public class AndBoolExpressionNode extends Node {
    private BoolExpressionNode boolExpressionNode;
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("&");
        boolExpressionNode = new BoolExpressionNode();
        boolExpressionNode.parse(context);
    }

    public String toString() {
        return "& " + boolExpressionNode.toString();
    }
}
