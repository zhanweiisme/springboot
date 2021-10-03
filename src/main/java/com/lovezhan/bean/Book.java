package com.lovezhan.bean;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {
	
    private Integer id;

    private String filename;

    private String cover;

    private String title;

    private String author;

    private String publisher;

    private String bookid;

    private Integer category;

    private String categorytext;

    private String language;

    private String rootfile;

    private String originalname;

    private String filepath;

    private String unzippath;

    private String coverpath;

    private String createuser;

    private Long createdt;

    private Long updatedt;

    private Integer updatetype;


}