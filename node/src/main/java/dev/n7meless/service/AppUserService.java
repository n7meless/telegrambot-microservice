package dev.n7meless.service;

import dev.n7meless.entity.AppUser;

public interface AppUserService {
    String registerUser(AppUser appUser);

    String setEmail(AppUser appUser, String email);
}