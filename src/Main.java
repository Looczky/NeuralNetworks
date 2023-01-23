import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        double[][] inputs = {{0,0,0},{0,0,1},{0,1,0},{0,1,1},
                             {1,0,0},{1,0,1}};                      // Training set - Binary numbers
        double[][] targets = {{1},{0},{1},{0},
                              {1},{0}};                             // Training set's targets - parity of input numbers
        double[][] test = {{1,1,1},{1,1,0}};                        // Test set


        NeuralNetwork neuralNetwork = new NeuralNetwork(3,100,1);
        neuralNetwork.trainOnRandomData(inputs,targets,50000);

        List<Double> prediction;
        System.out.println("Test set values:");
        for(double d[]:test)
        {
            prediction = neuralNetwork.predict(d);
            System.out.println(prediction.toString());
        }
    }
}