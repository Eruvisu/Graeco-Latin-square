
public class Main {

    /**
     * @param args the command line arguments
     */
    private static int n;

    public static void main(String[] args) {
        String[] Latin = new String[]{"A", "B", "C"};
        String[] Graeco = new String[]{"\u03B1", "\u03B3", "\u03B2"};
        n = 3;
        String[][] square = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = Latin[j];
                square[i][j] = square[i][j] + Graeco[j];
            }
            permutareL(Latin);
            permutareG(Graeco);
        }
        if (verificare(square)) {
            System.out.println("solutia este corecta");

            printare(square);
        }
    }

    public static void permutareL(String[] a) {
        String aux = a[0];
        for (int i = 0; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        a[n - 1] = aux;

    }

    public static void permutareG(String[] a) {
        String aux = a[n - 1];
        for (int i = n - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = aux;
    }

    public static boolean verificare(String[][] matrix) {
        for (int ind = 0; ind < n; ind++) {
            for (int ind2 = 0; ind2 < n; ind2++) {

                char ch0 = matrix[ind][ind2].charAt(0);
                char ch1 = matrix[ind][ind2].charAt(1);
                String a = matrix[ind][ind2];
                for (int i = 0; i < n; i++) {
                    if (i != ind && i != ind2) {
                        if (matrix[ind][i].charAt(0) == ch0 || matrix[i][ind2].charAt(0) == ch0) {
                            return false;
                        } else if (matrix[ind][i].charAt(1) == ch1 || matrix[i][ind2].charAt(1) == ch1) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (i != ind) {
                        for (int j = 0; j < n; j++) {
                            if (j != ind2) {
                                if (matrix[i][j] == a) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void printare(String[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}
