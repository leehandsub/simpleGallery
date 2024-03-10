package simplegallery.example.simplegallery.di

import dagger.Component
import simplegallery.example.simplegallery.MainActivity
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface ApplicationGraph {
    fun inject(activity: MainActivity)
}