package com.craftinginterpreters.lox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScannerTests {

  @Test
  void helloWorld() {
    Scanner scanner = new Scanner("hello");
    assertEquals(TokenType.IDENTIFIER, scanner.scanTokens().get(0).type);
    assertEquals(TokenType.EOF, scanner.scanTokens().get(1).type);
  }

  @Test
  void multilineComments() {
    Scanner oneLine = new Scanner("/* a comment */");

    assertEquals(TokenType.EOF, oneLine.scanTokens().get(0).type);
    assertEquals(1, oneLine.scanTokens().get(0).line);

    Scanner twoLines = new Scanner("/* a \n comment */");
    assertEquals(2, twoLines.scanTokens().get(0).line);

    Scanner nested = new Scanner("/* a /* nested */ comment */");
    System.out.println(nested.scanTokens());
    assertEquals(TokenType.EOF, nested.scanTokens().get(0).type);
  }
}
