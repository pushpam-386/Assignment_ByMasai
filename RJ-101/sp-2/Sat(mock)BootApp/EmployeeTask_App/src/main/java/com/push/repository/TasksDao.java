package com.push.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.Tasks;

public interface TasksDao extends JpaRepository<Tasks, Integer>{
//	public List<Tasks> findByStartDateAndDeadline(Date startDate,Date deadline);
	public List<Tasks> findAllByOrderByDeadlineDesc();
}
