package zza06_javafx;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button solve;
    @FXML
    private Button clean;
    @FXML
    private Button exit;
    @FXML
    private TextField textInputA;
    @FXML
    private TextField textInputB;
    @FXML
    private TextField textInputX;
    @FXML
    private Label textResult;

    @FXML
    private void solve(ActionEvent event) {
        double a, b, x, y;
        try {
            a = Double.parseDouble(textInputA.getText());
            b = Double.parseDouble(textInputB.getText());
            x = Double.parseDouble(textInputX.getText());
            textInputA.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
            textInputB.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
            textInputX.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
        } catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введеных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textInputA.requestFocus();
            textResult.setText("В введённых значениях допущены ошибки");
            textInputA.setText("");
            textInputB.setText("");
            textInputX.setText("");
            textInputA.setStyle("-fx-background-color: red;" + "-fx-border-color: black;");
            textInputB.setStyle("-fx-background-color: red;" + "-fx-border-color: black;");
            textInputX.setStyle("-fx-background-color: red;" + "-fx-border-color: black;");

            return;
        }

        if (x >= 4) {
            y = (x + 4 * a) / (b * a * a * b);
        } else {
            y = (x * x * x - a * b);
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            textResult.setText("Ответ: " + String.format(":%.2f", y));
        } else {
            textResult.setText("Нет ответа");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void clean(ActionEvent event) {
        textResult.setText("Ответ: ");
        textInputA.setText("");
        textInputB.setText("");
        textInputX.setText("");
        textInputA.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
        textInputB.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
        textInputX.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
