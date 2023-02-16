package com.example.enigma_z2.helper.task;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CreateTaskHelper {
    private String title;
    private String description;
    private Date executionDate;
    private Long idUser;
}
