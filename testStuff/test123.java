package testStuff;

public class test123 {
    public static void main(String[] args) {
        int[] arr = feldSumme(new int[][] { { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3, 3 } }); // 10; 18
        for (int i : arr) {
            System.out.println(i);
        }
        test123 a = new test123();
        a.a();
    }

    public void a() {
        int[] arr = this.feldSumme(new int[][] { { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3, 3 } }); // 10; 18
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] feldSumme(int[][] feld) {
        int[] summierteFelder = new int[feld.length];
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                summierteFelder[i] += feld[i][j];
            }
        }
        return summierteFelder;
    }

}
