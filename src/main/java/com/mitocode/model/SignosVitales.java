package com.mitocode.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "signos_vitales")
public class SignosVitales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSignoVital;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signo_vital_paciente"))
    private Paciente paciente;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "temperatura", length = 50, nullable = true)
    private String temperatura;

    @Column(name = "pulso", length = 50, nullable = true)
    private String pulso;

    @Column(name = "ritmoRespiratorio", length = 50, nullable = true)
    private String ritmoRespiratorio;

    public Integer getIdSignoVital() {
        return idSignoVital;
    }

    public void setIdSignoVital(Integer idSignoVital) {
        this.idSignoVital = idSignoVital;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getRitmoRespiratorio() {
        return ritmoRespiratorio;
    }

    public void setRitmoRespiratorio(String ritmoRespiratorio) {
        this.ritmoRespiratorio = ritmoRespiratorio;
    }
}
