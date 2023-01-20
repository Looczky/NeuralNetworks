import java.util.List;

public class NeuralNetwork {
    Matrix weightsInputHidden;
    Matrix weightsHiddenOutput;
    Matrix biasHidden;
    Matrix biasOutput;

    float learningRate = 0.02f;

    public NeuralNetwork(int input, int hidden, int output) {
        weightsInputHidden = new Matrix(hidden, input);
        weightsHiddenOutput = new Matrix(output, hidden);
        biasHidden = new Matrix(hidden, 1);
        biasOutput = new Matrix(output, 1);
    }

    private void train(double[] inputs, double[] targets) {
        Matrix inputLayer = Matrix.fromArray(inputs);
        Matrix hiddenLayer = calculateHiddenLayer(inputLayer);
        Matrix outputLayer = calculateOutputLayer(hiddenLayer);
        updateWeightsAndBiases(outputLayer, targets, hiddenLayer, inputLayer);
    }

    public void trainOnRandomData(double[][] inputs, double[][] targets, int trainAmount) {
        for (int i = 0; i < trainAmount; i++) {
            int rand = (int)(Math.random() * inputs.length);
            this.train(inputs[rand], targets[rand]);
        }
    }

    public List<Double> predict(double[] inputs) {
        Matrix inputLayer = Matrix.fromArray(inputs);
        Matrix hiddenLayer = calculateHiddenLayer(inputLayer);
        Matrix outputLayer = calculateOutputLayer(hiddenLayer);
        return outputLayer.toArray();
    }

    private Matrix calculateHiddenLayer(Matrix inputLayer) {
        Matrix hiddenLayer = Matrix.multiply(weightsInputHidden, inputLayer);
        hiddenLayer.add(biasHidden);
        hiddenLayer.softplus();
        return hiddenLayer;
    }

    private Matrix calculateOutputLayer(Matrix hiddenLayer) {
        Matrix outputLayer = Matrix.multiply(weightsHiddenOutput, hiddenLayer);
        outputLayer.add(biasOutput);
        outputLayer.softplus();
        return outputLayer;
    }

    private void updateWeightsAndBiases(Matrix outputLayer, double[] targets, Matrix hiddenLayer, Matrix inputLayer){
        Matrix targetLayer = Matrix.fromArray(targets);
        Matrix error = Matrix.subtract(targetLayer, outputLayer);
        Matrix gradient = outputLayer.dsoftplus();
        gradient.multiply(error);
        gradient.multiply(learningRate);

        Matrix weightDeltaHiddenOutput = Matrix.multiply(gradient, Matrix.transpose(hiddenLayer));
        weightsHiddenOutput.add(weightDeltaHiddenOutput);
        biasOutput.add(gradient);

        Matrix hiddenLayerErrors = Matrix.multiply(Matrix.transpose(weightDeltaHiddenOutput), error);
        Matrix hiddenGradient = hiddenLayer.dsoftplus();
        hiddenGradient.multiply(hiddenLayerErrors);
        hiddenGradient.multiply(learningRate);

        Matrix weightDeltaInputHidden = Matrix.multiply(hiddenGradient, Matrix.transpose(inputLayer));
        weightsInputHidden.add(weightDeltaInputHidden);
        biasHidden.add(hiddenGradient);
    }

}
