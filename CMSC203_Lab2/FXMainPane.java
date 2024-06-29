import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

    //student Task #2:
    //  declare five buttons, a label, and a textfield
    //  declare two HBoxes
    
    // Declare the buttons
    private Button helloButton;
    private Button howdyButton;
    private Button chineseButton;
    private Button clearButton;
    private Button exitButton;
    
    // Declare the label
    private Label feedbackLabel;

    // Declare the textfield
    private TextField feedbackTextField;

    // Declare the HBoxes
    private HBox buttonHBox;
    private HBox feedbackHBox;
    
    //student Task #4:
    //  declare an instance of DataManager
    private DataManager dataManager;

    /**
     * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
     * wait to add a component to its containing component until the container has
     * been created.  This is the only constraint on the order in which the following 
     * statements appear.
     */
    FXMainPane() {
        //student Task #2:
        //  instantiate the buttons, label, and textfield
        helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");

        // Instantiate the label
        feedbackLabel = new Label("Feedback:");

        // Instantiate the textfield
        feedbackTextField = new TextField();

        //  instantiate the HBoxes
        buttonHBox = new HBox();
        feedbackHBox = new HBox();
        
        //student Task #4:
        //  instantiate the DataManager instance
        dataManager = new DataManager();
        
        //  set margins and set alignment of the components
        HBox.setMargin(helloButton, new Insets(10));
        HBox.setMargin(howdyButton, new Insets(10));
        HBox.setMargin(chineseButton, new Insets(10));
        HBox.setMargin(clearButton, new Insets(10));
        HBox.setMargin(exitButton, new Insets(10));
        
        buttonHBox.setAlignment(Pos.CENTER);
        feedbackHBox.setAlignment(Pos.CENTER);
        
        //student Task #3:
        //  add the label and textfield to one of the HBoxes
        feedbackHBox.getChildren().addAll(feedbackLabel, feedbackTextField);
        
        //  add the buttons to the other HBox
        buttonHBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);

        //  add the HBoxes to this FXMainPanel (a VBox)
        this.getChildren().addAll(feedbackHBox, buttonHBox);
        
        // Set button actions
        helloButton.setOnAction(new ButtonHandler());
        howdyButton.setOnAction(new ButtonHandler());
        chineseButton.setOnAction(new ButtonHandler());
        clearButton.setOnAction(new ButtonHandler());
        exitButton.setOnAction(new ButtonHandler());
    }

    //Task #4:
    //  create a private inner class to handle the button clicks
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == helloButton) {
                feedbackTextField.setText(dataManager.getHello());
            } else if (event.getSource() == howdyButton) {
                feedbackTextField.setText(dataManager.getHowdy());
            } else if (event.getSource() == chineseButton) {
                feedbackTextField.setText(dataManager.getChinese());
            } else if (event.getSource() == clearButton) {
                feedbackTextField.setText("");
            } else if (event.getSource() == exitButton) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}
