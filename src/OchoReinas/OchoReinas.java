package OchoReinas;

/**
 *
 * @author Sebas Carlosama
 */
public class OchoReinas {

    private int cantidad;

    private String[] arreglo_soluciones;
    private String[][] matriz_soluciones;

    public OchoReinas() {
        this.cantidad = 0;
        arreglo_soluciones = new String[92];
        matriz_soluciones = new String[92][8];
        for (int i = 0; i < arreglo_soluciones.length; i++) {
            arreglo_soluciones[i] = "";
        }
    }

    public String[][] getMatriz_soluciones() {
        return matriz_soluciones;
    }

    public String[] getArreglo_soluciones() {
        return arreglo_soluciones;
    }

    public void SolucionesReinas(int[] solucion, int n_reinas, int fila) {

        if (n_reinas == fila) {

            for (int i = 0; i < n_reinas; i++) {
                arreglo_soluciones[cantidad] += ((char) (65 + i)) + "" + (solucion[i] + 1) + "  ";
                this.matriz_soluciones[cantidad][i] = ((char) (65 + i)) + "" + (solucion[i] + 1);
            }
            this.cantidad++;
        } else {
            for (solucion[fila] = 0; solucion[fila] < n_reinas; solucion[fila]++) {
                if (comprobar(solucion, fila)) {
                    SolucionesReinas(solucion, n_reinas, fila + 1);
                }
            }
        }
    }

    public static Boolean comprobar(int[] solucion, int fila) {
        for (int i = 0; i < fila; i++) {
            if (solucion[i] == solucion[fila] || Math.abs(fila - i) == Math.abs(solucion[fila] - solucion[i])) {
                return false;
            }
        }
        return true;
    }
}
