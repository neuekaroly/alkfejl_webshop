package elte.alkfejlbead.webshop.model.api.response;

import elte.alkfejlbead.webshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Token {
    public static final String TOKEN = "X-WEBSHOP-TOKEN";
    private String token;
    private User.Role role;
}
