package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import org.springframework.stereotype.Service;


public interface PostService {
    PostDto creatPost(PostDto postDto);
}
