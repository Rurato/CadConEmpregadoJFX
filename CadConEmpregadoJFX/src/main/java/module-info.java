module com.mycompany.cadconempregadojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires org.postgresql.jdbc;
    requires java.sql;
    opens com.mycompany.cadconempregadojfx to javafx.fxml;
    exports com.mycompany.cadconempregadojfx;
    requires json.simple;
    //requires jaxp.api;
}
