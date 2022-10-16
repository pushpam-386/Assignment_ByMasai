package com.push.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.Tasks;

public interface TasksDao extends JpaRepository<Tasks, Integer>{
	public List<Tasks> findByStartDateAndDeadLine(Date startDate,Date deadLine);
	public List<Tasks> findOrderByDeadLineDescOrAscList(Date deadLine);
}
