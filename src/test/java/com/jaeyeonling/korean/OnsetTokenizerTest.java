package com.jaeyeonling.korean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OnsetTokenizerTest {

    private Tokenizer onsetTokenizer;

    @BeforeEach
    void setUp() {
        onsetTokenizer = new OnsetTokenizer();
    }

    @ParameterizedTest
    @CsvSource({
            "안녕하세여,ㅇㄴㅎㅅㅇ",
            "반갑습니다!,ㅂㄱㅅㄴㄷ!",
            "가나다라마바사아자차카타파하,ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ",
            "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ,ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ",
            "hello,hello",
            "헬lo,ㅎlo",
            "HELL O 월드,HELL O ㅇㄷ",
    })
    void tokenize(final String input,
                  final String expected) {
        // when
        final var out = onsetTokenizer.tokenize(input);

        // then
        assertThat(out).isEqualTo(expected);
    }
}