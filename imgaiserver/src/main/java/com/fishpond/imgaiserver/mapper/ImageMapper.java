package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Image;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {
    public int addImage(Image image);
    public int removeImageById(@Param("id") int id);
    public int updateImageById(Image image);
    public int updateImageSelectiveById(Image image);
    public Image getImageById(@Param("id") int id);
    public List<Image> getAllImage();
}
