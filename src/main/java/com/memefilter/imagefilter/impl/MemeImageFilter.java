package com.memefilter.imagefilter.impl;

import com.memefilter.imagefilter.ImageFilter;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

/**
 * Created by aross on 18/02/17.
 */
@Component("imageFilter")
public class MemeImageFilter implements ImageFilter {
    @Override
    public String getImageText(BufferedImage image) {
        return null;
    }
}
