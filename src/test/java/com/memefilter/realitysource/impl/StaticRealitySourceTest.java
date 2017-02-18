package com.memefilter.realitysource.impl;

import com.memefilter.realitysource.RealitySource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by aross on 18/02/17.
 */
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.memefilter.realitysource.impl"})
public class StaticRealitySourceTest {

    @Autowired
    @Qualifier("realitySource")
    private RealitySource realitySource;

    @Test
    public void getRealMeaningThrowsOnNullArg() {
        assertThatThrownBy(() -> realitySource.getRealMeaning(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Meme text must not be null.");

    }

    @Test
    public void getRealMeaningReturnsValidOutputIgnoringMemeCasing() throws Exception {
        assertThat(realitySource.getRealMeaning("Meme")).isEqualTo("Reality");
        assertThat(realitySource.getRealMeaning("MEME")).isEqualTo("Reality");
        assertThat(realitySource.getRealMeaning("meme")).isEqualTo("Reality");
    }

    @Test
    public void getRealMeaningReturnsEmptyForNotFoundInput() {
        assertThat(realitySource.getRealMeaning("##################")).isEqualTo("");
    }

    @Test
    public void getRealMeaningReturnsEmptyForEmptyInput() {
        assertThat(realitySource.getRealMeaning("")).isEqualTo("");
    }

}