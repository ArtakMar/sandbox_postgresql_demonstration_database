package ru.artak.spring_hibernate_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildrenDto {
    private Long id;
    private String name;
    private BaseDto base;
}
