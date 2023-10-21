package com.craftinginterpreters.lox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScannerTests {

  @Test
  void helloWorld() {
    Scanner scanner = new Scanner("hello");
    assertEquals(TokenType.IDENTIFIER, scanner.scanTokens().get(0).type);
  }
}
