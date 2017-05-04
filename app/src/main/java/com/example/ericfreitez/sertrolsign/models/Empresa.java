package com.example.ericfreitez.sertrolsign.models;

import java.util.ArrayList;

/**
 * Created by Eric Freitez on 04/05/2017.
 */

public class Empresa {

    private String nombreEmpresa;
    private String direccionEmpresa;

    public Empresa() {
    }

    public Empresa(String nombreEmpresa, String direccionEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }


    public ArrayList<Empresa> cargarData(){
        ArrayList<Empresa> itemsEmpresa = new ArrayList<>();

        itemsEmpresa.add(new Empresa("Tubrica","tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, laboris nisi"));
        itemsEmpresa.add(new Empresa("Nestle","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod"));
        itemsEmpresa.add(new Empresa("OtraVez C.A","ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehende"));
        itemsEmpresa.add(new Empresa("Preca C.A","ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehende"));
        itemsEmpresa.add(new Empresa("EPA C.A","ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehende"));

        return itemsEmpresa;

    }
}
