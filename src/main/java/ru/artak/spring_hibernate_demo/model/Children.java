package ru.artak.spring_hibernate_demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Children {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "base_id")
//    @JsonBackReference  --- вроде так лучше
    @JsonIgnore
    private Base base;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "children")
    @JsonBackReference
    private List<SubChildren> subChildrenList;



    public void setSubChildrenList(List<SubChildren> subChildrenList) {
        subChildrenList.forEach(subChildren -> subChildren.setChildren(this));
        this.subChildrenList = subChildrenList;
    }
}
