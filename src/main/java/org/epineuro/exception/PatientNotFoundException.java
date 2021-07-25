package org.epineuro.exception;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Long id) {
        super("Paciente não encontrado" + id);
    }
}
