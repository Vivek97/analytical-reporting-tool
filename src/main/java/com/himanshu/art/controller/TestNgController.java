package com.himanshu.art.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himanshu.art.entity.Suite;
import com.himanshu.art.service.TestNgService;

@Controller
public class TestNgController {

	@Autowired
	private TestNgService testNgService;

	@ModelAttribute("Suite")
	public Suite construct() {
		return new Suite();
	}

	/*
	 * @RequestMapping("/testsuite") public String build(Model model){
	 * System.out.println(" are aa gaya  controller me"); List<Suite>
	 * sut=testNgService.findAll(); System.out.println(sut.get(0).getName());
	 * model.addAttribute("Suite", testNgService.findAll()); //
	 * System.out.println("done with controller"+ testNgService.findAll());
	 * 
	 * 
	 * return "testsuite"; }
	 */

	@RequestMapping("/build")
	public String build(Model model) {
		model.addAttribute("suiteList", testNgService.getAllSuite());
		return "build";
	}
	
	@RequestMapping("/build/{name}")
	public String detail(Model model,@PathVariable String name){
		System.out.println("name come1 "+name);
		model.addAttribute("testList1",testNgService.getAllTest(name));
		System.out.println("name come "+name);
		return "testdetails";
	}
	
/*	@RequestMapping("/build/{}")
	public String build1(Model model) {
		model.addAttribute("suiteList", testNgService.getAllSuite());
		return "build";
	}
*/

	@RequestMapping("/testdetails/{name}")
	public String testdetails(Model model,@PathVariable String name) {

		System.out.println("  class           name                "+name);

		model.addAttribute("classList",
				testNgService.getAllClass(name));
	return "classdetails";
	}
	@RequestMapping("/testdetails")
	public String testdetails(Model model) {

		 model.addAttribute("testList",testNgService.getAllTest("Default suite"));

		model.addAttribute("methodlist", testNgService
				.getSuiteLevelClassDetails("Primary suite", "PASS"));
		return "testdetails";
	}

	@RequestMapping("/classdetails")
	public String classdetails(Model model) {

		model.addAttribute("classList",
				testNgService.getAllClass("Default test"));
		model.addAttribute("methodlist",
				testNgService.getTestLevelClassDetails("First test", "TOTAL"));
		return "classdetails";
	}

	@RequestMapping("/testngdashboard")
	public String testngDetails(Model model) {
	model.addAttribute("stable",testNgService.getStableTestCases());
	model.addAttribute("unstable",testNgService.getUnStableTestCases());
	model.addAttribute("skipped",testNgService.getSkippedTestCases());
	model.addAttribute("duration",testNgService.getLongDurationTestCases());
		model.addAttribute("projectTotal", testNgService.getProjectStatus());
		return "testngdashboard";
	}

	/*
	 * @RequestMapping("/testsuite") public String build(Model model){
	 * System.out.println(" are aa gaya  controller me"); List<Suite>
	 * sut=testNgService.findAll(); System.out.println(sut.get(0).getName());
	 * model.addAttribute("Suite",
	 * testNgService.findBySuiteNameservice("Default")); Suite
	 * s=testNgService.findBySuiteNameservice("Default");
	 * System.out.println(" Suite  "+s.getSuite_id() );
	 * 
	 * System.out.println("done with controller"+ testNgService.findAll());
	 * 
	 * 
	 * return "testsuite"; }
	 */

	/*
	 * @RequestMapping("/users/{id}") public String detail(Model
	 * model,@PathVariable int id){ model.addAttribute("user",
	 * userService.findOneWithBlogs(id)); return "user-detail"; }
	 */

	/*
	 * @RequestMapping("/testsuite") public String build(Model model){
	 * //System.out.println(" are aa gaya  controller me "+userName); Suite
	 * sut=testNgService.findBySuiteNameservice("Default"); List<Integer>
	 * tid=testNgService.findTestIdBySuiteId(sut.getSuite_id());
	 * 
	 * 
	 * model.addAttribute("Suite",
	 * testNgService.findBySuiteNameservice("Default")); Suite
	 * s=testNgService.findBySuiteNameservice("Default");
	 * System.out.println(" Suite  "+s.getSuite_id() );
	 * 
	 * model.addAttribute("Suite_result",testNgService.query1("Default")); //
	 * System.out.println("done with controller"+
	 * testNgService.query1("Default"));
	 * 
	 * return "testsuite"; }
	 */

	/*
	 * @RequestMapping("/testsuite") public String build(Model model){
	 * //System.out.println(" are aa gaya  controller me "+userName); Suite
	 * sut=testNgService.findBySuiteNameservice("Default"); List<Integer>
	 * tid=testNgService.findTestIdBySuiteId(sut.getSuite_id());
	 * 
	 * 
	 * model.addAttribute("Suite",
	 * testNgService.findBySuiteNameservice("Default")); Suite
	 * s=testNgService.findBySuiteNameservice("Default");
	 * System.out.println(" Suite  "+s.getSuite_id() );
	 * 
	 * // System.out.println("done with controller"+
	 * testNgService.query1("Default"));
	 * 
	 * return "testsuite"; }
	 */

	/*
	 * @RequestMapping("/testSuite") public String users(Model model){
	 * 
	 * System.out.println(" are aa gaya  controller me");
	 * model.addAttribute("Suite", testNgService.findAll());
	 * System.out.println("done with controller"); return "users"; }
	 */

	/*
	 * @ModelAttribute("testingresult") public TestingResult construct(){ return
	 * new TestingResult(); }
	 * 
	 * 
	 * @RequestMapping("/testing-result") public String test
	 * 
	 * 
	 * @ModelAttribute("testingresult") public TestingResult
	 * testingresultconstruct(){ return new TestingResult(); }
	 * 
	 * @RequestMapping("/testing-results") public String fetchtestresult(Model
	 * model){
	 * model.addAttribute("testingresult",testNgService.fetchtestresult());
	 * return "testingresult"; }
	 * 
	 * @ModelAttribute("user") public User construct(){ return new User(); }
	 * 
	 * @RequestMapping("/users") public String users(Model model){
	 * model.addAttribute("user", userService.findAll()); return "users"; }
	 * 
	 * @RequestMapping("/users/{id}") public String detail(Model
	 * model,@PathVariable int id){ model.addAttribute("user",
	 * userService.findOneWithBlogs(id)); return "user-detail"; }
	 * 
	 * @RequestMapping("/register") public String showRegister(){ return
	 * "user-register"; }
	 * 
	 * @RequestMapping(value="/register", method=RequestMethod.POST) public
	 * String doRegister(@ModelAttribute("user") User user){
	 * userService.save(user); return "redirect:/register.html?success=true"; }
	 */

	/*
	 * ---------------------------------------------------------------------
	 */
	/*
	 * @Autowired private TestNgService testNgService;
	 * 
	 * @Autowired private UserService userService;
	 * 
	 * @RequestMapping("/build") public String build() { return "build"; }
	 * 
	 * @RequestMapping("/testdetails") public String testdetails() { return
	 * "testdetails"; }
	 * 
	 * @RequestMapping("/classdetails") public String classdetails() { return
	 * "classdetails"; }
	 * 
	 * @RequestMapping("/testngbuild") public String testngbuild() { return
	 * "testngbuild"; }
	 * 
	 * @RequestMapping("/testngtest") public String testngtest() { return
	 * "testngtest"; }
	 * 
	 * @RequestMapping("/testngdashboard") public String testngdashboard() {
	 * return "testngdashboard"; }
	 */

}
