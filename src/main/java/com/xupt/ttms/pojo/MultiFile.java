package com.xupt.ttms.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MultiFile {
    private List<MultipartFile> list;//该List集合中包含对应的上传文件的信息

    @Override
    public String toString() {
        return "MultiFile{" +
                "list=" + list +
                '}';
    }

    public List<MultipartFile> getList() {
        return list;
    }

    public void setList(List<MultipartFile> list) {
        this.list = list;
    }
}

