package com.psp.security.token;

import com.psp.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TokenRepository {
  private final List<Token> tokens = new ArrayList<>();
  private final UserRepository userRepository;

  public List<Token> findAllValidTokenByUser(String id) {
    return userRepository.findAll().stream()
            .flatMap(user -> tokens.stream()
                    .filter(token -> token.user.getId().equals(user.getId())
                            && user.getId().equals(id)
                            && !(token.expired || token.revoked)
                    )
            )
            .toList();
  }

  public void saveAll(List<Token> tokens) {
    this.tokens.addAll(tokens);
  }

  public Token save(Token token) {
    tokens.add(token);
    return token;
  }

  public Optional<Token> findByToken(String jwt) {
    return tokens.stream().filter(token -> token.token.equals(jwt)).findFirst();
  }
}
