package cr.ac.ucenfotec.bl.entitites.Estante;

public class Estante {
    private int codigoEstante;
    private double alto;
    private double ancho;
    private double profundidad;


    public Estante() {

    }

    public Estante(int codigoEstante, double alto, double ancho, double profundidad) {
        this.codigoEstante = codigoEstante;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    public int getCodigoEstante() {
        return codigoEstante;
    }

    public void setCodigoEstante(int codigoEstante) {
        this.codigoEstante = codigoEstante;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public String toString() {
        return "Estante: " +
                "Código del Estante=" + codigoEstante +
                ", Medida alto=" + alto +
                ", Medida ancho=" + ancho +
                ", Medida profundidad=" + profundidad;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estante estante = (Estante) o;
        return codigoEstante == estante.codigoEstante && Double.compare(alto, estante.alto) == 0 && Double.compare(ancho, estante.ancho) == 0 && Double.compare(profundidad, estante.profundidad) == 0;
    }


}
