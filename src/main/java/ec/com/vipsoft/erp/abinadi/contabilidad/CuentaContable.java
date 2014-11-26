package ec.com.vipsoft.erp.abinadi.contabilidad;

import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public abstract class CuentaContable implements Serializable, Comparable<CuentaContable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String codigo;
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

    protected boolean subcuentasSonAuxiliares;
    protected GrupoCuenta grupo;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    protected Set<CuentaContable>subCuentas;
    @ManyToOne
    private Entidad entidad;

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

}
