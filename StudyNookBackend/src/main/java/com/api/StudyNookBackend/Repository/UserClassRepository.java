package com.api.StudyNookBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.StudyNookBackend.Entity.UserClass;

@Repository
public interface UserClassRepository extends JpaRepository<UserClass, Long> {
}
