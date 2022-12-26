package com.mnr.catalogueservice.security;

public Interface SecurityParams {
    //definir des constantes
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET = "miirbri1@gmail.com";
    public static final int EXPIRATION = 1000*60*60*24*10;
    public static final String HEADER_PREFIX = "Bearer ";
}
