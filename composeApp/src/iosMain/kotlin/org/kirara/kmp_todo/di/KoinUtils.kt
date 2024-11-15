package org.kirara.kmp_todo.di

import org.kirara.kmp_todo.presentation.BaseViewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

actual inline fun <reified T: BaseViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>
) : KoinDefinition<T> = factory(qualifier, definition)