package com.memefilter.realitysource.impl;

import com.memefilter.realitysource.RealitySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aross on 18/02/17.
 */
@Component("realitySource")
public class StaticRealitySource implements RealitySource {
    private static final Map<Pattern, Integer> quoteStore = new HashMap<>();
    private static final Map<Integer, String> realityStore = new HashMap<>();

    public StaticRealitySource() {
        quoteStore.put(Pattern.compile("Meme", Pattern.CASE_INSENSITIVE), 0);
        quoteStore.put(Pattern.compile("If you can't handle me at my .+ you don't deserve me at my .+", Pattern.CASE_INSENSITIVE), 1);

        realityStore.put(0, "Reality");
        realityStore.put(1, "If you won't put up with me when I mistreat you, you don't deserve me.");
    }

    @Override
    public String getRealMeaning(final String memeText) {
        if (memeText == null) {
            throw new IllegalArgumentException("Meme text must not be null.");
        }

        final Optional<Map.Entry<Pattern, Integer>> entry = quoteStore.entrySet().stream().filter(e -> e.getKey().matcher(memeText).matches()).findFirst();

        if (!entry.isPresent()) {
            return "";
        }

        final String result = realityStore.get(entry.get().getValue());

        if (result == null) {
            throw new IllegalStateException(String.format("Real meaning not available for meme! (%s)", memeText));
        }

        return result;
    }
}
