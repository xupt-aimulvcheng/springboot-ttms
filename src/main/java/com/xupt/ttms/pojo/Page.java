package com.xupt.ttms.pojo;

import java.io.Serializable;

public class Page  implements Serializable {
    private static final long serialVersionUID = -7769872887655981374L;
    private Integer page;
    private Integer limit;

    public Page(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Page() {
    }
}
