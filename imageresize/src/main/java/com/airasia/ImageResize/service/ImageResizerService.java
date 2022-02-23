package com.airasia.ImageResize.service;


import com.airasia.ImageResize.model.ImageResizerModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.apache.log4j.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class ImageResizerService {

//    Logger log = Logger.getLogger(ImageResizerService.class.getName());
//
//    String fileName = "/Users/nivedita/Documents/codebases/backend/imageresize/logs/test.log";

    public void resizerService(ImageResizerModel imagedata) throws JsonParseException {
        Gson gson = new Gson();


        try {
//            JsonObject joj = new Gson().fromJson(String.valueOf(imagedata), JsonObject.class);

            float quality = imagedata.getImageSize();
            String ImageFile = imagedata.getImagePaths();

            File imageFile = new File(ImageFile);

            File compressedFile = new File(ImageFile.replace("data", "replaced"));
            InputStream inp = new FileInputStream(imageFile);
            OutputStream ou = new FileOutputStream(compressedFile);

            BufferedImage image = ImageIO.read(inp);
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

            if (!writers.hasNext())
                throw new IllegalStateException("No writers found");

            ImageWriter writer = writers.next();
            ImageOutputStream ios = ImageIO.createImageOutputStream(ou);
            writer.setOutput(ios);

            ImageWriteParam param = writer.getDefaultWriteParam();

            // compress to a given quality
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(quality);

            // appends a complete image stream containing a single image and
            //associated stream and image metadata and thumbnails to the output
            writer.write(null, new IIOImage(image, null, null), param);

            // close all streams
            inp.close();
            ou.close();
            ios.close();
            writer.dispose();

        } catch (JsonParseException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
