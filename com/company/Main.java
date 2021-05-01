package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            BufferedReader reader = new BufferedReader(new FileReader("d:\\program"));
            String text = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println("**SOURCE**\n" + text + "\n");
            Node node = new ProgramNode();
            node.parse(new Context(text));
            System.out.println("**AST**\n" + node);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void execute(Node node) {

    }
}
