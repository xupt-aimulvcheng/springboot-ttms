package com.xupt.ttms.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MenuKey implements Serializable {
    private Long id;
    private String title;
    private String href;
}