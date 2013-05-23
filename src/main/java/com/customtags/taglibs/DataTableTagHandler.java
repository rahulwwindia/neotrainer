package com.customtags.taglibs;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

@SuppressWarnings({ "rawtypes", "unused" })
/**
 *
 * TagHandler for DataTable
 * @document  DataTableTagHandler.java
 * @author webwerks
 * @version 1.0
 * @date 09/01/2013 
 */
public class DataTableTagHandler extends SimpleTagSupport {
 
	private String name;
	private String id;
	private String tableId;
	private String labels; 
	private String dtBorder;
	private String dtWidth;
	private String dtHeight;
	private List dataList;
	private String formBean;
	private Boolean isDisplayLength;
	private String formBeanColumn;
	private static String dtOutput;

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIsDisplayLength(Boolean isDisplayLength) {
		this.isDisplayLength = isDisplayLength;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public void setDtBorder(String dtBorder) {
		this.dtBorder = dtBorder;
	}

	public void setDtWidth(String dtWidth) {
		this.dtWidth = dtWidth;
	}

	public void setDtHeight(String dtHeight) {
		this.dtHeight = dtHeight;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	public void setFormBean(String formBean) {
		this.formBean = formBean;
	}

	public void setFormBeanColumn(String formBeanColumn) {
		this.formBeanColumn = formBeanColumn;
	}

	@Override
	public void doTag() throws JspException, IOException {

		/*
		 * attribute dtBorder - if not set then assign default value. attribute
		 * dtWidth - if not set then assign default value. attribute dtHeigth -
		 * if not set then assign default value. attribute displayLength - if
		 * not set then assign default value.
		 */
		if (dtBorder == null)
			dtBorder = "0";
		if (dtWidth == null)
			dtWidth = "900";
		if (dtHeight == null)
			dtHeight = "340";
		if (isDisplayLength == null)
			isDisplayLength = false;

		/*
		 * javascript code for dataTable. 
		 */

		dtOutput = "<head>"
				+ "<style type='text/css' title='currentStyle'>"
				+ "@import 'resources/css/demo_table_jui.css';" 
				+ "</style>" 
				+ "<script type='text/javascript' language='javascript' src='resources/js/jquery.dataTables.js'></script>"
				+ "<script type='text/javascript' charset='utf-8'>"
				+ "$(document).ready(function() {" + "$('#"
				+ tableId
				+ "').dataTable({" 
				+ "\"bJQueryUI\":" 
				+ true
				+ ","
				+ "\"bDestroy\":"
				+ true
				+ ","
				+ "\"sLoadingRecords\":\"Loading...\","
				+ "\"sPaginationType\": \"full_numbers\""
				+ "});"
				+ "});"
				+ "function fnFeaturesInit (){"
				+ "$('ul.limit_length>li').each( function(i) {"
				+ "if ( i > 10 ) {"
				+ "this.style.display = 'none';"
				+ "}"
				+ "});"
				+ "$('ul.limit_length').append( '<li class=\"css_link\">Show more<\\/li>' );"
				+ "$('ul.limit_length li.css_link').click( function () {"
				+ "$('ul.limit_length li').each( function(i) {"
				+ "if ( i > 5 ) {"
				+ "this.style.display = 'list-item';"
				+ "}"
				+ "});"
				+ "$('ul.limit_length li.css_link').css( 'display', 'none' );"
				+ "});" + "}" + "</script>" + "</head>";

		/*
		 * creating table element <table> with its default attributes
		 * cellspacing, cellpadding and class and custom tag attributes -
		 * dtBorder, dtWidth, dtHeight, tableId
		 */

		dtOutput = dtOutput + "<table cellpadding='0' cellspacing='0' border='"
				+ dtBorder + "' width='" + dtWidth + "' " + "height='"
				+ dtHeight + "' class='display' id='" + tableId + "' style="
				+ isDisplayLength + ">";

		/*
		 * creating table header
		 */

		/*
		 * labels must be comma(,) separated only if specifying one label then
		 * it must end with a comma(,)
		 */

		if (!labels.matches("(.*),(.*)")) {
			try {
				throw new DataTableException(
						"labels must be comma(,) separated.");
			} catch (DataTableException e) {
				e.printStackTrace();
			}
		} else {
			String[] strHeaderArr = labels.split(",");
			dtOutput = dtOutput + "<thead><tr>";
			for (String dtHeader : strHeaderArr) {
				dtOutput = dtOutput + "<th>" + dtHeader + "</th>";
			}

			dtOutput = dtOutput + "</tr></thead>";

			/*
			 * if formBeanColumn is null then all the bean properties are
			 * displayed else only the specified bean properties in
			 * formBeanColumn are displayed.
			 * 
			 * 
			 * formBeanColumn must be comma(,) separated only if specifying one
			 * label then it must end with a comma(,)
			 */

			String[] strFormBeanColumn = null;
			dtOutput = dtOutput + "<tbody>";
			if (formBeanColumn == null) {
				fillDataTable(strFormBeanColumn);
			} else {
				try {

					if (!formBeanColumn.matches("(.*),(.*)"))
						throw new DataTableException(
								"formBeanColumn must be comma(,) separated");
					else {
						strFormBeanColumn = formBeanColumn.split(",");

						if (strHeaderArr.length != strFormBeanColumn.length)
							throw new DataTableException(
									"there must be same number of headers(labels) and form bean properties(formBeanColumn)");
						else
							fillDataTable(strFormBeanColumn);
					}

				} catch (DataTableException e) {
					e.printStackTrace();
				}
			}
			dtOutput = dtOutput + "</tbody>";
		}
		dtOutput = dtOutput + "</table>";
		/*
		 * returning the dataTable generated.
		 */
		getJspContext().getOut().println(dtOutput);
	}

	
	/**
	 * function for creating table body using custom tag attributes dataList -
	 * List of bean object formBean - specifies the type of bean object in List
	 * @param strFormBeanColumn
	 */

	void fillDataTable(String[] strFormBeanColumn) {
		boolean retSuccess = true;
		if (dataList != null && !dataList.isEmpty() && formBean != null) {
			
				Iterator iLst = dataList.iterator();
				while (iLst.hasNext()) {
					if (!retSuccess)
						break;
					/*
					 * retreiving bean object from List then accessing the Class
					 * type of bean Object to retreive the fields value for
					 * populating in dataTable.
					 */
					Object beanObj = (Object) iLst.next();
					Class<?> beanClass = beanObj.getClass();
					dtOutput = dtOutput + "<tr class='gradeU'>";

					try {
						if (strFormBeanColumn != null) {
							for (String columnBean : strFormBeanColumn) {
								retSuccess = getFormBeanFields(beanClass,
										beanObj, columnBean);
								if (!retSuccess)
									throw new DataTableException(columnBean
											+ " is not a form bean property");
							}
						} else {
							getFormBeanFields(beanClass, beanObj);
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (DataTableException e) {
						e.printStackTrace();
					}
					dtOutput = dtOutput + "</tr>";
				
			}
		}
	}
		/**
		 * function for retrieving the Form Bean fields values
	 	 * when user want to display selective list in data Table.
		 * 
		 * @param beanClass - Bean Class type 
		 * @param beanObj   - Bean Object
		 * @param fieldName - field whose value to be retrieved.
		 * @return
		 * @throws IllegalArgumentException
		 * @throws IllegalAccessException
		 */
	boolean getFormBeanFields(Class<?> beanClass, Object beanObj,
			String fieldName) throws IllegalArgumentException,
			IllegalAccessException {
		for (Field beanField : beanClass.getDeclaredFields()) {
			beanField.setAccessible(true);
			if (fieldName != null
					&& fieldName.trim().equalsIgnoreCase(
							beanField.getName().trim())) {
				Object beanFieldValue = beanField.get(beanObj);
				if (beanFieldValue == null) {
					beanFieldValue = "-";  
				}
				if(fieldName.equals("title"))    
				{ 
					
 				dtOutput = dtOutput + "<td class='center'><a href=viewArticle.htm?articleTitle="+beanFieldValue.toString().replaceAll(" ", "%20")+">"+beanFieldValue +"</a></td>";
 				System.out.println("OP : "+dtOutput);
				        
				}       
				else     
				{
					dtOutput = dtOutput + "<td class='center'>"+beanFieldValue+"</td>"; 
					 
					     
				} 
				return true;
			} 
		} 
		return false;
	}

	/**
	 * function for retrieving all the Form Bean fields
	 * when user want to display whole list in data Table.
	 * 
	 * @param beanClass - Bean Class type 
	 * @param beanObj -   Bean Object
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	void getFormBeanFields(Class<?> beanClass, Object beanObj)
			throws IllegalArgumentException, IllegalAccessException {
		for (Field beanField : beanClass.getDeclaredFields()) {
			beanField.setAccessible(true);
			Object beanFieldValue = beanField.get(beanObj);
			if (beanFieldValue == null) {
				beanFieldValue = "-";
			}
			dtOutput = dtOutput + "<td class='center'>" + beanFieldValue
					+ "</td>";
		}
	}
}

/*
 * Custom Exception
 */
class DataTableException extends Exception {
	
	private String errorMsg;

	public DataTableException(String message) {
		errorMsg = message;
	}

	@Override
	public String toString() {
		return errorMsg;
	}
}
