package by.ipps.client.resttemplate.rest.impl;

import by.ipps.client.entity.Vacancy;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.rest.VacancyRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class VacancyTemplate extends AbstractBaseEntityRestTemplate<Vacancy>
    implements VacancyRestTemplate {}
