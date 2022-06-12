package ru.artak.spring_hibernate_demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@NamedEntityGraphs(
        {
                @NamedEntityGraph(
                        name = "base",
//attributeNodes = {
//                                @NamedAttributeNode("id"),
//                                @NamedAttributeNode("name")
//}
                       includeAllAttributes = true
                )

        }
)
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Base {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST}, mappedBy = "base")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "base")
    @JsonBackReference
//    @JsonManagedReference -- вроде так лучше
    private List<Children> childrenList;


    public void setChildrenList(List<Children> childrenList) {
        childrenList.forEach(children -> children.setBase(this));
        this.childrenList = childrenList;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Children> getChildrenList() {
        return this.childrenList;
    }
}
