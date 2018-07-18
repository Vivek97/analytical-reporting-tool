package com.himanshu.art.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.himanshu.art.entity.Blog;
import com.himanshu.art.entity.Feature;
import com.himanshu.art.entity.Item;
import com.himanshu.art.entity.Role;
import com.himanshu.art.entity.TestingResult;
import com.himanshu.art.entity.User;
import com.himanshu.art.entity.projectDetail;
import com.himanshu.art.repository.BlogRepository;
import com.himanshu.art.repository.FeatureRepository;
import com.himanshu.art.repository.ItemRepository;
import com.himanshu.art.repository.RoleRepository;
import com.himanshu.art.repository.TestingResultRepository;
import com.himanshu.art.repository.UserRepository;
import com.himanshu.art.repository.projectDetailRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private TestingResultRepository testingResultRepository;

	@Autowired
	private FeatureRepository featureRepository;

	@Autowired
	private projectDetailRepository projectdetailRepository;

	@PostConstruct
	public void init() {
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);

			User userAdmin = new User();
			userAdmin.setEnabled(true);
			userAdmin.setName("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleAdmin);
			roles.add(roleUser);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);

			Blog blogHimanshu = new Blog();
			blogHimanshu.setName("HIMANSHU");
			blogHimanshu.setUrl("http://himanshu.com");
			blogHimanshu.setUser(userAdmin);
			blogRepository.save(blogHimanshu);

			Item item1 = new Item();
			item1.setBlog(blogHimanshu);
			item1.setTitle("first");
			item1.setLink("http://www.himanshu.com");
			item1.setPublishedDate(new Date());
			itemRepository.save(item1);

			Item item2 = new Item();
			item2.setBlog(blogHimanshu);
			item2.setTitle("second");
			item2.setLink("http://www.hardik.com");
			item2.setPublishedDate(new Date());
			itemRepository.save(item2);

			Blog blogHimanshu1 = new Blog();
			blogHimanshu1.setName("HIMANSHU1");
			blogHimanshu1.setUrl("http://kunal.com");
			blogHimanshu1.setUser(userAdmin);
			blogRepository.save(blogHimanshu1);

		}

		if (roleRepository.findByName("ROLE_VERIZON") == null) {

			Role roleUserVerizon = new Role();
			roleUserVerizon.setName("ROLE_VERIZON");
			roleRepository.save(roleUserVerizon);

			User userVerizon = new User();
			userVerizon.setEnabled(true);
			userVerizon.setName("verizon");
			BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
			userVerizon.setPassword(encoder2.encode("verizon"));
			List<Role> roles2 = new ArrayList<Role>();
			roles2.add(roleUserVerizon);
			userVerizon.setRoles(roles2);
			userRepository.save(userVerizon);

			projectDetail prod = new projectDetail();
			prod.setProject_id(101);
			prod.setPro_name("Verizon");
			projectdetailRepository.save(prod);

			TestNgXmlPArsingService tng = new TestNgXmlPArsingService();
			try {
				List<TestingResult> tr = tng.getparseData();
				for (TestingResult testingResult : tr) {
					testingResultRepository.save(testingResult);
				}
			} catch (ParserConfigurationException e) {
				System.out.println("testng error");
			}

		}

		if (roleRepository.findByName("ROLE_PUMA") == null) {

			Role roleUserPuma = new Role();
			roleUserPuma.setName("ROLE_PUMA");
			roleRepository.save(roleUserPuma);

			User userPuma = new User();
			userPuma.setEnabled(true);
			userPuma.setName("puma");
			BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
			userPuma.setPassword(encoder1.encode("puma"));
			List<Role> roles1 = new ArrayList<Role>();
			roles1.add(roleUserPuma);
			userPuma.setRoles(roles1);
			userRepository.save(userPuma);

			projectDetail prod1 = new projectDetail();
			prod1.setProject_id(201);
			prod1.setPro_name("Puma");
			projectdetailRepository.save(prod1);

			JsonParsingService jsonlist = new JsonParsingService();
			try {
				Feature f = jsonlist.getJsonDetails();
				featureRepository.save(f);

			} catch (Exception e) {
				System.out.println("json error");
			}
		}
	}
}
