package chris.example.com.volvochallenge.application

import android.app.Application
import android.content.Context
import chris.example.com.volvochallenge.injection.app.AppComponent
import chris.example.com.volvochallenge.injection.app.AppModule
import chris.example.com.volvochallenge.injection.app.DaggerAppComponent
import chris.example.com.volvochallenge.injection.main.MainComponent
import chris.example.com.volvochallenge.injection.main.MainModule
import chris.example.com.volvochallenge.utils.Const

class VolvoChallengeApplication : Application()
{
    private lateinit var appComponent: AppComponent
    private var mainComponent: MainComponent? = null
    private lateinit var appModule: AppModule

    override fun onCreate()
    {
        super.onCreate()

        appModule = AppModule(Const.BASE_URL)

        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build()
    }

    fun getMainComponent(): MainComponent
    {
        mainComponent = appComponent.add(MainModule())
        return mainComponent as MainComponent
    }

    fun clearMainComponent()
    {
        mainComponent = null
    }

    companion object
    {

        operator fun get(context: Context): VolvoChallengeApplication
        {
            return context.applicationContext as VolvoChallengeApplication
        }
    }
}