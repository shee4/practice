package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleIntersections {

    public static void main(String[] args) {
        System.out.println("create 1st triangle:");
        Triangle firstTri = Triangle.create();
        System.out.println();
        System.out.println("create 2nd triangle:");
        Triangle secondTri = Triangle.create();

        List<Point> intersectionPoints = new ArrayList<>();
        hasIntersection(intersectionPoints, firstTri.a, firstTri.b, secondTri.a, secondTri.c); // AB1 & AC2
        hasIntersection(intersectionPoints, firstTri.a, firstTri.b, secondTri.a, secondTri.b); // AB1 & AB2
        hasIntersection(intersectionPoints, firstTri.a, firstTri.b, secondTri.b, secondTri.c); // AB1 & BC2
        hasIntersection(intersectionPoints, firstTri.b, firstTri.c, secondTri.a, secondTri.b); // BC1 & AB2
        hasIntersection(intersectionPoints, firstTri.b, firstTri.c, secondTri.b, secondTri.c); // BC1 & BC2
        hasIntersection(intersectionPoints, firstTri.b, firstTri.c, secondTri.a, secondTri.c); // BC1 & AC2
        hasIntersection(intersectionPoints, firstTri.a, firstTri.c, secondTri.b, secondTri.c); // AC1 & BC2
        hasIntersection(intersectionPoints, firstTri.a, firstTri.c, secondTri.a, secondTri.c); // AC1 & AC2
        hasIntersection(intersectionPoints, firstTri.a, firstTri.c, secondTri.a, secondTri.b); // AC1 & AB2

        addInsidePoints(intersectionPoints, firstTri, secondTri);

        double area = getArea(intersectionPoints);
        System.out.println("Area of intersection: " + area);
    }

    private static double getArea(List<Point> points) {
        double res = 0;
        int size = points.size();
        for (int i = 0; i < size - 1; i++)
            res += points.get(i).x * points.get(i + 1).y;
        res += points.get(size - 1).x * points.get(0).y;
        for (int i = 0; i < size - 1; i++)
            res -= points.get(i + 1).x * points.get(i).y;
        res -= points.get(0).x * points.get(size - 1).y;
        return 0.5 * Math.abs(res);
    }

    private static void addInsidePoints(List<Point> points, Triangle ft, Triangle st) {
        if(isInside(ft.a, ft.b, ft.c, st.a))
            points.add(st.a);
        if(isInside(ft.a, ft.b, ft.c, st.a))
            points.add(st.a);
        if(isInside(ft.a, ft.b, ft.c, st.a))
            points.add(st.a);
        if(isInside(ft.a, ft.b, ft.c, st.a))
            points.add(st.a);
        if(isInside(ft.a, ft.b, ft.c, st.a))
            points.add(st.a);
        if(isInside(ft.a, ft.b, ft.c, st.a))
            points.add(st.a);
    }

    private static boolean isInside(Point a, Point b, Point c, Point a1) {
        double underFirst = (a.x - a1.x) * (b.y - a.y) - (b.x - a.x) * (a.y - a1.y);
        double nearSecond = (b.x - a1.x) * (c.y - b.y) - (c.x - b.x) * (b.y - a1.y);
        double aboveThird = (c.x - a1.x) * (a.y - c.y) - (a.x - c.x) * (c.y - a1.y);
        return underFirst > 0 && nearSecond > 0 && aboveThird > 0 || underFirst < 0 && nearSecond < 0 && aboveThird < 0;
    }

    public static void hasIntersection(List<Point> l, Point ft1, Point ft2, Point st1, Point st2){
        Point possInter = getIntersection(ft1, ft2, st1, st2);
        if(possInter != null)
            l.add(possInter);
    }

    public static Point getIntersection(Point a1, Point b1, Point a2, Point b2){
        double tan1 = (b1.x - a1.x)/(b1.y - a1.y);
        double tan2 = (b2.x - a2.x)/(b2.y - a2.y);
        if(tan1 == tan2) return null;

        Point res = null;
        double x = -((a1.x * b1.y - b1.x * a1.y) * (b2.x - a2.x) - (a2.x * b2.y - b2.x * a2.y) * (b1.x - a1.x)) /
                    ((a1.y - b1.y) * (b2.x - a2.x) - (a2.y - b2.y) * (b1.x - a1.x));
        double y = ((a2.y - b2.y) * (-x) - (a2.x * b2.y - b2.x * a2.y)) / (b2.x - a2.x);
        if ((Math.min(a1.x,b1.x) <= x && Math.max(a1.x,b1.x) >= x &&
                Math.min(a2.x, b2.x) <= x && Math.max(a2.x, b2.x) >= x) &&
                (Math.min(a1.x, b1.x) <= y && Math.max(a1.x, b1.x) >= y &&
                        Math.min(a2.x, b2.x) <= y && Math.max(a2.x, b2.x) >= y))
            res = new Point(x,y);
        return res;
    }


    
    public static class Point{
        final double x;
        final double y;
        
        public Point(double first, double second){
            x = first;
            y = second;
        }
    }
    
    public static class Triangle{
        Point a;
        Point b;
        Point c;
        
        public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
            a = new Point(x1,y1);
            b = new Point(x2,y2);
            c = new Point(x3,y3);
        }
        public Triangle(Point p1, Point p2, Point p3){
            new Triangle(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
        }

        public static Triangle create(){
            Scanner scan = new Scanner(System.in);
            System.out.println("type 1st corner coords:\nx:");
            double x1 = scan.nextDouble();
            System.out.println("y:");
            double y1 = scan.nextDouble();
            System.out.println("type 2nd corner coords:\nx:");
            double x2 = scan.nextDouble();
            System.out.println("y:");
            double y2 = scan.nextDouble();
            System.out.println("type 3d corner coords:\nx:");
            double x3 = scan.nextDouble();
            System.out.println("y:");
            double y3 = scan.nextDouble();
            return new Triangle(x1, y1, x2, y2, x3, y3);
        }
    }
}
