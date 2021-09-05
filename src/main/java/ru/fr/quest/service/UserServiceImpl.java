package ru.fr.quest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fr.quest.dao.UserDao;
import ru.fr.quest.model.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByEmail(username).orElse(null);
    }
}
