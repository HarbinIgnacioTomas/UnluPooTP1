package ar.unlu.poo.ej7;

import java.util.ArrayList;
import java.util.Scanner;

public class ListadoFormulas {
    ArrayList<Formula> formulas=new ArrayList<>();
    Integer in;
    Integer i;
    Scanner dato=new Scanner(System.in);

    public void agregarFormula(){
        Formula formula=new Formula();
        System.out.printf("Ingrese el primer coeficiente (a): ");
        formula.setA(dato.nextInt());
        dato.nextLine();
        System.out.printf("Ingrese el segundo coeficiente (b): ");
        formula.setB(dato.nextInt());
        dato.nextLine();
        System.out.printf("Ingrese el tercer coeficiente (c) ");
        formula.setC(dato.nextInt());
        dato.nextLine();
        formulas.add(formula);
    }

    public void mostrarListado(){
        for (i=0; i<formulas.size(); i++){
            System.out.printf("Formula %d: "+formulas.get(i).getA()+" * x^2 + "+formulas.get(i).getB()+" * x + "+formulas.get(i).getC()+"\n", i+1);
        }
    }

    public void calcularRaices(){
        System.out.printf("Elija la formula a calcular raices: \n");
        for (i=0; i<formulas.size(); i++){
            System.out.printf("Formula %d: "+formulas.get(i).getA()+" * x^2 + "+formulas.get(i).getB()+" * x + "+formulas.get(i).getC()+"\n", i+1);
        }
        System.out.printf("Opcion: ");
        in=dato.nextInt()-1;
        dato.nextLine();
        if (in>formulas.size()-1){
            System.out.printf("La formula no exite.\n");
        }
        else {
            formulas.get(in).obetenerRaices();
        }

    }
    public void evaluarFuncion(){
        System.out.printf("Elija la formula a evaluar: \n");
        for (i=0; i<formulas.size(); i++){
            System.out.printf("Formula %d: "+formulas.get(i).getA()+" * x^2 + "+formulas.get(i).getB()+" * x + "+formulas.get(i).getC()+"\n", i+1);
        }
        System.out.printf("Opcion: ");
        in=dato.nextInt()-1;
        dato.nextLine();
        if (in>formulas.size()-1){
            System.out.printf("La formula no exite.\n");
        }
        else {
            System.out.printf("Ingrese el valor X a evaluar: ");
            formulas.get(in).calcularParaX(dato.nextFloat());
        }
    }
}
