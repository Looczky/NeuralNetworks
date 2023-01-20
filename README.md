# NeuralNetworks v1.0
To create a neural network we need to set input and target values.
For example:
```
double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
double[][] targets = {{0},{1},{1},{0}};
```
Now we can create a neural Network for example with:
- 2 input layers
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
to certain values:
```
List<Double> prediction;
for(double d[]:inputs)
{
    prediction = neuralNetwork.predict(d);
    System.out.println(prediction.toString());
}
```
