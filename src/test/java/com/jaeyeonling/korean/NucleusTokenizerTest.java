package com.jaeyeonling.korean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NucleusTokenizerTest {

    private Tokenizer nucleusTokenizer;

    @BeforeEach
    void setUp() {
        nucleusTokenizer = new NucleusTokenizer();
    }

    @ParameterizedTest
    @CsvSource({
            "안녕하세여,ㅏㅕㅏㅔㅕ",
            "반갑습니다!,ㅏㅏㅡㅣㅏ!",
            "아애야얘어에여예오와왜외요우워웨위유으의이,ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ",
            "ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ,ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ",
            "hello,hello",
            "헬lo,ㅔlo",
            "HELL O 월드,HELL O ㅝㅡ",
    })
    void tokenize(final String input,
                  final String expected) {
        // when
        final var out = nucleusTokenizer.tokenize(input);

        // then
        assertThat(out).isEqualTo(expected);
    }
}