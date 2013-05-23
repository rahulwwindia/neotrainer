package com.neo.trainer.service.dashboard;

import java.util.List;

import com.neo.trainer.model.admin.Technologies;
import com.neo.trainer.model.article.Article;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.deshboard.Dashboard;
import com.neo.trainer.model.onlinetest.Questions;

public interface DashboardService {
	public List<Posts> getPosts();
	public List<Article> getArticles(); 
	public List<Technologies> getTechnologies();
	public List<Questions> getOnlineTest();
	public void saveDashOption(String topics);
	public List<Dashboard> getDashOption(); 
}
 