package chris.example.com.volvochallenge.injection.main

import chris.example.com.volvochallenge.network.RemoteDataSource
import chris.example.com.volvochallenge.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule
{
    @Provides
    internal fun providerMainPresenter(remoteDataSource: RemoteDataSource): MainPresenter
    {
        return MainPresenter(remoteDataSource)
    }
}