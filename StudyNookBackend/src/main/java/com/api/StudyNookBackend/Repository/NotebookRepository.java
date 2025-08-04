package com.api.StudyNookBackend.Repository;

import com.api.StudyNookBackend.Entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
}
