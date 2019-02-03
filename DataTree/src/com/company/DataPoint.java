package com.company;

import java.util.ArrayList;

public class DataPoint {
    private ArrayList<DataPoint> parents;
    private ArrayList<DataPoint> children;
    private int ID;
    private String data;

    public DataPoint(int ID, String data) {
        this.ID = ID;
        this.data = data;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }




    public void addParent(DataPoint dataPoint){
        this.parents.add(dataPoint);
    }

    public void removeParent(DataPoint dataPoint){
        this.parents.remove(parents.indexOf(dataPoint));
    }

    public ArrayList<DataPoint> getParents() {
        return parents;
    }

    public DataPoint getParent(int index){
        return parents.get(index);
    }




    public void addChildren(DataPoint dataPoint){
        this.children.add(dataPoint);
    }

    public void removeChildren(DataPoint dataPoint){
        this.children.remove(children.indexOf(children));
    }

    public ArrayList<DataPoint> getChildren() {
        return children;
    }

    public DataPoint getChild(int index){
        return children.get(index);
    }

    @Override
    public String toString() {
        return  "ID=" + ID + ", data='" + data + '\'';
    }
}
