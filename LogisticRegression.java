public class LogisticRegression {
    // ? Private Variables
    int[][] matrix;
    int[] y;
    double learningRate;
    int iterations;
    double w0 = 0.0;
    double w1 = 0.0;
    double w2 = 0.0;
    double sigmoid;

    // ? Constructor
    LogisticRegression(int[] _x1, int[] _x2, int[] _x3, int[] _y, double _learningRate, int _iterations, double _nX1, double _nX2) {
        int[][] aux = { { 1, _x1[0], _x1[1] }, { 1, _x2[0], _x2[1] }, { 1, _x3[0], _x3[1] } };
        this.y = _y;
        this.learningRate = _learningRate;
        this.iterations = _iterations;
        this.matrix = new int[this.y.length][this.y.length];
        this.matrix = aux;
        printMatrix();
        firstlap();
        printW();
        gradient();
        printW();
        sigmoid(_nX1, _nX2);
    }

    // ? Methods

    void printMatrix() {
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    void printW() {
        System.out.println("w0: " + w0);
        System.out.println("w1: " + w1);
        System.out.println("w2: " + w2);
    }

    void firstlap() {
        double aux = 0;
        aux = (((y[0] - (0.5)) * (matrix[0][0])) + ((y[1] - (0.5)) * (matrix[0][1]))
                + ((y[2] - (0.5)) * (matrix[0][2])));
        w0 = w0 - (learningRate * aux);

        aux = (((y[0] - (0.5)) * (matrix[1][0])) + ((y[1] - (0.5)) * (matrix[1][1]))
                + ((y[2] - (0.5)) * (matrix[1][2])));
        w1 = w1 - (learningRate * aux);

        aux = (((y[0] - (0.5)) * (matrix[2][0])) + ((y[1] - (0.5)) * (matrix[2][1]))
                + ((y[2] - (0.5)) * (matrix[2][2])));
        w2 = w2 - (learningRate * aux);
    }

    void gradient() {
        for (int i = 0; i < iterations; i++) {
            double aux = 0;
            aux = (((y[0] - (0.5)) * (matrix[0][0])) + ((y[1] - (0.5)) * (matrix[0][1]))
                    + ((y[2] - (0.5)) * (matrix[0][2])));
            w0 = w0 - (learningRate * aux);
            // System.out.println(w0);
            aux = (((y[0] - (0.5)) * (matrix[1][0])) + ((y[1] - (0.5)) * (matrix[1][1]))
                    + ((y[2] - (0.5)) * (matrix[1][2])));
            w1 = w1 - (learningRate * aux);
            // System.out.println(w1);
            aux = (((y[0] - (0.5)) * (matrix[2][0])) + ((y[1] - (0.5)) * (matrix[2][1]))
                    + ((y[2] - (0.5)) * (matrix[2][2])));
            w2 = w2 - (learningRate * aux);
            // System.out.println(w2);
        }
    }

    void sigmoid(double nX1, double nX2){
        sigmoid = (1)/(1+Math.pow(Math.E,-(w0+(w1)*(nX1)+(w2)*(nX2))));
        System.out.println("Sigmoid: " + sigmoid);
    }

}