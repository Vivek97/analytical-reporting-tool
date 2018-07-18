package com.himanshu.art.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.himanshu.art.entity.Element;
import com.himanshu.art.entity.Step;
import com.himanshu.art.repository.ElementsRepository;
import com.himanshu.art.repository.FeatureRepository;
import com.himanshu.art.repository.ResultRepository;
import com.himanshu.art.repository.StepRepository;

public class JsonService {
	
	@Autowired
	private FeatureRepository featureRepository;

	@Autowired
	private ElementsRepository elementsRepository;
	
	@Autowired
	private StepRepository stepRepository;
	
	@Autowired
	private ResultRepository resultRepository;
	
	
	public List<ArrayList<String>> getAllElements()
	{
		List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		for(Element e:elementsRepository.findAll())
		{
			ArrayList<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			
			for(Step s:e.getStepList())
			{
				total++;
				
				if(s.getResult().equals("PASS"))
				        pass++;
				
				else if(s.getResult().equals("FAIL"))
				       fail++;
				
				else if(s.getResult().equals("SKIP"))
					   skip++;	
			}
		temp.add(e.getName());
		temp.add(e.getType());
		temp.add(e.getKeyword());
		temp.add(Integer.toString(pass));
		temp.add(Integer.toString(fail));
		temp.add(Integer.toString(skip));
		temp.add(Integer.toString(total));
		result.add(temp);
		}	
		
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
