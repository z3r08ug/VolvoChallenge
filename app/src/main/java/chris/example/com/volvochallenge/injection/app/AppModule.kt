package chris.example.com.volvochallenge.injection.app

import chris.example.com.volvochallenge.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private var baseURL: String)
{
    @Provides
    @Singleton
    internal fun provideRemoteDataSource(): RemoteDataSource
    {
        return RemoteDataSource(baseURL)
    }
}