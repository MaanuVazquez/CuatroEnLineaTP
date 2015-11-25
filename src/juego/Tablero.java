package juego;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
//import javafx.scene.text.Font;
//import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Representación gráfica del Tablero del Juego Cuatro en Línea.
 * 
 */
public class Tablero {

	private static final int ALTO_FILA = 80;
	private static final int ANCHO_COLUMNA = 80;
	private static final int ALTURA_BOTON = 20;
	private static final double RADIO = Math.min(ALTO_FILA - 1, ANCHO_COLUMNA - 1) / 2;
	public final Image ICONO = new Image(getClass().getResourceAsStream("icon.png"));

	private HBox turno;
	private HBox botones;
	private BorderPane borde;
	private CuatroEnLinea juego;
	private GridPane grilla;
	private Stage escenario;
	private Label labelturnoDeJugador;
	private Label turnoDeJugador;
	private Button botonLimpiar;
	private boolean debugMode;
	private Circle[][] casilleros;

	/**
	 * post: asocia el Tablero a 'nuevoJuego' y lo inicializa a partir de su
	 * estado.
	 * 
	 * @param nuevoJuego
	 */
	public Tablero(CuatroEnLinea nuevoJuego, boolean debugMode) {

		juego = nuevoJuego;
		escenario = new Stage();
		escenario.getIcons().add(ICONO);

		borde = new BorderPane();
		grilla = new GridPane();

		this.debugMode = debugMode;

		botones = new HBox();
		turno = new HBox();
		turnoDeJugador = new Label();
		labelturnoDeJugador = new Label();
		turno.setAlignment(Pos.BOTTOM_LEFT);
		turno.setPadding(new Insets(0, 0, 10, 10));
		turno.setSpacing(5);
		turno.getChildren().add(labelturnoDeJugador);
		turno.getChildren().add(turnoDeJugador);
		borde.setLeft(grilla);
		borde.setRight(botones);
		borde.setBottom(turno);

	}

	/**
	 * post: muestra el Tablero en pantalla.
	 */
	public void mostrar() {

		dibujarBotones();

		int excedente = 150;

		double ancho = juego.contarColumnas() * ANCHO_COLUMNA + excedente;
		double alto = (juego.contarFilas() * ALTO_FILA) + ALTURA_BOTON + 50;

		Scene escena = new Scene(borde, ancho, alto);
		grilla.setPadding(new Insets(10, 10, 10, 10));

		escenario.setScene(escena);
		escenario.setResizable(false);
		escenario.setTitle(Aplicacion.TITULO);

		this.casilleros = new Circle[juego.contarFilas()][juego.contarColumnas()];

		dibujarTablero();

		escenario.show();
	}

	/**
	 * post: agrega los botones para soltar una ficha en cada columna del
	 * Tablero.
	 */
	private void dibujarBotones() {

		for (int columna = 0; columna < juego.contarColumnas(); columna++) {

			Button botonSoltarFicha = new Button("Soltar");

			botonSoltarFicha.setMinHeight(ALTURA_BOTON);

			botonSoltarFicha.setOnAction(new SoltarFicha(this, juego, columna));
			botonSoltarFicha.setMinWidth(ANCHO_COLUMNA);
			grilla.add(botonSoltarFicha, columna, 0);

		}

		/* Establecemos la barra horizontal de botones */

		botones.setSpacing(5);
		botones.setAlignment(Pos.BOTTOM_RIGHT);
		botones.setPadding(new Insets(0, 10, 0, 0));

		/* Creamos el botón para limpiar el tablero */
		botonLimpiar = new Button("Reiniciar");
		botonLimpiar.setOnAction(new LimpiarTablero(this, juego));
		botonLimpiar.setAlignment(Pos.BOTTOM_RIGHT);
		botonLimpiar.setDisable(true);

		botones.getChildren().add(botonLimpiar);
		if (this.debugMode) {

			/* Creamos el botón para limpiar el tablero */
			botonLimpiar.setText("Limpiar");
			botonLimpiar.setDisable(false);
		}

		/* Creamos el botón para cerrar el juego */
		Button botonSalir = new Button("Salir");
		botonSalir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent evento) {
				escenario.close();
			}
		});

		botones.getChildren().add(botonSalir);

	}

	/**
	 * post: actualiza el Tablero a partir del estado del juego asociado.
	 */
	public void dibujarTablero() {

		for (int fila = 1; fila <= juego.contarFilas(); fila++) {

			for (int columna = 1; columna <= juego.contarColumnas(); columna++) {

				Casillero casillero = juego.obtenerCasillero(fila, columna);

				Circle dibujoCasillero = dibujarCasillero(casillero);

				this.casilleros[fila - 1][columna - 1] = dibujoCasillero;

				grilla.add(this.casilleros[fila - 1][columna - 1], columna - 1, fila);

				if (debugMode) {

					int columnaDelCirculo = columna - 1;
					int filaDelCirculo = fila - 1;
					Label labelCasillero = new Label(filaDelCirculo + "" + columnaDelCirculo);
					grilla.add(labelCasillero, columna - 1, fila);
					GridPane.setHalignment(labelCasillero, HPos.CENTER);
					labelCasillero.setVisible(false);

					/*
					 * Evento para que al clickear se asigne al casillero
					 * clickeado la ficha del jugador en turno
					 */
					dibujoCasillero.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							juego.soltarFicha(filaDelCirculo, columnaDelCirculo);

							dibujar();

							if (juego.termino()) {

								mostrarResultado();
							}
						}
					});

					/*
					 * Evento para que al poner el mouse sobre un casillero se
					 * muestre su número de casillero
					 */
					dibujoCasillero.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							labelCasillero.setVisible(true);
						}
					});

					/*
					 * Evento para que al retirar el mouse del casillero deje de
					 * mostrar su número
					 */
					dibujoCasillero.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							labelCasillero.setVisible(false);
						}
					});

					labelCasillero.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							labelCasillero.setVisible(true);
						}
					});

					labelCasillero.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							juego.soltarFicha(filaDelCirculo, columnaDelCirculo);

							dibujar();

							if (juego.termino()) {

								mostrarResultado();
							}
						}
					});

					labelCasillero.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							labelCasillero.setVisible(false);
						}
					});

				}

				labelturnoDeJugador.setText("Turno del jugador:");

				if (!juego.termino()) {
					turnoDeJugador.setText(juego.obtenerTurno());
				} else {
					turnoDeJugador.setText("");
					labelturnoDeJugador.setText("");
				}
			}
		}

	}

	public void dibujar() {
		for (int fila = 0; fila < this.casilleros.length; fila++) {

			for (int columna = 0; columna < this.casilleros[fila].length; columna++) {

				this.casilleros[fila][columna].setFill(obtenerPintura(juego.obtenerCasillero(fila + 1, columna + 1)));

			}

			if (!juego.termino()) {
				turnoDeJugador.setText(juego.obtenerTurno());
			} else {
				turnoDeJugador.setText("");
				labelturnoDeJugador.setText("");
			}

		}
	}

	/**
	 * post: dibuja y devuelve el casillero dado.
	 * 
	 * @param casillero
	 * @return representación gráfica del Casillero.
	 */
	private Circle dibujarCasillero(Casillero casillero) {

		Circle dibujoCasillero = new Circle(RADIO, obtenerPintura(casillero));

		dibujoCasillero.setStroke(new Color(0.5, 0.5, 0.5, 1.0));
		dibujoCasillero.setScaleX(0.95);
		dibujoCasillero.setScaleY(0.95);
		return dibujoCasillero;
	}

	/**
	 * post: determina la pintura a utilizar para 'casillero'.
	 * 
	 * @param casillero
	 * @return pintura a utilizar para identificar el Casillero.
	 */
	private Paint obtenerPintura(Casillero casillero) {

		Paint pintura;

		switch (casillero) {

		case AMARILLO:
			pintura = Color.web("ffe600"); // Amarillo
			break;

		case AZUL:
			pintura = Color.web("0076ff"); // Azul
			break;

		default:
			pintura = Color.WHITE;
		}

		return pintura;
	}

	/*
	 * Post: deshabilita el botonLimpiar
	 */

	public void botonLimpiarDeshabilitar(boolean deshabilitado) {
		this.botonLimpiar.setDisable(deshabilitado);
	}

	/*
	 * Post: Devuelve si el modo debug está habilitado.
	 */

	public boolean debugModeHabilitado() {
		return this.debugMode;
	}

	/**
	 * pre : el juego asociado termina. post: muestra un mensaje indicando el
	 * resultado del juego.
	 */
	public void mostrarResultado() {
		if (!debugMode) {

			botonLimpiarDeshabilitar(false);
		}

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(Aplicacion.TITULO);

		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(ICONO);

		if (juego.hayGanador()) {
			alert.setHeaderText("FINAL DEL JUEGO");
			alert.setContentText(("El ganador es: " + juego.obtenerGanador()).toUpperCase());

		} else {
			alert.setHeaderText("FINAL DEL JUEGO");
			alert.setContentText("Hubo Empate".toUpperCase());
		}

		alert.showAndWait();

		// FORMA VIEJA
		//
		// Stage dialogo = new Stage();
		// dialogo.setTitle(Aplicacion.TITULO);
		// BorderPane panelGanador = new BorderPane();
		// panelGanador.setPadding(new Insets(10.0));
		// Label textoResultado;
		// Font fuente = new Font(40.0);
		// Button botonSalir = new Button("OK");
		// if (juego.hayGanador()) {
		//
		// textoResultado = new Label("Gana el jugador "
		// + juego.obtenerGanador());
		//
		// } else {
		//
		// textoResultado = new Label("Empataron");
		// }
		// textoResultado.setFont(fuente);
		// textoResultado.setTextFill(Color.RED);
		// panelGanador.setCenter(textoResultado);
		// panelGanador.setRight(botonSalir);
		// BorderPane.setAlignment(botonSalir, Pos.BOTTOM_RIGHT);
		//
		// botonSalir.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent event) {
		// dialogo.close();
		// }
		// });
		//
		// Scene escenaGanador = new Scene(panelGanador);
		//
		// dialogo.setScene(escenaGanador);
		// dialogo.initOwner(escenario);
		// dialogo.initModality(Modality.WINDOW_MODAL);
		// dialogo.setResizable(false);
		//
		// dialogo.showAndWait();
	}
}
