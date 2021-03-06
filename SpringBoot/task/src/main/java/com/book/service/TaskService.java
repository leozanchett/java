package com.book.service;

import com.book.dto.TaskDto;
import com.book.todo.entity.Task;
import com.book.todo.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
public class TaskService {

    private TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Page<Task> getTasks(Pageable pageable){
        return taskRepository.findAll(pageable);
    }

    public Task getTask(long taskId){
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent()){
            return task.get();
        }
        return null;
    }

    public Task saveTask(TaskDto taskDto){
        ModelMapper  modelMapper = new ModelMapper();
        Task task = modelMapper.map(taskDto, Task.class);
        return taskRepository.save(task);
    }
}
