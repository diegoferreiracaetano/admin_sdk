
import com.google.firebase.FirebaseApp
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseOptions
import java.io.FileInputStream
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message


object App {

    @JvmStatic
    fun main(args : Array<String>){
        val serviceAccount = FileInputStream("./serviceAccountKey.json")

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(URL)
                .build()

        FirebaseApp.initializeApp(options)


        val message = Message.builder()
                .putData("author", "TestAccount")
                .setToken(TOKEN)
                .build()

        val response = FirebaseMessaging.getInstance().send(message)

        println("Successfully sent message: $response")
    }

    val URL = "https://my-burguer-8c2de.firebaseio.com"
    val TOKEN = "d1ZBRu0J1qs:APA91bEn0dYgWVcbnXfFRVkGl7vrLx15IZya06Ok0ehGCPou0XKgUCRJmuecZXpU2FXkvo-xpDu3RypMq_pjURV-2ha0Cz9-Stn64kmAgoPmGGKqtdhP1SaIk6tAG6j4mSkwiLtxsLCG"


}