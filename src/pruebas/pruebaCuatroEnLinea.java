package pruebas;

import juego.CuatroEnLinea;
import juego.Casillero;

import org.junit.*;

public class pruebaCuatroEnLinea {

	CuatroEnLinea juego;

	@Test
	public void pruebaCuatroEnLineaCorrecto() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Emmanuel Vazquez", "Juan Domingo Perón");

		/* comprobación */
		Assert.assertNotNull(this.juego);
	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaInorrecto1x1() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(1, 1, "Emmanuel Vazquez", "Carlos Perez");
	}

	@Test
	public void pruebaCuatroEnLineaCorrecto10x10() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(10, 10, "Emmanuel Vazquez", "Mayra Aquino");

		/* comprobación */
		Assert.assertNotNull(this.juego);
	}

	@Test
	public void pruebaCuatroEnLineaCorrecto50x50() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(50, 50, "Emmanuel Vazquez", "Carlos Perez");

		/* comprobación */
		Assert.assertNotNull(this.juego);
	}

	@Test
	public void pruebaCuatroEnLineaCorrecto100x100() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(100, 100, "Emmanuel Vazquez", "Carlos Perez");

		/* comprobación */
		Assert.assertNotNull(this.juego);
	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaFilaIncorrecta() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(1, 6, "Emmanuel Vazquez", "Carlos Perez");

	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaColumnaIncorrecta() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(8, -6, "Emmanuel Vazquez", "Carlos Perez");
	}

	@Test(expected = Error.class)
	public void pruebaCuatroEnLineaFilaYColumnaIncorrecta() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(0, -6, "Emmanuel Vazquez", "Carlos Perez");
	}

	@Test(expected = Error.class)
	public void prueba3Filas() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(3, 4, "Manu", "Carlos");
	}

	@Test(expected = Error.class)
	public void prueba3Columnas() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 3, "Manu", "Carlos");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAzulVacio() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "", "Carlos");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAzulConEspaciosSolamente() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "     ", "Carlos");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAmarilloVacio() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "");
	}

	@Test(expected = Error.class)
	public void pruebaJugadorAmarilloConEspaciosSolamente() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "      ");
	}

	@Test
	public void pruebaContarFilas() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(10, 8, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarFilas();

		/* comprobación */
		Assert.assertEquals(10, contarFilas);
	}

	@Test
	public void pruebaContarFilasNumerosAltos() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(100, 200, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarFilas();

		/* comprobación */
		Assert.assertEquals(100, contarFilas);
	}

	@Test(expected = Error.class)
	public void pruebaContarFilasNumeroNegativo() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(-4, 4, "Manu", "Carlos");

	}

	@Test
	public void pruebaContarColumnas() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarColumnas();

		/* comprobación */
		Assert.assertEquals(4, contarFilas);
	}

	@Test(expected = Error.class)
	public void pruebaContarColumnasNumeroNegativo() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, -4, "Manu", "Carlos");

	}

	@Test
	public void pruebaContarColumnasNumerosAltos() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(100, 200, "Manu", "Carlos");

		/* operaciones */
		int contarColumnas = this.juego.contarColumnas();

		/* comprobación */
		Assert.assertEquals(200, contarColumnas);
	}

	@Test
	public void pruebaObtenerCasilleroEn0() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(1);
		Casillero casilla = this.juego.obtenerCasillero(5, 1);

		/* comprobación */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaObtenerCasilleroen1() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(2);
		Casillero casilla = this.juego.obtenerCasillero(5, 2);

		/* comprobación */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaObtenerCasilleroEn2() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(3);
		Casillero casilla = this.juego.obtenerCasillero(5, 3);

		/* comprobación */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaObtenerCasillero3() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(4);
		Casillero casilla = this.juego.obtenerCasillero(5, 4);

		/* comprobación */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test(expected = Error.class)
	public void pruebaObtenerCasilleroFueraDeRangoMaximo() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(5);

	}

	@Test(expected = Error.class)
	public void pruebaObtenerCasilleroFueraDeRangoMinimo() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(5, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(-1);

	}

	@Test
	public void pruebaSoltarFichasJuegoTermino() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, termino);
	}

	@Test
	public void pruebaSoltarFichasJuegoNoTermino() {
		/* condición inicial */
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

		/* comprobación */

		Assert.assertEquals(false, termino);
	}

	@Test
	public void pruebaSoltarFichasJugadorSueltaEnLugarYaOcupado() {
		/* condición inicial */
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

		/* comprobación */

		Assert.assertEquals(false, termino);
	}

	@Test(expected = Error.class)
	public void pruebaSoltarFichasNumeroNegativo() {
		/* condición inicial */
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
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);// Jugador uno
		this.juego.soltarFicha(2);// Jugador dos
		this.juego.soltarFicha(4);// Jugador uno

	}

	public void pruebaSoltarFichasJugadorTiraCuandoElJuegoTermino() {
		/* condición inicial */
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
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontalGanadorJugadorDos() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHorizontalGanadorAlPrincipioJugadorUno() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaDiagonalIzquierda() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaDiagonalDerechaGanadorJugadorDos() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorHorizontal4x4() {

		/* condición inicial */

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

		/* comprobación */

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontal5x4() {

		/* condición inicial */

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

		/* comprobación */

		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorHorizontal6x6() {
		/* condición inicial */
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
		/* condición inicial */
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
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHayGanadorVertical5x4() {
		/* condición inicial */
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
		/* condición inicial */
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
		/* condición inicial */
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
		/* condición inicial */
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
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorDiagonal6x6() {
		/* condición inicial */
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
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaHayGanadorDiagonal8x8() {

		/* condición inicial */
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
