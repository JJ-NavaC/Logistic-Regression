public class LogisticRegression {
    private double[][] x;
    private double[] y;
    private double[] w;
    private double w0 = 0;
    private double w1 = 0;
    private double w2 = 0;
    private int n;
    private double learningRate;
    private int iterations;
    private double sigmoid;
    private double sumx1;
    private double sumx2;
    private double sumy;

    LogisticRegression(double[][] _x, double[] _y, double _learningRate, int _iterations) {
        this.x = _x;
        this.y = _y;
        this.n = _y.length;
        w = new double[n];
        this.learningRate = _learningRate;
        this.iterations = _iterations;
        setSumx1();
        setSumx2();
        setSumy();
    }

    public void setSumx1() {
        double aux = 0;
        for (int i = 0; i < n; i++) {
            aux = aux + x[1][i];
        }
        System.out.println(aux);
        sumx1 = aux;
    }

    public void setSumx2() {
        double aux = 0;
        for (int i = 0; i < n; i++) {
            aux = aux + x[2][i];
        }
        System.out.println(aux);
        sumx1 = aux;
    }

    public void setSumy() {
        double aux = 0;
        for (int i = 0; i < n; i++) {
            aux = aux + y[i];
        }
        System.out.println(aux);
        sumy = aux;
    }

    public double getSumx1() {
        return sumx1;
    }

    public double getSumx2() {
        return sumx2;
    }

    public double getSumy() {
        return sumy;
    }

    void firstlap() {
        for (int i = 0; i < n; i++) {
            w[i] = w[i]
                    - learningRate * ((y[0] - 0.5) * (x[i][0]) + (y[1] - 0.5) * (x[i][1]) + (y[2] - 0.5) * (x[i][2]));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(w[i]);
        }
        w0 = w[0];
        w1 = w[1];
        w2 = w[2];
    }

    void gradient() {
        System.out.println(w0);
        System.out.println(w1);
        System.out.println(w2);
        for (int i = 0; i < 10; i++) {
            System.out.println("Lap: " + (i + 1));
            w0 = w0 - (learningRate * (getSumy() - (w0 + (w1 * getSumx1()) + (w2 * getSumx2()))));
            w1 = w1
                    - (learningRate * (-2 / n) * (getSumx1())
                            * (getSumy() - (w0 + (w1 * getSumx1()) + (w2 * getSumx2()))));
            w2 = w2
                    - (learningRate * (-2 / n) * (getSumx2())
                            * (getSumy() - (w0 + (w1 * getSumx1()) + (w2 * getSumx2()))));
            System.out.println(w0);
            System.out.println(w1);
            System.out.println(w2);
        }
    }

    void sigmoid(double nX1, double nX2) {
        sigmoid = (1) / (1 + Math.pow(Math.E, -(w[0] + (w[1]) * (nX1) + (w[2]) * (nX2))));
        System.out.println("Sigmoid: " + sigmoid);
    }

}
