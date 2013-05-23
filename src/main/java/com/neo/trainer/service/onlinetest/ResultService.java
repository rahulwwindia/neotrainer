package com.neo.trainer.service.onlinetest;

import java.util.List;

import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.model.onlinetest.Results;
import com.neo.trainer.model.onlinetest.SearchResult;

public interface ResultService {
	
	public List<Results> getResult(SearchResult range);
	
}
