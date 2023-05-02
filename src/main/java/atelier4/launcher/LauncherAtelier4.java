package atelier4.launcher;


import atelier4.controller.Mediator;
import atelier4.controller.localController.Controller;
import atelier4.gui.GuiConfig;
import atelier4.gui.View;
import atelier4.model.BoardGame;
import atelier4.model.Coord;
import atelier4.model.Model;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LauncherAtelier4 extends Application {

	private BoardGame<Coord> model;
	private EventHandler<MouseEvent> controller;
	private View view;
	
	public static void main (String[] args) {

		LauncherAtelier4.launch();
	}

	@Override
	public void init () throws Exception {
		super.init();
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Objet qui gère les aspects métier du jeu de dame :
		///////////////////////////////////////////////////////////////////////////////////////
		
		this.model = new Model();

		
		///////////////////////////////////////////////////////////////////////////////////////
		// Objet qui contrôle les actions de la vue et les transmet au model
		// il renvoie les réponses du model à  la vue
		///////////////////////////////////////////////////////////////////////////////////////
		
		this.controller = new Controller();
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Fenêtre dans laquelle se dessine le damier est écoutée par controller
		///////////////////////////////////////////////////////////////////////////////////////

		this.view = new View(controller);
		
		// Controller doit pouvoir invoquer les méthodes du model
		// il enverra ensuite des instructions à view qui relaiera à son objet Board
		// En mode Client/Server 
		// Les actions devront être propagées sur les vues de chaque client et non pas seulement 
		// sur celle qui a initié l'action 
		 ((Mediator) controller).setView(view);
		 ((Mediator) controller).setModel(model);
	}


	@Override
	public void start (Stage primaryStage) {

		primaryStage.setScene(new Scene(this.view, GuiConfig.HEIGHT, GuiConfig.HEIGHT));
		primaryStage.setTitle("Jeu de dames - Version Atelier 2");
		primaryStage.show();
	}

	
}

