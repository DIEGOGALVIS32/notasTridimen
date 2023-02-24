package matriz_tridimensional;

import java.util.Random;
import java.util.Scanner;

public class Matriz_Tridimensional {

    public static void main(String[] args) {

        Scanner informe = new Scanner(System.in);

        float[][][] Notas = new float[4][3][3];
        byte posicion = 0;

        String Cursos[] = {"calculo", "algebra", "fisica"};
        String Estudiantes[] = {"pedro", "maria", "muan", "pepe"};

        float Suma = 0, Promedio = 0;

        float definitivaCurso = 0,conDefCursoAlge = 0;
        float[] defCursoAlge = new float[Estudiantes.length];

        String tecladoEstudiante,tecladoCurso;

        for (byte Fila = 0; Fila < Notas.length; Fila++) {
            for (byte Columna = 0; Columna < Notas[Fila].length; Columna++) {
                for (byte Fondo = 0; Fondo < Notas[Fila][Columna].length; Fondo++) {
                    float random=(float) (Math.random() * 4 + 1);
                    Notas[Fila][Columna][Fondo] = Math.round(random);
                }
            }
        }
        for (byte Fila = 0; Fila < Estudiantes.length; Fila++) {
            System.out.println("Estudiante: " + Estudiantes[Fila]);
            for (byte Columna = 0; Columna < Cursos.length; Columna++) {
                System.out.println("Curso: " + Cursos[Columna]);
                for (byte Fondo = 0; Fondo < Notas[Fila][Columna].length; Fondo++) {
                    System.out.println("Notas " + (Fondo + 1) + ": " + Notas[Fila][Columna][Fondo]);
                    System.out.println("  ");

                    if (Fondo == 2) {
                        definitivaCurso += (Notas[Fila][Columna][Fondo] * 0.40);
                    } else {
                        definitivaCurso += (Notas[Fila][Columna][Fondo] * 0.30);
                    }
                    /////// Definitivas Algebra - 2. Estudiante con mayor nota definitiva en algebra (30,30,40)
                    defCursoAlge[Fila] = conDefCursoAlge;
                    if (Columna == 0) {
                        conDefCursoAlge = definitivaCurso;
                    }

                }
                //// DEFINITIVA POR CURSOS
                double promedio = definitivaCurso / 3;
                definitivaCurso=(definitivaCurso*10)/10;
                System.out.println("Definitiva Curso " + Cursos[Columna] + " es igual a: " + definitivaCurso);
                definitivaCurso = 0;
                System.out.println("");
            }
            ///2. Estudiante con mayor nota definitiva en algebra (30,30,40)
            byte defMayor = (byte) defCursoAlge[0];

            for (int i = 1; i < defCursoAlge.length; i++) {
                if (defCursoAlge[i] > defMayor) {
                    defMayor = (byte) defCursoAlge[i];
                    posicion = (byte) i;
                }
            }



        }
        switch (posicion) {
            case 0:
                System.out.println("SOLUCION PREGUNTA 2: Pedro es el estudiante con mayor definitiva en algebra");
                break;
            case 1:
                System.out.println("SOLUCION PREGUNTA 2: Maria es la estudiante con mayor definitiva en algebra");
                break;
            case 2:
                System.out.println("SOLUCION PREGUNTA 2: Juan es el estudiante con mayor definitiva en algebra");
                break;
            default:
                System.out.println("SOLUCION PREGUNTA 2: Pepe es el estudiante con mayor definitiva en algebra");
                break;
        }
        for (int Prom = 0; Prom < Estudiantes.length; Prom++) {
            Suma += Notas[Prom][0][2];
            Promedio = Suma / 4;

        }

        System.out.println("SOLUCION PREGUNTA 1");
        System.out.println("El promedio del examen final del curso de " + Cursos[0] + " es: " + Promedio);
        System.out.println("\nSOLUCION PREGUNTA 3");


        System.out.println("Ingresar estudiante: ");
        tecladoEstudiante = informe.next();
        System.out.println("Ingresar Curso: ");
        tecladoCurso = informe.next();
        byte contEstu=0,contCur=0;
        for (int i = 0; i < Estudiantes.length; i++) {
            if(tecladoEstudiante.equals(Estudiantes[i])){
                contEstu=(byte) i;
            }
        }
        for (int j = 0; j < Cursos.length; j++) {
            if(tecladoCurso.equals(Cursos[j])){
                contCur=(byte) j;
            }
        }

        for (byte fila2 = contEstu; fila2 < contEstu + 1; fila2++) {
            System.out.println("Estudiante: " + Estudiantes[fila2]);
            for (byte columna2 = contCur; columna2 < contCur + 1; columna2++) {
                System.out.println("Curso: " + Cursos[columna2]);
                for (byte fondo2 = 0; fondo2 <Notas[fila2][columna2].length; fondo2++) {
                    System.out.println("Corte " + (fondo2 + 1) + ": " + Notas[fila2][columna2][fondo2]);
                }
            }
            System.out.println("");
        }
    }

}
