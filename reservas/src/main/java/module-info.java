module co.edu.uniquindio.poo.java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    exports co.edu.uniquindio.poo;
    opens co.edu.uniquindio.poo to javafx.fxml;
    opens co.edu.uniquindio.poo.model to javafx.base;
    exports co.edu.uniquindio.poo.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.viewController to javafx.fxml;
}
