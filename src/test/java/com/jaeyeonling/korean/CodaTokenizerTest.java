package com.jaeyeonling.korean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CodaTokenizerTest {

    private Tokenizer codaTokenizer;

    @BeforeEach
    void setUp() {
        codaTokenizer = new CodaTokenizer();
    }

    @ParameterizedTest
    @CsvSource({
            "안녕하세여,'ㄴㅇ   '",
            "반갑습니답!,ㄴㅂㅂ ㅂ!",
            "악앆앇안앉않앋알앍앎앏앐앑앒앓암압앖앗았앙앚앛앜앝잎앟,ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ",
            "hello,hello",
            "헬lo,ㄹlo",
            "HELL O 월드,'HELL O ㄹ '",
    })
    void tokenize(final String input,
                  final String expected) {
        // when
        final var out = codaTokenizer.tokenize(input);

        // then
        assertThat(out).isEqualTo(expected);
    }
}