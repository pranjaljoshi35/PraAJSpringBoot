package com.dao;

import javax.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.CSVData;

@Component
public class CSVDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(CSVData t)
	{
		Integer i=(Integer) this.hibernateTemplate.save(t);
		return i;
	}
	
	public List<CSVData> getAll()
	{
		
		List<CSVData> rows=	this.hibernateTemplate.loadAll(CSVData.class);
		return rows;
	}
	
}
