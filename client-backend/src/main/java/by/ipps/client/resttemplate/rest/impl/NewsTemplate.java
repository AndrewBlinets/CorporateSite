package by.ipps.client.resttemplate.rest.impl;

import by.ipps.client.entity.News;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.rest.NewsRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsTemplate extends AbstractBaseEntityRestTemplate<News>
    implements NewsRestTemplate {}
