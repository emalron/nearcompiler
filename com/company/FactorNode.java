package com.company;

import java.text.ParseException;
import java.util.regex.Pattern;

// <factor> ::= ['-'] (number | '(' <aexpr> ')' | identifier)
public class FactorNode extends Node {
    private String name;
    private AccExpressionNode accExpressionNode;
    private IdentifierNode identifierNode;

    @Override
    public void parse(Context context) throws ParseException {
        StringBuilder sb = new StringBuilder();
        boolean is_minus = "-".equals(context.currentToken());
        if(is_minus) {
            context.skipToken("-");
            sb.append("-");
        }
        String pattern = "^(([0-9])|([1-9][0-9]*))$";
        name = context.currentToken();
        boolean number_matched = Pattern.matches(pattern, name);
        boolean bracket_matched = "(".equals(name);
        if(number_matched) {
            context.skipToken(name);
            sb.append(name);
        } else if(bracket_matched) {
            context.skipToken("(");
            accExpressionNode = new AccExpressionNode();
            accExpressionNode.parse(context);
            boolean not_bracket_matched = !")".equals(context.currentToken());
            if(not_bracket_matched) {
                System.out.println("last: " + context.currentToken() + " next: " + context.nextToken());
                throw new ParseException(") is missing.", 4);
            }
            context.skipToken(")");
            String result = String.format("( %s )", accExpressionNode);
            sb.append(result);
        } else {
            identifierNode = new IdentifierNode();
            identifierNode.parse(context);
            sb.append(identifierNode);
        }
        name = sb.toString();
    }

    public String toString() {
        return name;
    }
}
