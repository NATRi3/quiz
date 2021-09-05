package ru.fr.quest.service;

import ru.fr.quest.model.User;

public interface UserService {

    User getUserByUsername(String username);
}
