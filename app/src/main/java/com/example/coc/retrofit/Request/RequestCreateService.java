
package com.example.coc.retrofit.Request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestCreateService {

    @SerializedName("nombreServicio")
    @Expose
    private List<String> nombreServicio = new ArrayList<String>();
    @SerializedName("cliente_id")
    @Expose
    private List<Integer> clienteId = new ArrayList<Integer>();
    @SerializedName("nombreEquipo")
    @Expose
    private List<String> nombreEquipo = new ArrayList<String>();
    @SerializedName("serialEquipo")
    @Expose
    private List<String> serialEquipo = new ArrayList<String>();
    @SerializedName("horometro")
    @Expose
    private List<String> horometro = new ArrayList<String>();
    @SerializedName("kilometraje")
    @Expose
    private List<String> kilometraje = new ArrayList<String>();
    @SerializedName("planta_id")
    @Expose
    private List<Integer> plantaId = new ArrayList<Integer>();
    @SerializedName("fechaEntrada")
    @Expose
    private List<String> fechaEntrada = new ArrayList<String>();
    @SerializedName("fechaSalida")
    @Expose
    private List<String> fechaSalida = new ArrayList<String>();
    @SerializedName("horaEntrada")
    @Expose
    private List<String> horaSalida = new ArrayList<String>();
    @SerializedName("horaSalida")
    @Expose
    private List<String> horaEntrada = new ArrayList<String>();
    @SerializedName("fotoInicio")
    @Expose
    private List<String> fotoInicio = new ArrayList<String>();
    @SerializedName("fotoProceso")
    @Expose
    private List<String> fotoProceso = new ArrayList<String>();
    @SerializedName("fotoFin")
    @Expose
    private List<String> fotoFin = new ArrayList<String>();
    @SerializedName("descripcion")
    @Expose
    private List<String> descripcion = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     *  @param servicio
     * @param descripcion
     * @param nameEquipo
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
    public RequestCreateService(String servicio, String descripcion, String nameEquipo, String serialEquipo, String horometro, String fechaEntrada, String fechaSalida, String horaEntrada, String horaSalida, int plantaId, int clienteId, String fotoInicio, String fotoProceso, String fotoFin) {
    }

    /**
     * @param fotoFin
     * @param fechaEntrada
     * @param fotoProceso
     * @param nombreEquipo
     * @param horaEntrada
     * @param horaSalida
     * @param nombreServicio
     * @param horometro
     * @param plantaId
     * @param clienteId
     * @param descripcion
     * @param kilometraje
     * @param fotoInicio
     * @param fechaSalida
     * @param serialEquipo
     */
    public RequestCreateService(List<String> nombreServicio, List<Integer> clienteId, List<String> nombreEquipo, List<String> serialEquipo, List<String> horometro, List<String> kilometraje, List<Integer> plantaId, List<String> fechaEntrada, List<String> fechaSalida, List<String> horaEntrada, List<String> horaSalida, List<String> fotoInicio, List<String> fotoProceso, List<String> fotoFin, List<String> descripcion) {
        super();
        this.nombreServicio = nombreServicio;
        this.clienteId = clienteId;
        this.nombreEquipo = nombreEquipo;
        this.serialEquipo = serialEquipo;
        this.horometro = horometro;
        this.kilometraje = kilometraje;
        this.plantaId = plantaId;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaEntrada = horaEntrada;
        this.horaEntrada = horaSalida;
        this.fotoInicio = fotoInicio;
        this.fotoProceso = fotoProceso;
        this.fotoFin = fotoFin;
        this.descripcion = descripcion;
    }

    public List<String> getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(List<String> nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public List<Integer> getClienteId() {
        return clienteId;
    }

    public void setClienteId(List<Integer> clienteId) {
        this.clienteId = clienteId;
    }

    public List<String> getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(List<String> nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<String> getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(List<String> serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public List<String> getHorometro() {
        return horometro;
    }

    public void setHorometro(List<String> horometro) {
        this.horometro = horometro;
    }

    public List<String> getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(List<String> kilometraje) {
        this.kilometraje = kilometraje;
    }

    public List<Integer> getPlantaId() {
        return plantaId;
    }

    public void setPlantaId(List<Integer> plantaId) {
        this.plantaId = plantaId;
    }

    public List<String> getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(List<String> fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public List<String> getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(List<String> fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<String> getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(List<String> horaEntrada) {
        this.horaEntrada = horaEntrada;
    }


    public List<String> getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(List<String> horaSalida) {
        this.horaSalida = horaSalida;
    }


    public List<String> getFotoInicio() {
        return fotoInicio;
    }

    public void setFotoInicio(List<String> fotoInicio) {
        this.fotoInicio = fotoInicio;
    }

    public List<String> getFotoProceso() {
        return fotoProceso;
    }

    public void setFotoProceso(List<String> fotoProceso) {
        this.fotoProceso = fotoProceso;
    }

    public List<String> getFotoFin() {
        return fotoFin;
    }

    public void setFotoFin(List<String> fotoFin) {
        this.fotoFin = fotoFin;
    }

    public List<String> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(List<String> descripcion) {
        this.descripcion = descripcion;
    }

}
