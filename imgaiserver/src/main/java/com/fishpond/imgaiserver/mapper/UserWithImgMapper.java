package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Image;
import com.fishpond.imgaiserver.model.UserWithImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWithImgMapper {
    public int addUserWithImage(UserWithImg userWithImg);
    public int removeUserWithImageByUid(@Param("uid") int uid);
    public int removeUserWithImageByIid(@Param("iid") int iid);
    public List<Image> getImageByUid(@Param("uid")int uid);
}
