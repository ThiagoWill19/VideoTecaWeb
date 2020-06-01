package com.thiagowill.videoteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thiagowill.videoteca.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
