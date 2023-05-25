package com.psp.security.token;

import com.psp.security.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

  public Integer id;
  public String token;
  @Builder.Default
  public TokenType tokenType = TokenType.BEARER;
  public boolean revoked;
  public boolean expired;
  public User user;
}
