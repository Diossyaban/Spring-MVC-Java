package com.bootcamp.firstproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category {
    
    @Id
    @SequenceGenerator(name = "seq_category", sequenceName = "seq_id_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    @Column(name = "cate_id")
    private Long cateId;

    @Column(name = "cate_name")
    @Size(max = 25, message = "Length Field name maksimal 25 karakter")
    @NotBlank(message = "Field name harus diisi")
    private String cateName;

    public Category() {
    }

    public Category(Long cateId,
            @Size(max = 25, message = "Length Field name maksimal 25 karakter") @NotBlank(message = "Field name harus diisi") String cateName) {
        this.cateId = cateId;
        this.cateName = cateName;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    
}
