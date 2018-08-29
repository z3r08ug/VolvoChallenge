package chris.example.com.volvochallenge.base

interface BasePresenter<V : BaseView>
{
    fun attachView(view: V)
    fun detachView()
}