package ar.unlu.poo.ej11;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores=new ArrayList<>();
    private String adicionales="KkZzXxYyWwQq";
    Diccionario diccionario=new Diccionario();

    public  void agregarPalabraDiccionario(String palabra){
        diccionario.agregarPalabra(palabra);
    }

    public void agregarJugador(String nombre){
        Jugador jugador=new Jugador();
        jugador.setNombre(nombre);
        jugadores.add(jugador);
    }

    public void puntuarPalabra(String palabra, Jugador jugador){
        Integer puntaje=0;
        Integer i;
        Integer j;
        Palabra p=new Palabra();
        p.setPalabra(palabra);
        p.setLon(palabra.length());
        if (diccionario.buscarPalabra(palabra)==false){
            System.out.printf("La palabra no se encuentra en el diccionario\n");
        }
        else {
            puntaje=palabra.length();
            for (i=0; i<adicionales.length(); i++){
                for (j=0; j<palabra.length(); j++){
                    Character s1=adicionales.charAt(i);
                    Character s2=palabra.charAt(j);
                    if (s1.equals(s2)){
                        puntaje++;
                    }
                }
            }
        jugador.setPuntaje(jugador.getPuntaje()+puntaje);
        System.out.printf("+"+puntaje+" puntos\n");
        }
    }

    public void mostrarJugador(String nombre){
        Integer encontrado=0;
        Integer i;
        for (i=0; i<jugadores.size(); i++){
            if (jugadores.get(i).getNombre().equals(nombre)){
                encontrado=1;
                System.out.printf(""+nombre+": "+jugadores.get(i).getPuntaje()+" puntos\n");
            }
        }
        if (encontrado==0){
            System.out.printf("El jugador no existe");
        }
    }

    public void ganador(){
        Integer mayor_puntaje=0;
        String ganador="";
        Integer i=0;
        for (i=0; i< jugadores.size(); i++){
            mostrarJugador(jugadores.get(i).getNombre());
            if (jugadores.get(i).getPuntaje()>mayor_puntaje){
                mayor_puntaje=jugadores.get(i).getPuntaje();
                ganador=jugadores.get(i).getNombre();
            }
        }
        System.out.printf("\nGanador/es:\n");
        for (i=0; i< jugadores.size(); i++){
            if (jugadores.get(i).getPuntaje()==mayor_puntaje){
                this.mostrarJugador(jugadores.get(i).getNombre());
            }
        }
    }

    public void mostrarDiccionario(){
        Integer i;
        for (i=0; i<diccionario.getDiccionario().size(); i++){
            System.out.printf(""+diccionario.getDiccionario().get(i)+"\n");
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}
