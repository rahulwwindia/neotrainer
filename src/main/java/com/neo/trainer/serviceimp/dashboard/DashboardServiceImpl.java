package com.neo.trainer.serviceimp.dashboard;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.admin.Technologies;
import com.neo.trainer.model.article.Article;
import com.neo.trainer.model.blog.Posts;
import com.neo.trainer.model.deshboard.Dashboard;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.QuestionSet;
import com.neo.trainer.model.onlinetest.Questions;
import com.neo.trainer.service.dashboard.DashboardService;
import com.neo.trainer.serviceimp.login.LoginServiceImpl;

@Service
public class DashboardServiceImpl implements DashboardService {
	private static final Logger log = Logger
			.getLogger(DashboardServiceImpl.class);

	/** The session factory. */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Posts> getPosts() {
		// List<Posts> listPost=null;
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();

			Criteria c = session.createCriteria(Posts.class).setMaxResults(4)
					.addOrder(Order.desc("postDate"));

			return c.list();
		} catch (Exception e) {
		}
		return null;
	}

	public List<Article> getArticles() {
		// List<Posts> listPost=null;
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();

			Criteria c = session.createCriteria(Article.class).setMaxResults(3)
					.addOrder(Order.desc("date"));

			return c.list();
		} catch (Exception e) {
		}
		return null;
	}

	public List<Technologies> getTechnologies() {
		// List<Posts> listPost=null;
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();

			Criteria c = session.createCriteria(Technologies.class)
					.setMaxResults(5);

			return c.list();
		} catch (Exception e) {
		}
		return null;
	}

	public List<Questions> getOnlineTest() {
		List<Questions> listQuest = null;
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			Criteria c = session.createCriteria(Questions.class).setMaxResults(5).addOrder(Order.asc("questId"));
			listQuest = c.list();
			return c.list();
		} catch (Exception e) {
		}
		return null;
	} 
	public void saveDashOption(String topics)
	{
		hibernateTemplate.deleteAll(hibernateTemplate.loadAll(Dashboard.class));  
		Dashboard dash = new Dashboard();
		String[] selected = topics.split(",");
		for (int i = 0; i < selected.length; i++) {
		dash.setDashOption(selected[i]);
		hibernateTemplate.save(dash);
		}     
		
	}

	public List<Dashboard> getDashOption() {
		
		return hibernateTemplate.find("from Dashboard");
	}
}
