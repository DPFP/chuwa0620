package com.chuwa.redbook.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PostDto {

    private long id;

    private String title;

    private String description;

    private String content;

}
