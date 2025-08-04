package com.api.StudyNookBackend.Repository;

import com.api.StudyNookBackend.Entity.NoteTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTagRepository extends JpaRepository<NoteTag, Long> {
}
