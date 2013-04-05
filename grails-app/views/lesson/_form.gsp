<%@ page import="org.kurron.domain.Lesson" %>



<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="lesson.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${lessonInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'units', 'error')} ">
	<label for="units">
		<g:message code="lesson.units.label" default="Units" />
		
	</label>
	<g:select name="units" from="${org.kurron.domain.Unit.list()}" multiple="multiple" optionKey="id" size="5" value="${lessonInstance?.units*.id}" class="many-to-many"/>
</div>

