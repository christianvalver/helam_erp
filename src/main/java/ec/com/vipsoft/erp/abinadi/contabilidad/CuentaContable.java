package ec.com.vipsoft.erp.abinadi.contabilidad;

import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import javax.validation.constraints.NotNull;

@Entity
public abstract class CuentaContable implements Serializable, Comparable<CuentaContable> {

    public CuentaContable() {
        debe=BigDecimal.ZERO;
        haber=BigDecimal.ZERO;
        debe_periodo1=BigDecimal.ZERO;
        debe_periodo2=BigDecimal.ZERO;
        debe_periodo3=BigDecimal.ZERO;
        debe_periodo4=BigDecimal.ZERO;
        debe_periodo5=BigDecimal.ZERO;
        haber_periodo1=BigDecimal.ZERO;
        haber_periodo2=BigDecimal.ZERO;
        haber_periodo3=BigDecimal.ZERO;
        haber_periodo4=BigDecimal.ZERO;
        haber_periodo5=BigDecimal.ZERO;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected boolean esAuxiliar;
    @NotNull
    protected String codigo;
    @NotNull
    protected String descripcion;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal debe;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal haber;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal debe_periodo1;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal debe_periodo2;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal debe_periodo3;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal debe_periodo4;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal debe_periodo5;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal haber_periodo1;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal haber_periodo2;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal haber_periodo3;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal haber_periodo4;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal haber_periodo5;

    @Column(name = "subauxiliares",columnDefinition = "boolean default false")
    protected boolean subcuentasSonAuxiliares;
    @Enumerated(EnumType.ORDINAL)
    protected GrupoCuenta grupo;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected Set<CuentaContable> subCuentas;
    @ManyToOne
    private Entidad entidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getDebe() {
        return debe;
    }

    public void setDebe(BigDecimal debe) {
        this.debe = debe;
    }

    public BigDecimal getHaber() {
        return haber;
    }

    public void setHaber(BigDecimal haber) {
        this.haber = haber;
    }

    public BigDecimal getDebe_periodo1() {
        return debe_periodo1;
    }

    public void setDebe_periodo1(BigDecimal debe_periodo1) {
        this.debe_periodo1 = debe_periodo1;
    }

    public BigDecimal getDebe_periodo2() {
        return debe_periodo2;
    }

    public void setDebe_periodo2(BigDecimal debe_periodo2) {
        this.debe_periodo2 = debe_periodo2;
    }

    public BigDecimal getDebe_periodo3() {
        return debe_periodo3;
    }

    public void setDebe_periodo3(BigDecimal debe_periodo3) {
        this.debe_periodo3 = debe_periodo3;
    }

    public BigDecimal getDebe_periodo4() {
        return debe_periodo4;
    }

    public void setDebe_periodo4(BigDecimal debe_periodo4) {
        this.debe_periodo4 = debe_periodo4;
    }

    public BigDecimal getDebe_periodo5() {
        return debe_periodo5;
    }

    public void setDebe_periodo5(BigDecimal debe_periodo5) {
        this.debe_periodo5 = debe_periodo5;
    }

    public BigDecimal getHaber_periodo1() {
        return haber_periodo1;
    }

    public void setHaber_periodo1(BigDecimal haber_periodo1) {
        this.haber_periodo1 = haber_periodo1;
    }

    public BigDecimal getHaber_periodo2() {
        return haber_periodo2;
    }

    public void setHaber_periodo2(BigDecimal haber_periodo2) {
        this.haber_periodo2 = haber_periodo2;
    }

    public BigDecimal getHaber_periodo3() {
        return haber_periodo3;
    }

    public void setHaber_periodo3(BigDecimal haber_periodo3) {
        this.haber_periodo3 = haber_periodo3;
    }

    public BigDecimal getHaber_periodo4() {
        return haber_periodo4;
    }

    public void setHaber_periodo4(BigDecimal haber_periodo4) {
        this.haber_periodo4 = haber_periodo4;
    }

    public BigDecimal getHaber_periodo5() {
        return haber_periodo5;
    }

    public void setHaber_periodo5(BigDecimal haber_periodo5) {
        this.haber_periodo5 = haber_periodo5;
    }

    public boolean isSubcuentasSonAuxiliares() {
        return subcuentasSonAuxiliares;
    }

    public void setSubcuentasSonAuxiliares(boolean subcuentasSonAuxiliares) {
        this.subcuentasSonAuxiliares = subcuentasSonAuxiliares;
    }

    public GrupoCuenta getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoCuenta grupo) {
        this.grupo = grupo;
    }

    public Set<CuentaContable> getSubCuentas() {
        return subCuentas;
    }

    public void setSubCuentas(Set<CuentaContable> subCuentas) {
        this.subCuentas = subCuentas;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    @Override
    public int compareTo(CuentaContable o) {
        int retorno = entidad.compareTo(o.entidad);
        if (retorno == 0) {
            retorno = codigo.compareToIgnoreCase(o.codigo);
        }
        return retorno;
    }

    public abstract void mayorizar();

    public abstract BigDecimal calcularSaldo();

    public boolean tieneMovimientos() {
        if ((debe.doubleValue() > 0) || (haber.doubleValue() > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public CuentaContable anadirSubCuenta(String descripcion) {
        CuentaContable subCuentaNueva = null;
        if (!tieneMovimientos()) {
            if (this instanceof CuentaDeudora) {
                subCuentaNueva = new CuentaDeudora();
            }
            if (this instanceof CuentaAcreedora) {
                subCuentaNueva = new CuentaAcreedora();
            }
            StringBuilder sbcodigo = new StringBuilder(codigo);
            sbcodigo.append(".");
            sbcodigo.append(subCuentas.size() + 1);
            subCuentaNueva.setCodigo(sbcodigo.toString());
            subCuentaNueva.setDescripcion(descripcion);
            subCuentaNueva.setGrupo(grupo);
            subCuentaNueva.setSubcuentasSonAuxiliares(subcuentasSonAuxiliares);
            subCuentaNueva.setEsAuxiliar(subcuentasSonAuxiliares);
            subCuentas.add(subCuentaNueva);
        }
        return subCuentaNueva;
    }

    public boolean isEsAuxiliar() {
        return esAuxiliar;
    }

    public void setEsAuxiliar(boolean esAuxiliar) {
        this.esAuxiliar = esAuxiliar;
    }

}

