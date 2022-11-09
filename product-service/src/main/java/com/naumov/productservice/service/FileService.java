package com.naumov.productservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileService {

    public void saveImage(String filePath, byte[] bytesImage)
    {
        File file = new File(filePath);
    try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(byte b: bytesImage){
            writer.write(b);
        }
        writer.flush();
        writer.close();
    }catch (IOException e){
        e.printStackTrace();
    }
    }
}
