package com.lazareva.resourceController.mapper;

public interface BaseMapper <Entity, Model>{
    Entity toEntity (Model model);

    Model toModel (Entity entity);
}
