package az.mycompany.turboservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelDto {
    private int id;
    @NotBlank(message ="Brand name can't be empty or null")
    private String name;
    @NotBlank(message =" brand can't be empty or null")
    private BrandDto brandDto;
}
