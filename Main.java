public class Main {
    static double[] x1 = { 1, 4, 2 };
    static double[] x2 = { 1, 2, 4 };
    static double[] y = { 0, 1, 1 };
    static double learningRate = 0.1; // * Logistic
    static int iterations = 100; // * Logistic

    static double px1 = 3.5;
    static double px2 = 4.0;

    public static void main(String[] args) {
        LogisticRegression logisticRegression = new LogisticRegression(x1, x2, y,
                learningRate, iterations);
        logisticRegression.firstlap();
        logisticRegression.gradient();
        System.out.println();
        logisticRegression.sigmoid(px1, px2);
    }
}
