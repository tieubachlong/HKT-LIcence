/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hkt.license.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author longnt
 */
@Table
@Entity
public class Key implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private long id;
    private String nameCustomer;
    private String keyMachine;
    private String inputData;
    private String keyActivate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateStart;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEnd;

    public Key() {
    }

    public Key(String nameCustomer, String keyMachine, String inputData, String keyActivate, Date dateStart, Date dateEnd) {
        this.nameCustomer = nameCustomer;
        this.keyMachine = keyMachine;
        this.inputData = inputData;
        this.keyActivate = keyActivate;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    
    public void setData(String nameCustomer, String keyMachine, String inputData, String keyActivate, Date dateStart, Date dateEnd){
        this.nameCustomer = nameCustomer;
        this.keyMachine = keyMachine;
        this.inputData = inputData;
        this.keyActivate = keyActivate;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getKeyActivate() {
        return keyActivate;
    }

    public void setKeyActivate(String keyActivate) {
        this.keyActivate = keyActivate;
    }

    public String getKeyMachine() {
        return keyMachine;
    }

    public void setKeyMachine(String keyMachine) {
        this.keyMachine = keyMachine;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nameCustomer;
    }
}
