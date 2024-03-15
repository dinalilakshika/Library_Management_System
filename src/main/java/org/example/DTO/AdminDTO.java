package org.example.DTO;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {

    private String mail;
    private String password;
}
