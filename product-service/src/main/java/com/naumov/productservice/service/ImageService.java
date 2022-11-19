package com.naumov.productservice.service;

import com.naumov.productservice.model.Image;
import com.naumov.productservice.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    
    public String getFilePathFromId(Integer id){
        Image image = imageRepository.getImageById(id);
        if(image == null) {
            return "not found";
        }
        return image.getFilePath();
    }
}
