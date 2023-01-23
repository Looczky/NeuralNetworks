# NeuralNetworks v1.0
To create a neural network we need to set input and target values.
Our inputs are going to be binary numbers and the targets will represent their parity:
```
double[][] inputs = {{0,0,0},{0,0,1},{0,1,0},{0,1,1},
                     {1,0,0},{1,0,1}};
double[][] targets = {{1},{0},{1},{0},
                      {1},{0}};
```
Now we can create a Neural Network with:
- 3 input layers
- 100 hidden layers
- 1 output layer
```
NeuralNetwork neuralNetwork = new NeuralNetwork(2,100,1);
```
Train it properly with our inputs and targets for example 50000 times:
```
neuralNetwork.trainOnRandomData(inputs,targets,50000);
```
Now let's test the neural network by showing its predictions
for some inputs not included in our training set:
```
double[][] test = {{1,1,1},{1,1,0}}; 

List<Double> prediction;
for(double d[]:test)
{
    prediction = neuralNetwork.predict(d);
    System.out.println(prediction.toString());
}
```
