package com.company;

import java.text.ParseException;
import java.util.ArrayList;

// <expr> ::= <bexpr> { '&' <bexp> | '|' <bexpr> } '!'<expr> | true | false
public class ExpressionNode extends Node {
    private String name;
    private ArrayList bexprList;
    private ExpressionNode expressionNode;
    @Override
    public void parse(Context context) throws ParseException {
        if("true".equals(context.currentToken()) || "false".equals(context.currentToken())) {
            name = context.currentToken();
            context.skipToken(name);
        } else if("!".equals(context.currentToken())) {
            context.skipToken("!");
            expressionNode = new ExpressionNode();
            expressionNode.parse(context);
        } else {
            bexprList = new ArrayList();
            BoolExpressionNode bexprNode = new BoolExpressionNode();
            bexprNode.parse(context);
            bexprList.add(bexprNode);
            while(true) {
                String current = context.currentToken();
                if("&".equals(current)) {
                    AndBoolExpressionNode andBExpr = new AndBoolExpressionNode();
                    andBExpr.parse(context);
                    bexprList.add(andBExpr);
                } else if("|".equals(current)) {
                    OrBoolExpressionNode orBExpr = new OrBoolExpressionNode();
                    orBExpr.parse(context);
                    bexprList.add(orBExpr);
                } else {
                    break;
                }
            }
        }
    }

    public String toString() {
        if(name != null) {
            return name;
        }
        if(bexprList != null) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<bexprList.size(); i++) {
                sb.append(bexprList.get(i) + " ");
            }
            return sb.toString();
        } else {
            return "!" + expressionNode.toString();
        }
    }
}
