
public class Runner {

    public static void main(String[] args) {
        float[][] data = {
            {0.00f, 0.00f},
            {1.00f, 0.00f},
            {0.00f, 1.00f},
            {1.00f, 1.00f}
        };

        float[] expected = {0.00f, 0.00f, 0.00f, 1.00f};

        Perceptron p = new Perceptron(2);
        p.train(data, expected, 10000);

        for (int i = 0; i < data.length; i++) {
            int result = p.activate(data[i]);
            System.out.println("Result: " + i + ": " + result);	
        }
    }
}
