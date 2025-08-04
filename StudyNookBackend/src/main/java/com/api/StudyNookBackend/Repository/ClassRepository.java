package com.api.StudyNookBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.StudyNookBackend.Entity.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
