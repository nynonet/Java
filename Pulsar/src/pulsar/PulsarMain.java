/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andeson
 */
public class PulsarMain extends Application {
    
    String teste;
    
    @Override
    public void start(Stage primaryStage) {
        Image image = new Image( getClass().getResourceAsStream("/img.gif") );
        
        ImageView imageView = new ImageView(image);
        
        Text texto = new Text("72");
        texto.setFont(new Font(90));
        
//        imageView.setPreserveRatio(true) ;  
        StackPane root = new StackPane();
        root.getChildren().add( imageView );
        root.getChildren().add( texto );
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Coranção Batendo...");
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
