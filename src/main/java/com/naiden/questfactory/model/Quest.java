package com.naiden.questfactory.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@NodeEntity
public class Quest {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3)
    @Property
    private String name;

    @Property
    private String description;

    @Relationship(type = "hasEntryPoint")
    private QuestRoom entryPoint;

    public Quest() {
    }

    public Quest(String name, String description, String entryPointName) {
        this.name = name;
        this.description = description;
        this.entryPoint = new QuestRoom(entryPointName);
    }

    public Quest(String entryPointName) {
        this.name = entryPointName;
    }


    public Quest(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestRoom getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(QuestRoom entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return Objects.equals(name, quest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public String toString() {
        return this.name + "'s entry point: " + entryPoint.getName();
    }

}
