package atelier1.launcher;


import atelier1.controller.Mediator;
import atelier1.controller.localController.Controller;
import atelier1.gui.GuiConfig;
import atelier1.gui.View;
import atelier1.model.BoardGame;
import atelier1.model.Coord;
import atelier1.model.Model;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LauncherAtelier1 extends Application {

	private BoardGame<Coord> model;
	private EventHandler<MouseEvent> controller;
	private View view;
	
	public static void main (String[] args) {

		LauncherAtelier1.launch();
	}

	@Override
	public void init () throws Exception {
		super.init();
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Objet qui g�re les aspects m�tier du jeu de dame :
		///////////////////////////////////////////////////////////////////////////////////////
		
		this.model = new Model();

		
		///////////////////////////////////////////////////////////////////////////////////////
		// Objet qui contr�le les actions de la vue et les transmet au model
		// il renvoie les r�ponses du model � la vue
		///////////////////////////////////////////////////////////////////////////////////////
		
		this.controller = new Controller();
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Fen�tre dans laquelle se dessine le damier est �cout�e par controller
		///////////////////////////////////////////////////////////////////////////////////////
				
		this.view = new View(controller);
		
		// Controller doit pouvoir invoquer les m�thodes du model
		// il enverra ensuite des instructions � view qui relaiera � son objet Board
		// En mode Client/Server 
		// Les actions devront �tre propag�es sur les vues de chaque client et non pas seulement 
		// sur celle qui a initi� l'action 
		 ((Mediator) controller).setView(view);
		 ((Mediator) controller).setModel(model);
	}


	@Override
	public void start (Stage primaryStage) {

		primaryStage.setScene(new Scene(this.view, GuiConfig.HEIGHT, GuiConfig.HEIGHT));
		primaryStage.setTitle("Jeu de dames - Version Atelier 1");
		primaryStage.show();
	
	}

	
}

