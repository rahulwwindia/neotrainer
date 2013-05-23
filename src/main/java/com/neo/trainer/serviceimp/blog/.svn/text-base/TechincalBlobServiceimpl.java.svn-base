package com.neo.trainer.serviceimp.blog;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.neo.trainer.model.blog.Editor;
import com.neo.trainer.service.blog.ITechnicalBlogService;

// TODO: Auto-generated Javadoc
/**
 * The Class TechincalBlobServiceimpl.
 */
@Service
public class TechincalBlobServiceimpl implements ITechnicalBlogService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(TechincalBlobServiceimpl.class);

	/** The session factory. */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.ITechnicalBlogService#addBlog(com.neo.trainer.model.blog.Editor)
	 */
	public boolean addBlog(Editor editor) {
		System.out.println("in add edotir");
		if (editor != null) {
			logger.info("in add Blog method");
			System.out.println(editor.getEditorText());
			System.out.println(editor.getEmailId());
			System.out.println(editor.getName());
			hibernateTemplate.saveOrUpdate(editor);
			return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see com.neo.trainer.service.blog.ITechnicalBlogService#getBlog(java.lang.Integer)
	 */
	public List<Editor> getBlog(Integer id) {
	
		List<Editor> lstEditor = hibernateTemplate.find(
				"from Editor where id=?", id);
		return lstEditor;

	}

}
