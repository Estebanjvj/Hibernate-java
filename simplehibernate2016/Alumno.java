

import javax.persistence.*;

@Entity
@Table(name = "Alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlumno")
	private int idAlumno;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idCiudad")
    Ciudad ciudad;

	/*@Column(name = "idCiudad")
	private int idCiudad;*/

	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Sexo")
	private String sexo;

	@Column(name = "edad")
	private int edad;

	public Alumno() {
	}

	public Alumno(String nombre, String sexo, int edad) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}

	/*public Alumno(String nombre, int idCiudad, String sexo, int edad) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.idCiudad = idCiudad;
	}*/

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	/*public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}*/
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String Sexo) {
		this.sexo = Sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Ciudad getCiudad(){
            return this.ciudad;
    }

    public void setCiudad(Ciudad ciudad){
            this.ciudad = ciudad;
    }

    @Override
    public String toString(){
            return "idAlumno: "+this.idAlumno+", Nombre: "+this.nombre;
    }
}
