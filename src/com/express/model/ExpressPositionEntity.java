package com.express.model;

/**
 * Created by violet on 2016/4/27.
 */
public class ExpressPositionEntity {
    private int id;
    private double x;
    private double y;

    public ExpressPositionEntity() {
    }

    public ExpressPositionEntity(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "ExpressPositionEntity{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
