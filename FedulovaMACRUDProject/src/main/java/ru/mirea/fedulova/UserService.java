package ru.mirea.fedulova;

public interface UserService {
    UserEntity getUser(int id);
    UserEntity addUser(UserRequest userRequest);
}
