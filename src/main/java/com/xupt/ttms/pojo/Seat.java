package com.xupt.ttms.pojo;

public class Seat {
    private Integer id;
    private Integer studioId;
    private Integer row;
    private Integer col;
    private Integer status = 1; //1代表完好，0代表损坏，9代表已购买

    private Hall hall;

    public Seat() {
    }

    public Seat(Integer id, Integer studioId, Integer row, Integer col) {
        this.id = id;
        this.studioId = studioId;
        this.row = row;
        this.col = col;
    }

    public Seat(Integer id, Integer studioId, Integer row, Integer col, Integer status) {
        this.id = id;
        this.studioId = studioId;
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", studioId=" + studioId +
                ", row=" + row +
                ", col=" + col +
                ", status=" + status +
                '}';
    }
}
