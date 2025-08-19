import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
       
        // Clase scanner que nos permite que el usuario escriba
        Scanner scan = new Scanner(System.in);

        //Declaraciones y asignacion de variables
        String palabraSecreta = "alebrije";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //Arreglos:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        //estructura de control: Iterativa Bucle
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
        // Estructura de control  Itearativa (Bucle)
        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a a divinar : " + String.valueOf(letrasAdivinadas)+" ("+ palabraSecreta.length() +" letras)");
            System.out.println("introduce una letra, por favor");
            
            // uasmos la clase scanner para pedir una letra
            char letra = Character.toLowerCase(scan.next().charAt(0));

            boolean letraCorrecta = false;
            
            //estructura de control iterativa (Bucle)
            for (int i = 0; i < palabraSecreta.length(); i++) {
                //estructura de control: condicional
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            if (!letraCorrecta){
                intentos = intentos +1; 
                System.err.println("!Incorrecto! Te quedan "+ (intentosMaximos - intentos)+" intentos.");
            }
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("\n\t !Felicidades¡ \n Has adivinado la palabra secreta: "+ palabraSecreta.toUpperCase());
            }
        }
        if(!palabraAdivinada){
            System.out.println("\n¡Que pena! Se terminaron los intentos!, Fin del Juego");
        }
        scan.close(); //cerramos el escucha del teclado.
    }
}
