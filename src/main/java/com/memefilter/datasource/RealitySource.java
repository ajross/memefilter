package com.memefilter.datasource;

import org.springframework.stereotype.Component;

/**
 * Created by aross on 18/02/17.
 */

public interface RealitySource {
    String getRealMeaning(String memeText);
}
