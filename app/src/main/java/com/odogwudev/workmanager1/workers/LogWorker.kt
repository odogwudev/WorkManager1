package com.odogwudev.workmanager1.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.odogwudev.workmanager1.repository.SharedPreferencesRepository
import java.util.*


const val LOG_WORKER_TAG = "LogWorker"

class LogWorker(val context: Context, params: WorkerParameters) : Worker(context, params) {

    private var sharedPreferencesRepository: SharedPreferencesRepository =
        SharedPreferencesRepository(context)


    override fun doWork(): Result {

        try {

            var info = sharedPreferencesRepository.getInfo()


            if (info != null) {
                info += "\n${Calendar.getInstance().time.toLocaleString()}"
                sharedPreferencesRepository.setInfo(info)
            } else {
                info = Calendar.getInstance().time.toLocaleString()
                sharedPreferencesRepository.setInfo(info)
            }


            return Result.success()
        } catch (exception: Exception) {
            return Result.retry()
        }
    }
}