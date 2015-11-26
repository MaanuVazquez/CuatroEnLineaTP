package juego;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Aplicación del juego Cuatro en Línea.
 * 
 * Punto de entrada del programa.
 * 
 */
public class Aplicacion extends Application {

	public static final String TITULO = "Cuatro en Línea";
	public final Image ICONO = new Image(getClass().getResourceAsStream("icon.png"));
	private GridPane grilla;

	private TextField campoNombreJugadorRojo;
	private TextField campoNombreJugadorAmarillo;

	private TextField campoColumnas;
	private TextField campoFilas;

	private Button botonIniciar;

	private CheckBox checkDebug;

	Stage escenarioPrincipal;

	@Override
	public void start(Stage escenarioPrincipal) {

		crearGrilla();

		Scene escena = new Scene(grilla, 400, 300);
		escenarioPrincipal.setScene(escena);
		escenarioPrincipal.setTitle(TITULO);
		escenarioPrincipal.getIcons().add(ICONO);
		escenarioPrincipal.show();
		this.escenarioPrincipal = escenarioPrincipal;
	}

	private void crearGrilla() {

		grilla = new GridPane();
		grilla.setAlignment(Pos.CENTER);
		grilla.setHgap(20);
		grilla.setVgap(20);

		Text textoTitulo = new Text(TITULO);
		textoTitulo.setFont(new Font(16));

		crearControles();

		grilla.add(textoTitulo, 0, 0, 2, 1);
		grilla.add(new Label("Jugador Azul"), 0, 1);
		grilla.add(campoNombreJugadorRojo, 1, 1);
		grilla.add(new Label("Jugador Amarillo"), 0, 2);
		grilla.add(campoNombreJugadorAmarillo, 1, 2);
		grilla.add(new Label("Filas"), 0, 3);
		grilla.add(campoFilas, 1, 3);
		grilla.add(new Label("Columnas"), 0, 4);
		grilla.add(campoColumnas, 1, 4);
		grilla.add(botonIniciar, 0, 5, 2, 1);
		grilla.add(checkDebug, 2, 5, 1, 1);

		GridPane.setHalignment(botonIniciar, HPos.CENTER);
		GridPane.setHalignment(textoTitulo, HPos.CENTER);
	}

	private void crearControles() {

		campoNombreJugadorRojo = new TextField("Player 1");
		campoNombreJugadorAmarillo = new TextField("Player 2");

		campoColumnas = new TextField("4");
		campoFilas = new TextField("4");

		botonIniciar = new Button("Empezar");
		botonIniciar.setOnAction(new IniciarJuego(this));

		checkDebug = new CheckBox("Debug Mode");
	}

	/**
	 * post: crea un juego CuatroEnLinea, lo asocia a una Tablero y comienza su
	 * ejecución.
	 * 
	 */
	public void iniciar() {

		String nombreJugadorAzul = campoNombreJugadorRojo.getText();
		String nombreJugadorAmarillo = campoNombreJugadorAmarillo.getText();

		if (nombreJugadorAzul.trim().isEmpty() || nombreJugadorAmarillo.trim().isEmpty()) {
			dialogoError("El nombre de los jugadores no debe ser vacio");
		} else {
			int filas = Integer.parseInt(campoFilas.getText());
			int columnas = Integer.parseInt(campoColumnas.getText());
			if (filas < 4 || columnas < 4) {
				dialogoError("Las columnas y filas deben ser iguales o mayores a 4");
			} else {
				CuatroEnLinea juego = new CuatroEnLinea(filas, columnas, nombreJugadorAzul, nombreJugadorAmarillo);
				Tablero tablero = new Tablero(juego, checkDebug.isSelected());
				tablero.mostrar();
				this.escenarioPrincipal.close();
			}
		}

	}

	public void dialogoError(String mensaje) {
		Stage dialogo = new Stage();
		dialogo.setTitle(TITULO);
		dialogo.getIcons().add(ICONO);
		BorderPane panelError = new BorderPane();
		panelError.setPadding(new Insets(10.0));
		Label textoError;
		Font fuente = new Font(15.0);
		Button botonSalir = new Button("Aceptar");
		textoError = new Label(mensaje);
		textoError.setFont(fuente);
		textoError.setTextFill(Color.BLACK);
		panelError.setCenter(textoError);
		panelError.setRight(botonSalir);
		BorderPane.setAlignment(botonSalir, Pos.BOTTOM_RIGHT);
		BorderPane.setMargin(botonSalir, new Insets(0, 0, 0, 10));

		botonSalir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialogo.close();
			}
		});

		Scene escenaGanador = new Scene(panelError);

		dialogo.setScene(escenaGanador);
		dialogo.initOwner(escenarioPrincipal);
		dialogo.initModality(Modality.WINDOW_MODAL);
		dialogo.setResizable(false);

		dialogo.showAndWait();
	}

	public static void main(String[] args) {

		launch(args);
	}
}
