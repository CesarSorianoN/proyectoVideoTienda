package filmstore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pelicula database table.
 * 
 */
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	
	private Date anio;

	private long cantidad;

	private String clasificacion;

	private String estado;

	private String estudio;

	private String genero;

	private long precio;

	private String titulo;

	public Pelicula() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "anio" ,length =19)
	public Date getAnio() {
		return this.anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	@Column(name = "cantidad", length = 20)
	public long getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "clasificacion", length = 75)
	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Column(name = "estado", length = 5)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "estudio", length = 75)
	public String getEstudio() {
		return this.estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	@Column(name = "genero", length = 75)
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Column(name = "precio", length = 20)
	public long getPrecio() {
		return this.precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	@Column(name = "titulo", length = 75)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}