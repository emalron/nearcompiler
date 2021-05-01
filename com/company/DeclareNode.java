package com.company;

import java.text.ParseException;
import java.util.ArrayList;

// <decl> ::= <type> identifier;
public class DeclareNode extends Node {
    private TypeNode typeNode;
    private IdentifierNode identifierNode;

    @Override
    public void parse(Context context) throws ParseException {
        typeNode = new TypeNode();
        typeNode.parse(context);
        identifierNode = new IdentifierNode();
        identifierNode.parse(context);
        context.skipToken(";");
    }

    @Override
    public String toString() {
        return typeNode.toString() + " " + identifierNode.toString();
    }
}
