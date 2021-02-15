package by.ipps.client.resttemplate.rest.impl;

import by.ipps.client.entity.Project;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.rest.ProjectRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProjectTemplate extends AbstractBaseEntityRestTemplate<Project>
    implements ProjectRestTemplate {}
