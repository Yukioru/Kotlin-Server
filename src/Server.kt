import org.wasabifx.wasabi.app.AppConfiguration
import org.wasabifx.wasabi.app.AppServer
import com.github.salomonbrys.kotson.*
import java.util.*

class Server(val port: Int) {

    fun start() {
        val app = AppServer(AppConfiguration(port, enableLogging = true))
        routes(app)
        app.start()
    }

    private fun routes(app: AppServer) {
        app.get("/", {
            response.send(jsonObject(
                    "name" to "Kotlin example server",
                    "time" to Date().time,
                    "author" to "/about"
            ).toString())
        })

        app.get("/about", {
            response.send(jsonObject(
                    "author" to "Andrey Kondalov",
                    "about" to "JavaScript Full-stack developer",
                    "contacts" to jsonObject(
                            "vk" to "https://vk.com/yukioru",
                            "github" to "https://github.com/Yukioru",
                            "website" to "https://yukio.ru"
                    )
            ).toString())
        })
    }

}