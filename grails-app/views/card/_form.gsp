<%@ page import="org.kurron.domain.Card" %>



<div class="fieldcontain ${hasErrors(bean: cardInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="card.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${cardInstance?.name}"/>
</div>

