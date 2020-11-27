package com.example.pacdesarrollo

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.lang.Thread.sleep
import android.os.Build


class Reproductor : Service() {



    companion object{

        var mp : MediaPlayer? = null
        val CHANNEL_ID = "Musica Channel"

        //Iniciamos servicio
        fun starService(context: Context){
            val startIntent = Intent(context, ServicioCreado::class.java)
            ContextCompat.startForegroundService(context, startIntent)

        }

        //Destruimos servicio
        fun stopService(context: Context){
            val stopIntent = Intent(context, ServicioCreado::class.java)
            context.stopService(stopIntent)
        }

        //Funciones del servicio

        fun reproduce(){
            mp?.start()
        }

        fun pausa(){
            mp?.pause()
        }

        fun bloquea(){
            Thread(Runnable{
                mp?.pause()
                sleep(15000)
                mp?.start()
            }).start()
        }


    }



    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {



        //Notificaciones
        createNotificationChannel()
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,0)
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Reproduciendo audio")
                .setContentText("Todo pasa")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setCategory(NotificationCompat.CATEGORY_STATUS)
                .setContentIntent(pendingIntent)
                .build()

        startForeground(1, notification)


        mp=MediaPlayer.create(this@Reproductor,R.raw.todopasa);
        mp?.start()

        return START_STICKY
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                    CHANNEL_ID,
                    "PAC_LOW",
                    NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }



    override fun onDestroy() {
        super.onDestroy()

        mp?.release()

    }


}