package pruebas;

import juego.CuatroEnLinea;
import juego.Casillero;

import org.junit.*;

public class pruebaCuatroEnLinea {

	CuatroEnLinea juego;

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
	public void pruebaCuatroEnLineaCorrecto() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Emmanuel Vazquez",
				"Juan Domingo Per�n");

		/* comprobaci�n */
		Assert.assertNotNull(this.juego);
	}

	@Test
	public void pruebaContarFilas() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarFilas();

		/* comprobaci�n */
		Assert.assertEquals(4, contarFilas);
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

	@Test
	public void pruebaObtenerCasillero() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);
		Casillero casilla = this.juego.obtenerCasillero(4, 1);

		/* comprobaci�n */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaVertical() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);
		this.juego.soltarFicha(0);
		this.juego.soltarFicha(1);
		this.juego.soltarFicha(1);
		this.juego.soltarFicha(2);
		this.juego.soltarFicha(2);
		this.juego.soltarFicha(3);
		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHorizontal() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);
		this.juego.soltarFicha(1);
		this.juego.soltarFicha(0);
		this.juego.soltarFicha(1);
		this.juego.soltarFicha(0);
		this.juego.soltarFicha(1);
		this.juego.soltarFicha(0);
		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaDiagonalIzquierda() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0); // COLOR 0
		this.juego.soltarFicha(0); // COLOR 1
		this.juego.soltarFicha(0); // COLOR 0
		this.juego.soltarFicha(0); // COLOR 1
		this.juego.soltarFicha(2); // COLOR 0
		this.juego.soltarFicha(1); // COLOR 1
		this.juego.soltarFicha(1); // COLOR 0
		this.juego.soltarFicha(1); // COLOR 1
		this.juego.soltarFicha(1); // COLOR 0
		this.juego.soltarFicha(2); // COLOR 1
		this.juego.soltarFicha(2); // COLOR 0
		this.juego.soltarFicha(3); // COLOR 1
		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaDiagonalDerecha() {
		/* condici�n inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(3); // COLOR 0
		this.juego.soltarFicha(3); // COLOR 1
		this.juego.soltarFicha(3); // COLOR 0
		this.juego.soltarFicha(3); // COLOR 1
		this.juego.soltarFicha(1); // COLOR 0
		this.juego.soltarFicha(2); // COLOR 1
		this.juego.soltarFicha(2); // COLOR 0
		this.juego.soltarFicha(2); // COLOR 1
		this.juego.soltarFicha(2); // COLOR 0
		this.juego.soltarFicha(1); // COLOR 1
		this.juego.soltarFicha(1); // COLOR 0
		this.juego.soltarFicha(0); // COLOR 1
		boolean gano = this.juego.termino();

		/* comprobaci�n */
		Assert.assertEquals(true, gano);

	}

}
