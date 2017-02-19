package com.memefilter.imagefilter.impl;

import com.memefilter.imagefilter.ImageFilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;
import static org.bytedeco.javacpp.lept.pixReadMem;
import static org.bytedeco.javacpp.tesseract.*;

/**
 * Created by aross on 18/02/17.
 */
@Component("imageFilter")
public class MemeImageFilter implements ImageFilter {


    @Override
    public String getImageText(final BufferedImage image) {
        if (image == null) {
            throw new IllegalArgumentException("Image must not be null.");
        }

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init("/usr/share/tesseract/tessdata", "eng") != 0) {
            throw new IllegalStateException("Could not initialize tesseract.");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            throw new IllegalStateException("Error writing image to buffer.", e);
        }
        byte[] bytes = baos.toByteArray();
        PIX pixImage = pixReadMem(bytes, bytes.length);

        api.SetImage(pixImage);
        // Get OCR result
        final BytePointer outText = api.GetUTF8Text();

        // Destroy used object and release memory
        api.End();

        final String result = outText.getString();
        outText.deallocate();
        pixDestroy(pixImage);

        return result;

    }
}
