package pruebas;

import juego.CuatroEnLinea;
import juego.Casillero;

import org.junit.*;

public class pruebaCuatroEnLinea {

	CuatroEnLinea juego;

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
	public void pruebaCuatroEnLineaCorrecto() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Emmanuel Vazquez",
				"Juan Domingo Perón");

		/* comprobación */
		Assert.assertNotNull(this.juego);
	}

	@Test
	public void pruebaContarFilas() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		int contarFilas = this.juego.contarFilas();

		/* comprobación */
		Assert.assertEquals(4, contarFilas);
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

	@Test
	public void pruebaObtenerCasillero() {
		/* condición inicial */
		this.juego = new CuatroEnLinea(4, 4, "Manu", "Carlos");

		/* operaciones */
		this.juego.soltarFicha(0);
		Casillero casilla = this.juego.obtenerCasillero(4, 1);

		/* comprobación */
		Assert.assertEquals(true, casilla != Casillero.VACIO);
	}

	@Test
	public void pruebaVertical() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaHorizontal() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);
	}

	@Test
	public void pruebaDiagonalIzquierda() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);

	}

	@Test
	public void pruebaDiagonalDerecha() {
		/* condición inicial */
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

		/* comprobación */
		Assert.assertEquals(true, gano);

	}

}
