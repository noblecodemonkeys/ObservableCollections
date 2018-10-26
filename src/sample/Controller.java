package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    @FXML
    TextField tfText;

    private Thread dateThread;
    private DateFormat df = new SimpleDateFormat("hh:mm:ss");

    boolean isRunning = true;
    private final StringProperty twoWayInput = new SimpleStringProperty("");

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        tfText.textProperty().bindBidirectional(twoWayInputProperty());

        dateThread = new Thread(this::handleThread);
        dateThread.start();

    }

    private void handleThread()
    {
        while (isRunning)
        {
            String dateStr = ("current time: " + df.format(new Date()));

            Platform.runLater(() -> {
                setTwoWayInput(dateStr);
            });


            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException iex)
            {

            }
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event)
    {


        if (isRunning)
        {
            isRunning = false;
        }
        else
        {
            isRunning = true;

            dateThread = new Thread(this::handleThread);
            dateThread.setName("running date time");
            dateThread.start();
        }


    }


    public void Dispose()
    {
     isRunning = false;

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

}
