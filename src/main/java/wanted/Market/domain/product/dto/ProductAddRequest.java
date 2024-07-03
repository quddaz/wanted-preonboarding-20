package wanted.Market.domain.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private int price;
}
