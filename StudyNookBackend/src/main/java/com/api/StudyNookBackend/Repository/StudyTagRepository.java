package com.api.StudyNookBackend.Repository;

import com.api.StudyNookBackend.Entity.StudyTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTagRepository extends JpaRepository<StudyTag, Long> {
}
