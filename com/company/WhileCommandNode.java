package com.company;

import java.text.ParseException;

// <if command> := while '(' <expr> ')' <stmt>
public class WhileCommandNode extends Node {
    private ExpressionNode expressionNode;
    private StatementNode stmtNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("while");
        checkString("(", context.currentToken());
        context.skipToken("(");
        expressionNode = new ExpressionNode();
        expressionNode.parse(context);
        checkString(")", context.currentToken());
        context.skipToken(")");
        stmtNode = new StatementNode();
        stmtNode.parse(context);
    }

    private void checkString(String pattern, String target) throws ParseException {
        if(!pattern.equals(target)) {
            String msg = String.format("while missing \"%s\", current: %s", pattern, target);
            throw new ParseException(msg, 4);
        }
    }

    @Override
    public String toString() {
        // String msg = String.format("{type: \"print\", value:\"\n\t%s", expressionNode);
        String thenS = stmtNode.toString().replaceAll("\n", "\n\t");
        String msg = String.format("WHILE %S \n\t%s", expressionNode,thenS);
        return msg;
    }
}
