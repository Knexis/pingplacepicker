package com.rtchagas.pingplacepicker.viewmodel

import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.Place
import java.util.*

/**
 * Resource holder provided to the UI
 */
class Resource<T> private constructor(val status: Status, val data: T?, val error: Throwable?) {

    /**
     * Possible status types of a response provided to the UI
     */
    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    companion object {

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }

        fun <T> loading(data: T): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Throwable): Resource<T> {
            return Resource(Status.ERROR, null, error)
        }

        fun <T> error(error: Throwable, data: T): Resource<T?>? {
            return Resource(Status.ERROR, data, error)
        }
    }
}
