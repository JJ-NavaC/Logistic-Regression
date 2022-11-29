public class Main {
    static int[] x1 = { 1, 1 };
    static int[] x2 = { 4, 2 };
    static int[] x3 = { 2, 4 };
    static int[] y = { 0, 1, 1 };

    public static void main(String[] args) {
        LogisticRegression logisticRegression = new LogisticRegression(x1, x2, x3, y, 0.1, 100, 3.5, 4);
    }

    /*
     * static double[] x1 = { 1, 1, 1 };
     * static double[] x2 = { 1, 4, 2 };
     * static double[] x3 = { 1, 2, 4 };
     * 
     * static double[] yi = { 0, 1, 1 };
     * 
     * static double learningRate = 0.1;
     * static double iterations = 1;
     * 
     * static double[] wj = { 0, 0, 0 };
     * 
     * public static void main(String[] args) {
     * while(iterations > 0){
     * iterations--;
     * 
     * for (int i = 0; i < wj.length; i++) {
     * wj[i] = wj[i] - learningRate * ((yi[0] - .5)*(x3[0]) + (yi[1] - .5)*(x3[1]) +
     * (yi[2] - .5)*(x3[2]));
     * }
     * 
     * }
     * 
     * System.out.println(wj[2]);
     * }
     */

}
