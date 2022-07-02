package com.audit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.audit.exception.ProjectManagerNotFoundException;
import com.audit.model.ProjectManager;
import com.audit.repository.ProjectManagerRepo;

@ExtendWith(MockitoExtension.class)
public class ProjectManagerServiceTest {
	@Mock
	private ProjectManagerRepo projectManagerRepo;

	@InjectMocks
	private ProjectManagerService projectManagerService;	// the real one to assert
	
	@Test
	public void getProjectManagerByUserNameTest() throws ProjectManagerNotFoundException{
		String username1 = "user1";
		ProjectManager projectManager = null;
		
		// test ProjectManager object -- for correct
		projectManager = new ProjectManager();
		projectManager.setId(1);
		projectManager.setName("raghav");	// any username available in database
		projectManager.setPassword("raghav123");
		projectManager.setProjectName("Audit Management");
		when(projectManagerRepo.getProjectManagerByUserName(username1)).thenReturn(projectManager);
		assertEquals(projectManager, projectManagerService.getProjectManagerByUserName(username1));
		
		
		// test ProjectManager object -- for wrong
		final String username2 = "invalidUser1";
		projectManager = null;
		when(projectManagerRepo.getProjectManagerByUserName(username2)).thenThrow(ProjectManagerNotFoundException.class);
		
		
		assertThrows(ProjectManagerNotFoundException.class, ()-> projectManagerService.getProjectManagerByUserName(username2));
		
	}

}
