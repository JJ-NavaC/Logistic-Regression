public class LogisticRegression1 {
    // Private Variables
    private double beta_0 = 0;
    private double beta_1 = 0;
    private double beta_2 = 0;
    private double[] setX1;
    private double[] setX2;
    private double[] setY;
    private double n;
    /*
     * private double partialDerivateB0;
     * private double partialDerivateB1;
     * private double partialDerivateB2;
     */
    private double learningRate;
    private double iterations;
    private double sigmoid;

    private double error;
    private double errorTolerance;

    // Constructor
    LogisticRegression1(double[] _setX1, double[] _setX2, double[] _setY, double _learningRate, int _iterations,
            double _errorTolerance) {
        this.setX1 = _setX1;
        this.setX2 = _setX2;
        this.setY = _setY;
        this.learningRate = _learningRate;
        this.iterations = _iterations;
        this.errorTolerance = _errorTolerance;
        setN(_setY.length);
        /*
         * setPartialDerivateB0();
         * setPartialDerivateB1();
         * setPartialDerivateB2();
         */
    }

    // Getters
    public double getBeta_0() {
        return this.beta_0;
    }

    public double getBeta_1() {
        return this.beta_1;
    }

    public double getBeta_2() {
        return this.beta_2;
    }

    public double[] getSetX1() {
        return this.setX1;
    }

    public double[] getSetX2() {
        return this.setX2;
    }

    public double[] getSetY() {
        return this.setY;
    }

    public double getN() {
        return this.n;
    }

    /*
     * public double getPartialDerivateB0() {
     * return this.partialDerivateB0;
     * }
     * 
     * public double getPartialDerivateB1() {
     * return this.partialDerivateB1;
     * }
     * 
     * public double getPartialDerivateB2() {
     * return this.partialDerivateB1;
     * }
     */

    public double getLearningRate() {
        return this.learningRate;
    }

    public double getError() {
        return this.error;
    }

    public double getErrorTorelance() {
        return this.errorTolerance;
    }

    // Setters
    public void setN(int _n) {
        this.n = (double) _n;
    }

    public void setBeta_0(double beta_0) {
        this.beta_0 = beta_0;
    }

    public void setBeta_1(double beta_1) {
        this.beta_1 = beta_1;
    }

    public void setBeta_2(double beta_2) {
        this.beta_2 = beta_2;
    }

    public void setError(double error) {
        this.error = error;
    }

    /*
     * public void setPartialDerivateB0() {
     * double aux = 0;
     * double aux1 = 0;
     * for (int i = 0; i < getN(); i++) {
     * // aux = aux + (setY[i] - (getBeta_0() + (getBeta_1() * setX1[i]) +
     * (getBeta_2()
     * // * setX2[i])));
     * aux = aux + (getBeta_0() + (getBeta_1() * setX1[i]) + (getBeta_2() *
     * setX2[i]) - setY[i]);
     * }
     * // aux1 = (-2 / getN()) * aux;
     * aux1 = (1 / getN()) * aux;
     * partialDerivateB0 = aux1;
     * }
     * 
     * public void setPartialDerivateB1() {
     * double aux = 0;
     * double aux1 = 0;
     * for (int i = 0; i < getN(); i++) {
     * // aux = aux + ((setX1[i]) * (setY[i] - (getBeta_0() + (getBeta_1() *
     * setX1[i])
     * // + (getBeta_2() * setX2[i]))));
     * aux = aux + ((getBeta_0() + (getBeta_1() * setX1[i]) + (getBeta_2() *
     * setX2[i]) - setY[i]) * (setX1[i]));
     * }
     * // aux1 = (-2 / getN()) * aux;
     * aux1 = (1 / getN()) * aux;
     * partialDerivateB1 = aux1;
     * }
     * 
     * public void setPartialDerivateB2() {
     * double aux = 0;
     * double aux1 = 0;
     * for (int i = 0; i < getN(); i++) {
     * // aux = aux + ((setX2[i]) * (setY[i] - (getBeta_0() + (getBeta_1() *
     * setX1[i])
     * // + (getBeta_2() * setX2[i]))));
     * aux = aux + ((getBeta_0() + (getBeta_1() * setX1[i]) + (getBeta_2() *
     * setX2[i]) - setY[i]) * (setX2[i]));
     * }
     * // aux1 = (-2 / getN()) * aux;
     * aux1 = (1 / getN()) * aux;
     * partialDerivateB2 = aux1;
     * }
     */

    public void calculateError() {
        double aux = 0;
        double aux1 = 0;
        for (int i = 0; i < getN(); i++) {
            aux = aux + ((setY[i] - (getBeta_0() + (getBeta_1() * setX1[i]) + (getBeta_2() * setX2[i]))));
        }
        aux1 = (1 / getN()) * (Math.pow(aux, 2));
        setError(aux1);
    }

    void firstlap() {
        double aux0 = 0, aux1 = 0, aux2 = 0;
        for (int i = 0; i < n; i++) {
            aux0 = aux0 + (beta_0 + (beta_1 * setX1[i]) + (beta_2 * setX2[i]) - setY[i]);
            aux1 = aux1 + ((beta_0 + (beta_1 * setX1[i]) + (beta_2 * setX2[i]) - setY[i]) * (setX1[i]));
            aux2 = aux2 + ((beta_0 + (beta_1 * setX1[i]) + (beta_2 * setX2[i]) - setY[i]) * (setX2[i]));
        }
        setBeta_0(beta_0 - (learningRate * ((1 / n) * (aux0))));
        setBeta_1(beta_1 - (learningRate * ((1 / n) * (aux1))));
        setBeta_2(beta_2 - (learningRate * ((1 / n) * (aux2))));    }

    // Main process
    public void process() {
        int c = 0;
        calculateError();
        while ((getError() > getErrorTorelance())) {
            double aux0 = 0, aux1 = 0, aux2 = 0;
            System.out.println("\tError (Lap " + (c) + "): " + getError());
            System.out.println("Beta 0: " + getBeta_0());
            System.out.println("Beta 1: " + getBeta_1());
            System.out.println("Beta 2: " + getBeta_2());
            for (int i = 0; i < n; i++) {
                aux0 = aux0 + (beta_0 + (beta_1 * setX1[i]) + (beta_2 * setX2[i]) - setY[i]);
                aux1 = aux1 + ((beta_0 + (beta_1 * setX1[i]) + (beta_2 * setX2[i]) - setY[i]) * (setX1[i]));
                aux2 = aux2 + ((beta_0 + (beta_1 * setX1[i]) + (beta_2 * setX2[i]) - setY[i]) * (setX2[i]));
            }
            setBeta_0(beta_0 - (learningRate * ((1 / n) * (aux0))));
            setBeta_1(beta_1 - (learningRate * ((1 / n) * (aux1))));
            setBeta_2(beta_2 - (learningRate * ((1 / n) * (aux2))));
            calculateError();
            c++;
        }
        System.out.println();
    }

    void sigmoid(double nX1, double nX2) {
        sigmoid = ((1) / (1 + Math.pow(Math.E, -(beta_0 + (beta_1) * (nX1) + (beta_2) * (nX2)))));
        System.out.println("Sigmoid: " + sigmoid);
    }
}