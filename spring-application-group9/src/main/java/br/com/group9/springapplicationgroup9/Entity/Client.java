package br.com.group9.springapplicationgroup9.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long clientId;
    private String name;
    private String email;
    private String cpf;
    private Integer age;
    private String address;
}
