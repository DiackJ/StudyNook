package com.api.StudyNookBackend.Config;

import io.github.cdimascio.dotenv.Dotenv;

//fall-back configuration to make sure env values are always used
public class EnvLoader {
    public static void loadEnv(){
        Dotenv dotenv;
        dotenv = Dotenv
                .configure()
                .directory("./")
                .filename(".env")
                .load();

        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
    }
}
