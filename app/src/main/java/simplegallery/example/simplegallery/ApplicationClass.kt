package simplegallery.example.simplegallery

import android.app.Application
import simplegallery.example.simplegallery.di.ApplicationGraph
import simplegallery.example.simplegallery.di.DaggerApplicationGraph

class ApplicationClass : Application() {
    lateinit var applicationGraph: ApplicationGraph
    override fun onCreate() {
        super.onCreate()
        applicationGraph = DaggerApplicationGraph.builder().build()
    }
}