package org.lessons.java.list;

public class Regalo {
    // ATTRIBUTI
    private String descrizione;
    private String destinatario;

    // COSTRUTTORE
    public Regalo(String descrizione, String destinatario) {
        this.descrizione = descrizione;
        this.destinatario = destinatario;
    }

    // GETTER E SETTER
    // DESCRIZIONE
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    // DESTINATARIO
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Regalo {Descrizione: " + descrizione + ", Destinatario: " + destinatario + "}";
    }
}
