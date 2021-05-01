package com.company;

import java.text.ParseException;

// <bexpr> ::= <aexpr> [<relop> <aexpr>]
public class BoolExpressionNode extends Node {
    private AccExpressionNode aexprNode, aexprNode2;
    private RelopNode relopNode;

    @Override
    public void parse(Context context) throws ParseException {
        aexprNode = new AccExpressionNode();
        aexprNode.parse(context);
        String name = context.currentToken();
        boolean not_matched = !"==".equals(name) && !"!=".equals(name) && !"{{ge}}".equals(name) && !"{{le}}".equals(name) && !">".equals(name)
                && !"<".equals(name);
        if(not_matched) {
            return;
        }
        relopNode = new RelopNode();
        relopNode.parse(context);
        aexprNode2 = new AccExpressionNode();
        aexprNode2.parse(context);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(aexprNode);
        if(relopNode != null) {
            sb.append(relopNode);
        }
        if(aexprNode2 != null) {
            sb.append(aexprNode2);
        }
        return sb.toString();
    }
}
