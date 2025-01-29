
public class Perceptron {
    private float[] weights;
    private float learningRate = 0.2f;

    public Perceptron(int connection) {
        weights = new float[connection];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = (float) Math.random() * 2 - 1;
        }
    }

    public int activate(float[] inputs) {
        float sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return sum - learningRate >= 0 ? 1 : 0;
    }

    public String toString() {
        return "Perceptron{ weights=" + java.util.Arrays.toString(weights) + "}";
    }

    private float alpha = 0.1f;
    public void train(float[][] data, float[] expected, int epochs) {
        for (int i = 0; i < epochs; i++) {
            for (int j = 0; j < data.length; j++) {
                float[] inputs = data[j];
                int target = (int) expected[j];
                int result = activate(inputs);
                int error = target - result;
                for (int k = 0; k < weights.length; k++) {
                    weights[k] += error * inputs[k] * learningRate;
                }
            }
        }
    }
}