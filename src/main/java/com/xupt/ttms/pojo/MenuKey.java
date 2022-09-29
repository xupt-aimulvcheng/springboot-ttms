package com.xupt.ttms.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MenuKey implements Serializable {
    private static final long serialVersionUID = -3313200764774942340L;
    private Long id;
    private String title;
    private String href;
}