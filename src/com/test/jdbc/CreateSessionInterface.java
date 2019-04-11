package com.test.jdbc;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public interface CreateSessionInterface {
	
	Session getSession();
	
}
