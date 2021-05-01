package com.company;

import java.text.ParseException;

// <if command> := if '(' <expr> ')' then <stmt> [else <stmt>]
public class IfCommandNode extends Node {
    private ExpressionNode expressionNode;
    private StatementNode thenStmtNode, elseStmtNode;
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("if");
        checkString("(", context.currentToken());
        context.skipToken("(");
        expressionNode = new ExpressionNode();
        expressionNode.parse(context);
        checkString(")", context.currentToken());
        context.skipToken(")");
        checkString("then", context.currentToken());
        context.skipToken("then");
        thenStmtNode = new StatementNode();
        thenStmtNode.parse(context);
        if("else".equals(context.currentToken())) {
            context.skipToken("else");
            elseStmtNode = new StatementNode();
            elseStmtNode.parse(context);
        }
    }

    private void checkString(String pattern, String target) throws ParseException {
        if(!pattern.equals(target)) {
            String msg = String.format("if missing \"%s\"", pattern);
            throw new ParseException(msg, 4);
        }
    }

    @Override
    public String toString() {
        // String msg = String.format("{type: \"print\", value:\"\n\t%s", expressionNode);
        String thenS = thenStmtNode.toString().replaceAll("\n", "\n\t");
        String msg = String.format("IF %s \n\tTHEN %s", expressionNode,thenS);
        if(elseStmtNode != null) {
            String elseS = elseStmtNode.toString().replaceAll("\n", "\n\t");
            msg += String.format("\n\tELSE %s", elseS);
        }
        return msg;
    }
}
