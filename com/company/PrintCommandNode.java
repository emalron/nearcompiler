package com.company;

import java.text.ParseException;

// <print command> := print <expr>;
public class PrintCommandNode extends Node {
    private ExpressionNode expressionNode;
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken("print");
        boolean not_matched = !"print".equals(name);
        if(not_matched) {
            throw new java.text.ParseException(name + " is not matched.", 3);
        }
        expressionNode = new ExpressionNode();
        expressionNode.parse(context);
        not_matched = !";".equals(context.currentToken());
        if(not_matched) {
            throw new ParseException("Print missing \";\"", 4);
        }
        context.skipToken(";");
    }

    @Override
    public String toString() {
        // String msg = String.format("{type: \"print\", value:\"\n\t%s", expressionNode);
        String msg = String.format("PRINT \n\t %s", expressionNode);
        return msg;
    }
}
