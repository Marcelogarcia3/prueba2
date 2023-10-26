package model;

public class Seleccion {
    private String nombreSeleccion;

    private String id;

    private int rankingFifa;

    private String iconoBandera;

    public Seleccion(String nombreSeleccion, String id, int rankingFifa, String iconoBandera) {
        this.nombreSeleccion = nombreSeleccion;
        this.id = id;
        this.rankingFifa = rankingFifa;
        this.iconoBandera = iconoBandera;
    }

    public String getNombreSeleccion() {
        return nombreSeleccion;
    }

    public void setNombreSeleccion(String nombreSeleccion) {
        this.nombreSeleccion = nombreSeleccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRankingFifa() {
        return rankingFifa;
    }

    public void setRankingFifa(int rankingFifa) {
        this.rankingFifa = rankingFifa;
    }

    public String getIconoBandera() {
        return iconoBandera;
    }

    public void setIconoBandera(String iconoBandera) {
        this.iconoBandera = iconoBandera;
    }
}

