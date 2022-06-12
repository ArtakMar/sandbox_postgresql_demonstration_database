package ru.artak.spring_hibernate_demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artak.spring_hibernate_demo.model.*;
import ru.artak.spring_hibernate_demo.repository.BaseRepo;
import ru.artak.spring_hibernate_demo.repository.ChildrenRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BaseController {

    private final BaseRepo baseRepo;
    private final ChildrenRepo childrenRepo;

    public BaseController(BaseRepo baseRepo, ChildrenRepo childrenRepo) {
        this.baseRepo = baseRepo;
        this.childrenRepo = childrenRepo;
    }

    @GetMapping("/baseh")
    public Base getBaseh() {
        var byId = baseRepo.findWithHierarchyById(1L);

        return byId;
    }

    @GetMapping("/basehdto")
    public BaseHir getBasehdto() {
        var byId = baseRepo.findWithHierarchyById(1L);

        return new BaseHir(byId.getId(), byId.getName(), byId.getChildrenList());
    }


    @GetMapping("/base")
    public Base getBase() {
        var byId = baseRepo.findById(1L).get();
        return byId;
    }

    @GetMapping("/children")
    public List<Children> getChildren() {
        List<Children> all = childrenRepo.findAll();
        return all;
    }

    @GetMapping("/childrendto")
    public ChildrenDto getChildrenDto() {
        Children children = childrenRepo.findById(1L).get();

        return new ChildrenDto(children.getId(), children.getName(), new BaseDto(children.getBase().getId(), children.getBase().getName()));
    }


    @PostMapping
    public void add() {
        Base base = new Base();
        base.setName("Base");


        List<Children> childrenList = new ArrayList<>();

        Children children = new Children();
        children.setName("Children");
        childrenList.add(children);

        SubChildren subChildren = new SubChildren();
        subChildren.setName("SubChildren");

        children.setSubChildrenList(List.of(subChildren));
        base.setChildrenList(childrenList);

        baseRepo.save(base);
    }
}
