package banco.modelos;

import java.util.Date;

public class Transferencia {
	
	private Integer id;
	private Integer idOrigen;
	private Integer idDestino;
	private double importe;
	private String concepto;
	private Date fecha;

	public Transferencia() {
		// TODO Auto-generated constructor stub
	}
	
	public Transferencia(Integer id,Integer idOrigen,Integer idDestino,double importe,String concepto) {
		this.id = id;
		this.idOrigen= idOrigen;
		this.idDestino= idDestino;
		this.importe= importe;
		this.concepto= concepto;
		this.fecha= new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
