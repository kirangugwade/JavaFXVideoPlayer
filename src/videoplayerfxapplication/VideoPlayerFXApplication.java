
package videoplayerfxapplication;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author kiran
 */
public class VideoPlayerFXApplication extends Application {
    
    private double xOffset;
    private double yOffset;
     
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Video Player by Ki");
        
        //Remove default windows frame (minimize,maximize,close) 
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setScene(scene);
        stage.show();
        
        //Double click to fullscreen & versa..
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            Boolean fullscreen=true;
            @Override
            public void handle(MouseEvent DoubleClick) {
                if(DoubleClick.getClickCount() == 2){
                    if(fullscreen){
                        stage.setFullScreen(true);
                        fullscreen = false; 
                    }
                    else{
                        stage.setFullScreen(false);
                        fullscreen = true; 
                    }
                }
            }
        });
        
        
        //Handle windows drag and move app
        scene.setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });
        
      
       
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
