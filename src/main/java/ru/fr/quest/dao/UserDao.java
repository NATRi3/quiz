package ru.fr.quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fr.quest.model.User;

import java.util.Optional;


public interface UserDao {
    Optional<User> getUserByEmail(String email);
}
