package com.fishpond.imgaiserver.service;

import com.fishpond.imgaiserver.mapper.UserWithImgMapper;
import com.fishpond.imgaiserver.model.Image;
import com.fishpond.imgaiserver.model.UserWithImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWithImgService {
    @Autowired
    UserWithImgMapper userWithImgMapper;

    public int addUserWithImage(UserWithImg userWithImg){
        return userWithImgMapper.addUserWithImage(userWithImg);
    }
    public int removeUserWithImageByUid(int uid){
        return userWithImgMapper.removeUserWithImageByUid(uid);
    }
    public int removeUserWithImageByIid(int iid){
        return userWithImgMapper.removeUserWithImageByIid(iid);
    }
    public List<Image> getImageByUid(int uid){
        return userWithImgMapper.getImageByUid(uid);
    }
}
