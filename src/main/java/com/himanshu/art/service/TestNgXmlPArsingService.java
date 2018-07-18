package com.himanshu.art.service;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.himanshu.art.entity.MyClass;
import com.himanshu.art.entity.MyException;
import com.himanshu.art.entity.Suite;
import com.himanshu.art.entity.Test;
import com.himanshu.art.entity.TestMethod;
import com.himanshu.art.entity.TestingResult;
import com.himanshu.art.entity.projectDetail;

@Service
public class TestNgXmlPArsingService {

	public List<TestingResult> getparseData()
			throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = null;
		try {
			File xmlFile = new File("xml_file\\testng-results.xml");
			doc = builder.parse(xmlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<TestingResult> test_list = new ArrayList<TestingResult>();
		NodeList nodeList = doc.getElementsByTagName("testng-results");
		projectDetail pro = new projectDetail();
		pro.setProject_id(101);
		pro.setPro_name("verizon");
		TestNgXmlPArsingService tservice = new TestNgXmlPArsingService();
		test_list = tservice.getTestingResult(nodeList, pro);
		return test_list;
	}

	public List<TestingResult> getTestingResult(NodeList testNodeList,
			projectDetail pro) {
		List<TestingResult> list = new ArrayList<TestingResult>();
		if (testNodeList != null) {
			int length = testNodeList.getLength();
			for (int i = 0; i < length; i++) {
				Node node = testNodeList.item(i);
				TestingResult tst = new TestingResult();
				if (node instanceof Element) {
					try {
						tst.setFailed(Integer.parseInt(node.getAttributes()
								.getNamedItem("failed").getNodeValue()));

						tst.setPassed(Integer.parseInt(node.getAttributes()
								.getNamedItem("passed").getNodeValue()));

						tst.setSkipped(Integer.parseInt(node.getAttributes()
								.getNamedItem("skipped").getNodeValue()));

						tst.setTotal(Integer.parseInt(node.getAttributes()
								.getNamedItem("total").getNodeValue()));
						tst.setPro(pro);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {

						tst.setSuiteList(getSuiteDetails(
								((Element) node).getElementsByTagName("suite"),
								tst));
					} catch (Exception e) {
						e.printStackTrace();
					}
					list.add(tst);
				}
			}
		}
		return list;
	}

	public List<Suite> getSuiteDetails(NodeList suitelist, TestingResult tst) {
		List<Suite> list = new ArrayList<Suite>();
		if (suitelist != null) {
			int length = suitelist.getLength();
			for (int i = 0; i < length; i++) {
				Node node = suitelist.item(i);
				Suite sut = new Suite();
				if (node instanceof Element) {

					try {
						sut.setDuration_ms(Integer.parseInt(node
								.getAttributes().getNamedItem("duration-ms")
								.getNodeValue()));

						String s = node.getAttributes()
								.getNamedItem("started-at").getNodeValue();
						sut.setStarted_at(getFormattedDate(s));
						
						sut.setName(node.getAttributes().getNamedItem("name")
								.getNodeValue());
						s = node.getAttributes().getNamedItem("finished-at")
								.getNodeValue();
						sut.setFinished_at(getFormattedDate(s));

						
							sut.setTestlist(getTestDetails(((Element) node)
									.getElementsByTagName("test"), sut));
						

					} catch (Exception e) {
						e.printStackTrace();
					}
					list.add(sut);
				}
			}
		}
		return list;
	}

	public Timestamp getFormattedDate(String str) throws ParseException {
		java.util.Date parsedUtilDate;
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
		parsedUtilDate = formater.parse(str);
		java.sql.Timestamp time=new java.sql.Timestamp(parsedUtilDate.getTime());
	//	java. sqltDate = new java.sql.Date(parsedUtilDate.getTime());
		return time;
	}

	public List<Test> getTestDetails(NodeList testlist, Suite sut) {
		List<Test> list = new ArrayList<Test>();
		if (testlist != null) {
			int length = testlist.getLength();
			for (int i = 0; i < length; i++) {
				Node node = testlist.item(i);
				Test tst = new Test();
				if (node instanceof Element) {
					try {
						tst.setDuration_ms(Integer.parseInt(node
								.getAttributes().getNamedItem("duration-ms")
								.getNodeValue()));
						String s = node.getAttributes()
								.getNamedItem("finished-at").getNodeValue();
						tst.setFinished_at(getFormattedDate(s));
						s = node.getAttributes().getNamedItem("started-at")
								.getNodeValue();
						tst.setStarted_at(getFormattedDate(s));
						tst.setName(node.getAttributes().getNamedItem("name")
								.getNodeValue());
						

						tst.setClsList(getClassDetails(
								((Element) node).getElementsByTagName("class"),
								tst));
					} catch (Exception e) {
						e.printStackTrace();
					}
					list.add(tst);
				}
			}
		}
		return list;
	}

	public ArrayList<MyClass> getClassDetails(NodeList myclasslist, Test tst) {
		ArrayList<MyClass> list = new ArrayList<MyClass>();
		if (myclasslist != null) {
			int length = myclasslist.getLength();
			for (int i = 0; i < length; i++) {
				Node node = myclasslist.item(i);
				MyClass mycls = new MyClass();
				if (node instanceof Element) {
					try {
						mycls.setName(((Element) node).getAttributes()
								.getNamedItem("name").getNodeValue());

						mycls.setTestMethod(getTestMethodDetails(
								((Element) node)
										.getElementsByTagName("test-method"),
								mycls));
					} catch (Exception e) {
						e.printStackTrace();
					}
					list.add(mycls);
				}
			}
		}
		return list;
	}

	public List<TestMethod> getTestMethodDetails(NodeList tstmethodList,
			MyClass mycls) {
		List<TestMethod> list = new ArrayList<TestMethod>();
		if (tstmethodList != null) {
			int length = tstmethodList.getLength();
			for (int i = 0; i < length; i++) {
				Node node = tstmethodList.item(i);
				TestMethod tst = new TestMethod();
				if (node instanceof Element) {
					try {
						tst.setDuration_ms(Integer.parseInt(node
								.getAttributes().getNamedItem("duration-ms")
								.getNodeValue()));
						tst.setStatus(node.getAttributes()
								.getNamedItem("status").getNodeValue());
						tst.setSignature(node.getAttributes()
								.getNamedItem("signature").getNodeValue());
						tst.setName(node.getAttributes().getNamedItem("name")
								.getNodeValue());
						String s = node.getAttributes()
								.getNamedItem("started-at").getNodeValue();
						tst.setStarted_at(getFormattedDate(s));
						s = node.getAttributes().getNamedItem("finished-at")
								.getNodeValue();
						tst.setFinished_at(getFormattedDate(s));
						tst.setExceptionList(getMyExceptionList(
								((Element) node)
										.getElementsByTagName("exception"), tst));
					} catch (Exception e) {
						e.printStackTrace();
					}
					list.add(tst);
				}
			}
		}
		return list;
	}

	public List<MyException> getMyExceptionList(NodeList excpList,
			TestMethod tst) {
		List<MyException> list = new ArrayList<MyException>();
		if (excpList != null) {
			int length = excpList.getLength();
			for (int i = 0; i < length; i++) {
				Node node = excpList.item(i);
				MyException myexc = new MyException();
				if (node instanceof Element) {
					try {
						myexc.setCls(node.getAttributes().getNamedItem("class")
								.getNodeValue());
						/*
						NodeList msg = ((Element) node)
								.getElementsByTagName("message");

						Element emt = (Element) msg.item(i);

						NodeList full_stack = ((Element) node)
								.getElementsByTagName("full-stacktrace");
						emt = (Element) full_stack.item(i);

*/						// Edited
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					list.add(myexc);
				}
			}
		}
		return list;
	}
}
