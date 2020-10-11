package by.ipps.client.resttemplate.rest;

import by.ipps.client.entity.News;
import by.ipps.client.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.stereotype.Component;

@Component
public interface NewsRestTemplate extends BaseEntityRestTemplate<News> {}
