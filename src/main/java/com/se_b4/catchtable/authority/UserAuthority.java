package com.se_b4.catchtable.authority;

import lombok.Getter;

@Getter
public enum UserAuthority {
    USER("ROLE_USER"),
    OWNER("ROLE_OWNER"),
    ADMIN("ROLE_ADMIN");

    private final String role;

    UserAuthority(String role) {this.role = role;}
}
