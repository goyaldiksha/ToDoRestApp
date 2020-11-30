package com.lendbox.diksha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lendbox.diksha.model.TaskDetails;

@Repository
public interface TaskDetailRepository extends JpaRepository<TaskDetails, Integer> {

/*	@Query(value= "INSERT INTO task_Details (user_id, name, date, completed) VALUES (:userId,:name,:date,:completed)",
			nativeQuery = true)
	TaskDetails addTask(@Param("userId") Integer uid, @Param("name") String name, @Param("date") String dueDate, @Param("completed") Boolean completed);*/
	 
	List<TaskDetails> findAll();
	
	List<TaskDetails> findByUserId(Integer userId);

	@Modifying
	@Transactional
	@Query(value=  "update task_Details set completed=?1 WHERE id=?2" , nativeQuery = true)
	void updateCompletedTask(Integer completed, Integer id);
	
	@Transactional
	void deleteById(Integer id);

}
