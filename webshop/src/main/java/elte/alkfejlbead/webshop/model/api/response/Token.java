package elte.alkfejlbead.webshop.model.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Token {
    public static final String TOKEN = "X-WEBSHOP-TOKEN";
    private String token;
}
