package pruebas;

import juego.CuatroEnLinea;
import juego.Casillero;

import org.junit.*;

public class pruebaCuatroEnLinea {

	CuatroEnLinea juego;

	@Test
	public void pruebaCuatroEnLineaCorrecto() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Emmanuel Vazquez", "Juan Domingo Per�n");

		/* comprobaci�n */
		Assert.assertNotNull(this.juego);
	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaInorrecto1x1() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(1, 1, "Emmanuel Vazquez", "Carlos Perez");
	}

	@Test
	public void pruebaCuatroEnLineaCorrecto10x10() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(10, 10, "Emmanuel Vazquez", "Mayra Aquino");

		/* comprobaci�n */
		Assert.assertNotNull(this.juego);
	}

	@Test
	public void pruebaCuatroEnLineaCorrecto50x50() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(50, 50, "Emmanuel Vazquez", "Carlos Perez");

		/* comprobaci�n */
		Assert.assertNotNull(this.juego);
	}

	@Test
	public void pruebaCuatroEnLineaCorrecto100x100() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(100, 100, "Emmanuel Vazquez", "Carlos Perez");

		/* comprobaci�n */
		Assert.assertNotNull(this.juego);
	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaFilaIncorrecta() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(1, 6, "Emmanuel Vazquez", "Carlos Perez");

	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaColumnaIncorrecta() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(8, -6, "Emmanuel Vazquez", "Carlos Perez");
	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaFilaYColumnaIncorrecta() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(0, -6, "Emmanuel Vazquez", "Carlos Perez");
	}

	@Test(expected = Error.class)
	public void prueba3Filas() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(3, 4, "Manu", "Carlos");
	}

	@Test(expected = Error.class)
	public void prueba3Columnas() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 3, "Manu", "Carlos");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAzulVacio() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "", "Carlos");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAzulConEspaciosSolamente() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "     ", "Carlos");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAmarilloVacio() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAmarilloConEspaciosSolamente() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "      ");
	}

	@Test
	public void pruebaContarFilas() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(10, 8, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarFilas();

		/* comprobaci�n */
		Assert.assertEquals(10, contarFilas);
	}

	@Test
	public void pruebaContarFilasNumerosAltos() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(100, 200, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarFilas();

		/* comprobaci�n */
		Assert.assertEquals(100, contarFilas);
	}

	@Test(expected = Error.class)
	public void pruebaContarFilasNumeroNegativo() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(-4, 4, "Manu", "Carlos");

	}

	@Test
	public void pruebaContarColumnas() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarColumnas();

		/* comprobaci�n */
		Assert.assertEquals(4, contarFilas);
	}

	@Test(expected = Error.class)
	public void pruebaContarColumnasNumeroNegativo() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, -4, "Manu", "Carlos");

	}

	@Test
	public void pruebaContarColumnasNumerosAltos() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(100, 200, "Manu", "Carlos");

		/* operaciones */
		int contarColumnas = this.juego.contarColumnas();

		/* comprobaci�n */
		Assert.assertEquals(200, contarColumnas);
	}

	@Test
	public void pruebaObtenerCasilleroEn0() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);
		Casillero casilla = this.juego.obtenerCasillero(5, 1);

		/* comprobaci�n */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaObtenerCasilleroen1() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(2);
		Casillero casilla = this.juego.obtenerCasillero(5, 2);

		/* comprobaci�n */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaObtenerCasilleroEn2() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(3);
		Casillero casilla = this.juego.obtenerCasillero(5, 3);

		/* comprobaci�n */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaObtenerCasillero3() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(4);
		Casillero casilla = this.juego.obtenerCasillero(5, 4);

		/* comprobaci�n */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test(expected = Error.class)
	public void pruebaObtenerCasilleroFueraDeRangoMaximo() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(5);

	}

	@Test(expected = Error.class)
	public void pruebaObtenerCasilleroFueraDeRangoMinimo() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(-1);

	}

	@Test
	public void pruebaSoltarFichasJuegoTermino() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos

		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos
		boolean termino = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, termino);
	}

	@Test
	public void pruebaSoltarFichasJuegoNoTermino() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos

		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno

		boolean termino = this.juego.termino();

		/* comprobaci�n */

		Assert.assertEquals(false, termino);
	}

	@Test
	public void pruebaSoltarFichasJugadorSueltaEnLugarYaOcupado() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos

		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos, tiene otra posibilidad para
									// tirar

		boolean termino = this.juego.termino();

		/* comprobaci�n */

		Assert.assertEquals(false, termino);
	}

	@Test(expected = Error.class)
	public void pruebaSoltarFichasNumeroNegativo() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(0);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos

		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(-1);// Jugador uno

	}

	@Test(expected = Error.class)
	public void pruebaSoltarFichasFichaFueraDeRago() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno

	}

	public void pruebaSoltarFichasJugadorTiraCuandoElJuegoTermino() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(0);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos

		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(3);// Jugador uno

	}

	// --------------------------Hay Ganador-------------------------------
	@Test
	public void pruebaHayGanadorHorizontalGanadorJugadorUno() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos

		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos

		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno

		boolean gano = this.juego.hayGanador();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontalGanadorJugadorDos() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos

		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos

		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno

		boolean gano = this.juego.hayGanador();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHorizontalGanadorAlPrincipioJugadorUno() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos

		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno
		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaDiagonalIzquierda() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos

		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos

		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos

		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaDiagonalDerechaGanadorJugadorDos() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos

		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos

		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos

		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorHorizontal4x4() {

		/* condici�n inicial */

		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno

		boolean gano = this.juego.hayGanador();

		/* comprobaci�n */

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontal5x4() {

		/* condici�n inicial */

		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */

		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(4);// Jugador dos
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno

		boolean gano = this.juego.hayGanador();

		/* comprobaci�n */

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontal6x6() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(6, 6, "Manu", "Carlos");
		/* operacion */

		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(5); // Jugador uno
		this.juego.soltarFicha(6); // Jugador dos
		this.juego.soltarFicha(6); // Jugador uno

		boolean gano = this.juego.hayGanador();

		/* comprobacion */

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontal10x8() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(10, 8, "Manu", "Carlos");
		/* operacion */

		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(6); // Jugador dos
		this.juego.soltarFicha(5); // Jugador uno
		this.juego.soltarFicha(7); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos

		boolean gano = this.juego.hayGanador();

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontal12x7() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(12, 7, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);// Jugador uno
		this.juego.soltarFicha(1);// Jugador dos
		this.juego.soltarFicha(2);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(3);// Jugador uno
		this.juego.soltarFicha(3);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno
		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorVertical5x4() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */

		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno

		boolean gano = this.juego.hayGanador();

		/* comprobacion */

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorVertica9x10() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(9, 10, "Manu", "Carlos");

		this.juego.soltarFicha(6); // Jugador uno
		this.juego.soltarFicha(7); // Jugador dos
		this.juego.soltarFicha(8); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(8); // Jugador uno
		this.juego.soltarFicha(7); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(8); // Jugador uno
		this.juego.soltarFicha(8); // Jugador dos
		this.juego.soltarFicha(7); // Jugador uno
		this.juego.soltarFicha(7); // Jugador dos
		this.juego.soltarFicha(8); // Jugador uno
		this.juego.soltarFicha(7); // Jugador dos
		this.juego.soltarFicha(7); // Jugador uno
		this.juego.soltarFicha(6); // Jugador dos
		this.juego.soltarFicha(7); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(7); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(7); // Jugador uno

		boolean gano = this.juego.hayGanador();

		/* comprobacion */

		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorVertica8x5() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(8, 5, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos

		boolean gano = this.juego.hayGanador();

		/* comprobacion */

		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorVertical9x12() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(9, 12, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(5); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(5); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos

		boolean gano = this.juego.hayGanador();

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorDiagonal4x4() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos

		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorDiagonal6x6() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(6, 6, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(5); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno

		boolean gano = this.juego.hayGanador();
		/* comprobacion */

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorDiagonal7x6() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(7, 6, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(3); // Jugador dos
		this.juego.soltarFicha(3); // Jugador uno
		this.juego.soltarFicha(2); // Jugador dos
		this.juego.soltarFicha(2); // Jugador uno
		this.juego.soltarFicha(1); // Jugador dos

		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorDiagonal8x8() {

		/* condici�n inicial */
		this.juego = new CuatroEnLinea(8, 8, "Manu", "Carlos");

		/* operacion */

		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(7); // Jugador dos
		this.juego.soltarFicha(6); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(5); // Jugador uno
		this.juego.soltarFicha(6); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(5); // Jugador dos
		this.juego.soltarFicha(4); // Jugador uno
		this.juego.soltarFicha(4); // Jugador dos

		boolean gano = this.juego.hayGanador();

		/* comprobacion */

		Assert.assertEquals(true, gano);

	}

}
