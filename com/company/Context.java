package com.company;

import java.text.ParseException;
import java.util.StringTokenizer;

public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String text) {
        text = text.replaceAll(";" ," ;");
        text = text.replaceAll("-" ," - ");
        text = text.replaceAll("[*]" ," * ");
        text = text.replaceAll("/" ," / ");
        text = text.replaceAll("[+]" ," + ");
        text = text.replaceAll("[(]" ," ( ");
        text = text.replaceAll("[)]" ," ) ");
        text = text.replaceAll(">=" ," {{ge}} ");
        text = text.replaceAll("<=" ," {{le}} ");
        text = text.replaceAll(">" ," > ");
        text = text.replaceAll("<" ," < ");
        text = text.replaceAll("==" ," == ");
        text = text.replaceAll("!=" ," {{neq}} ");
        text = text.replaceAll("!" ," ! ");
        text = text.replaceAll("&" ," & ");
        text = text.replaceAll("[|]" ," | ");
        this.tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public String nextToken() {
        if(tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(String token) throws ParseException {
        boolean not_matched_token = !token.equals(currentToken);
        if(not_matched_token) {
            String msg = String.format("Warning: %s is expected, but %s is found", currentToken, token);
            throw new ParseException(msg, 0);
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch(NumberFormatException e) {
            String msg = String.format("Warning: %s", e);
            throw new ParseException(msg, 1);
        }
        return number;
    }
}
