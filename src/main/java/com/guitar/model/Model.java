package com.guitar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Model.findAllModelsByType", query = "select m from Model m where m.modelType.name = :name")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private BigDecimal price;

//    @JsonIgnore
//    private int frets;
    private int frets;

    @Column(name = "WOODTYPE")
    private String woodType;

    @Column(name = "YEARFIRSTMADE")
    private Date yearFirstMade;

    @ManyToOne
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "MODELTYPE_ID")
    private ModelType modelType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getFrets() {
        return frets;
    }

    public void setFrets(int frets) {
        this.frets = frets;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public Date getYearFirstMade() {
        return yearFirstMade;
    }

    public void setYearFirstMade(Date yearFirstMade) {
        this.yearFirstMade = yearFirstMade;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public Long getId() {
        return id;
    }
}
