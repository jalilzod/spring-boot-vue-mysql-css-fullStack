package com.jalilzod_art.firststep.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long id;
    private String title;
    private String description;
    private String status;
    private java.sql.Timestamp createdAt;



}
