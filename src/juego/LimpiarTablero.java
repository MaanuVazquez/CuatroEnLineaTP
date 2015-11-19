package juego;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * Acci�n ejecutada al presionar un bot�n para limpiar el tablero del juego
 * actual.
 * 
 */
public class LimpiarTablero implements EventHandler<ActionEvent> {

	private Tablero tablero;
	private CuatroEnLinea juego;

	/**
	 * post: asocia la acci�n de limpiar el tablero en el juego 'cuatroEnLinea'
	 * del tablero 'tableroCuatroEnLinea'.
	 * 
	 * @param tableroCuatroEnLinea
	 * @param cuatroEnLinea
	 */
	public LimpiarTablero(Tablero tableroCuatroEnLinea,
			CuatroEnLinea cuatroEnLinea) {

		tablero = tableroCuatroEnLinea;
		juego = cuatroEnLinea;
	}

	@Override
	public void handle(ActionEvent evento) {

		juego.limpiarTablero();

		tablero.dibujar();

	}
}
