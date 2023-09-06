import ar.unlu.poo.ej11.Juego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer turno=0;
        String chars;
        Integer flag=1;
        Juego juego=new Juego();
        Scanner dato=new Scanner(System.in);

        System.out.printf("---Cargar diccionario---\n");

        while (flag!=0){
            System.out.printf("Ingresar palara (S para salir): ");
            chars=dato.nextLine();
            if (chars.equals("S") || chars.equals("s")){
                flag=0;
            }
            else {
                juego.agregarPalabraDiccionario(chars);
            }
        }

        flag=1;
        while (flag!=0){
            System.out.printf("Ingrese nuevo jugador (S para terminar): ");
            chars=dato.nextLine();
            if (chars.equals("S") || chars.equals("s")){
                flag=0;
            }
            else {
                juego.agregarJugador(chars);
            }
        }

        flag=1;
        while (flag!=0){
            System.out.printf("\n'TERMINAR' para finalizar el juego\n");
            System.out.printf("Turno de ");
            System.out.printf(""+juego.getJugadores().get(turno).getNombre()+"\n");
            System.out.printf("Palabra: ");
            chars=dato.nextLine();
            if (chars.equals("TERMINAR")){
                System.out.printf("\n");
                juego.ganador();
                flag=0;
            }
            else {
                juego.puntuarPalabra(chars, juego.getJugadores().get(turno));
                turno++;
                if (turno==juego.getJugadores().size()){
                    turno=0;
                }
            }
        }
    }
}