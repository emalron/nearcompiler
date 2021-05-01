package com.company;

import java.text.ParseException;
import java.util.ArrayList;

// <let command> := let <decls> in <block> end
public class LetCommandNode extends Node {
    private ArrayList declareList;
    private BlockNode blockNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("let");
        declareList = new ArrayList();
        while(true) {
            DeclareNode declareNode = new DeclareNode();
            declareNode.parse(context);
            declareList.add(declareNode);
            if("in".equals(context.currentToken())) {
                context.skipToken("in");
                break;
            }
        }
        blockNode = new BlockNode();
        blockNode.parse(context);
        context.skipToken("end");
    }

    @Override
    public String toString() {
        // String msg = String.format("{type: \"print\", value:\"\n\t%s", expressionNode);
        String blockS = blockNode.toString().replaceAll("\n", "\n\t");
        String msg = String.format("LET %s in \n\t%s", declareList, blockS);
        return msg;
    }
}
