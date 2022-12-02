public class LogisticRegression {
    private double[] x1;
    private double[] x2;
    private double[] y;
    private double w0 = 0;
    private double w1 = 0;
    private double w2 = 0;
    private double n;
    private double learningRate;
    private int iterations;
    private double sigmoid;

    LogisticRegression(double[] _x1, double[] _x2, double[] _y, double _learningRate, int _iterations) {
        this.x1 = _x1;
        this.x2 = _x2;
        this.y = _y;
        this.n = (double) _y.length;
        this.learningRate = _learningRate;
        this.iterations = _iterations;
    }

    void firstlap() {
        double aux0 = 0, aux1 = 0, aux2 = 0;
        for (int i = 0; i < n; i++) {
            aux0 = aux0 + (((1 / (1 + Math.pow(Math.E, -(w0 + (w1 * x1[i]) + (w2 * x2[i]))))) - y[i]));
            aux1 = aux1 + (((1 / (1 + Math.pow(Math.E, -(w0 + (w1 * x1[i]) + (w2 * x2[i]))))) - y[i]) * x1[i]);
            aux2 = aux2 + (((1 / (1 + Math.pow(Math.E, -(w0 + (w1 * x1[i]) + (w2 * x2[i]))))) - y[i]) * x2[i]);
        }
        w0 = w0 - (learningRate * (aux0));
        w1 = w1 - (learningRate * (aux1));
        w2 = w2 - (learningRate * (aux2));
        System.out.println("First Lap");
        System.out.println(w0);
        System.out.println(w1);
        System.out.println(w2);
    }

    void gradient() {
        for (int it = 0; it < iterations; it++) {
            System.out.println("Lap " + (it + 1));
            double aux0 = 0, aux1 = 0, aux2 = 0;
            for (int i = 0; i < n; i++) {
                aux0 = aux0 + (((1 / (1 + Math.pow(Math.E, -(w0 + (w1 * x1[i]) + (w2 * x2[i]))))) - y[i]));
                aux1 = aux1 + (((1 / (1 + Math.pow(Math.E, -(w0 + (w1 * x1[i]) + (w2 * x2[i]))))) - y[i]) * x1[i]);
                aux2 = aux2 + (((1 / (1 + Math.pow(Math.E, -(w0 + (w1 * x1[i]) + (w2 * x2[i]))))) - y[i]) * x2[i]);
            }
            w0 = w0 - (learningRate * (aux0));
            w1 = w1 - (learningRate * (aux1));
            w2 = w2 - (learningRate * (aux2));
            System.out.println(w0);
            System.out.println(w1);
            System.out.println(w2);
        }
    }

    void sigmoid(double nX1, double nX2) {
        sigmoid = ((1) / (1 + Math.pow(Math.E, -(w0 + (w1) * (nX1) + (w2) * (nX2)))));
        System.out.println("Sigmoid: " + sigmoid);
        if(sigmoid > 0.5) {
            System.out.println("YES :)");
        } else {
            System.out.println("NOO :(");
        }
    }

}
