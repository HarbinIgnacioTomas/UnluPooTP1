package ar.unlu.poo.ej8;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilidadesContrsenia {
    Scanner dato=new Scanner(System.in);
    SecureRandom random=new SecureRandom();
    String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String generar(Integer lon){
        String contrasenia="";
        Integer i;
        for (i=0; i<lon; i++){
            contrasenia+=""+chars.charAt(random.nextInt(62));
        }
        return contrasenia;
    }

    public Integer esFuerte(String contrasenia){
        Integer i;
        Integer j;
        String numsC="0123456789";
        String mayusC="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusC="abcdefghijklmnopqrstuvwxyz";
        Integer nums=0;
        Integer mayus=0;
        Integer minus=0;
        for (i=0; i<contrasenia.length(); i++){
            for (j=0; j<numsC.length(); j++){
                if (contrasenia.charAt(i)==numsC.charAt(j)) {
                    nums++;
                }
            }
            for (j=0; j<mayusC.length(); j++){
                if (contrasenia.charAt(i)==mayusC.charAt(j)){
                    mayus++;
                }
            }
            for (j=0; j<mayusC.length(); j++){
                if (contrasenia.charAt(i)==minusC.charAt(j)){
                    minus++;
                }
            }
        }
        if (mayus<3 || minus<2 || nums<2){
            return 0;
        }
        else {
            return 1;
        }
    }

    public Contrasenia hacerFuerte(Contrasenia contrasenia){
        String nueva=contrasenia.getContrasenia();
        Integer lon=contrasenia.getLongitud();
        if (this.esFuerte(nueva)==1){
            System.out.printf("La contraseña ya es fuerte");
            return null;
        }
        while (this.esFuerte(nueva)==0){
            nueva=this.generar(lon);
        }
        contrasenia.setContrasenia(nueva);
        System.out.printf("Nueva contrasenia: "+nueva+" fuerte\n");
        return contrasenia;
    }

    public Contrasenia reGenerar(Contrasenia contrasenia, Integer lon){
        contrasenia.setLongitud(lon);
        contrasenia.setContrasenia(this.generar(lon));
        return contrasenia;
    }

    public void generarPorCantidad(Integer cant_contrasenias, Integer lon){
        Integer i;
        ArrayList<Contrasenia> lista_contrasenias=new ArrayList<>();
        for (i=0; i<cant_contrasenias; i++){
            Contrasenia contrasenia=new Contrasenia();
            this.reGenerar(contrasenia, lon);
            System.out.printf(""+contrasenia.getContrasenia());
            if (this.esFuerte(contrasenia.getContrasenia())==1){
                System.out.printf(" fuerte\n");
            }
            else {
                System.out.printf(" debil\n");
            }
            lista_contrasenias.add(contrasenia);
        }
        System.out.printf("convertir debiles a fuertes? (1 para si / 0 para no):");
        Integer op=dato.nextInt();
        if (op==0){
            return;
        }
        else if (op==1){
            for (i=0; i<lista_contrasenias.size(); i++){
                if (this.esFuerte(lista_contrasenias.get(i).getContrasenia())==0){
                    this.hacerFuerte(lista_contrasenias.get(i));
                }
                else {
                    this.mostrarContrasenia(lista_contrasenias.get(i));
                }
            }
        }
        else {
            System.out.printf("Opcion no valida");
        }

    }

    public void mostrarContrasenia(Contrasenia contrasenia){
        System.out.printf(""+contrasenia.getContrasenia());
        if (this.esFuerte(contrasenia.getContrasenia())==1){
            System.out.printf(" fuerte\n");
        }
        else {
            System.out.printf(" debil\n");
        }
    }
}
