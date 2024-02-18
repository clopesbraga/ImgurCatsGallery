import com.example.catslist.model.CatsListModel
import com.example.catslist.network.RequestEndpoint
import com.example.catslist.view.MainActivity
import io.reactivex.Maybe
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit

class MainActivityTest {

    @Mock
    private lateinit var remoteMock: RequestEndpoint
    @Mock
    private lateinit var retrofitServiceMock: Retrofit
    @Mock
    private lateinit var mainActivityMock: MainActivity
    @Mock
    private lateinit var data: CatsListModel


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

    }

    @Test
    fun `should_verify_is_not_null`() {

        `when`(retrofitServiceMock.create(RequestEndpoint::class.java)).thenReturn(remoteMock)
        `when`(remoteMock.sendRequest()).thenReturn(Maybe.just(data))

        assertNotNull(mainActivityMock.bringCatsList())

    }

    @Test
    fun `should_return_success `() {

        `when`(retrofitServiceMock.create(RequestEndpoint::class.java)).thenReturn(remoteMock)
        `when`(remoteMock.sendRequest()).thenReturn(Maybe.just(data))

        assertTrue(mainActivityMock.bringCatsList())

    }

    @Test
    fun should_return_error() {

        val errorMessage = "ERRO_REQUEST"

        `when`(retrofitServiceMock.create(RequestEndpoint::class.java)).thenReturn(remoteMock)
        `when`(remoteMock.sendRequest()).thenReturn(Maybe.error(Throwable(errorMessage)))

        assertFalse(mainActivityMock.bringCatsList())
    }

    @After
    fun tearDown() {
        RxAndroidPlugins.reset()
    }

}
