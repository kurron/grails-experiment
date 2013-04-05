<%@ page import="org.kurron.domain.Unit" %>



<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'list', 'error')} required">
	<label for="list">
		<g:message code="unit.list.label" default="List" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="list" name="list.id" from="${org.kurron.domain.List.list()}" optionKey="id" required="" value="${unitInstance?.list?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="unit.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${unitInstance?.title}"/>
</div>

