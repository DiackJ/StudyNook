package com.api.StudyNookBackend.Repository;

import com.api.StudyNookBackend.Entity.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTagRepository extends JpaRepository<UserTag, Long> {
}
