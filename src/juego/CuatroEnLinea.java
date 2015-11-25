package juego;

/**
 * Juego Cuatro en Línea
 * 
 * Reglas:
 * 
 * El objetivo de este juego consiste en colocar cuatro fichas en una fila
 * contínua vertical, horizontal o diagonalmente.
 * 
 * Para colocar fichas en el juego ambos jugadores hacen click sobre en el boton
 * "Soltar" que se encuentra sobre la columna deseada. La regla para colocarlas
 * consiste en que la estas siempre "caen hasta abajo". Es decir una ficha puede
 * ser colocada bien en la parte inferior de una columna o bien sobre otra de
 * alguna otra columna.
 * 
 * La partida termina si una de las siguientes condiciones se cumple:
 * 
 * Uno de los jugadores coloca cuatro o más fichas en una línea contínua
 * vertical, horizontal o diagonalmente. Este jugador gana la partida o si todas
 * las casillas del tablero están ocupadas y ningún jugador cumple la condición
 * anterior para ganar. En este caso la partida finaliza en empate.
 * 
 * Integrantes :
 * 
 * Mayra Aquino
 * 
 * Emmanuel Vazquez
 * 
 * Comisión:
 * 
 * Lunes y Miercoles 18 - 22 hs.
 * 
 * Profesores:
 * 
 * Facundo Rodriguez Arceri
 * 
 * Santiago Risaro
 * 
 * Mariano Tugnarelli
 * 
 * Lucas Ponce de León
 * 
 */

public class CuatroEnLinea {

	private Casillero tablero[][];
	private String jugadorAmarillo;
	private String jugadorAzul;
	private boolean turnoJugadorAmarillo;
	private boolean ganaAmarillo;

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4. post: empieza el
	 * juego entre el jugador que tiene fichas rojas, identificado como
	 * 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 'jugadorAmarillo'. Todo el tablero está vacío.
	 * 
	 * @param filas
	 *            : cantidad de filas que tiene el tablero.
	 * @param columnas
	 *            : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo
	 *            : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo
	 *            : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorAzul, String jugadorAmarillo) {

		/* Validamos que las filas/columnas son mayores o iguales a 4 */
		if (filas < 4 || columnas < 4) {
			throw new Error("Las filas o columnas deben ser mayores o iguales a 4");
		}

		/* Validamos que los nombres ingresados no sean solo espacios */
		if (jugadorAmarillo.trim().isEmpty() || jugadorAzul.trim().isEmpty()) {
			throw new Error("Los nombres de jugadores ingresados son incorrectos");
		}

		/* Llenamos el tablero de casilleros vacios */
		this.tablero = new Casillero[filas][columnas];

		for (int fila = 0; fila < this.tablero.length; fila++) {
			for (int columna = 0; columna < this.tablero[fila].length; columna++) {
				this.tablero[fila][columna] = Casillero.VACIO;
			}
		}

		/* Asignamos los nombres a los respectivos atributos */
		this.jugadorAmarillo = jugadorAmarillo;
		this.jugadorAzul = jugadorAzul;

		/* Hacemos el primer turno aleatorio */
		this.turnoJugadorAmarillo = Math.random() < 0.5;

		this.ganaAmarillo = false;

	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el
	 * tablero.
	 */
	public int contarFilas() {

		return this.tablero.length;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el
	 * tablero.
	 */
	public int contarColumnas() {

		return this.tablero[0].length;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()], columnas está en el
	 * intervalo [1, contarColumnas()].
	 * 
	 * post: indica qué ocupa el casillero indicado por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {

		verificarFila(fila - 1);
		verificarColumna(columna - 1);
		return this.tablero[fila - 1][columna - 1];
	}

	/**
	 * pre : el juego no terminó, columna está en el intervalo [1,
	 * contarColumnas()] y aún queda un Casillero.VACIO en la columna indicada.
	 * 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	public void soltarFicha(int columna) {

		verificarColumna(columna); // ToDo si hay error, cambiar a col-1

		boolean casilleroAsignado = false;

		if (!termino()) {

			for (int fila = contarFilas() - 1; (fila >= 0) && (!casilleroAsignado); fila--) {

				if (this.tablero[fila][columna] == Casillero.VACIO) {

					if (turnoJugadorAmarillo) {

						this.tablero[fila][columna] = Casillero.AMARILLO;
						casilleroAsignado = true;
						turnoJugadorAmarillo = false;

					} else {

						this.tablero[fila][columna] = Casillero.AZUL;
						casilleroAsignado = true;
						turnoJugadorAmarillo = true;
					}
				}
			}
		}

	}

	public void soltarFicha(int fila, int columna) {

		verificarColumna(columna);
		verificarFila(fila);

		if (!termino()) {
			if (this.tablero[fila][columna] == Casillero.VACIO) {
				if (turnoJugadorAmarillo) {
					this.tablero[fila][columna] = Casillero.AMARILLO;
					turnoJugadorAmarillo = false;
				} else {
					this.tablero[fila][columna] = Casillero.AZUL;
					turnoJugadorAmarillo = true;
				}
			}
		}
	}

	/**
	 * post: indica si el juego termina porque uno de los jugadores gana o no
	 * existen casilleros vacios.
	 */
	public boolean termino() {

		int casillerosOcupados = 0;

		for (int fila = 0; fila < contarFilas(); fila++) {

			for (int columna = 0; columna < contarColumnas(); columna++) {

				if (this.tablero[fila][columna] != Casillero.VACIO) {

					casillerosOcupados++;
				}
			}
		}

		return (casillerosOcupados == contarFilas() * contarColumnas()) || hayGanador();
	}

	/**
	 * post: indica si el juego termina y tiene un ganador.
	 */
	public boolean hayGanador() {

		return (chequeoVertical() || chequeoHorizontal() || chequeoDiagonalIzquierda() || chequeoDiagonalDerecha());

	}

	/**
	 * pre : el juego termina
	 * 
	 * post: devuelve el nombre del jugador que gana el juego.
	 */
	public String obtenerGanador() {

		String ganador;

		if (!termino()) {
			throw new Error("El juego todavia no terminó");
		}

		if (!hayGanador()) {
			throw new Error("El juego terminó en empate");
		}

		if (this.ganaAmarillo) {
			ganador = this.jugadorAmarillo;
		} else {
			ganador = this.jugadorAzul;
		}

		return ganador;
	}

	public void limpiarTablero() {
		/* Llenamos el tablero de casilleros vacios */
		this.tablero = new Casillero[contarFilas()][contarColumnas()];

		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[i].length; j++) {
				this.tablero[i][j] = Casillero.VACIO;
			}
		}

		/* Hacemos el primer turno aleatorio */
		this.turnoJugadorAmarillo = Math.random() < 0.5;

		this.ganaAmarillo = false;

	}

	public String obtenerTurno() {
		String nombreDelJugadorAlQueLeToca = "";
		if (this.turnoJugadorAmarillo) {
			nombreDelJugadorAlQueLeToca = this.jugadorAmarillo;
		} else {
			nombreDelJugadorAlQueLeToca = this.jugadorAzul;
		}

		return nombreDelJugadorAlQueLeToca;
	}

	private boolean chequeoVertical() {
		boolean hayGanador = false;

		for (int fila = 0; fila < contarFilas() && !hayGanador; fila++) {

			int casillerosContinuosAzules = 0;
			int casillerosContinuosAmarillos = 0;

			for (int columna = 0; columna < contarColumnas() && !hayGanador; columna++) {
				if (this.tablero[fila][columna] == Casillero.AZUL) {

					casillerosContinuosAzules++;
					casillerosContinuosAmarillos = 0;

				} else if (this.tablero[fila][columna] == Casillero.AMARILLO) {

					casillerosContinuosAmarillos++;
					casillerosContinuosAzules = 0;

				} else {

					casillerosContinuosAmarillos = 0;
					casillerosContinuosAzules = 0;
				}

				hayGanador = (casillerosContinuosAzules == 4) || (casillerosContinuosAmarillos == 4);
				this.ganaAmarillo = (casillerosContinuosAmarillos == 4);
			}
		}
		return hayGanador;
	}

	private boolean chequeoHorizontal() {
		boolean hayGanador = false;

		for (int columna = 0; columna < contarColumnas() && !hayGanador; columna++) {

			int casillerosContinuosAzules = 0;
			int casillerosContinuosAmarillos = 0;
			for (int fila = 0; fila < contarFilas() && !hayGanador; fila++) {

				if (this.tablero[fila][columna] == Casillero.AZUL) {

					casillerosContinuosAzules++;
					casillerosContinuosAmarillos = 0;
				} else if (this.tablero[fila][columna] == Casillero.AMARILLO) {

					casillerosContinuosAmarillos++;
					casillerosContinuosAzules = 0;
				} else {

					casillerosContinuosAmarillos = 0;
					casillerosContinuosAzules = 0;
				}
				hayGanador = (casillerosContinuosAzules == 4) || (casillerosContinuosAmarillos == 4);
				ganaAmarillo = (casillerosContinuosAmarillos == 4);
			}
		}

		return hayGanador;
	}

	private boolean chequeoDiagonalDerecha() {
		boolean hayGanador = false;

		for (int fila = 3; fila < contarFilas() && !hayGanador; fila++) {
			for (int columna = 0; columna < contarColumnas() - 3 && !hayGanador; columna++) {
				hayGanador = ((this.tablero[fila][columna] == Casillero.AMARILLO
						&& this.tablero[fila - 1][columna + 1] == Casillero.AMARILLO
						&& this.tablero[fila - 2][columna + 2] == Casillero.AMARILLO
						&& this.tablero[fila - 3][columna + 3] == Casillero.AMARILLO)
						|| (this.tablero[fila][columna] == Casillero.AZUL
								&& this.tablero[fila - 1][columna + 1] == Casillero.AZUL
								&& this.tablero[fila - 2][columna + 2] == Casillero.AZUL
								&& this.tablero[fila - 3][columna + 3] == Casillero.AZUL));
				ganaAmarillo = (this.tablero[fila][columna] == Casillero.AMARILLO
						&& this.tablero[fila - 1][columna + 1] == Casillero.AMARILLO
						&& this.tablero[fila - 2][columna + 2] == Casillero.AMARILLO
						&& this.tablero[fila - 3][columna + 3] == Casillero.AMARILLO);
			}
		}

		return hayGanador;
	}

	private boolean chequeoDiagonalIzquierda() {
		boolean hayGanador = false;

		for (int fila = 3; fila < contarFilas() && !hayGanador; fila++) {
			for (int columna = 3; columna < contarColumnas() && !hayGanador; columna++) {
				hayGanador = ((this.tablero[fila][columna] == Casillero.AMARILLO
						&& this.tablero[fila - 1][columna - 1] == Casillero.AMARILLO
						&& this.tablero[fila - 2][columna - 2] == Casillero.AMARILLO
						&& this.tablero[fila - 3][columna - 3] == Casillero.AMARILLO)
						|| (this.tablero[fila][columna] == Casillero.AZUL
								&& this.tablero[fila - 1][columna - 1] == Casillero.AZUL
								&& this.tablero[fila - 2][columna - 2] == Casillero.AZUL
								&& this.tablero[fila - 3][columna - 3] == Casillero.AZUL));
				ganaAmarillo = (this.tablero[fila][columna] == Casillero.AMARILLO
						&& this.tablero[fila - 1][columna - 1] == Casillero.AMARILLO
						&& this.tablero[fila - 2][columna - 2] == Casillero.AMARILLO
						&& this.tablero[fila - 3][columna - 3] == Casillero.AMARILLO);
			}
		}
		return hayGanador;
	}

	private void verificarFila(int fila) {
		if (fila < 0 || fila >= contarFilas()) {
			throw new Error("Numero de fila invalido.");
		}
	}

	private void verificarColumna(int columna) {
		if (columna < 0 || columna >= contarColumnas()) {
			throw new Error("Numero de columna invalido.");
		}
	}
}
