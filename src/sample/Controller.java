package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    @FXML
    TextField tfText;

    @FXML
    ComboBox cbNames;
    //uncomment to reference the collection created in the FXML
//    @FXML
//    ObservableList newItems;

    //the observable list
    ObservableList<String> names = FXCollections.observableArrayList("Mary", "Bob", "sam");

    private final StringProperty twoWayInput = new SimpleStringProperty("");


    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        String temp = tfText.getText();
        //do a quick sanity check before adding the text to the list
        if (temp.equals("") || names.contains(temp))
        {
            return;
        }

        names.add(temp);
        //Uncomment to bind to the collection defined in the FXML file
        //  newItems.add(temp);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        tfText.textProperty().bindBidirectional(twoWayInputProperty());
        //this links the collection to the combobox
         cbNames.setItems(names);
    }

    public String getTwoWayInput()
    {
        return twoWayInput.get();
    }

    public StringProperty twoWayInputProperty()
    {
        return twoWayInput;
    }

    public void setTwoWayInput(String twoWayInput)
    {
        this.twoWayInput.set(twoWayInput);
    }

    public ObservableList<String> getNames()
    {
        return names;
    }

    public void setNames(ObservableList<String> names)
    {
        this.names = names;
    }
}
