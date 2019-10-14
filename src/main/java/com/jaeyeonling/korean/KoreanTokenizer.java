package com.jaeyeonling.korean;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class KoreanTokenizer implements Tokenizer {

    private static final char START_INDEX_OF_KOREAN_SYLLABLES = 0xAC00;

    private final char[] baseCharacter;

    abstract int getCriteria(final char character);

    @Override
    public String tokenize(final String source) {
        return source.chars()
                .mapToObj(this::castCharacter)
                .map(this::tokenize)
                .map(Object::toString)
                .collect(joining());
    }

    private char castCharacter(final int value) {
        return (char) value;
    }

    private char tokenize(final char character) {
        if (canNotTokenize(character)) {
            return character;
        }

        final var unicode = character - START_INDEX_OF_KOREAN_SYLLABLES;
        return baseCharacter[getCriteria((char) unicode)];
    }

    private boolean canNotTokenize(final char character) {
        return character < START_INDEX_OF_KOREAN_SYLLABLES;
    }
}
