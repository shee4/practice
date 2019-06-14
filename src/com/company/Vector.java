package com.company;

public class Vector {

    private static threeDPoint start;
    private static threeDPoint end;
    private static int xCoord;
    private static int yCoord;
    private static int zCoord;


    public Vector(int x1, int y1, int z1, int x2, int y2, int z2){
        start = new threeDPoint(x1, y1, z1);
        end = new threeDPoint(x2, y2, z2);
        xCoord = end.x - start.x;
        yCoord = end.y - start.y;
        zCoord = end.z - start.z;
    }

    public Vector(int x, int y, int z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Vector(threeDPoint p1, threeDPoint p2){

        new Vector(p1.x, p1.y, p1.z, p2.x, p2.y, p2.z);
    }

    public double getLength(){
        return Math.sqrt(Math.pow((xCoord), 2) + Math.pow((yCoord), 2) + Math.pow((zCoord), 2));
    }

    public Vector vectorSum(Vector v){
        return new Vector(this.xCoord + v.xCoord, this.yCoord + v.yCoord, this.zCoord + v.zCoord);
    }

    public Vector vectorSubtract(Vector v){
        return new Vector(this.xCoord - v.xCoord, this.yCoord - v.yCoord, this.zCoord - v.zCoord);
    }

    public double scalarMult(Vector v){
        return this.xCoord * v.xCoord + this.yCoord * v.yCoord + this.zCoord * v.zCoord;
    }

    public double cos(Vector v){
        return scalarMult(v) / (getLength() * v.getLength());
    }

    class threeDPoint{
        final int x;
        final int y;
        final int z;

        threeDPoint(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
