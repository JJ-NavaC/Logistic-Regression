public class Main {
    // static double[][] x = {{ 1, 1, 1 },{ 1, 4, 2 },{ 1, 2, 4 }};
    static double[] x1 = { 1, 4, 2 };
    static double[] x2 = { 1, 2, 4 };
    static double[] y = { 0, 1, 1 };
    static double learningRate = 0.1; //* Logistic
    static int iterations = 100; //* Logistic
    
    static double learningRate1 = 0.07; //* Gradient
    static double errorTolerance = 0.00001; //* Gradient

    static double px1 = 3.5;
    static double px2 = 4.0;

    public static void main(String[] args) {

        //! Logistic
        LogisticRegression logisticRegression = new LogisticRegression(x1, x2, y,
                learningRate, iterations);
        System.out.println("Method 1:");
        logisticRegression.firstlap();
        logisticRegression.gradient();
        System.out.println();
        logisticRegression.sigmoid(px1, px2);

        //! Gradient
        LogisticRegression1 logisticRegression1 = new LogisticRegression1(x1, x2, y,
                learningRate1, iterations,
                errorTolerance);
        System.out.println("\n\nMethod 2:");
        logisticRegression1.firstlap();
        logisticRegression1.process();
        System.out.println();
        logisticRegression1.sigmoid(px1, px2);


        //! COMPROBAR
        /* 
        // MULTIPLE LINEAL REGRESSION BY MATRIX --- VECTORIZED //? LISTO
        System.out.println("\nMULTIPLE LINEAL REGRESSION BY MATRIX --- VECTORIZED\n");
        RegressionLinealMultiple1 regressionLinealMultiple1 = new RegressionLinealMultiple1(x1, x2, y);
        System.out.println("Betas Vector: ");
        regressionLinealMultiple1.printVector(regressionLinealMultiple1.getVectorBetas(), 3);
        System.out.println("Formula: " + regressionLinealMultiple1.getFormula());
        System.out.println("Predict for X1: " + px1 + " and X2: " + px2 + " | y = "
                        + regressionLinealMultiple1.predict(px1, px2));

        // MULTIPLE LINEAL REGRESSION BY DETERMINANTS --- CRAMMER //? LISTO
        System.out.println("\nMULTIPLE LINEAL REGRESSION BY DETERMINANTS --- CRAMMER\n");
        RegressionLinealMultiple2 regressionLinealMultiple2 = new RegressionLinealMultiple2(
                        x1,
                        x2, y);
        System.out.println("Beta 0: " + regressionLinealMultiple2.getBeta_0());
        System.out.println("Beta 1: " + regressionLinealMultiple2.getBeta_1());
        System.out.println("Beta 2: " + regressionLinealMultiple2.getBeta_2());
        System.out.println("\nFormula: " + regressionLinealMultiple2.getFormula());
        System.out.println("Predict for X1: " + px1 + " and X2 = " + px2 + " | y = "
                        + regressionLinealMultiple2.predict(px1, px2)); 
                        */

    }
}
