package chris.example.com.volvochallenge.injection.app

import chris.example.com.volvochallenge.injection.main.MainComponent
import chris.example.com.volvochallenge.injection.main.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent
{
    fun add(mainModule: MainModule): MainComponent
}