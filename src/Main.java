import clases.SistemaTurno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        SistemaTurno sistemaTurno = new SistemaTurno();
        boolean continuar = true;
        while (continuar) {
            System.out.println(" MENU MANEJO DE TURNO ");
            System.out.println("1. Registrar");
            System.out.println("2. Atender");
            System.out.println("3. Cancelar");
            System.out.println("4. Insertar urgente");
            System.out.println("5. Estadísticas");
            System.out.println("6. Mostrar");
            System.out.println("0. Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el ID: ");
                    int id = sc.nextInt();
                    System.out.println("Tipo (P/G) : ");
                    char tipo = sc.next().toUpperCase().charAt(0);
                    System.out.println("Tiempo : ");
                    int tiempo = sc.nextInt();
                    if (sistemaTurno.registrarTurno(id,tipo,tiempo))
                        System.out.println("Registrado correctamente");
                    else
                        System.out.println("Registrado incorrecto");
                    break;
                case 2:
                    if (sistemaTurno.atender()) {
                        System.out.println("Turno atendido");
                    }else
                        System.out.println("No se encuentra");
                    break;
                case 3:
                    System.out.println("Ingresa el ID a cancelar: ");
                    int idCancelar = sc.nextInt();
                    if (sistemaTurno.cancelar(idCancelar))
                        System.out.println("Cancelado correctamente");
                    else
                        System.out.println("No encontrado");
                    break;

                case 4:
                    System.out.println("Posicion: ");
                    int posicion = sc.nextInt();
                    System.out.println("ID: ");
                    int id2 = sc.nextInt();
                    System.out.println("Tipo: ");
                    char tipo2 = sc.next().toUpperCase().charAt(0);
                    System.out.println("Tiempo: ");
                    int tiempo2 = sc.nextInt();
                    if (sistemaTurno.insertarUrgente(posicion,id2,tipo2,tiempo2)) {
                        System.out.println("Registrado correctamente");
                    }
                    else
                        System.out.println("Registrado incorrecto");
                    break;
                case 5:
                    sistemaTurno.estadisticas();
                    break;
                case 6:
                    sistemaTurno.mostrar();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    continuar = false;
                    break;

                    default:
                        System.out.println("Opcion  no valida");

                }
            }
        }

    }
