<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div role="grid" class="dataTables_wrapper" id="example_wrapper">
<div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix">
<div id="example_length" class="dataTables_length">
<label>Show <select name="example_length" size="1" aria-controls="example">
<option value="10" selected="selected">10</option>
<option value="25">25</option>
<option value="50">50</option>
<option value="100">100</option></select> entries</label></div>
<div class="dataTables_filter" id="example_filter"><label>Search: <input type="text" aria-controls="example"></label></div>
</div>
<div style="width: 900px;overflow: auto;">
<table width="900" height="150" cellspacing="0" cellpadding="0" border="0" id="example" class="display dataTable" aria-describedby="example_info" style="width: 900px;"><thead><tr role="row"><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 98px;" aria-sort="ascending" aria-label="SerailNo: activate to sort column descending"><div class="DataTables_sort_wrapper">SerailNo<span class="DataTables_sort_icon css_right ui-icon ui-icon-triangle-1-n"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 105px;" aria-label="Name: activate to sort column ascending"><div class="DataTables_sort_wrapper">Name<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 84px;" aria-label="Data1: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data1<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 72px;" aria-label="Data2: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data2<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 72px;" aria-label="Data3: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data3<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 72px;" aria-label="Data4: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data4<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 72px;" aria-label="Data5: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data5<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 72px;" aria-label="Data6: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data6<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 62px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 84px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 84px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 61px;" aria-label="Data: activate to sort column ascending"><div class="DataTables_sort_wrapper">Data<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th></tr></thead><tbody role="alert" aria-live="polite" aria-relevant="all"><tr class="gradeC odd">                                         	<td class="  sorting_1">KHTML</td>                                            	<td class=" ">Konqureror 3.1</td>                                   	<td class=" ">KDE 3.1</td>                                          	<td class="center ">3.1</td>                              	<td class="center ">C</td><td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class=" ">Presto</td>                                         <td class=" ">Nintendo DS browser</td>                            <td class=" ">Nintendo DS</td>                                    <td class="center ">8.5</td>                             <td class="center ">C/A<sup>1</sup></td>                 <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             </tr><tr class="gradeA even"><td class="  sorting_1">Presto</td>                                         <td class=" ">Nintendo DS browser</td>                            <td class=" ">Nintendo DS</td>                                    <td class="center ">8.5</td>                             <td class="center ">C/A<sup>1</sup></td>                 <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class=" ">Presto</td>                                         <td class=" ">Nintendo DS browser</td>                            <td class=" ">Nintendo DS</td>                                    <td class="center ">8.5</td>                             <td class="center ">C/A<sup>1</sup></td>                 <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             <td class="center ">8.5</td>                             </tr></tbody>
</table>
</div>
<div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix"><div class="dataTables_info" id="example_info">Showing 1 to 2 of 2 entries</div><div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers" id="example_paginate"><a class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default ui-state-disabled" tabindex="0" id="example_first">First</a><a class="previous fg-button ui-button ui-state-default ui-state-disabled" tabindex="0" id="example_previous">Previous</a><span><a class="fg-button ui-button ui-state-default ui-state-disabled" tabindex="0">1</a></span><a class="next fg-button ui-button ui-state-default ui-state-disabled" tabindex="0" id="example_next">Next</a><a class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default ui-state-disabled" tabindex="0" id="example_last">Last</a></div></div></div>
</body>
</html>