package com.example.geogg;

public class Program {
    public static void main(String[] args) {

    }

    static double Gr(double gr, double min, double sk)
    {
        return gr + min / 60 + sk / 3600;
    }

    static String Gr_min_sk(double gr_double)
    {
        int gr = (int) gr_double;
        int min = (int) ((gr_double - gr) * 60);
        double sk = (double) ((gr_double - gr - (double) min / 60) * 3600);
        return String.valueOf(gr) + " " + String.valueOf(min) + " " + String.valueOf(sk);
    }

    static String XY_b(double Xa, double Ya, double d, double gr, double min, double sk) {
        double angle = Gr(gr, min, sk);
        double d_X = d * Math.cos(Math.toRadians(angle));
        double d_Y = d * Math.sin(Math.toRadians(angle));
        double Xb = Xa + d_X;
        double Yb = Ya + d_Y;

        String res = String.valueOf(Xb) + " " + String.valueOf(Yb);
        return res;
    }

    static double Ob(double Xa, double Ya, double Xb, double Yb)
    {
        double dx = Xb -Xa;
        double dy = Yb - Ya;
        double res = Math.toDegrees(Math.atan(Math.abs((double) dy / dx)));
        double rumb = res;

        //System.out.println(dx);
        //System.out.println(dy);

        //System.out.println(res);
        if (dx > 0 && dy > 0){
            rumb = res;
        }
        else if (dx < 0 && dy > 0){
            rumb = 180 - res;
        }
        else if (dx < 0 && dy < 0){
            rumb = res - 180;
        }
        else if (dx > 0 && dy < 0){
            rumb = 360 - res;
        }
        double A = 360 - rumb;
        double d = dx/Math.cos(Math.toRadians(A));
        //String strRes = Integ(res);
        // String[] arr = res.split("");
        //String A =
        //double grad1 = Grad(72,16,46);
        //System.out.println(arr + "sf ");
        return d;
    }


    static String D_alfa(double Xa, double Ya, double Xb, double Yb) {
        double d_X = Xb - Xa;
        double d_Y = Yb - Ya;
        double r = Math.toDegrees(Math.atan(Math.abs((double) d_Y / d_X)));
        //String[] list_r_gr = r_gr.split(" ");

        //double gr = Double.parseDouble(list_r_gr[0]);
        //double min = Double.parseDouble(list_r_gr[1]);
        //double sk = Double.parseDouble(list_r_gr[2]);

        //double r = Gr(gr, min, sk);
        double alfa = 0;

        if (d_X > 0 && d_Y > 0) {
            alfa = r;
        } else if (d_X < 0 && d_Y > 0) {
            alfa = 180 - r;
        } else if (d_X < 0 && d_Y < 0) {
            alfa = r - 180;
        } else if (d_X > 0 && d_Y < 0) {
            alfa = 360 - r;
        }

        double alfa_cos = Math.cos(Math.toRadians(alfa));
        double d = d_X / alfa_cos;
        return String.valueOf(d) + " " + String.valueOf(alfa);
    }
}
