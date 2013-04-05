<%@ page import="org.kurron.domain.Instructor" %>



<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="instructor.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${instructorInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="instructor.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${instructorInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'lessons', 'error')} ">
	<label for="lessons">
		<g:message code="instructor.lessons.label" default="Lessons" />
		
	</label>
	<g:select name="lessons" from="${org.kurron.domain.Lesson.list()}" multiple="multiple" optionKey="id" size="5" value="${instructorInstance?.lessons*.id}" class="many-to-many"/>
</div>

