package com.capstone.ecommerce.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="CATEGORY_NAME", length=50, nullable = false, unique = true)
    private String name;

}
