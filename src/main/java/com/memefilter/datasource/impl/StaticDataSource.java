package com.memefilter.datasource.impl;

import com.memefilter.datasource.RealitySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aross on 18/02/17.
 */
@Component("realitySource")
public class StaticDataSource implements RealitySource {
    private static final Map<String, Integer> quoteStore = new HashMap<>();

    @Override
    public String getRealMeaning(String memeText) {
        return null;
    }
}
