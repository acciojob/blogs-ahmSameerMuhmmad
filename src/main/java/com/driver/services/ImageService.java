package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);
        List<Image>imageList=new ArrayList<>();
        imageList.add(image);
        blog.setImageList(imageList);
        blogRepository2.save(blog);
        return image;


    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

//        Blog blog=blogRepository2.findById(id).get();
        Image image=imageRepository2.findById(id).get();
        String size=image.getDimensions();
        int screenDim=Integer.valueOf(screenDimensions);
        int imageDim=Integer.valueOf(size);
        int ans=screenDim/imageDim;
        return ans;



    }
}
