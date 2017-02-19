package com.memefilter.imagefilter.impl;

import com.memefilter.imagefilter.ImageFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by aross on 18/02/17.
 */
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.memefilter.imagefilter.impl"})
public class MemeImageFilterTest {

    @Autowired
    @Qualifier("imageFilter")
    private ImageFilter imageFilter;

    @Test
    public void getImageTextThrowsOnNullImage() {
        assertThatThrownBy(() -> imageFilter.getImageText(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Image must not be null.");
    }

    @Test
    public void getImageTextReturnsEmptyStringIfNoTextFound() {
        final String result = getTextFromImageResource("solid-black.png");
        assertThat(result).isEqualTo("");
    }

    @Test
    public void getImageTextReturnsTextForClearImage() {
        final String result = getTextFromImageResource("handle-clear.png");
        assertThat(result).isEqualToIgnoringCase("If you can't handle me at my worst, you don't deserve me at my best");
    }

    private String getTextFromImageResource(final String filename) {
        final InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);

        BufferedImage image = null;
        try {
            image = ImageIO.read(resourceAsStream);
        } catch (final IOException e) {
            fail("Unable to read image.", e);
        }

        return imageFilter.getImageText(image);
    }

}