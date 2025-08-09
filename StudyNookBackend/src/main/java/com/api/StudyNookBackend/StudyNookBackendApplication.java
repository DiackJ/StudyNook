package com.api.StudyNookBackend;

import com.api.StudyNookBackend.Config.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyNookBackendApplication {

	static{
		EnvLoader.loadEnv();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudyNookBackendApplication.class, args);
	}

}
