<%@ page import="org.kurron.domain.List" %>



<div class="fieldcontain ${hasErrors(bean: listInstance, field: 'cards', 'error')} ">
	<label for="cards">
		<g:message code="list.cards.label" default="Cards" />
		
	</label>
	<g:select name="cards" from="${org.kurron.domain.Card.list()}" multiple="multiple" optionKey="id" size="5" value="${listInstance?.cards*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: listInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="list.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${listInstance?.name}"/>
</div>

