package org.epineuro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugsDTO {
    private Long id;
    private String name;
    private String drugGroup;
}
