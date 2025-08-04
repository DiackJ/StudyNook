package com.api.StudyNookBackend.Repository;

import com.api.StudyNookBackend.Entity.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
}
