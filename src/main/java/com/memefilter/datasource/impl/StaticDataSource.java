package com.memefilter.datasource.impl;

import com.memefilter.datasource.QuoteSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aross on 18/02/17.
 */
@Component("quoteSource")
public class StaticDataSource implements QuoteSource {
    private static final Map<String, Integer> quoteStore = new HashMap<>();

    @Override
    public String getRealQuote(String quote) {
        return null;
    }
}
