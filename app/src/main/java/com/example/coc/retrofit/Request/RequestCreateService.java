
package com.example.coc.retrofit.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestCreateService {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombreServicio")
    @Expose
    private String nombreServicio;
    @SerializedName("cliente_id")
    @Expose
    private Integer clienteId;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("nombreEquipo")
    @Expose
    private String nombreEquipo;
    @SerializedName("serialEquipo")
    @Expose
    private String serialEquipo;
    @SerializedName("horometro")
    @Expose
    private String horometro;
    @SerializedName("kilometraje")
    @Expose
    private String kilometraje;
    @SerializedName("planta_id")
    @Expose
    private Integer plantaId;
    @SerializedName("fechaEntrada")
    @Expose
    private String fechaEntrada;
    @SerializedName("fechaSalida")
    @Expose
    private String fechaSalida;
    @SerializedName("horaEntrada")
    @Expose
    private String horaEntrada;
    @SerializedName("horaSalida")
    @Expose
    private String horaSalida;
    @SerializedName("fotoInicio")
    @Expose
    private String fotoInicio;
    @SerializedName("fotoProceso")
    @Expose
    private String fotoProceso;
    @SerializedName("fotoFin")
    @Expose
    private String fotoFin;

    /**
     * No args constructor for use in serialization
     *
     * @param nombreServicio
     * @param descripcion
     * @param nombreEquipo
     * @param serialEquipo
     * @param horometro
     * @param fechaEntrada
     * @param fechaSalida
     * @param horaEntrada
     * @param horaSalida
     * @param plantaId
     * @param clienteId
     * @param fotoInicio
     * @param fotoProceso
     * @param fotoFin
     */
    public RequestCreateService(String nombreServicio, String descripcion, String nombreEquipo, String serialEquipo, String horometro, String fechaEntrada, String fechaSalida, String horaEntrada, String horaSalida, int plantaId, int clienteId, String fotoInicio, String fotoProceso, String fotoFin) {
    }

    /**
     * 
     * @param descripcion
     * @param horaEntrada
     * @param fotoProceso
     * @param horaSalida
     * @param nombreServicio
     * @param clienteId
     * @param kilometraje
     * @param fotoInicio
     * @param nombreEquipo
     * @param fechaSalida
     * @param fechaEntrada
     * @param horometro
     * @param id
     * @param fotoFin
     * @param serialEquipo
     * @param plantaId
     */
    public RequestCreateService(Integer id, String nombreServicio, Integer clienteId, String descripcion, String nombreEquipo, String serialEquipo, String horometro, String kilometraje, Integer plantaId, String fechaEntrada, String fechaSalida, String horaEntrada, String horaSalida, String fotoInicio, String fotoProceso, String fotoFin) {
        super();
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.clienteId = clienteId;
        this.descripcion = descripcion;
        this.nombreEquipo = nombreEquipo;
        this.serialEquipo = serialEquipo;
        this.horometro = horometro;
        this.kilometraje = kilometraje;
        this.plantaId = plantaId;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fotoInicio = fotoInicio;
        this.fotoProceso = fotoProceso;
        this.fotoFin = fotoFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(String serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public String getHorometro() {
        return horometro;
    }

    public void setHorometro(String horometro) {
        this.horometro = horometro;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Integer getPlantaId() {
        return plantaId;
    }

    public void setPlantaId(Integer plantaId) {
        this.plantaId = plantaId;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFotoInicio() {
        return fotoInicio;
    }

    public void setFotoInicio(String fotoInicio) {
        this.fotoInicio = fotoInicio;
    }

    public String getFotoProceso() {
        return fotoProceso;
    }

    public void setFotoProceso(String fotoProceso) {
        this.fotoProceso = fotoProceso;
    }

    public String getFotoFin() {
        return fotoFin;
    }

    public void setFotoFin(String fotoFin) {
        this.fotoFin = fotoFin;
    }

}
