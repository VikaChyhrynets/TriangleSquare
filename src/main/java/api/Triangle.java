package api;

public class Triangle {

    public double square(double a, double b, double c) {
        // Square can`t be - 1, so we consider that if it`s not possible to calculate triangle`s square, than
        // we`ll return - 1
        double square = -1;

        if (a <= 0) {
            System.out.println("It can`t be a triangle. Side a is " + a);
        } else if (b <= 0) {
            System.out.println("It can`t be a triangle. Side b is " + b);
        } else if (c <= 0) {
            System.out.println("It can`t be a triangle. Side c is " + c);
        } else if (a+b < c) {
            System.out.println("It can`t be a triangle. Length of the a and b sum is less than c");
        } else if (a+c < b) {
            System.out.println("It can`t be a triangle. Length of the a and c sum is less than b");
        } else if (b+c < a) {
            System.out.println("It can`t be a triangle. Length of the b and c sum is less than a");
        } else {
            double p = (a + b + c) / 2;
            square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Square: " + square);
        }

        return Math.round( square * 100.0 ) / 100.0;
    }

}
