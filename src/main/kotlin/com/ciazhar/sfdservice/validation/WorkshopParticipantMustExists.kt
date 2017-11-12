package com.ciazhar.sfdservice.validation

import com.ciazhar.sfdservice.repository.WorkshopParticipantRepository
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
@Target(CLASS, FILE, ANNOTATION_CLASS, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = arrayOf(WorkshopParticipantMustExistsValidator::class))
@MustBeDocumented
annotation class WorkshopParticipantMustExists(
        val message: String = "WorkshopParticipantMustExists",
        val groups: Array<KClass<*>> = arrayOf(),
        val payload: Array<KClass<out Payload>> = arrayOf(),
        val path: Array<String> = arrayOf()
)

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class WorkshopParticipantMustExistsValidator (private val repository: WorkshopParticipantRepository)
    : ConstraintValidator<WorkshopParticipantMustExists, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return repository.existsById(value).block()
    }

}