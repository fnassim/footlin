package com.footlin.palo.footlin.di.components

import com.footlin.palo.footlin.di.modules.NetworkModule
import com.footlin.palo.footlin.di.scopes.FootlinApplicationScope
import dagger.Component

/**
 * Created by user on 6/10/17.
 */
@FootlinApplicationScope
@Component(modules = arrayOf(NetworkModule::class))
interface ApplicationComponent {
}