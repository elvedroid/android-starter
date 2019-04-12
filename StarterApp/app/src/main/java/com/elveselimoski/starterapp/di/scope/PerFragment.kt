package com.elveselimoski.starterapp.di.scope

import javax.inject.Scope

/**
 * Created by Elvedin Selimoski on 12/6/17. mail: elveselimoski@gmail.com
 */

@Scope
@Retention
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FILE,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class PerFragment