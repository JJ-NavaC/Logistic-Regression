public class LogisticRegression1 {
    // Private Variables
    private double beta_0 = 0;
    private double beta_1 = 0;
    private double beta_2 = 0;
    private double sigmoid = 0;
    private double[] setX1;
    private double[] setX2;
    private double[] setY;
    private double sumX1;
    private double sumX2;
    private double sumY;
    private double n;
    private double partialDerivateB0;
    private double partialDerivateB1;
    private double partialDerivateB2;
    private double learningRate = 0.003;
    private double error;
    private int iterations;

    // Constructor
    LogisticRegression1(double[] _setX1, double[] _setX2, double[] _setY, int _iterations, double _learningRate) {
        this.setX1 = _setX1;
        this.setX2 = _setX2;
        this.setY = _setY;
        this.iterations = _iterations;
        this.learningRate = _learningRate;
        setSumX1(_setX1);
        setSumX2(_setX2);
        setSumY(_setY);
        setN(_setY.length);
        setPartialDerivateB0();
        setPartialDerivateB1();
        setPartialDerivateB2();
    }

    // Getters
    public double getBeta_0() {
        return this.beta_0;
    }

    public double getBeta_1() {
        return this.beta_1;
    }

    public double getBeta_2() {
        return this.beta_1;
    }

    public double[] getSetX1() {
        return this.setX1;
    }

    public double[] getSetX2() {
        return this.setX1;
    }

    public double[] getSetY() {
        return this.setY;
    }

    public double getSumX1() {
        return this.sumX1;
    }

    public double getSumX2() {
        return this.sumX2;
    }

    public double getSumY() {
        return this.sumY;
    }

    public double getN() {
        return this.n;
    }

    public double getPartialDerivateB0() {
        return this.partialDerivateB0;
    }

    public double getPartialDerivateB1() {
        return this.partialDerivateB1;
    }

    public double getPartialDerivateB2() {
        return this.partialDerivateB2;
    }

    public double getLearningRate() {
        return this.learningRate;
    }

    public double getError() {
        return this.error;
    }

    public double getIterations() {
        return this.iterations;
    }

    // Setters
    public void setSumX1(double[] _sumX1) {
        double aux = 0;
        for (int i = 0; i < _sumX1.length; i++) {
            aux = aux + _sumX1[i];
        }
        this.sumX1 = aux;
    }

    public void setSumX2(double[] _sumX2) {
        double aux = 0;
        for (int i = 0; i < _sumX2.length; i++) {
            aux = aux + _sumX2[i];
        }
        this.sumX2 = aux;
    }

    public void setSumY(double[] _sumY) {
        double aux = 0;
        for (int i = 0; i < _sumY.length; i++) {
            aux = aux + _sumY[i];
        }
        this.sumY = aux;
    }

    public void setN(int _n) {
        this.n = _n;
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

    public void setPartialDerivateB0() {
        double aux = 0;
        aux = (double) ((-2) / getN())
                * (getSumY() - (getBeta_0() + (getBeta_1() * getSumX1()) + (getBeta_2() * getSumX2())));
        this.partialDerivateB0 = (double) aux;
    }

    public void setPartialDerivateB1() {
        double aux = 0;
        aux = (double) (((-2 / getN()) * (getSumX1()))
                * (getSumY() - (getBeta_0() + (getBeta_1() * getSumX1()) + (getBeta_2() * getSumX2()))));
        this.partialDerivateB1 = (double) aux;
    }

    public void setPartialDerivateB2() {
        double aux = 0;
        aux = (double) (((-2 / getN()) * (getSumX2()))
                * (getSumY() - (getBeta_0() + (getBeta_1() * getSumX1()) + (getBeta_2() * getSumX2()))));
        this.partialDerivateB2 = (double) aux;
    }

    public void calculateError() {
        double aux = (double) (1 / getN())
                * Math.pow((getSumY() - (getBeta_0() + (getBeta_1() * getSumX1()) + (getBeta_2() * getSumX2()))), 2);
        setError(aux);
    }

    // Main process
    public void process() {
        calculateError();
        for (int i = 0; i < getIterations(); i++) {
            System.out.println("Lap " + (i+1));            
            setBeta_0(getBeta_0() - getLearningRate() * getPartialDerivateB0());
            setBeta_1(getBeta_1() - getLearningRate() * getPartialDerivateB1());
            setBeta_2(getBeta_2() - getLearningRate() * getPartialDerivateB2());
            setPartialDerivateB0();
            setPartialDerivateB1();
            setPartialDerivateB2();
            System.out.println("w0: " + getBeta_0());
            System.out.println("w1: " + getBeta_1());
            System.out.println("w2: " + getBeta_2());
        }
    }

    void sigmoid(double nX1, double nX2) {
        sigmoid = (1) / (1 + Math.pow(Math.E, -(getBeta_0() + ((getBeta_1()) * (nX1)) + ((getBeta_2()) * (nX2)))));
        System.out.println("Sigmoid: " + sigmoid);
    }
}
