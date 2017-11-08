
public class Asignatura {
	private int Cod;
	private String NombreA;
	private String NombreP;
	private int Horas;
	public Asignatura(int cod, String nombreA, String nombreP, int horas) {
		super();
		Cod = cod;
		NombreA = nombreA;
		NombreP = nombreP;
		Horas = horas;
	}
	public Asignatura() {
		super();
	}
	public int getCod() {
		return Cod;
	}
	public void setCod(int cod) {
		Cod = cod;
	}
	public String getNombreA() {
		return NombreA;
	}
	public void setNombreA(String nombreA) {
		NombreA = nombreA;
	}
	public String getNombreP() {
		return NombreP;
	}
	public void setNombreP(String nombreP) {
		NombreP = nombreP;
	}
	public int getHoras() {
		return Horas;
	}
	public void setHoras(int horas) {
		Horas = horas;
	}
	
	
}
