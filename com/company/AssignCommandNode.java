package com.company;

import java.text.ParseException;

// <assign command> := identifier = <expr>;
public class AssignCommandNode extends Node {
    private IdentifierNode identifierNode;
    private ExpressionNode expressionNode;

    @Override
    public void parse(Context context) throws ParseException {
        identifierNode = new IdentifierNode();
        identifierNode.parse(context);
        context.skipToken("=");
        expressionNode = new ExpressionNode();
        expressionNode.parse(context);
        boolean not_matched = !";".equals(context.currentToken());
        if(not_matched) {
            throw new ParseException("Assign missing \";\"", 4);
        }
        context.skipToken(";");
    }

    @Override
    public String toString() {
        // String msg = String.format("{type: \"print\", value:\"\n\t%s", expressionNode);
        String msg = String.format("ASSIGN %s = %s", identifierNode, expressionNode);
        return msg;
    }
}
