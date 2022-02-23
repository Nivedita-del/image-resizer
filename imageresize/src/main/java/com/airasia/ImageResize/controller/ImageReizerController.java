package com.airasia.ImageResize.controller;


import com.airasia.ImageResize.service.ImageResizerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.airasia.ImageResize.model.ImageResizerModel;

import javax.ws.rs.core.Response;
import java.io.IOException;

@RestController
@RequestMapping(path="/imagereizer")
public class ImageReizerController {

    @PostMapping(path="/upload", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Response imageFileReSizer(@RequestBody ImageResizerModel imagemodel) {
        ImageResizerService imgser = new ImageResizerService();
        try{
            imgser.resizerService(imagemodel);

        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().entity(e).build();
        }
        return Response.serverError().build();
    }
}
