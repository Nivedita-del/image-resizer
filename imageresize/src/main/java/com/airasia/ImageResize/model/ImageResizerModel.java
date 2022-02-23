package com.airasia.ImageResize.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageResizerModel {
    float imageSize;
    String imagePaths;

    public float getImageSize() {
        return imageSize;
    }

    public void setImageSize(float imageSize) {
        this.imageSize = imageSize;
    }

    public String getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(String imagePaths) {
        this.imagePaths = imagePaths;
    }
}
