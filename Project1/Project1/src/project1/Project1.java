/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.event.ActionListener;
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
        Label resultsTotalTime = new Label("Total time: ");
        
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
                String sizeInput;
                String arrayType;
                String algorithmType;
                sizeInput = listSize.getText();
                arrayType = createArrayType.getSelectedToggle().toString();
                algorithmType = algorithmSelection.getSelectedToggle().toString();
                System.out.println("Variables initialized and declared, calling beginProcess function");
                //call the starting function
                beginProcess(sizeInput, arrayType, algorithmType);
                
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    static void beginProcess(String sizeInput, String arrayType, String algorithmType) {
        // initialize and declare variables from input textfields and radio buttons
        int sizeInt;
        System.out.println(sizeInput);
        System.out.println(arrayType);
        System.out.println(algorithmType);
        //try catch logic for converting the textfield into an integer value. If error, output to console.
        try {
            sizeInt = Integer.parseInt(sizeInput);
        } catch(NumberFormatException e) {
            System.out.println("Failed to convert array size string input to integer.");
            return;
        }
        // get arrayType input then call the correct array creation function.
        
        
        // get algorithm type and pass the newly created array to the correct algorithm to sort
    }
}
    



// note: should add option to generate a new array each time the start button is pressed or just used the existing generated array.
// I could have an array made on program start by default to have size of [0] so that if an array is not made, the function won't hard crash.

