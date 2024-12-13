package com.petya8bachey.modular_computer_configurator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ComponentType type;
    private String name;
    private String manufacturer;

    private Set<CompatibilityType> compatibility;
    private Set<CompatibilityType> requirement;

    @Override
    public String toString() {
        return "Component{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    public void addCompatibility(CompatibilityType type) {
        compatibility.add(type);
    }

    public void addRequirement(CompatibilityType type) {
        requirement.add(type);
    }

    public Component() {
        compatibility = new HashSet<>();
        requirement = new HashSet<>();
    }
}
