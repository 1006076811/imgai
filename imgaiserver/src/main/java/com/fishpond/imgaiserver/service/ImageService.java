package com.fishpond.imgaiserver.service;

import com.fishpond.imgaiserver.mapper.ImageMapper;
import com.fishpond.imgaiserver.model.Image;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageMapper imageMapper;
    public int addImage(Image image){
        return imageMapper.addImage(image);
    }
    public int removeImageById(int id){
        return imageMapper.removeImageById(id);
    }
    public int updateImageById(Image image){
        return imageMapper.updateImageById(image);
    }
    public int updateImageSelectiveById(Image image){
        return imageMapper.updateImageSelectiveById(image);
    }
    public Image getImageById(int id){
        return imageMapper.getImageById(id);
    }
    public List<Image> getAllImage(){
        return imageMapper.getAllImage();
    }
}
