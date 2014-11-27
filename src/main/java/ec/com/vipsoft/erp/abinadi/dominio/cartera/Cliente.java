/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author chrisvv
 */
@Entity
public class Cliente extends Contribuyente implements Serializable {
    @ManyToOne
    protected Tarifa tarifa;
   
}
