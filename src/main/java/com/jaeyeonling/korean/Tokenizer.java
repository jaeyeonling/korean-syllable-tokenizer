package com.jaeyeonling.korean;

@FunctionalInterface
public interface Tokenizer {

    String tokenize(final String source);
}
