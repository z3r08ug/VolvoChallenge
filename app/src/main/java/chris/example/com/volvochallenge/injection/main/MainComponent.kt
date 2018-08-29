package chris.example.com.volvochallenge.injection.main

import chris.example.com.volvochallenge.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent
{
    fun inject(mainActivity: MainActivity)
}