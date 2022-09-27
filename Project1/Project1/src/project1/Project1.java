/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        
        //example code (HBox)
        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);
        //example code (labels)
        
        Label listSizeLabel = new Label("List Size:");
        TextField listSize = new TextField();
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
        
        
//        menuGrid.add(lblName, 0, 0);
//        menuGrid.add(tfName, 1, 0);
//        menuGrid.add(lblPwd, 0, 1);
//        menuGrid.add(pfPwd, 1, 1);
//        menuGrid.add(label1,2,0);

        //I hate myself for this.
        menuGrid.add(selectAlgorithmLabel,0,0);
        menuGrid.add(radioButtons1,0,1);
        menuGrid.add(blankSpace,1,0);
        menuGrid.add(selectArrayType,2,0);
        menuGrid.add(radioButtons2,2,1);
        menuGrid.add(listSizeLabel,0,2);
        menuGrid.add(listSize,1,2);
        menuGrid.add(startLabel,0,3);
        menuGrid.add(startList,1,3);
        //experiement results
        // To make this work, I'm not using HBoxes at this time. I would argue that would make the script longer, but cleaner.
        menuGrid.add(experimentalResultsLabel,0,4);
        menuGrid.add(resultsN,0,5);
        menuGrid.add(resultsNText,1,5);
        menuGrid.add(resultsDataType,0,6);
        menuGrid.add(resultsDataTypeText,1,6);
        menuGrid.add(resultsSort,0,7);
        menuGrid.add(resultsSortText,1,7);
        menuGrid.add(resultsComparisons,0,8);
        menuGrid.add(resultsComparisonsText,1,8);
        menuGrid.add(resultsMovements,0,9);
        menuGrid.add(resultsMovementsText,1,9);
        menuGrid.add(resultsTotalTime,0,10);
        menuGrid.add(resultsTotalTimeText,1,10);
        
//        menuGrid.add(hbButtons, 0, 2, 2, 1);
        
        Scene scene = new Scene(menuGrid, 700, 850);
        
        primaryStage.setTitle("Project 1 - Kevin Savill");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


