package com.audit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.repository.ProjectManagerRepo;
import com.audit.exception.ProjectManagerNotFoundException;
import com.audit.model.ProjectManager;

@Service
public class ProjectManagerService {

	@Autowired
	private ProjectManagerRepo projectManagerRepo;
	
	public ProjectManager getProjectManagerByUserName(String username) throws ProjectManagerNotFoundException{
		ProjectManager projectManager = null;
		projectManager = projectManagerRepo.getProjectManagerByUserName(username);
		if(projectManager==null) {
			throw new ProjectManagerNotFoundException("Given Project-Manager-Details does not exist in our Database!!");
		}
		return projectManager;
	}
}
