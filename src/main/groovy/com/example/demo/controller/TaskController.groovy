package com.example.demo.controller
import com.example.demo.entity.Task
import com.example.demo.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController {

    @Autowired
    TaskRepository taskRepository

    @GetMapping
    Iterable<Task> getAllTasks() {
        return taskRepository.findAll()
    }

    @PostMapping
    Task createTask(@RequestBody Task task) {
//        Task n = new Task();
//        n.setTitle(task.getTitle());
//        n.setDescription(task.getDescription());
        return taskRepository.save(task)

    }

    @GetMapping("/{id}")
    Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null)
    }

    @PutMapping("/{id}")
    Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        updatedTask.id = id
        return taskRepository.save(updatedTask)
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id)
    }
}
