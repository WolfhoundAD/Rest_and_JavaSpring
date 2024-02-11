package org.example.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    private String address;
    private String email;
    private Long phone;
}
