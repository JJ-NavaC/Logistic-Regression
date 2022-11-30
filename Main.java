public class Main {
    /* static double[][] x = {{ 1, 1, 1 },{ 1, 4, 2 },{ 1, 2, 4 }}; */
    static double[] x1 = { 1, 4, 2 };
    static double[] x2 = { 1, 2, 4 };
    static double[] y = { 0, 1, 1 };
    static double learningRate = 0.01;
    static int iterations = 100;

    static double px1 = 3.5;
    static double px2 = 4;

    public static void main(String[] args) {
        /*
         * LogisticRegression logisticRegression = new LogisticRegression(x, y,
         * learningRate, iterations);
         * logisticRegression.firstlap();
         * logisticRegression.gradient();
         * logisticRegression.sigmoid(px1, px2);
         */
        
        //
        LogisticRegression1 logisticRegression1 = new LogisticRegression1(x1, x2, y, 100, learningRate);
        logisticRegression1.process();
        System.out.println("\nFinal Values : \nw0: " + logisticRegression1.getBeta_0() + "\nw1: "
                + logisticRegression1.getBeta_1() + "\nw2: " + logisticRegression1.getBeta_2() +
                "\n\nBy a Learning Rate of " + logisticRegression1.getLearningRate() +
                " after " + logisticRegression1.getIterations() + " iterations");
        logisticRegression1.sigmoid(px1, px2);
    }
}
