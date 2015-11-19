package juego;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * Acción ejecutada al presionar un botón para limpiar el tablero del juego
 * actual.
 * 
 */
public class LimpiarTablero implements EventHandler<ActionEvent> {

	private Tablero tablero;
	private CuatroEnLinea juego;

	/**
	 * post: asocia la acción de limpiar el tablero en el juego 'cuatroEnLinea'
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
