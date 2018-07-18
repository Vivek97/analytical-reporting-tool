package com.himanshu.art.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.validation.groups.Default;









import org.hibernate.mapping.Collection;
import org.hsqldb.types.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himanshu.art.entity.MyClass;
import com.himanshu.art.entity.Suite;
import com.himanshu.art.entity.Test;
import com.himanshu.art.entity.TestMethod;
import com.himanshu.art.repository.Class_testMethodRepository;
import com.himanshu.art.repository.MyClassRepository;
import com.himanshu.art.repository.MyExceptionRepository;
import com.himanshu.art.repository.SuiteRepository;
import com.himanshu.art.repository.Suite_Test_Repository;
import com.himanshu.art.repository.TestMethodRepository;
import com.himanshu.art.repository.TestRepository;
import com.himanshu.art.repository.TestingResultRepository;
import com.himanshu.art.repository.projectDetailRepository;
import com.himanshu.art.repository.test_ClassRepository;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Service
@Transactional
public class TestNgService {
	@Autowired
	private SuiteRepository suiterepository;
	
	@Autowired
	private MyClassRepository myClassRepository;

	@Autowired
	private MyExceptionRepository myExceptionRepository;

	@Autowired
	private projectDetailRepository projectdetailRepository;

	@Resource
	private TestingResultRepository testingResultRepository;

	@Autowired
	private TestMethodRepository testMethodRepository;

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private Suite_Test_Repository suite_Test_Repository;
	
	@Autowired
	private test_ClassRepository test_ClassRepository;
	
	@Autowired
	private Class_testMethodRepository class_testMethodRepository;
	
	@Transactional
	public List<Suite> findAll() {
		System.out.println("service layer");
		return suiterepository.findAll();
		
	}
	
	public Suite findBySuiteNameservice(String name)
	{
		System.out.println("named query");
		
	return suiterepository.findBySuiteName(name);
	}
	

	public List<ArrayList<String>> getAllSuite()
	{
		 List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		List<Suite> suite_list=suiterepository.findAll();
		for(Suite s:suite_list)
		{
			List<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			 for(Test t:s.getTestlist())
			    {
				for(MyClass c:t.getClsList())
				{
				
					for(TestMethod tm:c.getTestMethod())
					{
						total++;
						
						if(tm.getStatus().equals("PASS"))
						        pass++;
						
						else if(tm.getStatus().equals("FAIL"))
						       fail++;
						
						else if(tm.getStatus().equals("SKIP"))
							   skip++;
					}
				}
			}
		
			 
				temp.add(s.getName());
				temp.add((s.getStarted_at()).toString());
				temp.add((s.getFinished_at()).toString());
				temp.add(String.valueOf(s.getDuration_ms()));
				temp.add(Integer.toString(pass));
				temp.add(Integer.toString(fail));
				temp.add(Integer.toString(skip));
				temp.add(Integer.toString(total));
				result.add((ArrayList<String>) temp);
		}
		
		
		return result;
		
	}
	
	
	public List<ArrayList<String>> getAllTest(String suite_name)
	{
		 List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		Suite new_suite=suiterepository.findBySuiteName(suite_name);
		for(Test t:new_suite.getTestlist())
		{
			List<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			
			for(MyClass c:t.getClsList())
			{
			
				for(TestMethod tm:c.getTestMethod())
				{
					total++;
					
					if(tm.getStatus().equals("PASS"))
					        pass++;
					
					else if(tm.getStatus().equals("FAIL"))
					       fail++;
					
					else if(tm.getStatus().equals("SKIP"))
						   skip++;
				}
			}
			temp.add(t.getName());
			temp.add((t.getStarted_at()).toString());
			temp.add((t.getFinished_at()).toString());
			temp.add(String.valueOf(t.getDuration_ms()));
			temp.add(Integer.toString(pass));
			temp.add(Integer.toString(fail));
			temp.add(Integer.toString(skip));
			temp.add(Integer.toString(total));
			result.add((ArrayList<String>) temp);
		
		}
		
		return result;
		
		
	}
	
	public List<ArrayList<String>> getAllClass(String test_name)
	{
		List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		Test new_test=testRepository.FetchAllTestDetails(test_name);
		for(MyClass c:new_test.getClsList())
			{
			
			List<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			
			for(TestMethod tm:c.getTestMethod())
			{
				total++;
				
				if(tm.getStatus().equals("PASS"))
				        pass++;
				
				else if(tm.getStatus().equals("FAIL"))
				       fail++;
				
				else if(tm.getStatus().equals("SKIP"))
					   skip++;
			}
		
		temp.add(c.getName());   	
		temp.add(Integer.toString(pass));
		temp.add(Integer.toString(fail));
		temp.add(Integer.toString(skip));
		temp.add(Integer.toString(total));
		result.add((ArrayList<String>) temp);
		
			
		
	}
		return result;
	}
	
	
	
	public List<ArrayList<String>> getSuiteLevelClassDetails(String suite_name,String status)
	{
	
		
		 List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
			Suite new_suite=suiterepository.findBySuiteName(suite_name);
			for(Test t:new_suite.getTestlist())
			{
				
				
				for(MyClass c:t.getClsList())
				{
					List<String> temp=new ArrayList<String>();
				
				
					for(TestMethod tm:c.getTestMethod())
					{
						int i=0;
						
						if(status.equalsIgnoreCase(tm.getStatus()))
						{
							i=1;
								}
						else if(status.equalsIgnoreCase("total"))
						{
							i=1;
						}
			

						if(i==1)
						{
							temp.add(c.getName());
							temp.add(tm.getName());
							temp.add((tm.getStarted_at()).toString());
							temp.add((tm.getFinished_at()).toString());
							temp.add(String.valueOf(tm.getDuration_ms()));
							temp.add(status);

						}
					}
					
					result.add((ArrayList<String>) temp);
				}
			
				
			}
			
			return result;
	}
	
	
	public List<ArrayList<String>> getTestLevelClassDetails(String test_name,String status)
	{
		List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		Test new_test=testRepository.FetchAllTestDetails(test_name);
		for(MyClass c:new_test.getClsList())
		{
			List<String> temp=new ArrayList<String>();
			
				for(TestMethod tm:c.getTestMethod())
				{
					int i=0;
					
					if(status.equalsIgnoreCase(tm.getStatus()))
					{
						i=1;
							}
					else if(status.equalsIgnoreCase("total"))
					{
						i=1;
					}
		

					if(i==1)
					{
						temp.add(c.getName());
						temp.add(tm.getName());
						temp.add((tm.getStarted_at()).toString());
						temp.add((tm.getFinished_at()).toString());
						temp.add(String.valueOf(tm.getDuration_ms()));
						temp.add(tm.getStatus());

					}
				}
				
				result.add((ArrayList<String>) temp);
			}
		
		
		
		
		return result;
		
		
	}
	
	
	public List<String> getProjectStatus()
	{
		List<String> temp=new ArrayList<String>();
		int pass=0,fail=0,skip=0,total=0;
		List<Test> test_list=testRepository.findAll();
		for(Test t:test_list)
			{
			
		
		
			
			for(MyClass c:t.getClsList())
			{
			
				for(TestMethod tm:c.getTestMethod())
				{
					total++;
					
					if(tm.getStatus().equals("PASS"))
					        pass++;
					
					else if(tm.getStatus().equals("FAIL"))
					       fail++;
					
					else if(tm.getStatus().equals("SKIP"))
						   skip++;
				}
			}
		}
		

		temp.add(Integer.toString(pass));
		temp.add(Integer.toString(fail));
		temp.add(Integer.toString(skip));
		temp.add(Integer.toString(total));
		
		return temp;	    
		
	}
	 private Sort sortByDurationAsc() {
		String duration= "duration";
		System.out.println("doorie aa gayi          "+duration);
	        return new Sort(Sort.Direction.ASC,duration);
	    }
	
	public List<ArrayList<String>> getUnStableTestCases()
	{
		List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		List<Test> test_list=testRepository.findAll();
	
		for(Test t:test_list)
		{
			List<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			
			for(MyClass c:t.getClsList())
			{
			
				for(TestMethod tm:c.getTestMethod())
				{
					total++;
					
					if(tm.getStatus().equals("PASS"))
					        pass++;
					
					else if(tm.getStatus().equals("FAIL"))
					       fail++;
					
					else if(tm.getStatus().equals("SKIP"))
						   skip++;
				}
			}
			temp.add(t.getName());
			temp.add((t.getStarted_at()).toString());
			temp.add((t.getFinished_at()).toString());
			temp.add(String.valueOf(t.getDuration_ms()));
			temp.add(Integer.toString(pass));
			temp.add(Integer.toString(fail));
			temp.add(Integer.toString(skip));
			temp.add(Integer.toString(total));
			result.add((ArrayList<String>) temp);
		
		}
		
		Collections.sort(result, new Comparator<ArrayList<String>>() {
			public int compare(ArrayList<String> o1,ArrayList<String> o2)
			{
				
				return Integer.parseInt(o1.get(4))-Integer.parseInt(o2.get(4));
				
			}
			
		});

	
		Collections.reverse(result);
		return result;
				
	}
	
	

	public List<ArrayList<String>> getStableTestCases()
	{
		List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		List<Test> test_list=testRepository.findAll();
		
		
		for(Test t:test_list)	
		{
			TreeMap<Integer,ArrayList<String>> tree=new TreeMap<Integer,ArrayList<String>>();
			ArrayList<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			
			for(MyClass c:t.getClsList())
			{
			
				for(TestMethod tm:c.getTestMethod())
				{
					total++;
					
					if(tm.getStatus().equals("PASS"))
					        pass++;
					
					else if(tm.getStatus().equals("FAIL"))
					       fail++;
					
					else if(tm.getStatus().equals("SKIP"))
						   skip++;
				}
			}
			
			temp.add(t.getName());
			temp.add((t.getStarted_at()).toString());
			temp.add((t.getFinished_at()).toString());
			temp.add(String.valueOf(t.getDuration_ms()));
			temp.add(Integer.toString(pass));
			temp.add(Integer.toString(fail));
			temp.add(Integer.toString(skip));
			temp.add(Integer.toString(total));
			
			tree.put(pass, temp);
			
		System.out.println("Tree         "+tree);	
			result.add((ArrayList<String>) temp);
	
			
		
		}
		Collections.sort(result, new Comparator<ArrayList<String>>() {
			public int compare(ArrayList<String> o1,ArrayList<String> o2)
			{
				System.out.println(" parse    "+Integer.parseInt(o1.get(5)));
				return Integer.parseInt(o1.get(5))-Integer.parseInt(o2.get(5));
				
			}
			
		});
		return result;
				
	}
	
	
	
	public List<ArrayList<String>> getSkippedTestCases()
	{
		List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		List<Test> test_list=testRepository.findAll();
		
		
		for(Test t:test_list)	
		{
			TreeMap<Integer,ArrayList<String>> tree=new TreeMap<Integer,ArrayList<String>>();
			ArrayList<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			
			for(MyClass c:t.getClsList())
			{
			
				for(TestMethod tm:c.getTestMethod())
				{
					total++;
					
					if(tm.getStatus().equals("PASS"))
					        pass++;
					
					else if(tm.getStatus().equals("FAIL"))
					       fail++;
					
					else if(tm.getStatus().equals("SKIP"))
						   skip++;
				}
			}
			
			temp.add(t.getName());
			temp.add((t.getStarted_at()).toString());
			temp.add((t.getFinished_at()).toString());
			temp.add(String.valueOf(t.getDuration_ms()));
			temp.add(Integer.toString(pass));
			temp.add(Integer.toString(fail));
			temp.add(Integer.toString(skip));
			temp.add(Integer.toString(total));
			
			tree.put(pass, temp);
			
		System.out.println("Tree         "+tree);	
			result.add((ArrayList<String>) temp);
	
			
		
		}
		Collections.sort(result, new Comparator<ArrayList<String>>() {
			public int compare(ArrayList<String> o1,ArrayList<String> o2)
			{
				
				return Integer.parseInt(o1.get(6))-Integer.parseInt(o2.get(6));
				
			}
			
		});
		return result;
				
	}
	
	public List<ArrayList<String>> getLongDurationTestCases()
	{
		List<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		List<Test> test_list=testRepository.findAll(new Sort(Sort.Direction.DESC,"duration"));
		
		
		for(Test t:test_list)	
		{
			TreeMap<Integer,ArrayList<String>> tree=new TreeMap<Integer,ArrayList<String>>();
			ArrayList<String> temp=new ArrayList<String>();
			int pass=0,fail=0,skip=0,total=0;
			
			for(MyClass c:t.getClsList())
			{
			
				for(TestMethod tm:c.getTestMethod())
				{
					total++;
					
					if(tm.getStatus().equals("PASS"))
					        pass++;
					
					else if(tm.getStatus().equals("FAIL"))
					       fail++;
					
					else if(tm.getStatus().equals("SKIP"))
						   skip++;
				}
			}
			
			temp.add(t.getName());
			temp.add((t.getStarted_at()).toString());
			temp.add((t.getFinished_at()).toString());
			temp.add(String.valueOf(t.getDuration_ms()));
			temp.add(Integer.toString(pass));
			temp.add(Integer.toString(fail));
			temp.add(Integer.toString(skip));
			temp.add(Integer.toString(total));
			
			tree.put(pass, temp);
			
		System.out.println("Tree         "+tree);	
			result.add((ArrayList<String>) temp);
	
			
		
		}
	
		return result;
				
	}
	
	
	
	
	

	public List<Integer> findTestIdBySuiteId(Integer sid)
	{
		System.out.println("getting testid");

		return suite_Test_Repository.FindTest_idBySuite_ID(sid);
	}
	
	public List<Integer> findClassIdByTestIdService(List<Integer> tid)
	{
		
		return test_ClassRepository.FindClassIdByTestId(tid);
	}
	
	
	public List<Integer> findMethodIdByClassIdService(List<Integer> cid)
	{
		return class_testMethodRepository.FindMethodIdByClassId(cid);
	}
	
	public Test findTestByTestNameService(String test_name)
	{
		
		
		return testRepository.FetchAllTestDetails(test_name);
		
	}
	
	
	public List<String> query1(String name)
	{
		List<String> temp=new ArrayList<String>();
		Suite sut=findBySuiteNameservice(name);
		List<Integer> test_idList=findTestIdBySuiteId(sut.getSuite_id());
		List<Integer> class_idList=findClassIdByTestIdService(test_idList);
		List<Integer> methodIdList=findMethodIdByClassIdService(class_idList);
		List<TestMethod> methodDetails =testMethodRepository.findAll(methodIdList);
		Iterator itr=methodDetails.iterator();
		int pass=0,fail=0,skip=0,total=0;
		for(TestMethod tm:methodDetails)
		{
			total++;
			
			if(tm.getStatus().equals("PASS"))
			        pass++;
			
			else if(tm.getStatus().equals("FAIL"))
			       fail++;
			
			else if(tm.getStatus().endsWith("SKIP"))
				   skip++;
			
		}
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String obj1 = df.format(sut.getStarted_at());
		
		 
		temp.add(sut.getName());
		temp.add(df.format(sut.getStarted_at()));
		temp.add(df.format(sut.getFinished_at()));
		temp.add(String.valueOf(sut.getDuration_ms()));
		temp.add(Integer.toString(pass));
		temp.add(Integer.toString(fail));
		temp.add(Integer.toString(skip));
		temp.add(Integer.toString(total));
		
		for(String s:temp)
			System.out.println("       "+ s);
		return temp;
	}

	
	
	
	public List<String> query2(String name)
	{
		List<String> temp=new ArrayList<String>();
		Test new_test=findTestByTestNameService(name);
		List<Integer> test_idList=new ArrayList<>();
		test_idList.add(new_test.getTest_id());
		List<Integer> class_idList=findClassIdByTestIdService(test_idList);
		List<Integer> methodIdList=findMethodIdByClassIdService(class_idList);
		List<TestMethod> methodDetails =testMethodRepository.findAll(methodIdList);
		Iterator itr=methodDetails.iterator();
		int pass=0,fail=0,skip=0,total=0;
		for(TestMethod tm:methodDetails)
		{
			total++;
			
			if(tm.getStatus().equals("PASS"))
			        pass++;
			
			else if(tm.getStatus().equals("FAIL"))
			       fail++;
			
			else if(tm.getStatus().endsWith("SKIP"))
				   skip++;
			
		}
		
		/*DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String obj1 = df.format(sut.getStarted_at());
		
		 
		temp.add(sut.getName());
		temp.add(df.format(sut.getStarted_at()));
		temp.add(df.format(sut.getFinished_at()));
		temp.add(String.valueOf(sut.getDuration_ms()));
		temp.add(Integer.toString(pass));
		temp.add(Integer.toString(fail));
		temp.add(Integer.toString(skip));
		temp.add(Integer.toString(total));
		*/
		for(String s:temp)
			System.out.println("       "+ s);
		return temp;
	}
	
	
/*	@Autowired
	private MyClassRepository myClassRepository;

	@Autowired
	private MyExceptionRepository myExceptionRepository;

	@Autowired
	private projectDetailRepository projectdetailRepository;

	@Autowired
	private SuiteRepository suiteRepository;

	@Resource
	private TestingResultRepository testingResultRepository;

	@Autowired
	private TestMethodRepository testMethodRepository;

	@Autowired
	private TestRepository testRepository;

		
	@Transactional
	public TestingResult findByTestngResultID(int id){
		return testingResultRepository.findByTestngResultID(id);
	}
	
	@Transactional
	public List<TestingResult> fetchtestresult() {
		return testingResultRepository.fetchAllTestngResultDetails();
	}
	
	

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(
					0, 20, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

*/}
