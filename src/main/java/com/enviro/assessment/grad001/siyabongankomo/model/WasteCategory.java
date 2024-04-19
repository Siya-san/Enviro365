package com.enviro.assessment.grad001.siyabongankomo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WasteCategory {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Waste category Name Required")
    private String category;
    private String description;

}
