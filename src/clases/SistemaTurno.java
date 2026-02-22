package clases;

public class SistemaTurno {
    private int [] ids;
    private char []tipos;
    private int [] tiempos ;
    private  int n ;

    public SistemaTurno() {
        ids = new int [50];
        tipos = new char[50];
        tiempos = new int [50];
        n = 0;
    }
    public boolean registrarTurno(int id, char tipo, int tiempo) {
        if (n == 50) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (ids[i] == id) {
                return false;
            }

        }
        if (tipo != 'P' && tipo !='G'){
            return false;
        }
        if (tiempo < 1 || tiempo > 60) {
            return false;
        }
        ids[n] = id;
        tipos[n] = tipo;
        tiempos[n] = tiempo;
        n++;
        return true;
    }
    public boolean atender() {
        if (n == 0) {
            return false;
        }
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (tipos[i] == 'P') {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
        pos = 0;
        }
        for (int i = pos; i < n -1; i++) {
            ids[i] = ids[i+1];
            tipos[i] = tipos[i+1];
            tiempos[i] = tiempos[i+1];
        }
        n--;
        return true;
    }
    public boolean cancelar( int id) {
       int pos = -1;
       for (int i = 0; i < n; i++) {
           if (ids[i] == id) {
               pos = i;
               break;
           }
       }
       if (pos == -1) {
           return false;
       }
       for (int i = pos; i < n -1; i++) {
           ids[i] = ids[i+1];
           tipos[i] = tipos[i+1];
           tiempos[i] = tiempos[i+1];
       }
       n--;
       return true;
    }
    public boolean insertarUrgente(int k, int id, char tipo, int tiempo) {
        if (n == 50) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (ids[i] == id) {
                return false;
            }
        }
        for (int i = n; i > k ; i--) {
            ids[i] = ids[i-1];
            tipos[i] = tipos[i-1];
            tiempos[i] = tiempos[i-1];
        }
        ids[k] = id;
        tipos[k] = tipo;
        tiempos[k] = tiempo;
        n++;
        return true;
    }
    public void estadisticas (){
        if (n == 0) {
            System.out.println("No hay turnos");
            return;
        }
        int suma = 0;
        int contP = 0;
        int contG = 0;
        int maxTiempo = tiempos[0];
        int idMax = ids[0];
        char tipoMax = tipos[0];
        int multiplo5 = 0 ;
        for (int i = 1; i < n; i++) {
            suma += tiempos[i];
            if (tipos[i] == 'P')
                contP++;
            if (tipos[i] == 'G')
                contG++;
            if (tiempos[i] > maxTiempo) {
                maxTiempo = tiempos[i];
                idMax = ids[i];
                tipoMax = tipos[i];
            }
            if (tiempos[i] % 5 == 0) {
                multiplo5++;

            }

        }
        double promedio = suma * 1.0 / n;
        double porcentajeP = contP * 100.0 / n;
        double porcentajeG = contG * 100.0 / n;

        System.out.println("Promedio: " + promedio);
        System.out.println(" Porcentaje tipo P: " + porcentajeP);
        System.out.println("Porcentaje tipo G: " + porcentajeG);
        System.out.println("Mayor tiempo ID: " + idMax + " Tipo: " + tipoMax);
        System.out.println("Múltiplos de 5: " + multiplo5);
    }
    public void mostrar(){
        if (n == 0) {
            System.out.println("No hay turnos");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Pos " + i +
                    "  ID: " + ids[i] +
                    "  Tipo: " + tipos[i] +
                    "  Tiempo: " + tiempos[i]);
        }
    }

}
