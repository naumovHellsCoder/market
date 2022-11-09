package com.naumov.productservice.controller;

import com.naumov.productservice.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/shop/image")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @GetMapping(path = "/${id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getPathImage(@PathVariable("id") Integer id){
        return imageService.getFilePathFromId(id);
    }
}
