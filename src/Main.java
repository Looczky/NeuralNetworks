import java.util.List;

public class Main {
    public static void main(String[] args) {
        double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
        double[][] targets = {{0},{1},{1},{0}};

        NeuralNetwork neuralNetwork = new NeuralNetwork(2,100,1);
        neuralNetwork.trainOnRandomData(inputs,targets,50000);

        List<Double> prediction;
        for(double d[]:inputs)
        {
            prediction = neuralNetwork.predict(d);
            System.out.println(prediction.toString());
        }
    }
}