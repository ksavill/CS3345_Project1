/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.event.ActionListener;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kev
 */
public class Project1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //initialize the GridPane and the horizontal and veritcal gap components
        GridPane menuGrid = new GridPane();
        menuGrid.setHgap(10);
        menuGrid.setVgap(12);
        
        //create the RadioButton group for algorithm type to run
        ToggleGroup algorithmSelection = new ToggleGroup();
        //Insertion sort radio button
        RadioButton rb1 = new RadioButton("Insertion Sort");
        rb1.setToggleGroup(algorithmSelection);
        rb1.setSelected(true);      
        //Selection sort radio  button
        RadioButton rb2 = new RadioButton("Selection Sort");
        rb2.setToggleGroup(algorithmSelection);        
        //Quick sort radio button
        RadioButton rb3 = new RadioButton("Quick Sort");
        rb3.setToggleGroup(algorithmSelection);      
        //Merge sort radio button
        RadioButton rb4 = new RadioButton("Merge Sort");
        rb4.setToggleGroup(algorithmSelection);      
        //Heap sort radio button
        RadioButton rb5 = new RadioButton("Heap Sort");
        rb5.setToggleGroup(algorithmSelection);       
        //Radix sort radio button
        RadioButton rb6 = new RadioButton("Radix Sort");
        rb6.setToggleGroup(algorithmSelection);
        
        //create the RadioButton group for array generation type
        ToggleGroup createArrayType = new ToggleGroup();
        //InOrder list type
        RadioButton rb1_1 = new RadioButton("InOrder");
        rb1_1.setToggleGroup(createArrayType);
        rb1_1.setSelected(true);
        //ReverseOrder list type
        RadioButton rb2_1 = new RadioButton("ReverseOrder");
        rb2_1.setToggleGroup(createArrayType);        
        //AlmostOrder list type
        RadioButton rb3_1 = new RadioButton("AlmostOrder");
        rb3_1.setToggleGroup(createArrayType);       
        //Random list type
        RadioButton rb4_1 = new RadioButton("Random");
        rb4_1.setToggleGroup(createArrayType);
        
        
        
        Label listSizeLabel = new Label("List Size: ");
        TextField listSize = new TextField();
        // set the default value of the input textfield
        listSize.setText("50000");
        Label startLabel = new Label("Start List Creation and Test: ");
        Label selectAlgorithmLabel = new Label("Select Algorithm");
        Label selectArrayType = new Label("List Properties");
        Label blankSpace = new Label("            ");
        Button startList = new Button("Start");
//        startList.setStyle("-fx-font-size: 12pt;");

        //elements for displaying reuslts
        Label experimentalResultsLabel = new Label("Experiemental Results");
        Label resultsN = new Label("N: ");
        Label resultsDataType = new Label("DataType: ");
        Label resultsSort = new Label("Sort: ");
        Label resultsComparisons = new Label("Comparisons: ");
        Label resultsMovements = new Label("Movements: ");
        Label resultsTotalTime = new Label("Total time (ms): ");
        
        // The textfields are being set to read only, hence the <variable>.setEditable(false);
        TextField resultsNText = new TextField();
        resultsNText.setEditable(false);
        TextField resultsDataTypeText = new TextField();
        resultsDataTypeText.setEditable(false);
        TextField resultsSortText = new TextField();
        resultsSortText.setEditable(false);
        TextField resultsComparisonsText = new TextField();
        resultsComparisonsText.setEditable(false);
        TextField resultsMovementsText = new TextField();
        resultsMovementsText.setEditable(false);
        TextField resultsTotalTimeText = new TextField();
        resultsTotalTimeText.setEditable(false);
        
        //create Vertical box for algorithm selection radio buttons
        VBox radioButtons1 = new VBox();
        radioButtons1.getChildren().addAll(rb1,rb2,rb3,rb4,rb5,rb6);
        
        //create vertical box for array list properties radio buttons
        VBox radioButtons2 = new VBox();
        radioButtons2.getChildren().addAll(rb1_1,rb2_1,rb3_1,rb4_1);
        
        

        
        
        
        
        
        //(x,y) for grid arrangement. Can use this to arrange the radio buttons and other elements
        menuGrid.add(selectAlgorithmLabel,0,0);
        menuGrid.add(radioButtons1,0,1);
        menuGrid.add(blankSpace,1,0);
        menuGrid.add(selectArrayType,2,0);
        menuGrid.add(radioButtons2,2,1);
        menuGrid.add(listSizeLabel,0,2);
        menuGrid.add(listSize,1,2);
        
        //start gui items
        menuGrid.add(startLabel,0,4);
        menuGrid.add(startList,1,4);
        //experiement results
        menuGrid.add(experimentalResultsLabel,1,5);
        menuGrid.add(resultsN,1,6);
        menuGrid.add(resultsNText,2,6);
        menuGrid.add(resultsDataType,1,7);
        menuGrid.add(resultsDataTypeText,2,7);
        menuGrid.add(resultsSort,1,8);
        menuGrid.add(resultsSortText,2,8);
        menuGrid.add(resultsComparisons,1,9);
        menuGrid.add(resultsComparisonsText,2,9);
        menuGrid.add(resultsMovements,1,10);
        menuGrid.add(resultsMovementsText,2,10);
        menuGrid.add(resultsTotalTime,1,11);
        menuGrid.add(resultsTotalTimeText,2,11);
        
        Scene scene = new Scene(menuGrid, 700, 850);
        
        primaryStage.setTitle("Project 1 - Kevin Savill");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        startList.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // initialize variables
                String sizeInput;
                String arrayType;
                String algorithmType;
                int sizeInt;
                // results array that displays the algorithm results to gui
                String[] resultsArray;
                sizeInput = listSize.getText();
                arrayType = createArrayType.getSelectedToggle().toString();
                algorithmType = algorithmSelection.getSelectedToggle().toString();
                System.out.println("Variables initialized and declared, calling beginProcess function");
                //call the starting function
                sizeInt = beginProcess(sizeInput);
                
                // validation of sizeInt variable. If value of variable is not properly validated, end operation.
                if (sizeInt == -1 || sizeInt < 1) {
                    System.out.println("Invalid List Size Input");
                    return;
                }
                // call resultsArray function that determines the array type to generate and what algorithm to run for sorting
                // returns the statistics of the sort and then displays into the gui with the setText actions below this method call.
                resultsArray = runSorting(sizeInt, arrayType, algorithmType);
                
                // display the results in the GUI
                resultsNText.setText(resultsArray[0]);
                resultsDataTypeText.setText(resultsArray[1]);
                resultsSortText.setText(resultsArray[2]);
                resultsComparisonsText.setText(resultsArray[3]);
                resultsMovementsText.setText(resultsArray[4]);
                resultsTotalTimeText.setText(resultsArray[5]);
                
                // also output the results to console
                System.out.println("\nExperiement Results");
                System.out.println("Input Size: " + resultsArray[0]);
                System.out.println("Data Type: " + resultsArray[1]);
                System.out.println("Sort: " + resultsArray[2]);
                System.out.println("Comparisons: " + resultsArray[3]);
                System.out.println("Movements: " + resultsArray[4]);
                System.out.println("Total Time (ms): " + resultsArray[5]);
                
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    static int beginProcess(String sizeInput) {
        // initialize and declare variables from input textfields and radio buttons
        int sizeInt;
        

        //try catch logic for converting the textfield into an integer value. If error, output to console.
        try {
            sizeInt = Integer.parseInt(sizeInput);
            return sizeInt;
        } catch(NumberFormatException e) {
            System.out.println("Failed to convert array size string input to integer. Returning.");
            return -1;
        }
    }
    String[] runSorting(int sizeInt, String arrayType, String algorithmType) {
        // initialize array that will be used for sorting algorithms
        int[] testingArray;
        String[] resultsArray = new String[6];
        int[] sortingStatistics = null;
        // get arrayType input then call the correct array creation function.
        // if else statements for calling array creation function
        resultsArray[0] = String.valueOf(sizeInt);
        if (arrayType.contains("InOrder")) {
            System.out.println("Array type to call is Inorder");
            resultsArray[1] = "InOrder";
            testingArray = createInOrder(sizeInt);
        } else if (arrayType.contains("ReverseOrder")) {
            System.out.println("Array type to call is ReverseOrder");
            resultsArray[1] = "ReverseOrder";
            testingArray = createReverseOrder(sizeInt);
        } else if (arrayType.contains("AlmostOrder")) {
            System.out.println("Array type to call is AlmostOrder");
            resultsArray[1] = "AlmostOrder";
            testingArray = createAlmostOrder(sizeInt);
        } else {
            System.out.println("Array type to call is Random");
            resultsArray[1] = "Random";
            testingArray = createRandom(sizeInt);
        }
        System.out.println("Returned Array size: " + testingArray.length);
        // get algorithm type and pass the newly created array to the correct algorithm to sort
        // I will use Systam.nanoTime() before running the sorting method and then again once the results are returned and get the difference to have my running time.
        long startTime;
        long endTime;
        long runningTime;
        if (algorithmType.contains("Insertion Sort")) {
            System.out.println("Algorithm to run is Insertion Sort");
            resultsArray[2] = "Insertion Sort";
            startTime = System.nanoTime(); // start timer
            InsertionSort isort = new InsertionSort();
            isort.insertionSort(testingArray);
            endTime = System.nanoTime(); // end timer
            runningTime = (endTime - startTime) / 1000000;
            // get the comparison and movement counters
            resultsArray[3] = String.valueOf(isort.comparisons());
            resultsArray[4] = String.valueOf(isort.movements());
        } else if (algorithmType.contains("Selection Sort")) {
            System.out.println("Algorithm to run is Selection Sort");
            resultsArray[2] = "Selection Sort";
            startTime = System.nanoTime(); // start timer
            SelectionSort ssort = new SelectionSort();
            ssort.selectionSort(testingArray);
            endTime = System.nanoTime(); // end timer
            runningTime = (endTime - startTime) / 1000000;
            // get the comparison and movement counters
            resultsArray[3] = String.valueOf(ssort.comparisons());
            resultsArray[4] = String.valueOf(ssort.movements());
        } else if (algorithmType.contains("Quick Sort")) {
            System.out.println("Algorithm to run is Quick Sort");
            resultsArray[2] = "Quick Sort";
            startTime = System.nanoTime(); // start timer
            QuickSort qsort = new QuickSort();
            qsort.quickSort(testingArray);
            endTime = System.nanoTime(); // end timer
            runningTime = (endTime - startTime) / 1000000;
            // get the comparison and movement counters
            resultsArray[3] = String.valueOf(qsort.comparisons());
            resultsArray[4] = String.valueOf(qsort.movements());
        } else if (algorithmType.contains("Merge Sort")) {
            System.out.println("Algorithm to run is Merge Sort");
            resultsArray[2] = "Merge Sort";
            startTime = System.nanoTime(); // start timer
            MergeSort msort = new MergeSort();
            msort.resetCounters();
            msort.mergeSort(testingArray);
            endTime = System.nanoTime(); // end timer
            runningTime = (endTime - startTime) / 1000000;
            // get the comparison and movement counters
            resultsArray[3] = String.valueOf(msort.comparisons());
            resultsArray[4] = String.valueOf(msort.movements());
        } else if (algorithmType.contains("Heap Sort")) {
            System.out.println("Algorithm to run is Heap Sort");
            resultsArray[2] = "Heap Sort";
            // since the heapSort function requires E[], I can simply convert my int[] to an Integer[]
            // going to call Integer[] as heapArray
            Integer[] heapArray = new Integer[testingArray.length];
            int i=0;
            for (int value : testingArray) {
                heapArray[i++] = Integer.valueOf(value);
            }
            HeapSort hsort = new HeapSort();
            startTime = System.nanoTime(); // start timer
            hsort.heapSort(heapArray);
            endTime = System.nanoTime(); // end timer
            // get the comparison and movement counters
            resultsArray[3] = String.valueOf(hsort.comparisons());
            resultsArray[4] = String.valueOf(hsort.movements());
            runningTime = (endTime - startTime) / 1000000;
        } else {
            System.out.println("Algorithm to run is Radix Sort");
            resultsArray[2] = "Radix Sort";
            RadixSort rsort = new RadixSort();
            startTime = System.nanoTime(); // start timer
            rsort.radixsort(testingArray, sizeInt);
            endTime = System.nanoTime(); // end timer
            // get the comparison and movement counters
            resultsArray[3] = String.valueOf(rsort.comparisons());
            resultsArray[4] = String.valueOf(rsort.movements());
            runningTime = (endTime - startTime) / 1000000;
        } 
        
        // calculate the running time
        
        
        resultsArray[5] = String.valueOf(runningTime);
        return resultsArray;
        
    }
    
    // functions for creating array types
    //InOrder function
    static int[] createInOrder(int sizeInt) {
        int[] createdArray = new int[sizeInt];
        int i;
        for (i=0;i<sizeInt;i++) {
            createdArray[i] = i;
//            System.out.println(createdArray[i]);
        }
        System.out.println("created array length: " + createdArray.length);
        return createdArray;
    }
    //ReverseOrder function
    static int[] createReverseOrder(int sizeInt) {
        int[] createdArray = new int[sizeInt];
        int i;
        for (i=0;i<sizeInt;i++) {
            createdArray[i] = sizeInt-i;
//            System.out.println(createdArray[i]);
        }
        System.out.println("created array length: " + createdArray.length);
        return createdArray;
    }
    //AlmostOrder function
    static int[] createAlmostOrder(int sizeInt) {
        int[] createdArray = new int[sizeInt];
        int i;
        Random rand = new Random();
        for (i=0;i<sizeInt;i++) {
            // in this loop, I'm going to have if i%3 == 0, then insert a dirty value (random value ranging from 0 to sizeInt value-1
            if (i%3 == 0) {
                createdArray[i] = rand.nextInt(sizeInt);
            } else {
                createdArray[i] = i;
            }
//            System.out.println(createdArray[i]);
            
        }
        System.out.println("created array length: " + createdArray.length);
        return createdArray;
    }
    //RandomOrder function
    static int[] createRandom(int sizeInt) {
        int[] createdArray = new int[sizeInt];
        int i;
        Random rand = new Random();
        for (i=0;i<sizeInt;i++) {
            createdArray[i] = rand.nextInt(sizeInt);
//            System.out.println(createdArray[i]);
        }
        System.out.println("created array length: " + createdArray.length);
        return createdArray;
    }
}
    



// note: should add option to generate a new array each time the start button is pressed or just used the existing generated array.
// I could have an array made on program start by default to have size of [0] so that if an array is not made, the function won't hard crash.

