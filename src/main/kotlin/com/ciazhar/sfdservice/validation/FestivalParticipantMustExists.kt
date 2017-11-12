package com.ciazhar.sfdservice.validation

import com.ciazhar.sfdservice.repository.FestivalParticipantRepository
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
@Constraint(validatedBy = arrayOf(FestivalParticipantMustExistsValidator::class))
@MustBeDocumented
annotation class FestivalParticipantMustExists(
    val message: String = "FestivalParticipantMustExists",
    val groups: Array<KClass<*>> = arrayOf(),
    val payload: Array<KClass<out Payload>> = arrayOf(),
    val path: Array<String> = arrayOf()
)

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class FestivalParticipantMustExistsValidator (private val repository: FestivalParticipantRepository)
    : ConstraintValidator<FestivalParticipantMustExists, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return repository.existsById(value).block()
    }

}