package org.kurron.domain

import org.springframework.dao.DataIntegrityViolationException

class LessonController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [lessonInstanceList: Lesson.list(params), lessonInstanceTotal: Lesson.count()]
    }

    def create() {
        [lessonInstance: new Lesson(params)]
    }

    def save() {
        def lessonInstance = new Lesson(params)
        if (!lessonInstance.save(flush: true)) {
            render(view: "create", model: [lessonInstance: lessonInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'lesson.label', default: 'Lesson'), lessonInstance.id])
        redirect(action: "show", id: lessonInstance.id)
    }

    def show(Long id) {
        def lessonInstance = Lesson.get(id)
        if (!lessonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lesson.label', default: 'Lesson'), id])
            redirect(action: "list")
            return
        }

        [lessonInstance: lessonInstance]
    }

    def edit(Long id) {
        def lessonInstance = Lesson.get(id)
        if (!lessonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lesson.label', default: 'Lesson'), id])
            redirect(action: "list")
            return
        }

        [lessonInstance: lessonInstance]
    }

    def update(Long id, Long version) {
        def lessonInstance = Lesson.get(id)
        if (!lessonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lesson.label', default: 'Lesson'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (lessonInstance.version > version) {
                lessonInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'lesson.label', default: 'Lesson')] as Object[],
                          "Another user has updated this Lesson while you were editing")
                render(view: "edit", model: [lessonInstance: lessonInstance])
                return
            }
        }

        lessonInstance.properties = params

        if (!lessonInstance.save(flush: true)) {
            render(view: "edit", model: [lessonInstance: lessonInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'lesson.label', default: 'Lesson'), lessonInstance.id])
        redirect(action: "show", id: lessonInstance.id)
    }

    def delete(Long id) {
        def lessonInstance = Lesson.get(id)
        if (!lessonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'lesson.label', default: 'Lesson'), id])
            redirect(action: "list")
            return
        }

        try {
            lessonInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'lesson.label', default: 'Lesson'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'lesson.label', default: 'Lesson'), id])
            redirect(action: "show", id: id)
        }
    }
}
