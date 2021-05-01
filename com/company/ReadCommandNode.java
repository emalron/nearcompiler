package com.company;

import java.text.ParseException;

// <read command> ::= read <identifier>;
public class ReadCommandNode extends Node {
    private String name;
    private IdentifierNode idNode;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken("read");
        boolean not_matched = !"read".equals(name);
        if(not_matched) {
            throw new ParseException(name + " is not matched.", 3);
        }
        idNode = new IdentifierNode();
        idNode.parse(context);
        not_matched = !";".equals(context.currentToken());
        if(not_matched) {
            throw new ParseException("Read missing \";\"", 4);
        }
        context.skipToken(";");
    }

    @Override
    public String toString() {
        // String msg = String.format("{type: \"print\", value:\"\n\t%s", expressionNode);
        String msg = String.format("READ \n\t%s", idNode);
        return msg;
    }
}
