package az.mycompany.turboservice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BrandDto {
    private int id;
    @NotBlank(message ="Brand name can't be empty or null")
    private  String name;
}
