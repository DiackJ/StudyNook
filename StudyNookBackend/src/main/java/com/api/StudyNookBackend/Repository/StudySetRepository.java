package com.api.StudyNookBackend.Repository;

import com.api.StudyNookBackend.Entity.StudySet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudySetRepository extends JpaRepository<StudySet, Long> {
}
