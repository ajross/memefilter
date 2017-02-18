package com.memefilter.datasource.impl;

import com.memefilter.datasource.RealitySource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by aross on 18/02/17.
 */
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.memefilter.datasource.impl"})
public class StaticDataSourceTest {

    @Autowired
    @Qualifier("realitySource")
    private RealitySource realitySource;

    @Test
    public void getRealMeaningThrowsOnNullArg() {
        assertThatThrownBy(() -> realitySource.getRealMeaning(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input cannot be null");

    }

    @Test
    public void getRealMeaningReturnsValidOutput() throws Exception {
        assertThat(realitySource.getRealMeaning("Test")).isEqualTo("TestResponse");
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