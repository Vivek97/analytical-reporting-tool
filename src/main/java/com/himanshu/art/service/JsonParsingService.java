package com.himanshu.art.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.himanshu.art.entity.Arguments;
import com.himanshu.art.entity.Element;
import com.himanshu.art.entity.Embedding;
import com.himanshu.art.entity.Feature;
import com.himanshu.art.entity.Match;
import com.himanshu.art.entity.Result;
import com.himanshu.art.entity.Step;

@Service
public class JsonParsingService {

	public Feature getJsonDetails() throws IOException, ParseException {

		FileReader reader;
		JSONParser jsonParser = new JSONParser();
		Feature feature = new Feature();
		try {
			JSONObject jsonObject;
			reader = new FileReader("json_file\\cucumberAA.json");
			jsonObject = (JSONObject) jsonParser.parse(reader);

			feature.setFeature_id((String) jsonObject.get("id"));
			feature.setDescription((String) jsonObject.get("description"));
			feature.setName((String) jsonObject.get("name"));
			feature.setKeyword((String) jsonObject.get("keyword"));
			feature.setLine((Long) jsonObject.get("line"));

			JSONArray ele = (JSONArray) jsonObject.get("elements");
			Element element = null;
			Iterator i = ele.iterator();
			while (i.hasNext()) {
				element = new Element();
				JSONObject innerObjElement = (JSONObject) i.next();
				element.setDescription((String) innerObjElement
						.get("description"));
				element.setName((String) innerObjElement.get("name"));
				element.setKeyword((String) innerObjElement.get("keyword"));
				element.setLine((Long) innerObjElement.get("line"));

				JSONArray stp = (JSONArray) innerObjElement.get("steps");
				Step step = null;
				Iterator a = stp.iterator();
				while (a.hasNext()) {
					step = new Step();
					JSONObject innerObjSteps = (JSONObject) a.next();
					step.setKeyword((String) innerObjSteps.get("keyword"));
					step.setName((String) innerObjSteps.get("name"));
					step.setLine((Long) innerObjSteps.get("line"));

					Result result = new Result();
					JSONObject innerObjResult = (JSONObject) innerObjSteps
							.get("result");
					result.setDuration((Long) innerObjResult.get("duration"));
					result.setStatus((String) innerObjResult.get("status"));
					result.setError_message((String) innerObjResult
							.get("error_message"));
					step.setResult(result);

					JSONObject innerObjMatch = (JSONObject) innerObjSteps
							.get("match");
					Match mtch = new Match();
					mtch.setLocation((String) innerObjMatch.get("location"));

					Arguments arg = null;
					if (innerObjMatch.get("arguments") != null) {
						JSONArray argument = (JSONArray) innerObjMatch
								.get("arguments");
						Iterator argu = argument.iterator();

						while (argu.hasNext()) {
							arg = new Arguments();
							JSONObject innerObjArguments = (JSONObject) argu
									.next();
							arg.setVal((String) innerObjArguments.get("val"));
							arg.setOffset((Long) innerObjArguments
									.get("offset"));
							mtch.setArguments(arg);
						}
					}

					Embedding embedding = null;
					if (innerObjSteps.get("embeddings") != null) {
						JSONArray emb = (JSONArray) innerObjSteps
								.get("embeddings");
						embedding = new Embedding();
						Iterator em = emb.iterator();
						while (em.hasNext()) {
							JSONObject innerObjEmbedding = (JSONObject) em
									.next();
							embedding.setData((String) innerObjEmbedding
									.get("data"));

						}
					}

					step.setMatch(mtch);
					step.setEmbeddingList(embedding);
					element.setStepList(step);
				}

				feature.setElementList(element);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return feature;
	}

}
