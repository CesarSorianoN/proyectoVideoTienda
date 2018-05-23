package filmstore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the pelicula database table.
 * 
 */
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date anio;

	private BigInteger cantidad;

	private String clasificacion;

	private String estado;

	private String estudio;

	private String genero;

	private BigInteger precio;

	private String titulo;

	public Pelicula() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getAnio() {
		return this.anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	public BigInteger getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigInteger cantidad) {
		this.cantidad = cantidad;
	}

	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstudio() {
		return this.estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public BigInteger getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigInteger precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}