package com.ust.poservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project-service", url = "http://localhost:3031/api/projects")
public interface ProjectClient {
    @GetMapping("/{projectId}")
    Object getProjectById(@PathVariable String projectId);

    @GetMapping("/{projectId}/employees")
    List<Object> getEmployeesWithProjectId(@PathVariable String projectId);
     
}

