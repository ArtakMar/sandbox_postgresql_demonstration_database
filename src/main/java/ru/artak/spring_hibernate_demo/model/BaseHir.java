package ru.artak.spring_hibernate_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseHir {
    private Long id;
    private String name;
    private List<Children> childrenList;
}
