package com.example.consumoservicio.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    private int idEstudiante;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String instituacionEducativa;

    @Override
    public String toString() {
        return "Estudiante{" +
                "\nidEstudiante=" + idEstudiante +
                ",\n tipoDocumento='" + tipoDocumento + '\'' +
                ",\n numeroDocumento='" + numeroDocumento + '\'' +
                ",\n nombres='" + nombres + '\'' +
                ",\n apellidos='" + apellidos + '\'' +
                ",\n instituacionEducativa='" + instituacionEducativa + '\'' +
                '}';
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getInstituacionEducativa() {
        return instituacionEducativa;
    }
}
