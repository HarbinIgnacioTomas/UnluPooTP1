package ar.unlu.poo.ej7;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Formula {
    private Integer a=1;
    private Integer b=1;
    private Integer c=-1;

    public void setA(Integer a) {
        this.a = a;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public Integer getC() {
        return c;
    }

    public Object obetenerRaices(){
        if ((float)(int)Math.pow(b,2)-(4*a*c)==0){
            Float raiz=(-b+((float)(int)Math.sqrt((float)(int)Math.pow(b,2)-(4*a*c))))/2*a;
            System.out.printf("Raiz de la funcion: "+raiz+"\n");
            return raiz;
        }
        else if ((float)(int)Math.pow(b,2)-(4*a*c)>0){
            Float raiz1=(-b+((float)(int)Math.sqrt((float)(int)Math.pow(b,2)-(4*a*c))))/2*a;
            Float raiz2=(-b-((float)(int)Math.sqrt((float)(int)Math.pow(b,2)-(4*a*c))))/2*a;
            System.out.printf("Raices de la funcion: "+raiz1+" y "+raiz2+"\n");
            ArrayList<Float> raices=new ArrayList<>();
            raices.add(raiz1);
            raices.add(raiz2);
            return  raices;
        }
        else {
            System.out.printf("La funcion no tiene raices.\n");
            return null;
        }
    }
    public Float calcularParaX(Float x){
        Float y=(float)a*(float)(int)Math.pow(x,2)+(float)b*x+(float)c;
        System.out.printf("Resultado para Y evaluado en X: "+y+"\n");
        return y;
    }
}
